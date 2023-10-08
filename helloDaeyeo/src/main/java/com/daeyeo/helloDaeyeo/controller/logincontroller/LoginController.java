package com.daeyeo.helloDaeyeo.controller.logincontroller;

import com.daeyeo.helloDaeyeo.dto.MemberRegisterDto;
import com.daeyeo.helloDaeyeo.service.MemberService;
import jakarta.validation.Valid;
import org.hibernate.grammars.hql.HqlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    MemberService memberService;

    @RequestMapping("memberForgotPw")
    public String memberForgotPw(Model model){
        return "/login/memberForgotPw";
    }
    @RequestMapping("memberLogin")
    public String memberLogin(Model model){
        return "/login/memberLogin";
    }
    @GetMapping("memberRegister")
    public String memberRegister(Model model){
        model.addAttribute("memberRegisterDto", new MemberRegisterDto());
        return "/login/memberRegister";
    }
    @PostMapping("memberRegister")
    public String insertMember(@Valid MemberRegisterDto memberRegisterDto , BindingResult bindingResult ,
                               Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("err", true);
            return "login/memberRegister";
        }
        try {
        memberService.insertMember(memberRegisterDto);

        } catch (IllegalStateException exception) {
            model.addAttribute("registErr", true);
            return "login/memberRegister";
        }
        return "redirect:/login/memberRegister";
    }
}
