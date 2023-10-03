package com.daeyeo.daeyeoclient.member.service;

import com.daeyeo.daeyeoclient.member.dto.LoginRequestDto;
import com.daeyeo.daeyeoclient.member.dto.TokenDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final WebClient webClient;

    public Mono<TokenDto> login(LoginRequestDto dto) {
        return webClient.post()
                .uri("/login")
                .bodyValue(dto)
                .retrieve()
                .bodyToMono(TokenDto.class);
    }
}
