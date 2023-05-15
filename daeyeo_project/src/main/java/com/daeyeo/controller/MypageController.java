package com.daeyeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/myPage")
public class MypageController {
    @RequestMapping("")
    public String myPage() {
        return "myPage/myPage";
    }

    @RequestMapping("/passwordChange")
    public String passwordChange() {
        return "myPage/passwordChange";
    }

    @RequestMapping("/profile")
    public String profile() {
        return "myPage/profile";
    }

    @RequestMapping("/myWishList")
    public String myWishList() {
        return "myPage/my_wish_list";
    }

    @RequestMapping("/reservation")
    public String reservation() {
        return "myPage/reservation";
    }

    @RequestMapping("/rental_log")
    public String rental_log() {
        return "myPage/rental_log";
    }

    @RequestMapping("/rental_manage")
    public String rental_manage() {
        return "myPage/rental_manage";
    }
}
