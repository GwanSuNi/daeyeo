package com.daeyeo.helloDaeyeo.dto.memberDto;

import com.daeyeo.helloDaeyeo.entity.Member;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
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
    public AdminMemberDto(Member member){
        this.userEmail = member.getUserEmail();
        this.userName = member.getUsername();
        this.phone = member.getPhone();
        this.registDate = member.getRegistDate();
        this.objectCount = member.getRentalObjects().size();
        this.reviewCount = member.getReviews().size();
        this.rentalCount = member.getRentalStatuses().size();
        this.paySum = member.getPaySum();
        this.moneyEarned = member.getMoneyEarned();
    }
}
