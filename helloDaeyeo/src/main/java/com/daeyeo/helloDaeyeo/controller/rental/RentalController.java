package com.daeyeo.helloDaeyeo.controller.rental;

import com.daeyeo.helloDaeyeo.dto.category.MainCategoryDto;
import com.daeyeo.helloDaeyeo.dto.category.SubCategoryDto;
import com.daeyeo.helloDaeyeo.dto.rental.*;
import com.daeyeo.helloDaeyeo.embedded.Address;
import com.daeyeo.helloDaeyeo.entity.RentalObject;
import com.daeyeo.helloDaeyeo.entity.SubCategory;
import com.daeyeo.helloDaeyeo.repository.MemberRepository;
import com.daeyeo.helloDaeyeo.service.MainCategoryService;
import com.daeyeo.helloDaeyeo.service.MemberService;
import com.daeyeo.helloDaeyeo.service.RentalObjectService;
import com.daeyeo.helloDaeyeo.service.SubCategoryService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/rental")
public class RentalController {
    private final SubCategoryService subCategoryService;
    private final RentalObjectService rentalObjectService;
    private final MemberService memberService;
    private final MemberRepository memberRepository;
    private final MainCategoryService mainCategoryService;


    // TODO: 지금은 db에서 데이터들을 다 가져온다음 페이징을 하는 데 db에서 페이징을 한 데이터들을 가져오는 걸로 바꿔야 함
    @GetMapping({"list", "list/{page}"})
    public String rentalList(SearchSpecDto specDto, @PathVariable(required = false) Integer page, Model model) {
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

    @RequestMapping("write/{objectId}")
    public String rentalWrite(@PathVariable long objectId, Model model) {
        model.addAttribute("rentalObject", rentalObjectService.getRentalObject(objectId));
        model.addAttribute("rentalStatus", new RentalStatusFormDto());
        return "rental/rentalWrite";
    }
    @PostMapping("write.do")
    public String rentalStatusSend(@ModelAttribute("rentalStatus")RentalStatusFormDto rentalStatusFormDto){

        return "rental/rentalWrite";
    }
    @GetMapping("/getSubCategories")
    @ResponseBody
    public List<SubCategoryDto> getSubCategories(@RequestParam("mainCategoryId") String mainCategoryId) {
        // 선택한 MainCategory에 대한 SubCategory 데이터를 서비스를 통해 가져옵니다.
        List<SubCategoryDto> subCategoryList = subCategoryService.getSubCategories(mainCategoryId);
        return subCategoryList;
    }

    @GetMapping("rentalRegistrationForm")
    public String showRentalRegistrationForm(Model model) {
//      memberService.validateMember(request);
        List<MainCategoryDto> mainCategoryList = mainCategoryService.getAllCategories();
        model.addAttribute("rentalRegister", new RentalRegisterFormDto());
        model.addAttribute("mainCategoryList",mainCategoryList);
        return "rental/rentalRegistrationForm";
    }



    @PostMapping("rentalRegistrationForm")
    public String register(@Valid @ModelAttribute("rentalRegister")RentalRegisterFormDto rentalRegisterFormDto , BindingResult bindingResult,Model model) {
        if(bindingResult.hasErrors()){
            return "rental/rentalRegistrationForm";
        }else if (rentalRegisterFormDto.getScId()==null){
            model.addAttribute("scIdChoice","장소를 선택해주세요");
            return "rental/rentalRegistrationForm";
        }
        RentalRegisterDto rentalRegisterDto = new RentalRegisterDto(rentalRegisterFormDto);
        rentalRegisterDto.setUserId("test@test.com");
        rentalRegisterFormDto.castLocalDate(rentalRegisterDto);
        rentalObjectService.insertRentalObject(rentalRegisterDto);
//        memberService.validateMember(request);
        return "rental/rentalRegistrationForm";
    }
    /*
    @RequestMapping("/rental.do")
    public String rental(@RequestParam int objectId, @RequestParam String startDuration, @RequestParam String endDuration, @RequestParam int price, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        UserEntity loginUser = (UserEntity) session.getAttribute("loginUser");
        String send = "redirect:/rental/list";

        if (loginUser == null)
            send = "redirect:/login";
        else
            rentalLogService.insertRentalLog(objectId, loginUser.getUserEmail(), LocalDate.parse(startDuration), LocalDate.parse(endDuration), price);

        return send;
    }
     */
}