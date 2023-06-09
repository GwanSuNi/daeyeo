package com.daeyeo.controller;

import com.daeyeo.config.LoginForm;
import com.daeyeo.entity.UserEntity;
import com.daeyeo.service.LoginService;
import com.daeyeo.service.NewUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class LoginController {
    @Autowired
    private NewUserService uService;
    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    public String loginPage() {
        return "login/member_login";
    }

    @PostMapping("/login.do")
    public String login(@Valid LoginForm form, BindingResult bindingResult, HttpServletRequest request) {
//        try {
//            UserEntity loginUser = loginService.login(form.getEmail(), form.getPassword());
//        } catch (IllegalStateException e) {
//            // 에러 메시지 설정 및 반환 페이지 설정
//            return "error/login_failed";
//        }

        // LoginForm 에 email 혹은 password 의 값이 존재하지 않을 때
        if (bindingResult.hasErrors()) {
            System.out.println("값이 없어요!");
            return "login/member_login";
        }
        System.out.println("값이 있어요!");
        UserEntity loginUser = loginService.login(form.getUserEmail(), form.getUserPw());

        /**
         * 로그인 성공 처리
         **/
//        //세션이 있으면 있는 세션 반환, 없으면 신규 세션을 생성
        HttpSession session = request.getSession();
//        //세션에 로그인 회원 정보 보관
        session.setAttribute("loginUser", loginUser);
        return "redirect:/";
    }
    public UserEntity getLoggedInUser(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            return (UserEntity) session.getAttribute("loginUser");
        }
        return null;
    }

    @RequestMapping("/register")
    public String register() {return "login/member_register";}
//    public String register() {
//        System.out.println("bdbd");
//        return "login/member_register";
//    }

    @RequestMapping("/forgotPw")
    public String findPw() {
        return "login/member_forgotPw";
    }

//    @PostMapping("/register")
//    public String post_register(UserDTO userDTO, BindingResult bindingResult, Model model) {
//        if (bindingResult.hasErrors()) {
//            return "/login";
//        }
//
//        UserEntity user = UserEntity.createUser(userDTO, passwordEncoder);
//
//        try {
//            uService.validateDuplicateMember(user);
//        } catch (IllegalStateException e) {
//            model.addAttribute("errorMessage", e.getMessage());
//            return "/login";
//        }
//
//        uService.insertUser(user);
//
//        return "redirect:/";
//    }
//    @GetMapping("/index")
//    public String index(@AuthenticationPrincipal Principal principal, Model model) {
//        model.addAttribute("username", principal.getName());
//        return "index";
//    }

//    @GetMapping("/login_process")
//    public String processLogin(@RequestParam("userEmail") String userEmail,
//                               @RequestParam("userPw") String userPw,
//                               HttpServletRequest request, Model model) {
//        System.out.println("login_process 가 실행됨");
//        try {
//            request.login(userEmail, userPw); // 로그인 시도
//        } catch (ServletException e) {
//            model.addAttribute("errorMessage", "Login Error: Check Your Account");
//            return "login/member_login";
//        }
//
//        return "redirect:/"; // 로그인 성공 후 리다이렉트할 페이지 (예: 홈페이지)
//    }

//    @RequestMapping("/findPw")
//    public String findPw() {return "login/member_forgotPw";}
//}
//    @GetMapping("/login_process")
//    public String login(@ModelAttribute UserDTO userDTO, HttpSession session) {
//        System.out.println("loing2 가 실행되긴 함");
//        UserDTO loginResult = userService.login(userDTO);
//        if (loginResult != null) {
//            // 로그인 성공
//            System.out.println("로그인 성공");
//            session.setAttribute("loginEmail", loginResult.getUserEmail());
////            session.setMaxInactiveInterval();
//            return "redirect:/";
//        } else {
//            return "redirect:/error/403";
//        }
//    }
}