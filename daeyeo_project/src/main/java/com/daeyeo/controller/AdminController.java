package com.daeyeo.controller;
import com.daeyeo.entity.MainCategory;
import com.daeyeo.entity.RentalObject;
import com.daeyeo.entity.SubCategory;
import com.daeyeo.entity.UserEntity;
import com.daeyeo.persistence.RentalObjectRepository;
import com.daeyeo.service.MainCategoryService;
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


    @RequestMapping("/adminMainPage")
    public String adminMainPage(Model model) {
//        Date minRegistDate = userService.getOldesRegistDate();
//        List<String> dateList = userService.createDateList(minRegistDate);
//        for (String date : dateList) {
//            String[] splitDate = date.split(",");
//            model.addAttribute("dateList", splitDate);
//        }
//        int paySum = userService.findByPaySum();
//        model.addAttribute("paysum",paySum);
        List<RentalObject> rentalObject1 = rentalObjectService.findAll();
        DateTimeFormatter newDateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년MM월dd HH:mm:ss");
        for (RentalObject rentalObject : rentalObject1) {
            LocalDateTime originalDateTime = rentalObject.getReceiptDuration();
            String formattedDateTime = originalDateTime.format(newDateTimeFormatter);
            rentalObject.setReceiptDuration(LocalDateTime.parse(formattedDateTime, newDateTimeFormatter));
        }
        model.addAttribute("rentalObject",rentalObject1);
        return "adminpage/adminMainPage";
    }

    @RequestMapping("/adminMemberPage")
    public String adminMemberPage(Model model) {
        List<UserEntity> userEntities = userService.findAll();


//        userEntities.
        model.addAttribute("userEntity",userEntities);
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
