package com.daeyeo.helloDaeyeo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateAccessTokenResponse {
    private String accessToken;
    // 리프레시 토큰을 위한 새로운 필드
    private String refreshToken;
}
