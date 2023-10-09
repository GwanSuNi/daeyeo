package com.daeyeo.helloDaeyeo.controller;

import com.daeyeo.helloDaeyeo.dto.RentalObjectDto;
import com.daeyeo.helloDaeyeo.dto.rental.RentalListDto;
import com.daeyeo.helloDaeyeo.dto.rental.SearchSpecDto;
import com.daeyeo.helloDaeyeo.service.RentalObjectService;
import com.daeyeo.helloDaeyeo.service.SubCategoryService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/rental")
public class RentalController {
    private final SubCategoryService subCategoryService;
    private final RentalObjectService rentalObjectService;

    @GetMapping("/list")
    public String rentalList(@ModelAttribute SearchSpecDto specDto, Model model) {
        List<String> categories = subCategoryService.getCategories(specDto);
        RentalListDto listDto = new RentalListDto(specDto.getMainCategory(), specDto.getSubCategory(), specDto.getSearchWord(), 0);
        List<RentalObjectDto> rentalObjectDtos = rentalObjectService.findListBySearchSpec(specDto);

        model.addAttribute("categories", categories);
        model.addAttribute("rentalList", listDto);
        model.addAttribute("rentalObjects", rentalObjectDtos);

        return "rental/rentalList";
    }

    @RequestMapping("/write")
    public String rentalWrite(@RequestParam("objectId") int objectId, Model model) {
        model.addAttribute("rentalObject", rentalObjectService.findRentalObject(objectId));

        return "rental/rentalWrite";
    }

    @RequestMapping("/form")
    public String rentalRegistrationForm(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        UserEntity loginUser = (UserEntity) session.getAttribute("loginUser");
        String send = "rental/rentalRegistrationForm";

        if (loginUser == null)
            send = "login/member_login";

        return send;
    }

    @RequestMapping("/register.do")
    public String doRegister(RentalObjectCmd rentalObjectCmd, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        UserEntity loginUser = (UserEntity) session.getAttribute("loginUser");
        String send = "redirect:/rental/list";

        if (loginUser == null)
            send = "redirect:/login";
        else
            rentalObjectService.insertRentalObject(loginUser.getUserEmail(), rentalObjectCmd);

        return send;
    }

    @RequestMapping("/rental.do")
    public String doRental(@RequestParam int objectId, @RequestParam String startDuration, @RequestParam String endDuration, @RequestParam int price, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        UserEntity loginUser = (UserEntity) session.getAttribute("loginUser");
        String send = "redirect:/rental/list";

        if (loginUser == null)
            send = "redirect:/login";
        else
            rentalLogService.insertRentalLog(objectId, loginUser.getUserEmail(), LocalDate.parse(startDuration), LocalDate.parse(endDuration), price);

        return send;
    }
}