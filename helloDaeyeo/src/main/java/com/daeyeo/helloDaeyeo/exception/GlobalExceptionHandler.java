package com.daeyeo.helloDaeyeo.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.view.RedirectView;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundMemberException.class)
    public RedirectView handleNotFoundMemberException(NotFoundMemberException e, Model model) {
        model.addAttribute("message", e.getMessage());

        return new RedirectView("login");
    }
}
