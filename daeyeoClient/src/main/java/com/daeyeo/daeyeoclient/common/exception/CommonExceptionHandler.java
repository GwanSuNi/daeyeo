package com.daeyeo.daeyeoclient.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;

@ControllerAdvice
public class CommonExceptionHandler {
    @ExceptionHandler(AuthenticationRequiredException.class)
    public Mono<Void> handleAuthenticationRequiredException(ServerWebExchange exchange) {
        return Mono.fromRunnable(() -> {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            exchange.getResponse().getHeaders().setLocation(URI.create("/login"));
        });
    }
}
