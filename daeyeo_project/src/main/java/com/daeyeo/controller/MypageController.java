package com.daeyeo.controller;

import com.daeyeo.entity.RentalLog;
import com.daeyeo.entity.RentalObject;
import com.daeyeo.entity.UserEntity;
import com.daeyeo.entity.WishList;
import com.daeyeo.persistence.RentalLogRepository;
import com.daeyeo.persistence.RentalObjectRepository;
import com.daeyeo.persistence.UserRepository;
import com.daeyeo.persistence.WishListRepository;
import org.apache.catalina.User;
import org.dom4j.rule.Mode;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/myPage")
public class MypageController {
    @Autowired
    RentalObjectRepository rentalObjectRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RentalLogRepository rentalLogRepository;
    @Autowired
    WishListRepository wishListRepository;


    @RequestMapping("")
    public String myPage() {
        return "myPage/myPage";
    }

    @RequestMapping("/myWishList")
    public String myWishList(Model model , HttpServletRequest httpServletRequest) {
        UserEntity loginUser = getLoggedInUser(httpServletRequest);
        String loginUserId = loginUser.getUserEmail();
        UserEntity userEntity = userRepository.findByUserEmail(loginUserId).get();
        List<WishList> wishList = wishListRepository.findByUserEntity(userEntity);
        model.addAttribute("wishList",wishList);
        return "myPage/my_wish_list";
    }

    @RequestMapping("/reservation")
    public String reservation(Model model, HttpServletRequest httpServletRequest) {
//            Optional<UserEntity> userEntityOptional = userRepository.findByUserEmail("ax@ax.com1");
//            if(userEntityOptional.isPresent()) {
//                UserEntity userEntity = userEntityOptional.get();
//                List<RentalObject> rentalObjectList = rentalObjectRepository.findByUserEntity(userEntity);
//                model.addAttribute("rentalObject", rentalObjectList);
//            } else {
//                // 사용자가 발견되지 않았을 때 대비하여 예외 처리 코드 작성
//            }
        UserEntity loginUser = getLoggedInUser(httpServletRequest);
        String loginUserId = loginUser.getUserEmail();
        UserEntity userEntity = userRepository.findByUserEmail(loginUserId).get();
        List<RentalObject> rentalObjectList = rentalObjectRepository.findByUserEntity(userEntity);
//        List<RentalObject> rentalObjectList = rentalObjectRepository.findAll();
        model.addAttribute("rentalObject1",rentalObjectList);
        return "myPage/reservation";
    }

    @RequestMapping("/rental_log")
    public String rental_log(Model model , HttpServletRequest httpServletRequest ) {
        UserEntity loginUser = getLoggedInUser(httpServletRequest);
        String loginUserId = loginUser.getUserEmail();
        UserEntity userEntity = userRepository.findByUserEmail(loginUserId).get();
        List<RentalLog> rentalLogs = rentalLogRepository.findByUserEntity(userEntity);
        model.addAttribute("rentalLog",rentalLogs);
        return "myPage/rental_log";
    }


    @RequestMapping("/rental_manage")
    public String rental_manage() {
        return "myPage/rental_manage";
    }
    @RequestMapping("/member_manage")
    public String member_manage() { return "myPage/member_manage";}

    public UserEntity getLoggedInUser(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            return (UserEntity) session.getAttribute("loginUser");
        }
        return null;
    }
}