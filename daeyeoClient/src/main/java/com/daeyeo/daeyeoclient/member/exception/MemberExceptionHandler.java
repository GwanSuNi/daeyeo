package com.daeyeo.daeyeoclient.member.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@ControllerAdvice
public class MemberExceptionHandler {
    @ExceptionHandler(WebClientResponseException.class)
    public RedirectView handleWebClientResponseException(WebClientResponseException e, RedirectAttributes redirectAttributes) {
        if (e.getStatusCode() == HttpStatus.UNAUTHORIZED) {
            redirectAttributes.addFlashAttribute("error", "아이디 또는 비밀번호가 잘못되었습니다.");
            return new RedirectView("/members/login");
        } else {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return new RedirectView("/error");
        }
    }
}
