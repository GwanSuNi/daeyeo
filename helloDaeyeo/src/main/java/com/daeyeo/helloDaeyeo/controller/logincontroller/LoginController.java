package com.daeyeo.helloDaeyeo.controller.logincontroller;

import com.daeyeo.helloDaeyeo.dto.memberRegistDto.MemberRegisterDto;
import com.daeyeo.helloDaeyeo.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    MemberService memberService;

    @RequestMapping("memberForgotPw")
    public String memberForgotPw(Model model) {
        return "/login/memberForgotPw";
    }

    @RequestMapping("memberLogin")
    public String memberLogin(Model model) {
        return "/login/memberLogin";
    }

    /**
     * 멤버 등록하는 폼을 보내줌
     * @param model
     * @return
     */
    @GetMapping("memberRegister")
    public String memberRegister(Model model) {
        model.addAttribute("memberRegisterDto", new MemberRegisterDto());
        return "/login/memberRegister";
    }
   //TODO 회원가입이 완료되었습니다 라는 팝업창같은거 만들으면 될듯 검증 또한 완벽한게 아니라서 검증을 추가해야할듯
    /***
     * 멤버 등록 폼 안에 값을 채운 Dto 를 받아온후에 그 Dto 로 값을 받아오고 bindingResult 로 값들에대한 검증을함
     * @param memberRegisterDto
     * @param bindingResult
     * @param model
     * @return
     */
    @PostMapping("memberRegister")
    public String insertMember(@Valid @ModelAttribute("memberRegisterDto") MemberRegisterDto  memberRegisterDto, BindingResult bindingResult,
                               Model model) {
        if (bindingResult.hasErrors()) {
            return "login/memberRegister";
        } else if (!memberRegisterDto.getUserPw().equals(memberRegisterDto.getUserPw1())) {
            model.addAttribute("passwordMatchError", "비밀번호가 일치하지 않습니다.");
            return "login/memberRegister";
        } else if (memberService.findMember(memberRegisterDto.getUserEmail()).isPresent()) {
            model.addAttribute("alreadyExistsId", "이미 아이디가 존재합니다.");
            return "login/memberRegister";
        } else {
            memberService.insertMember(memberRegisterDto);
            return "redirect:/login/memberRegister";
        }
    }
}
