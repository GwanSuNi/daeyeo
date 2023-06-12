package com.daeyeo.controller;

import com.daeyeo.command.RentalListCmd;
import com.daeyeo.command.RentalObjectCmd;
import com.daeyeo.entity.MainCategory;
import com.daeyeo.entity.SubCategory;
import com.daeyeo.entity.UserEntity;
import com.daeyeo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/rental")
public class RentalController {
    @Autowired
    NewUserService userService;
    @Autowired
    MainCategoryService mainCategoryService;
    @Autowired
    SubCategoryService subCategoryService;
    @Autowired
    RentalObjectService rentalObjectService;
    @Autowired
    RentalLogService rentalLogService;

    @RequestMapping("/list")
    public String rentalList(RentalListCmd rentalListCmd, Model model) {
        List<SubCategory> subCategories = subCategoryService.findByMcId(rentalListCmd.getMainCate());
        List<String> list;

        if (rentalListCmd.getMainCate().equals(""))
            list = mainCategoryService.getAllCategories().stream().map(MainCategory::getMcId).collect(Collectors.toList());
        else if (subCategories == null)
            list = new ArrayList<>();
        else
            list = subCategories.stream().map(SubCategory::getScId).collect(Collectors.toList());

        model.addAttribute("categories", list);
        System.out.println("==========================================");
        model.addAttribute("rentalList", rentalObjectService.findRentalObjectByCommand(rentalListCmd));

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
        String send = "rental/rentalList";
        UserEntity loginUser = (UserEntity) session.getAttribute("loginUser");

        if (loginUser == null)
            send = "login/member_login";
        else
            rentalObjectService.insertRentalObject(loginUser.getUserEmail(), rentalObjectCmd);

        return send;
    }

    @RequestMapping("/rental.do")
    public String doRental(@RequestParam int objectId, @RequestParam String startDuration, @RequestParam String endDuration, @RequestParam int price, HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        UserEntity loginUser = (UserEntity) session.getAttribute("loginUser");
        String send = "rental/rentalWrite";

        if (loginUser == null)
            send = "login/member_login";
        else
            rentalLogService.insertRentalLog(objectId, loginUser.getUserEmail(), LocalDate.parse(startDuration), LocalDate.parse(endDuration), price);

        return send;
    }
}
