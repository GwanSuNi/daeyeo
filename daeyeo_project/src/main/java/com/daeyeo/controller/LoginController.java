package com.daeyeo.controller;

import com.daeyeo.config.LoginForm;
import com.daeyeo.config.UserCreateForm;
import com.daeyeo.entity.UserEntity;
import com.daeyeo.exception.NotCorrespondingEmailException;
import com.daeyeo.service.LoginService;
import com.daeyeo.service.NewUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String login(@Valid LoginForm form, BindingResult bindingResult, HttpServletRequest request, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("err", true);
            return "login/member_login";
        }

        try {
            UserEntity loginUser = loginService.login(form.getUserEmail(), form.getUserPw());
            HttpSession session = request.getSession();
            session.setAttribute("loginUser", loginUser);
            return "redirect:/";
        } catch (IllegalStateException | NotCorrespondingEmailException exception) {
            model.addAttribute("loginErr", true);
            return "login/member_login";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "mainPage";
    }

    public UserEntity getLoggedInUser(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            return (UserEntity) session.getAttribute("loginUser");
        }
        return null;
    }

    @RequestMapping("/register")
    public String register() {
        return "login/member_register";
    }

    @PostMapping("/register.do")
    public String userRegister(@Valid UserCreateForm userCreateForm, BindingResult bindingResult,
                               Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("err", true);
            return "login/member_register";
        }
        try {
            uService.userRegister(userCreateForm.getUserName(), userCreateForm.getUserEmail(), userCreateForm.getUserPw(), userCreateForm.getPhoneNum(),
                    userCreateForm.getUserCategory(), userCreateForm.getDepartment(), userCreateForm.getZonecode(), userCreateForm.getRoadAddress(),
                    userCreateForm.getJibunAddress(), userCreateForm.getSido(), userCreateForm.getSigungu());
        } catch (IllegalStateException exception) {
            model.addAttribute("registErr", true);
            return "login/member_register";

        }
        return "redirect:/";
    }


    @RequestMapping("/forgotPw")
    public String findPw() {
        return "login/member_forgotPw";
    }
}