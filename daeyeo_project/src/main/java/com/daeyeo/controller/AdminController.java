package com.daeyeo.controller;
import com.daeyeo.entity.*;
import com.daeyeo.entity.ViewTable.DashBoard;
import com.daeyeo.entity.ViewTable.DashBoardMonthly;
import com.daeyeo.entity.ViewTable.DashBoardYearly;
import com.daeyeo.service.*;
import com.daeyeo.service.ViewTable.DashBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/adminMainPage")
    public String adminMainPage(Model model) {
        List <DashBoard> dashBoards = dashBoardService.findDailyAll();
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
    public String adminStatisticsPage(Model model) {
        List <DashBoard> dashBoards = dashBoardService.findDailyAll();
        List <DashBoardMonthly> dashBoardMonthlyList = dashBoardService.findMonthlyAll();
        List <DashBoardYearly> dashBoardYearlyList = dashBoardService.findYearlyAll();
        model.addAttribute("dashBoard",dashBoards);
        model.addAttribute("dashBoardMonthly",dashBoardMonthlyList);
        model.addAttribute("dashBoardYearly",dashBoardYearlyList);
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
