package com.daeyeo.helloDaeyeo.dto.memberDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberLoginDto {
    @NotEmpty(message = "이메일을 입력하세요")
    @Email(message = "이메일 형식에 맞게 다시 입력하세요")
    private String userEmail;
    @NotEmpty(message = "비밀번호를 입력하세요")
    @Size(min = 4)
    private String userPw;
}
