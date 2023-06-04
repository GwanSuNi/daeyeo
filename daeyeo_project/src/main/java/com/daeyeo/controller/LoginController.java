package com.daeyeo.controller;

import com.daeyeo.dto.UserDTO;
import com.daeyeo.entity.UserEntity;
import com.daeyeo.service.NewUserService;
import com.daeyeo.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller

@AllArgsConstructor
public class LoginController {
    @Autowired
    private NewUserService uService;
    @Autowired
    private UserService userService;
    @Autowired
    private
    PasswordEncoder passwordEncoder;

    @RequestMapping("/login")
    public String loginPage() {
        return "login/member_login";
    }

    @RequestMapping("/register")
    public String register() {
        System.out.println("bdbd");
        return "login/member_register";
    }

    @RequestMapping("/forgotPw")
    public String findPw() {
        return "login/member_forgotPw";
    }

    @PostMapping("/register")
    public String post_register(UserDTO userDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "/login";
        }

        UserEntity user = UserEntity.createUser(userDTO, passwordEncoder);

        try {
            uService.validateDuplicateMember(user);
        } catch (IllegalStateException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "/login";
        }

        uService.insertUser(user);

        return "redirect:/";
    }

    @GetMapping("/login_process")
    public String processLogin(@RequestParam("userEmail") String userEmail,
                               @RequestParam("userPw") String userPw,
                               HttpServletRequest request, Model model) {
        System.out.println("login_process 가 실행됨");
        try {
            request.login(userEmail, userPw); // 로그인 시도
        } catch (ServletException e) {
            model.addAttribute("errorMessage", "Login Error: Check Your Account");
            return "login/member_login";    
        }

        return "redirect:/"; // 로그인 성공 후 리다이렉트할 페이지 (예: 홈페이지)
    }

    @PostMapping("/login2")
    public String login(@ModelAttribute UserDTO userDTO, HttpSession session) {
        UserDTO loginResult = userService.login(userDTO);
        if (loginResult != null) {
            // 로그인 성공
            System.out.println("로그인 성공");
            session.setAttribute("loginEmail", loginResult.getUserEmail());
//            session.setMaxInactiveInterval();
            return "redirect:/";
        } else {
            return "redirect:/error/403";
        }
    }
}
