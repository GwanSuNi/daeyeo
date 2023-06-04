package com.daeyeo.config;

import com.daeyeo.service.NewUserService;
import com.daeyeo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter { // 2

    @Autowired
    private UserService userService; // 3

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    } //비밀번호를 그대로 저장하지 않고 BCryptPasswordEncoder의 해시 함수를 이용하여 암호화처리함

    @Override
    public void configure(WebSecurity web) {
        // 인증을 무시할 경로들을 설정해기.
        // static 하위 폴더 (css, js, img)는 무조건 접근이 가능해야하기 때문에 인증을 무시해야함
        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception { // http 관련 인증 설정이 가능
        http
                .authorizeRequests() // 접근에 대한 인증 설정시작
                .antMatchers("/login", "/register").permitAll() // 누구나 접근 허용
                .antMatchers("/").hasRole("USER") // USER, ADMIN만 접근 가능
                .antMatchers("/admin").hasRole("ADMIN") // ADMIN만 접근 가능
                .anyRequest().authenticated() // 나머지 요청들은 권한의 종류에 상관 없이 권한이 있어야 접근 가능
                .and()
                .formLogin() // 로그인에 관한 설정 시작
                    .loginPage("/login") // 로그인 페이지 링크
                    .loginProcessingUrl("/login")
                  .usernameParameter("userEmail") // 이메일 입력란 이름 설정
                  .passwordParameter("userPw") // 비밀번호 입력란 이름 설정
                .and()
                .logout() // 로그아웃에 관한 설정 시작
                    .logoutSuccessUrl("/login") // 로그아웃 성공시 리다이렉트 주소
                    .invalidateHttpSession(true) // 세션 날리기
                .and()
                .exceptionHandling()
                    .accessDeniedPage("/403");

        // 중복 로그인
        http.sessionManagement()
                .maximumSessions(1) // 최대 허용 로그인 세션
                .maxSessionsPreventsLogin(false); // false : 중복 로그인 시 기존 로그인 해제
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception { // 로그인할 때 필요한 정보를 가져오는 곳
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
        // 해당 서비스(userService)에서는 UserDetailsService를 implements해서
        // loadUserByUsername() 구현해야함 (서비스 참고)
        auth.inMemoryAuthentication().withUser("user").password("{noop}1111").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("{noop}1111").roles("ADMIN", "USER");
    }
}