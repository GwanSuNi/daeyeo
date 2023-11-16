package com.daeyeo.helloDaeyeo.dto.memberDto;

import com.daeyeo.helloDaeyeo.embedded.Address;
import com.daeyeo.helloDaeyeo.entity.Role;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDto {
    private long userId;
    private String userEmail;
    private Address memberAddress;
    private String phone;
    private String userPw;
    private String nickname;
    private LocalDateTime registDate;
    private String department;
    private String statusMsg;
    private int paySum;
    private int moneyEarned;
    private LocalDateTime banEndDate;
    private Set<Role> roles;
}
