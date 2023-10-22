package com.daeyeo.helloDaeyeo.controller.userView;

import com.daeyeo.helloDaeyeo.dto.category.MainCategoryDto;
import com.daeyeo.helloDaeyeo.dto.category.SubCategoryDto;
import com.daeyeo.helloDaeyeo.service.MainCategoryService;
import com.daeyeo.helloDaeyeo.service.SubCategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@Slf4j
@RequiredArgsConstructor
public class UserViewController {
    private final MainCategoryService mainCategoryService;
    private final SubCategoryService subCategoryService;

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

        List<MainCategoryDto> mainCategories = mainCategoryService.getAllCategories();
        Map<String, List<String>> categories = new HashMap<>();

        for (MainCategoryDto mainCategory : mainCategories) {
            List<SubCategoryDto> subCategories = subCategoryService.getSubCategories(mainCategory.getMcId());
            categories.put(mainCategory.getMcId(), subCategories.stream().map(SubCategoryDto::getScId).collect(Collectors.toList()));
        }

        model.addAttribute("categories", categories);

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
