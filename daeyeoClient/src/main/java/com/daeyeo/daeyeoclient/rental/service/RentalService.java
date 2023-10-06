package com.daeyeo.daeyeoclient.rental.service;

import com.daeyeo.daeyeoclient.common.service.TokenService;
import com.daeyeo.daeyeoclient.rental.dto.RentalObjectResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class RentalService {
    private final WebClient webClient;
    private final TokenService tokenService;

    public Flux<RentalObjectResponseDto> rentalList() {
        return webClient.get()
                .uri("/rentals/list")
                .retrieve()
                .bodyToFlux(RentalObjectResponseDto.class);
    }

    public Mono<RentalObjectResponseDto> rentalWrite(ServerWebExchange exchange) {
        return tokenService.manageAccessToken(exchange)
                .flatMap(accessToken -> webClient.get()
                        .uri("/rentals/write")
                        .header("Authorization", "Bearer " + accessToken)
                        .retrieve()
                        .bodyToMono(RentalObjectResponseDto.class));
    }
}
