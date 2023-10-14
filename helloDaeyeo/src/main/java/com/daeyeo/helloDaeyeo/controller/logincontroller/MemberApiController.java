package com.daeyeo.helloDaeyeo.controller.logincontroller;

import com.daeyeo.helloDaeyeo.dto.memberDto.MemberLoginDto;
import com.daeyeo.helloDaeyeo.dto.memberRegistDto.MemberRegisterDto;
import com.daeyeo.helloDaeyeo.entity.Member;
import com.daeyeo.helloDaeyeo.service.MemberService;
import com.daeyeo.helloDaeyeo.service.userDetails.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@Tag(name = "유저 컨트롤러", description = "유저 관련 API")
@RequestMapping("/memberApi")
public class MemberApiController {
    private final MemberService memberService;
    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping("/forgotPw")
    public String memberForgotPw(Model model) {
        return "/login/memberForgotPw";
    }

//    @RequestMapping("/memberLogin")
//    public String memberLogin(Model model) {
//        return "/login/memberLogin";
//    }

    /**
     * 멤버 등록하는 폼을 보내줌
     * @param model
     * @return
     */
    @GetMapping("/register")
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
    @PostMapping("/register")
    public String insertMember(@Valid MemberRegisterDto memberRegisterDto, BindingResult bindingResult,
                               Model model) {
        if (bindingResult.hasErrors()) {
            return "login/memberRegister";
        } else if (!memberRegisterDto.getUserPw().equals(memberRegisterDto.getUserPw1())) {
            model.addAttribute("passwordMatchError", "비밀번호가 일치하지 않습니다.");
            return "login/memberRegister";
        } else if (memberService.findMember(memberRegisterDto.getUserEmail()).isPresent()) {
            model.addAttribute("alreadyExistsId", "해당 이메일로 가입한 유저가 존재합니다.");
            return "login/memberRegister";
        } else {
            userService.save(memberRegisterDto);
            return "redirect:./memberLogin";
        }
    }

    // 로그인 페이지
    @GetMapping("/memberLogin")
    public String loginPage(Model model) {
        model.addAttribute("memberLoginDto", new MemberLoginDto());
        return "/login/memberLogin";
    }

    // 로그인 로직
    @PostMapping("/login.do")
    public String loginMember(@Valid MemberLoginDto memberLoginDto, BindingResult bindingResult, Model model) {
        Member member = memberService.findMember(memberLoginDto.getUserEmail()).orElse(null);
        if (member == null) {
            model.addAttribute("noUserError", "해당 이메일로 가입돼 있지 않습니다.");
            return "login/memberLogin";
        }

        boolean pwMatch = bCryptPasswordEncoder.matches(memberLoginDto.getUserPw(), member.getUserPw());
        log.info("입력한 pw: {}, DB pw: {}, pwMatch: {}", memberLoginDto.getUserPw(), member.getUserPw(), pwMatch);
        if (!pwMatch) {
            model.addAttribute("pwMatchError", "비밀번호가 같지 않거나 해당 이메일로 가입돼 있지 않습니다.");
            return "login/memberLogin";
        }
        // TODO: 대충 다 괜찮을 때 로직

        return "redirect:../mainPage";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request,response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:./memberLogin";
    }
}
