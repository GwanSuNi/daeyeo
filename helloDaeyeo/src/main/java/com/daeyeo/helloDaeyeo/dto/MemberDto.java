package com.daeyeo.helloDaeyeo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
    private String userId;
    private String userPw;
    private String userEmail;
    private String userName;
}
