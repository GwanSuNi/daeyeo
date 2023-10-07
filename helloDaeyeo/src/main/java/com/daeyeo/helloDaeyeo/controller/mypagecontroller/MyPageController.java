package com.daeyeo.helloDaeyeo.controller.mypagecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/myPage")
public class MyPageController {
    @RequestMapping("")
    public String mypage(){
        return "/myPage/myPage";
    }
    @RequestMapping("myWishList")
    public String wishList(){
        return "/myPage/myWishList";
    }
    @RequestMapping("reservation")
    public String reservation(){
        return "/myPage/reservation";
    }
    @RequestMapping("rentalManage")
    public String rentalManage(){
        return "/myPage/rentalManage";
    }
    @RequestMapping("rentalLog")
    public String rentalLog(){
        return "/myPage/rentalLog";
    }
    @RequestMapping("memberManage")
    public String memberManage(){
        return "/myPage/memberManage";
    }

}
