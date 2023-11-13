package com.daeyeo.helloDaeyeo.dto.memberDto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberUpdatePwDto {
    @NotNull(message = "입력해주세요")
    private String pw;
    @NotNull(message = "입력해주세요")
    private String newPw;
    @NotNull(message = "입력해주세요")
    private String newPwRepeat;
}
