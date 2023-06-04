package com.daeyeo.controller;
import com.daeyeo.entity.RentalObject;
import com.daeyeo.entity.SubCategory;
import com.daeyeo.persistence.RentalObjectRepository;
import com.daeyeo.service.NewUserService;
import com.daeyeo.service.RentalLogService;
import com.daeyeo.service.RentalObjectService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Transactional
public class AdminController {
    @Autowired
    RentalObjectService rentalObjectService;

    @RequestMapping("/adminMainPage")
    public String adminMainPage(Model model) {
        RentalObject rentalObject1 = rentalObjectService.findRentalObject(5,"scIdTest","test@test.com").get();
        SubCategory subCategory = rentalObject1.getSubCategory();
        model.addAttribute("subCategory",subCategory);
        model.addAttribute("rentalObject",rentalObject1);
        return "adminpage/adminMainPage";
    }

    @RequestMapping("/adminMemberPage")
    public String adminMemberPage() {
        return "adminpage/adminMemberPage";
    }
    @RequestMapping("/adminPostPage")
    public String adminPostPage(){
        return "adminpage/adminPostPage";
    }
    @RequestMapping("/adminReviewPage")
    public String adminReviewPage(){
        return "adminpage/adminReviewPage";
    }
    @RequestMapping("/adminStatisticsPage")
    public String adminStatisticsPage() {
        return "adminpage/adminStatisticsPage";
    }
    @RequestMapping("/adminAdPage")
    public String adminAdPage(){
        return "adminpage/adminAdPage";
    }
    @RequestMapping("/adminAdFormPage")
    public String adminAdFormPage(){
        return "adminpage/adminAdFormPage";
    }
}
