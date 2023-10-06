package com.daeyeo.helloDaeyeo.service;

import com.daeyeo.helloDaeyeo.config.jwt.TokenProvider;
import com.daeyeo.helloDaeyeo.entity.RefreshToken;
import com.daeyeo.helloDaeyeo.entity.User;
import com.daeyeo.helloDaeyeo.repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;

@RequiredArgsConstructor
@Service
public class RefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;
    private final TokenProvider tokenProvider;

    public RefreshToken findByRefreshToken(String refreshToken) {
        return refreshTokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected token"));
    }

    // 리프레시 토큰 발급 및 서버 저장
    // TODO: 만료기간 변수화
    public RefreshToken createRefreshToken(User user) {
        String refreshToken = tokenProvider.generateToken(user, Duration.ofDays(2));
        // 리프레시 토큰 서버 저장
        return refreshTokenRepository.save(new RefreshToken(user.getId(), refreshToken));
    }
}