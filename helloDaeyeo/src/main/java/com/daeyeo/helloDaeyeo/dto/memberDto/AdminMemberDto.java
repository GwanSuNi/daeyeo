package com.daeyeo.helloDaeyeo.dto.memberDto;

import com.daeyeo.helloDaeyeo.entity.Member;
import com.daeyeo.helloDaeyeo.entity.Role;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Getter
@Setter
@Slf4j
public class AdminMemberDto {

    private String userEmail;
    private String userName;
    private String phone;
    private LocalDateTime registDate;
    private int rentalCount;
    private int objectCount;
    private int reviewCount;
    private int paySum;
    private int moneyEarned;
    // 가장 최상위의 권한만 가짐 (View에서 검사하지 않게 하기 위해서)
    private String topRole;
    // 어드민 여부
    private boolean isAdmin = false;

    public AdminMemberDto(Member member) {
        this.userEmail = member.getUserEmail();
        this.userName = member.getUsername();
        this.phone = member.getPhone();
        this.registDate = member.getRegistDate();
        this.objectCount = member.getRentalObjects().size();
        this.reviewCount = member.getReviews().size();
        this.rentalCount = member.getRentalStatuses().size();
        this.paySum = member.getPaySum();
        this.moneyEarned = member.getMoneyEarned();
        for (Role role : member.getRoles()) {
            if (role.equals(Role.ADMIN)) {
                this.isAdmin = true;
                this.topRole = Role.ADMIN.name();
                break;
            } else if (role.equals(Role.MEMBER)) {
                this.topRole = Role.MEMBER.name();
            }
        }
    }
}
