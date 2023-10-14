package com.daeyeo.helloDaeyeo.dto.memberDto;

import com.daeyeo.helloDaeyeo.embedded.Address;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDto {
    private String userEmail;
    private Address memberAddress;
    private String phone;
    private String userPw;
    private String userName;
    private LocalDateTime registDate;
    private String department;
    private String statusMsg;
    private int paySum;
    private int moneyEarned;
}
