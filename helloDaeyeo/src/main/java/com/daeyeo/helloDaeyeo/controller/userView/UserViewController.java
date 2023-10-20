package com.daeyeo.helloDaeyeo.controller.userView;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class UserViewController {
    // TODO: 타임리프에서 sec:authentication이 작동하지 않아서 이런 방식으로 해봤는데, 코드 중복이 많아서 AOP를 적용해야하나 하는...
    @GetMapping("/login")
    public String login(Model model, @CurrentSecurityContext SecurityContext context) {
        Authentication authentication = context.getAuthentication();
        model.addAttribute("isLogined", !(authentication instanceof AnonymousAuthenticationToken));
        log.info("principal : {}, name: {}, authorities: {}, details : {}", authentication.getPrincipal(), authentication.getName(), authentication.getAuthorities(), authentication.getDetails());
        return "login/memberLogin";
    }
//
//    @GetMapping("/signup")
//    public String signup() {
//        return "login/memberRegister";
//    }

    @GetMapping("/")
    public String mainPage(Model model, @CurrentSecurityContext(expression = "authentication") Authentication authentication) {
        model.addAttribute("isLogined", !(authentication instanceof AnonymousAuthenticationToken));
        // 권한을 컬렉션에서 확인
        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(authority -> "ROLE_ADMIN".equals(authority.getAuthority()));
        model.addAttribute("isAdmin", isAdmin);
        log.info("principal : {}, name: {}, authorities: {}, details : {}", authentication.getPrincipal(), authentication.getName(), authentication.getAuthorities(), authentication.getDetails());
        return "mainPage";
    }

    @GetMapping("/loginCheck")
    public String loginCheck(Model model, @CurrentSecurityContext(expression = "authentication") Authentication authentication) {
        model.addAttribute("isLogined", !(authentication instanceof AnonymousAuthenticationToken));
        model.addAttribute("name", authentication.getName());

        // 권한을 컬렉션에서 확인
        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(authority -> "ROLE_ADMIN".equals(authority.getAuthority()));
        model.addAttribute("isAdmin", isAdmin);
        log.info("principal : {}, name: {}, authorities: {}, details : {}", authentication.getPrincipal(), authentication.getName(), authentication.getAuthorities(), authentication.getDetails());
        return "/login/loginCheck";
    }
}
