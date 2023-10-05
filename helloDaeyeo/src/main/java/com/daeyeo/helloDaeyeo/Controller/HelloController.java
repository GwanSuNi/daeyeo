package com.daeyeo.helloDaeyeo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","Hello");
        return "hello";
        // hello.html 확장자가 자동으로 붙음
        // 컨트롤러에서 return 해주면 templates에 가서 hello.html 을 자동으로 찾아줌
        // templates 는 동적리소스 간단하게 jsp 페이지같은것들 넣으면 됨
        // static 은 정적 리소스 이미지나 디자인 등등


    }
    @GetMapping("rentalList")
    public String testRental(){
        return "rentalList";
    }
}
