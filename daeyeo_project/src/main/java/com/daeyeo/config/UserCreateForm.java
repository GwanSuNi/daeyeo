package com.daeyeo.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;

@NoArgsConstructor
@Setter
@Getter
public class UserCreateForm {
    private String userName;
    @Email
    private String userEmail;
    private String userPw;
    private String phoneNum;
    private String userCategory;
    private String department;

    private int zonecode;
    private String roadAddress;
    private String jibunAddress;
    private String sido;
    private String sigungu;
}