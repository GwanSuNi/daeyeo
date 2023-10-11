package com.daeyeo.helloDaeyeo.entity;


import com.daeyeo.helloDaeyeo.dto.memberRegistDto.MemberRegisterDto;
import com.daeyeo.helloDaeyeo.dto.memberDto.MemberUpdateDto;
import com.daeyeo.helloDaeyeo.embedded.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Member")
public class Member  {
    @Id
    private String userEmail;
    @OneToMany(mappedBy = "member")
    Set<RentalObject> rentalObjects = new HashSet<RentalObject>();
    @OneToMany(mappedBy = "member")
    Set<RentalStatus> rentalStatuses = new HashSet<RentalStatus>();
    @OneToMany(mappedBy = "member")
    List<Review> reviews = new ArrayList<Review>();
    @Embedded
    private Address memberAddress;
    private String phone;
    private String userPw;
    private String userName;
    // 등록 날짜
    private LocalDateTime registDate;
    private String department;
    // 상태메세지
    private String statusMsg;
    // 유저가 사용한 돈
    private int paySum;
    // 유저가 벌은 돈
    private int moneyEarned;

    public Member(MemberRegisterDto memberRegisterDto){
        this.userEmail = memberRegisterDto.getUserEmail();
        this.userPw = memberRegisterDto.getUserPw();
        this.userName = memberRegisterDto.getUserName();
        this.memberAddress = memberRegisterDto.getAddress();
        this.phone = memberRegisterDto.getPhone();
        this.department = memberRegisterDto.getDepartment();
        this.registDate = LocalDateTime.now();
    }
    public Member(MemberUpdateDto memberUpdateDto){

    }
}
