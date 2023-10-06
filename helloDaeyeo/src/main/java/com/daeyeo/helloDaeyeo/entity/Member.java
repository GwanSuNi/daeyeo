package com.daeyeo.helloDaeyeo.entity;


import com.daeyeo.helloDaeyeo.dto.MemberDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @Column(name = "user_id")
    private String userId;
    @OneToMany(mappedBy = "objectIndex")
    Set<RentalObject> rentalObjects = new HashSet<RentalObject>();
    @OneToMany(mappedBy = "rentalLogIndex")
    List<RentalLog> rentalLogs = new ArrayList<RentalLog>();
    @OneToMany(mappedBy = "reviewIndex")
    List<Review> reviews = new ArrayList<Review>();

    private String userPw;
    private String userEmail;
    private String userName;
    public Member(MemberDto memberDto){
        this.userId = memberDto.getUserId();
        this.userPw = memberDto.getUserPw();
        this.userEmail = memberDto.getUserEmail();
        this.userName = memberDto.getUserName();
    }

}
