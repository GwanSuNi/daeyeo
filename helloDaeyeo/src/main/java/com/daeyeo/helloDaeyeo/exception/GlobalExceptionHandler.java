package com.daeyeo.helloDaeyeo.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundMemberException.class)
    public String handleNotFoundMemberException(NotFoundMemberException e, Model model) {
        model.addAttribute("message", e.getMessage());

        return "login";
    }
}
