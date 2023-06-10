package com.daeyeo.config;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@NoArgsConstructor
@Setter
@Getter
public class LoginForm {
    private String userEmail;
    private String userPw;
}