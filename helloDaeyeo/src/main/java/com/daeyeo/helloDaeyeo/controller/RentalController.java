package com.daeyeo.helloDaeyeo.controller;

import com.daeyeo.helloDaeyeo.dto.rental.RentalObjectDto;
import com.daeyeo.helloDaeyeo.dto.rental.RentalListDto;
import com.daeyeo.helloDaeyeo.dto.rental.RentalRegisterDto;
import com.daeyeo.helloDaeyeo.dto.rental.SearchSpecDto;
import com.daeyeo.helloDaeyeo.service.MemberService;
import com.daeyeo.helloDaeyeo.service.RentalObjectService;
import com.daeyeo.helloDaeyeo.service.SubCategoryService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("rentals")
public class RentalController {
    private final SubCategoryService subCategoryService;
    private final RentalObjectService rentalObjectService;
    private final MemberService memberService;

    @GetMapping("list")
    public String rentalList(@ModelAttribute SearchSpecDto specDto, Model model) {
        List<String> categories = subCategoryService.getCategories(specDto);
        RentalListDto listDto = new RentalListDto(specDto.getMainCategory(), specDto.getSubCategory(), specDto.getSearchWord(), 0);
        List<RentalObjectDto> rentalObjectDtos = rentalObjectService.findListBySearchSpec(specDto);

        model.addAttribute("categories", categories);
        model.addAttribute("rentalList", listDto);
        model.addAttribute("rentalObjects", rentalObjectDtos);

        return "rental/rentalList";
    }

    @GetMapping("write/{objectId}")
    public String rentalWrite(@PathVariable long objectId, Model model) {
        model.addAttribute("rentalObject", rentalObjectService.getRentalObject(objectId));

        return "rental/rentalWrite";
    }

    @GetMapping("register")
    public String showRentalRegistrationForm(HttpServletRequest request) {
        memberService.validateMember(request);

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