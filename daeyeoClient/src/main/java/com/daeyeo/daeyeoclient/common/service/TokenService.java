package com.daeyeo.daeyeoclient.common.service;

import com.daeyeo.daeyeoclient.common.exception.AccessTokenMissingException;
import com.daeyeo.daeyeoclient.common.exception.AuthenticationRequiredException;
import com.daeyeo.daeyeoclient.common.exception.RefreshTokenMissingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpCookie;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TokenService {
    private final WebClient webClient;

    public Mono<String> getTokenFromCookie(ServerWebExchange exchange, String tokenName) {
        return Mono.fromSupplier(() -> {
            HttpCookie cookie = exchange.getRequest().getCookies().getFirst(tokenName);
            if (cookie != null)
                return cookie.getValue();
            else
                return null;
        });
    }

    public Mono<String> getAccessTokenFromCookie(ServerWebExchange exchange) {
        return getTokenFromCookie(exchange, "access_token")
                .switchIfEmpty(Mono.error(new AccessTokenMissingException()));
    }

    public Mono<String> refreshAccessToken(ServerWebExchange exchange) {
        return Mono.justOrEmpty(getTokenFromCookie(exchange, "refresh_token"))
                .switchIfEmpty(Mono.error(new RefreshTokenMissingException()))
                .flatMap(refreshToken -> webClient.post()
                        .uri("/refresh")
                        .bodyValue(refreshToken)
                        .retrieve()
                        .bodyToMono(String.class));
    }

    public Mono<String> manageAccessToken(ServerWebExchange exchange) {
        return getAccessTokenFromCookie(exchange)
                .onErrorResume(AccessTokenMissingException.class, e -> refreshAccessToken(exchange))
                .onErrorResume(RefreshTokenMissingException.class, e -> Mono.error(new AuthenticationRequiredException()));
    }
}