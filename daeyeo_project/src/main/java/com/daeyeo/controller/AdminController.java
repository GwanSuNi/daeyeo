package com.daeyeo.controller;
import com.daeyeo.entity.*;
import com.daeyeo.persistence.MemberManagementRepository;
import com.daeyeo.persistence.RentalObjectRepository;
import com.daeyeo.service.*;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Controller
@Transactional
public class AdminController {
    @Autowired
    RentalObjectService rentalObjectService;
    @Autowired
    NewUserService userService;
    @Autowired
    MainCategoryService mainCategoryService;
    @Autowired
    MemberManagementService memberManagementService;
    @Autowired
    DashBoardService dashBoardService;
    @Autowired
    ReviewService reviewService;
    @Autowired
    AdService adService;


    @RequestMapping("/adminMainPage")
    public String adminMainPage(Model model) {
        List <DashBoard> dashBoards = dashBoardService.findAll();
        model.addAttribute("dashBoard",dashBoards);
        return "adminpage/adminMainPage";
    }

    @RequestMapping("/adminMemberPage")
    public String adminMemberPage(Model model) {
        List<MemberManagement> memberManagement = memberManagementService.findAll();
        model.addAttribute("memberManagement",memberManagement);
        return "adminpage/adminMemberPage";
    }
    @RequestMapping("/adminPostPage")
    public String adminPostPage(Model model){
        List<RentalObject> rentalObjects = rentalObjectService.findRentalObjectWithUser();
        model.addAttribute("rentalObject",rentalObjects);
        return "adminpage/adminPostPage";
    }
    @RequestMapping("/adminReviewPage")
    public String adminReviewPage(Model model){
        List<Review> reviewList = reviewService.findReviewWithUser();
        model.addAttribute("reviewList",reviewList);
        return "adminpage/adminReviewPage";
    }
    @RequestMapping("/adminStatisticsPage")
    public String adminStatisticsPage() {
        return "adminpage/adminStatisticsPage";
    }
    @RequestMapping("/adminAdPage")
    public String adminAdPage(){
        List<Advertisement> advertisements = adService.fin

        return "adminpage/adminAdPage";
    }
    @RequestMapping("/adminAdFormPage")
    public String adminAdFormPage(){
        return "adminpage/adminAdFormPage";
    }
}
