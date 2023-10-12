package com.daeyeo.helloDaeyeo.dto.memberDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberUpdatePwDto {

    private String pw;
    private String newPw1;
    private String newPw;

}
