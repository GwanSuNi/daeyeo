package com.daeyeo.controller;

import com.daeyeo.entity.*;
import com.daeyeo.entity.ViewTable.DashBoard;
import com.daeyeo.entity.ViewTable.DashBoardMonthly;
import com.daeyeo.entity.ViewTable.DashBoardYearly;
import com.daeyeo.persistence.MemberManagementRepository;
import com.daeyeo.persistence.RentalObjectRepository;
import com.daeyeo.service.*;
import com.daeyeo.service.ViewTable.DashBoardService;
import com.daeyeo.utils.ScriptUtils;
import org.dom4j.rule.Mode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public String adminMainPage(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        if (request.getSession(false).getAttribute("loginUser") == null) {
            ScriptUtils.alert(response, "어드민 계정 로그인이 필요한 페이지 입니다. 로그인 해주세요.");
            return "login/member_login";
        }
        List<DashBoard> dashBoards = dashBoardService.findDailyAll();
        model.addAttribute("dashBoard", dashBoards);
        return "adminpage/adminMainPage";
    }

    @RequestMapping("/adminMemberPage")
    public String adminMemberPage(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        if (request.getSession(false).getAttribute("loginUser") == null) {
            ScriptUtils.alert(response, "어드민 계정 로그인이 필요한 페이지 입니다. 로그인 해주세요.");
            return "login/member_login";
        }
        List<MemberManagement> memberManagement = memberManagementService.findAll();
        model.addAttribute("memberManagement", memberManagement);
        return "adminpage/adminMemberPage";
    }

    @RequestMapping("/adminPostPage")
    public String adminPostPage(HttpServletRequest request,HttpServletResponse response,  Model model) throws Exception {
        if (request.getSession(false).getAttribute("loginUser") == null) {
            ScriptUtils.alert(response, "어드민 계정 로그인이 필요한 페이지 입니다. 로그인 해주세요.");
            return "login/member_login";
        }
        List<RentalObject> rentalObjects = rentalObjectService.findRentalObjectWithUser();
        model.addAttribute("rentalObject", rentalObjects);
        return "adminpage/adminPostPage";
    }

    @RequestMapping("/adminReviewPage")
    public String adminReviewPage(HttpServletRequest request,HttpServletResponse response, Model model) throws Exception{
        if (request.getSession(false).getAttribute("loginUser") == null) {
            ScriptUtils.alert(response, "어드민 계정 로그인이 필요한 페이지 입니다. 로그인 해주세요.");
            return "login/member_login";
        }
        List<Review> reviewList = reviewService.findReviewWithUser();
        model.addAttribute("reviewList", reviewList);
        return "adminpage/adminReviewPage";
    }

    @RequestMapping("/adminStatisticsPage")
    public String adminStatisticsPage(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        if (request.getSession(false).getAttribute("loginUser") == null) {
            ScriptUtils.alert(response, "어드민 계정 로그인이 필요한 페이지 입니다. 로그인 해주세요.");
            return "login/member_login";
        }
        List<DashBoard> dashBoards = dashBoardService.findDailyAll();
        List<DashBoardMonthly> dashBoardMonthlyList = dashBoardService.findMonthlyAll();
        List<DashBoardYearly> dashBoardYearlyList = dashBoardService.findYearlyAll();
        model.addAttribute("dashBoard", dashBoards);
        model.addAttribute("dashBoardMonthly", dashBoardMonthlyList);
        model.addAttribute("dashBoardYearly", dashBoardYearlyList);
        return "adminpage/adminStatisticsPage";
    }

    @RequestMapping("/adminAdPage")
    public String adminAdPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (request.getSession(false).getAttribute("loginUser") == null) {
            ScriptUtils.alert(response, "어드민 계정 로그인이 필요한 페이지 입니다. 로그인 해주세요.");
            return "login/member_login";
        }
        return "adminpage/adminAdPage";
    }

    @RequestMapping("/adminAdFormPage")
    public String adminAdFormPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (request.getSession(false).getAttribute("loginUser") == null) {
            ScriptUtils.alert(response, "어드민 계정 로그인이 필요한 페이지 입니다. 로그인 해주세요.");
            return "login/member_login";
        }
        return "adminpage/adminAdFormPage";
    }
}
