package com.daeyeo.helloDaeyeo.controller;

import com.daeyeo.helloDaeyeo.dto.category.MainCategoryDto;
import com.daeyeo.helloDaeyeo.dto.category.SubCategoryDto;
import com.daeyeo.helloDaeyeo.dto.rental.RentalListPageInfoDto;
import com.daeyeo.helloDaeyeo.dto.rental.RentalObjectDto;
import com.daeyeo.helloDaeyeo.dto.rental.RentalRegisterDto;
import com.daeyeo.helloDaeyeo.dto.rental.SearchSpecDto;
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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("rentals")
public class RentalController {
    private final SubCategoryService subCategoryService;
    private final RentalObjectService rentalObjectService;
    private final MemberService memberService;
    private final MemberRepository memberRepository;
    private final MainCategoryService mainCategoryService;


    // TODO: total 인자를 0으로 넣고 있지만 데이터베이스에서 총 개수 조회해서 넣어야 함
    @GetMapping("list")
    public String rentalList(@ModelAttribute SearchSpecDto specDto, @ModelAttribute RentalListPageInfoDto pageInfoDto, Model model) {
        List<String> categories = subCategoryService.getCategories(specDto.getMainCategory());
        List<RentalObjectDto> rentalObjectDtos = rentalObjectService.findListBySearchSpec(specDto);
        // 정렬, 갖고오고싶은데이터 필터링하고

//        RentalListDto listDto = new RentalListDto(specDto.getMainCategory(), specDto.getSubCategory(), specDto.getSearchWord(), rentalObjectDtos.size());

//        Page<RentalObject> page = rentalObjectService.find(pageable,rentalObjectDtos);

        model.addAttribute("categories", categories);
//        model.addAttribute("rentalList", listDto);
        model.addAttribute("rentalObjects", rentalObjectDtos);
        model.addAttribute("searchSpec", specDto);
        model.addAttribute("pageInfo", pageInfoDto);

        return "rental/rentalList";
    }

    @GetMapping("write/{objectId}")
    public String rentalWrite(@PathVariable long objectId, Model model) {
        model.addAttribute("rentalObject", rentalObjectService.getRentalObject(objectId));

        return "rental/rentalWrite";
    }
    @GetMapping("/getSubCategories")
    @ResponseBody
    public List<SubCategoryDto> getSubCategories(@RequestParam("mainCategoryId") String mainCategoryId) {
        // 선택한 MainCategory에 대한 SubCategory 데이터를 서비스를 통해 가져옵니다.
        List<SubCategoryDto> subCategoryList = subCategoryService.getSubCategories(mainCategoryId);
        return subCategoryList;
    }

    @GetMapping("register")
    public String showRentalRegistrationForm(HttpServletRequest request, Model model) {

//        memberService.validateMember(request);
        List<MainCategoryDto> mainCategoryList = mainCategoryService.getAllCategories();
        model.addAttribute("registerDto", new RentalRegisterDto());
        model.addAttribute("mainCategoryList",mainCategoryList);
//        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
//        response.setHeader("Pragma", "no-cache");
//        response.setHeader("Expires", "0");

        return "rental/rentalRegistrationForm";
    }


    @RequestMapping("register.do")
    public String register(@ModelAttribute @Valid RentalRegisterDto dto, HttpServletRequest request) {
        memberService.validateMember(request);
        rentalObjectService.insertRentalObject(dto);

        return "redirect:/rentals/list";
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