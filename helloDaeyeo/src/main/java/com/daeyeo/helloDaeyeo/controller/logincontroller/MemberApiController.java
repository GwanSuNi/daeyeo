package com.daeyeo.helloDaeyeo.controller.logincontroller;

import com.daeyeo.helloDaeyeo.dto.memberRegistDto.MemberRegisterDto;
import com.daeyeo.helloDaeyeo.service.MemberService;
import com.daeyeo.helloDaeyeo.service.userDetails.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequiredArgsConstructor
@Tag(name = "유저 컨트롤러", description = "유저 관련 API")
@RequestMapping("/memberApi")
public class MemberApiController {
    private final MemberService memberService;
    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    // TODO: 비밀번호 찾는 로직 구현
    @Operation(summary = "비밀번호 찾기 화면으로 이동")
    @GetMapping("/forgotPw")
    public String memberForgotPw(Model model) {
        return "/login/memberForgotPw";
    }

//    @RequestMapping("/memberLogin")
//    public String memberLogin(Model model) {
//        return "/login/memberLogin";
//    }

    /**
     * 멤버 등록하는 폼을 보내줌
     *
     * @param model
     * @return
     */
    @Operation(summary = "회원가입 화면 이동")
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
    @Operation(summary = "회원가입 수행", description = "MemberRegisterDto를 통해 UserService에서 save")
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
    // TODO: DTO가 없어도 동작함, View 컨트롤러에 있는 /login만으로 통일하고 싶으나, redirect: 시 다른 클래스로 못가는 것이 현 문제
    @Operation(summary = "로그인 화면")
    @GetMapping("/memberLogin")
    public String loginPage(@RequestParam(value = "error", required = false) String error, Model model, @CurrentSecurityContext(expression = "authentication") Authentication authentication) {
        // 로그인 실패 시 원인에 따른 분기
        if ("idpw".equals(error)) {
            // 아이디/비밀번호 불일치 에러 처리
            model.addAttribute("errorMessage", "아이디나 비밀번호가 맞지 않습니다.");
        } else if ("baned".equals(error)) {
            // 계정 정지 에러 처리
            model.addAttribute("errorMessage", "계정이 정지되었습니다. 관리자에게 문의하세요.");
        } else if ("unknown".equals(error)) {
            // 기타 에러 처리
            model.addAttribute("errorMessage", "알 수 없는 이유로 로그인에 실패했습니다. 관리자에게 문의하세요.");
        }
        model.addAttribute("isLogined", !authentication.getName().equals("anonymousUser"));
        log.info("principal : {}, name: {}, authorities: {}, details : {}", authentication.getPrincipal(), authentication.getName(), authentication.getAuthorities(), authentication.getDetails());
        return "/login/memberLogin";
    }

    // 로그인 로직
    // post /login을 내가 만들어버리니까 시큐리티가 내부적으로 동작하는 엔드포인트를 내가 오버라이드 한 것 같음... 따라서 동작이 정상적이지 않았고
    // 비밀번호 검증, 시큐리티 컨텍스트에 있는 인증정보를 모든 엔드포인트에 이동할 때마다 내가 넘겨줘야되는 상황으로 되는 것 같음
    // 추가로 로그인 폼에서 post 방식의 body가 아닌, dto를 사용하니까 문제가 발생하는 것일 수도?
    // 확실한건 이 방식으로 하면 로그인 성공 시 localhost:8080/ 로 설정하는 것이 불가능했음 무조건 localhost:8080/memberApi로 가졌음
//    @PostMapping("/login")
//    public String loginMember(@Valid MemberLoginDto memberLoginDto, BindingResult bindingResult, Model model) {
//        Member member = memberService.findMember(memberLoginDto.getUserEmail()).orElse(null);
//        if (member == null) {
//            model.addAttribute("noUserError", "해당 이메일로 가입돼 있지 않습니다.");
//            return "login/memberLogin";
//        }
//
//        boolean pwMatch = bCryptPasswordEncoder.matches(memberLoginDto.getUserPw(), member.getUserPw());
//        log.info("입력한 pw: {}, DB pw: {}, pwMatch: {}", memberLoginDto.getUserPw(), member.getUserPw(), pwMatch);
//        if (!pwMatch) {
//            log.error("로그인 실패: 비밀번호 불일치");
//            model.addAttribute("pwMatchError", "비밀번호가 같지 않거나 해당 이메일로 가입돼 있지 않습니다.");
//            return "login/memberLogin";
//        }
//        log.info("로그인 성공");
//        return "redirect:/memberApi/mainPage";
//    }
    @Operation(summary = "로그아웃", description = "시큐리티 컨텍스트에서 로그아웃")
    @GetMapping("/logout")
    @Secured({"ROLE_MEMBER", "ROLE_ADMIN"})
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:./memberLogin";
    }
}
