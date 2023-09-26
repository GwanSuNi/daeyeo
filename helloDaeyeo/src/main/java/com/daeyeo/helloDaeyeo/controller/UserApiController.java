//package com.daeyeo.helloDaeyeo.controller;
//
//import com.daeyeo.helloDaeyeo.dto.AddUserRequest;
//import com.daeyeo.helloDaeyeo.service.UserService;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@RequiredArgsConstructor
//@Controller
//public class UserApiController {
//    private final UserService userService;
//
//
//    @PostMapping("/user")
//    public String signUp(AddUserRequest request) {
//        userService.save(request); // 회원가입 메서드 호출
//        return "redirect:/login";
//    }
//
//    @GetMapping("/logout")
//    public String logout(HttpServletRequest request, HttpServletResponse response) {
//        new SecurityContextLogoutHandler()
//                .logout(request, response,
//                        SecurityContextHolder.getContext().getAuthentication());
//        return "redirect:/login";
//    }
//}
