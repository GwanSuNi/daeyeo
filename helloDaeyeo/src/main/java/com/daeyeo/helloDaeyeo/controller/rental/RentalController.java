package com.daeyeo.helloDaeyeo.controller.rental;

import com.daeyeo.helloDaeyeo.dto.category.MainCategoryDto;
import com.daeyeo.helloDaeyeo.dto.category.SubCategoryDto;
import com.daeyeo.helloDaeyeo.dto.rental.*;
import com.daeyeo.helloDaeyeo.entity.Status;
import com.daeyeo.helloDaeyeo.exception.NotPermitTime;
import com.daeyeo.helloDaeyeo.exception.OverlapInTime;
import com.daeyeo.helloDaeyeo.service.MainCategoryService;
import com.daeyeo.helloDaeyeo.service.RentalObjectService;
import com.daeyeo.helloDaeyeo.service.RentalStatusService;
import com.daeyeo.helloDaeyeo.service.SubCategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/rentals")
public class RentalController {
    private final SubCategoryService subCategoryService;
    private final RentalObjectService rentalObjectService;
    private final MainCategoryService mainCategoryService;
    private final RentalStatusService rentalStatusService;


    // TODO: 지금은 db에서 데이터들을 다 가져온다음 페이징을 하는 데 db에서 페이징을 한 데이터들을 가져오는 걸로 바꿔야 함
    // TODO: rentalObject가 하나도 없을 때 '검색 결과가 없습니다.'라고 보여주고 html에 페이징도 안 보이게 해야함
    @GetMapping({"list", "list/{page}"})
    public String rentalList(SearchSpecDto specDto, @PathVariable(required = false) Integer page, Model model
            , @CurrentSecurityContext(expression = "authentication") Authentication authentication) {

        model.addAttribute("isLogined", !(authentication instanceof AnonymousAuthenticationToken));
        // 권한을 컬렉션에서 확인
        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(authority -> "ROLE_ADMIN".equals(authority.getAuthority()));
        model.addAttribute("isAdmin", isAdmin);

        if (page == null)
            page = 1;

        Pageable pageable = PageRequest.of(page - 1, 9);
        List<String> categories = subCategoryService.getCategories(specDto.getMainCategory());
        Page<RentalObjectDto> rentalObjectDtos = rentalObjectService.findListBySearchSpec(specDto, pageable);

        model.addAttribute("categories", categories);
        model.addAttribute("searchSpec", specDto);
        model.addAttribute("rentalObjects", rentalObjectDtos);

        return "rental/rentalList";
    }

    @GetMapping("write/{objectId}")
    public String rentalWrite(@PathVariable long objectId, Model model, @CurrentSecurityContext(expression = "authentication") Authentication authentication) {

        model.addAttribute("isLogined", !(authentication instanceof AnonymousAuthenticationToken));
        // 권한을 컬렉션에서 확인
        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(authority -> "ROLE_ADMIN".equals(authority.getAuthority()));
        model.addAttribute("isAdmin", isAdmin);

        RentalStatusFormDto rentalStatusFormDto = new RentalStatusFormDto();
        rentalStatusFormDto.setObjectId(objectId);
        model.addAttribute("rentalObject", rentalObjectService.getRentalObject(objectId));
        model.addAttribute("rentalStatus", rentalStatusFormDto);
        return "rental/rentalWrite";
    }
    //TODO 날짜가 겹치는지 안겹치는지에대한

    /***
     *
     * @param rentalStatusFormDto
     * @param model
     * @param redirectAttributes
     * @param authentication
     * @return
     */
    @PostMapping("write/status.do")
    public String rentalStatusSend(@ModelAttribute("rentalStatus") RentalStatusFormDto rentalStatusFormDto,
                                   Model model, RedirectAttributes redirectAttributes, @CurrentSecurityContext(expression = "authentication") Authentication authentication) {
        // rentalStatusFormDto 로 일단 값을 받고 rentalStatus로 넣어서 형변환 시도
        model.addAttribute("isLogined", !(authentication instanceof AnonymousAuthenticationToken));
        // 권한을 컬렉션에서 확인
        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(authority -> "ROLE_ADMIN".equals(authority.getAuthority()));
        model.addAttribute("isAdmin", isAdmin);
//        log.info("principal : {}, name: {}, authorities: {}, details : {}", authentication.getPrincipal(), authentication.getName(), authentication.getAuthorities(), authentication.getDetails());

        try {
            // 현재 로그인한 유저의 아이디값을 받아옴
            String userEmail = authentication.getName();
            // 값을 넣은 후에 날짜가 올바른지 확인하고 insertStatus 하는과정
            // new 하는 생성자를 통해서 값이 올바른지 확인하고 입력받은 날짜값에 대해 타입을 맞추기위해 날짜값을 형변환함
            RentalStatusDto rentalStatusDto = new RentalStatusDto(rentalStatusFormDto);
            // 로그인한 유저의 아이디값을 넣음
            rentalStatusDto.setUserEmail(userEmail);
            if (rentalStatusService.validPeriod(rentalStatusDto.getObjectIndex(),
                    rentalStatusDto.getStartTime(), rentalStatusDto.getEndTime())) {
                // 시간이 겹치지 않으므로 validPeriod는 true를 반환
                rentalStatusDto.setStatus(Status.PENDING);
                rentalStatusService.insertRentalStatus(rentalStatusDto);
            }
        } catch (NotPermitTime e) {
            String errorMessage = e.getMessage();
            redirectAttributes.addFlashAttribute("notPermitTimeError", errorMessage);
            System.out.println("====================================");
            return "redirect:/rentals/write/" + rentalStatusFormDto.getObjectId(); // 이전 페이지로 리다이렉트
        } catch (OverlapInTime o) {
            String errorMessage = o.getMessage();
            redirectAttributes.addFlashAttribute("overlapInTime", errorMessage);
            return "redirect:/rentals/write/" + rentalStatusFormDto.getObjectId(); // 이전 페이지로 리다이렉트
        }
        return "redirect:/myPage/reservation";
    }

    /***
     *
     * @param mainCategoryId
     * @return
     */

    @GetMapping("/getSubCategories")
    @ResponseBody
    public List<SubCategoryDto> getSubCategories(@RequestParam("mainCategoryId") String mainCategoryId) {
        // 선택한 MainCategory에 대한 SubCategory 데이터를 서비스를 통해 가져옵니다.
        List<SubCategoryDto> subCategoryList = subCategoryService.getSubCategories(mainCategoryId);
        return subCategoryList;
    }

    /***
     *
     * @param model
     * @param authentication
     * @return
     */

    @GetMapping("rentalRegistrationForm")
    public String showRentalRegistrationForm(Model model, @CurrentSecurityContext(expression = "authentication") Authentication authentication) {

        model.addAttribute("isLogined", !(authentication instanceof AnonymousAuthenticationToken));
        // 권한을 컬렉션에서 확인
        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(authority -> "ROLE_ADMIN".equals(authority.getAuthority()));
        model.addAttribute("isAdmin", isAdmin);

        List<MainCategoryDto> mainCategoryList = mainCategoryService.getAllCategories();
        model.addAttribute("rentalRegister", new RentalRegisterFormDto());
        model.addAttribute("mainCategoryList", mainCategoryList);
        return "rental/rentalRegistrationForm";
    }

    /***
     *
     * @param rentalRegisterFormDto
     * @param bindingResult
     * @param model
     * @param authentication
     * @return
     */
    @PostMapping("rentalRegistrationForm")
    public String register(@Valid @ModelAttribute("rentalRegister") RentalRegisterFormDto rentalRegisterFormDto, BindingResult bindingResult,
                           Model model, @CurrentSecurityContext(expression = "authentication") Authentication authentication) {
        model.addAttribute("isLogined", !(authentication instanceof AnonymousAuthenticationToken));
        // 권한을 컬렉션에서 확인
        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(authority -> "ROLE_ADMIN".equals(authority.getAuthority()));
        model.addAttribute("isAdmin", isAdmin);


        if (bindingResult.hasErrors()) {
            return "redirect:/rentals/rentalRegistrationForm";
        } else if (rentalRegisterFormDto.getScId() == null) {
            model.addAttribute("scIdChoice", "장소를 선택해주세요");
            return "redirect:/rentals/rentalRegistrationForm";
        }
        RentalRegisterDto rentalRegisterDto = new RentalRegisterDto(rentalRegisterFormDto);
        String userId = authentication.getName();
        rentalRegisterDto.setUserId(userId);
        rentalRegisterFormDto.castLocalDate(rentalRegisterDto);
        rentalObjectService.insertRentalObject(rentalRegisterDto);
        return "redirect:/rentals/list";
    }
}