package com.daeyeo.helloDaeyeo.handler.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String errMsg;
        // 여기에서 실패 이유 확인
        if (exception instanceof BadCredentialsException || exception instanceof InternalAuthenticationServiceException) {
            errMsg = "idpw";
        } else if (exception instanceof DisabledException) {
            // 계정 비활성화 실패 처리
            errMsg = "baned";
//        } else if (exception instanceof LockedException) {
//            // 계정 잠금 실패 처리
        } else {
            // 기타 실패 처리
            errMsg = "unknown";
        }
        response.sendRedirect("/memberApi/memberLogin?error=" + errMsg);
    }
}
