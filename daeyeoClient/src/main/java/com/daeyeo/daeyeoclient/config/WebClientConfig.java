package com.daeyeo.daeyeoclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Bean
    public WebClient webClient() {
//        return WebClient.create("http://localhost:8081");
        return WebClient.create("https://ad6a7dff-be61-44b0-a067-bf01080904e9.mock.pstmn.io");
    }
}
