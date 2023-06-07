package com.daeyeo.config;

import javax.validation.constraints.NotEmpty;

public class LoginForm {
    private @NotEmpty(
            message = "이메일은 필수 항목입니다."
    ) String userEmail;
    private @NotEmpty(
            message = "비밀번호는 필수 항목입니다."
    ) String userPw;

    public LoginForm() {
    }

    public String getuserEmail() {
        return this.userEmail;
    }

    public String getuserPw() {
        return this.userPw;
    }

    public void setuserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setuserPw(String userPw) {
        this.userPw = userPw;
    }
}
