package com.daeyeo.daeyeoclient.member.controller;

import com.daeyeo.daeyeoclient.member.service.MemberService;
import com.daeyeo.daeyeoclient.member.dto.LoginRequestDto;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
@RequestMapping("members")
public class MemberController {
    private final MemberService service;

    @GetMapping("login")
    public String loginPage(Model model) {
        model.addAttribute("loginDto", new LoginRequestDto());
        return "login/member_login";
    }

    @PostMapping("login.do")
    public Mono<ResponseEntity<Void>> login(@ModelAttribute LoginRequestDto dto, HttpServletResponse response) {
        return service.login(dto).map(tokenDto -> {
            createCookie(response, "access_token", tokenDto.getAccessToken(), 1);
            createCookie(response, "refresh_token", tokenDto.getRefreshToken(), 7);

            return ResponseEntity.ok().build();
        });
    }

    private void createCookie(HttpServletResponse response, String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setHttpOnly(true); // JavaScript에서 쿠키에 접근하는 것을 방지해서 크로스 사이트 스크립팅 공격(XSS)을 통한 쿠키의 도난을 방지할 수 있음.
        cookie.setSecure(true); // 쿠키가 HTTPS를 통해서만 전송되도록 해서 중간자 공격을 통한 쿠키의 도난을 방지할 수 있음.
        cookie.setMaxAge(maxAge * 24 * 60 * 60); // maxAge * 1일
        response.addCookie(cookie);
        // SameSite는 쿠키가 크로스 사이트 요청과 함께 전송되는 것을 제어하고 크로스 사이트 요청 위조 공격(CSRF)에 대한 일부 보호를 제공.
        // SameSite 플래그는 Strict, Lax, None의 세 가지 값이 있고 우리는 api 요청에 access 토큰을 포함해야 해서 None을 사용.
        // None은 어떠한 종류의 보호도 제공하지 않고 브라우저는 모든 크로스 사이트 브라우징 컨텍스트에서 쿠키를 첨부함
        // setSameSite()는 javax.servlet.http.Cookie 클래스가 지원하지 않으므로 헤더를 통해 직접 설정해야 함.
        response.addHeader("Set-Cookie", name + "=" + value+ "; SameSite=None");
    }
}
