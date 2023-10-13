package com.daeyeo.helloDaeyeo.dto.memberDto;

import com.daeyeo.helloDaeyeo.embedded.Address;
import com.daeyeo.helloDaeyeo.entity.RentalObject;
import com.daeyeo.helloDaeyeo.entity.RentalStatus;
import com.daeyeo.helloDaeyeo.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
    private String userEmail;
    private Set<RentalObject> rentalObjects = new HashSet<RentalObject>();
    private Set<RentalStatus> rentalStatuses = new HashSet<RentalStatus>();
    private List<Review> reviews = new ArrayList<Review>();
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
