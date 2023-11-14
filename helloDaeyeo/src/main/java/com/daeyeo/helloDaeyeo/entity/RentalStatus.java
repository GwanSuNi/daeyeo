package com.daeyeo.helloDaeyeo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RentalStatus {
    // review 키의 주인
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rentalStatusId;

    @ManyToOne(fetch = FetchType.LAZY)
    Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    RentalObject rentalObject;

    @OneToOne(mappedBy = "rentalStatus")
    private Review review;

    @OneToMany(mappedBy = "rentalStatus")
    List<RentalLog> rentalLogs = new ArrayList<RentalLog>();

    @Enumerated(EnumType.STRING)
    private Status status;

    // 대여 신청 날짜
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    // 대여하는 날짜
    private LocalDate rentalDate;

    // 결제금액
    private int payment;

    public void setMember(Member member) {
        this.member = member;
        member.getRentalStatuses().add(this);
    }

    public void setRentalObject(RentalObject rentalObject) {
        this.rentalObject = rentalObject;
        rentalObject.getRentalStatuses().add(this);
    }

    public void setReivew(Review review) {
        this.review = review;
        review.getRentalStatus().setReivew(review);
    }
}
