package com.daeyeo.helloDaeyeo.controller.userView;

import com.daeyeo.helloDaeyeo.dto.category.MainCategoryDto;
import com.daeyeo.helloDaeyeo.dto.category.SubCategoryDto;
import com.daeyeo.helloDaeyeo.service.MainCategoryService;
import com.daeyeo.helloDaeyeo.service.MemberService;
import com.daeyeo.helloDaeyeo.service.SubCategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
