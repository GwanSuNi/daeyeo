package com.daeyeo.helloDaeyeo.config;

import com.daeyeo.helloDaeyeo.service.userDetails.UserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    private final UserDetailService userService;

//    private final TokenAuthenticationFilter tokenAuthenticationFilter;

    @Bean
    public WebSecurityCustomizer configure() {
        return (web) -> web.ignoring()
                .requestMatchers(toH2Console())
                .requestMatchers("/static/**", "/css/**", "/error", "/swagger-ui/**", "/v3/**",
                        "/js/**", "/img/**");
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        return http
                http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/user", "/login/**", "/memberApi/**", "/loginCheck").permitAll()
                                .requestMatchers("/memberApi/memberLogin").anonymous()
                                .requestMatchers("/memberApi/register").anonymous()
                                .requestMatchers("/myPage/**").hasAnyRole("MEMBER", "ADMIN")
                                .requestMatchers("/adminpage/**").hasRole("ADMIN")
                                .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/", true)
                )
                .logout((logout) -> logout.permitAll())
                .httpBasic(Customizer.withDefaults());
        return http.build();

        // 옛날 방식 짬뽕이라 주석처리
//                .addFilterBefore(tokenAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
//                .authorizeRequests(authorizeRequests ->
//                        authorizeRequests
//                                .requestMatchers("/user", "/login/**", "/memberApi/**", "/loginCheck").permitAll()
//                                .requestMatchers("/memberApi/memberLogin").anonymous()
//                                .requestMatchers("/memberApi/register").anonymous()
//                                .requestMatchers("/myPage/**").hasAnyRole("MEMBER", "ADMIN")
//                                .requestMatchers("/adminpage/**").hasRole("ADMIN")
//                                .anyRequest().authenticated()
//                )
//                .formLogin()
//                .loginPage("/login")
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .defaultSuccessUrl("/", true)
//                .and()
//                .logout()
//                .logoutSuccessUrl("/login")
//                .invalidateHttpSession(true)
//                .deleteCookies("true")
//                .and()
//                .csrf().disable()
//                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder, UserDetailService userDetailService) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userService)
                .passwordEncoder(bCryptPasswordEncoder)
                .and()
                .build();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}