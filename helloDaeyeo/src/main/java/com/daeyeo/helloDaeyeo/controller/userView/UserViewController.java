package com.daeyeo.helloDaeyeo.controller.userView;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class UserViewController {
    @GetMapping("/login")
    public String login(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("isLogined", !authentication.getName().equals("anonymousUser"));
        log.info("principal : {}, name: {}, authorities: {}, details : {}",authentication.getPrincipal(), authentication.getName(), authentication.getAuthorities(), authentication.getDetails());
        return "login/memberLogin";
    }
//
//    @GetMapping("/signup")
//    public String signup() {
//        return "login/memberRegister";
//    }

    @GetMapping("/")
    public String mainPage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("isLogined", !authentication.getName().equals("anonymousUser"));
        log.info("principal : {}, name: {}, authorities: {}, details : {}",authentication.getPrincipal(), authentication.getName(), authentication.getAuthorities(), authentication.getDetails());
        return "/mainPage";
    }

    @GetMapping("/loginCheck")
    public String loginCheck(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("isLogined", !authentication.getName().equals("anonymousUser"));
        log.info("principal : {}, name: {}, authorities: {}, details : {}",authentication.getPrincipal(), authentication.getName(), authentication.getAuthorities(), authentication.getDetails());
        return "/login/loginCheck";
    }

    @GetMapping("guidebook")
    public String guidebook() {
        return "guidebook";
    }

    @GetMapping("txtEditor")
    public String txtEditor() {
        return "txtEditor";
    }
}
