package com.daeyeo.daeyeoclient.rental.controller;

import com.daeyeo.daeyeoclient.rental.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
@RequestMapping("rentals")
public class RentalController {
    private final RentalService service;

    @GetMapping("list")
    public Mono<String> rentalList(Model model) {
        return service.rentalList()
                .collectList()
                .doOnSuccess(objects -> model.addAttribute("rentalObjects", objects))
                .thenReturn("rental/rentalList");
    }

    @GetMapping("write")
    public Mono<String> rentalWriteWithToken(ServerWebExchange exchange, Model model) {
        return service.rentalWrite(exchange)
                .doOnSuccess(object -> model.addAttribute("rentalObject", object))
                .thenReturn("rental/rentalWrite");
    }
}
