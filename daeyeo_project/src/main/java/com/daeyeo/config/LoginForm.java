package com.daeyeo.config;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@Setter
@Getter
public class LoginForm {
    private @NotEmpty(
            message = "이메일은 필수 항목입니다."
    ) String userEmail;
    private @NotEmpty(
            message = "비밀번호는 필수 항목입니다."
    ) String userPw;

}