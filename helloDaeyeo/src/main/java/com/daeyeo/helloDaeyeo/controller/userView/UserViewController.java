package com.daeyeo.helloDaeyeo.controller.userView;

import com.daeyeo.helloDaeyeo.dto.mainPage.MainPageRentalItemDto;
import com.daeyeo.helloDaeyeo.dto.mainPage.MainPageResponseDto;
import com.daeyeo.helloDaeyeo.dto.rental.RentalStatusDto;
import com.daeyeo.helloDaeyeo.mapper.MainPageMapper;
import com.daeyeo.helloDaeyeo.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Controller
@Slf4j
@RequiredArgsConstructor
public class UserViewController {
    private final MainCategoryService mainCategoryService;
    private final SubCategoryService subCategoryService;
    private final RentalStatusService rentalStatusService;
    private final RentalObjectService rentalObjectService;
    private final MainPageService mainPageService;
    private final MainPageMapper mainPageMapper;

    @GetMapping("/login")
    public String login() {
        return "login/memberLogin";
    }
//
//    @GetMapping("/signup")
//    public String signup() {
//        return "login/memberRegister";
//    }

    @GetMapping("/")
    public String mainPage(Model model, @CurrentSecurityContext(expression = "authentication") Authentication authentication) {
        log.info("principal : {}, name: {}, authorities: {}, details : {}", authentication.getPrincipal(), authentication.getName(), authentication.getAuthorities(), authentication.getDetails());
        MainPageResponseDto mainPageResponseDto = mainPageService.prepareMainPage(authentication.getName());
        model.addAttribute("mainPage", mainPageResponseDto);
        return "/mainPage";
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

    @GetMapping("guidebook")
    public String guidebook() {
        return "guidebook";
    }

    @GetMapping("txtEditor")
    public String txtEditor() {
        return "txtEditor";
    }
}
