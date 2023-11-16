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
    private Member member;
    private String userEmail;

    @ManyToOne(fetch = FetchType.LAZY)
    private RentalObject rentalObject;

    @OneToOne(mappedBy = "rentalStatus")
    private Review review;

    @OneToMany(mappedBy = "rentalStatus")
    private List<RentalLog> rentalLogs = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Status status;

    // 대여 신청 날짜
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    // 대여하는 날짜
    private LocalDate rentalDate;

    @Transient
    private String rentalDateString;
    @Transient
    private String startTimeString;
    @Transient
    private String endTimeString;

    public void formatRental() {
        LocalDate rentalDate1 = this.rentalDate;
        String year = String.valueOf(rentalDate1.getYear());
        String month = String.valueOf(rentalDate1.getMonthValue());
        String day = String.valueOf(rentalDate1.getDayOfMonth());
        this.rentalDateString = year + "년 " + month + "월 " + day + "일";

        LocalDateTime startTime1 = this.startTime;
        LocalDateTime endTime1 = this.endTime;
        // 시간과 분 값을 가져와서 문자열로 변환
        int startHour = startTime1.getHour();
        int startMinute = startTime1.getMinute();
        String formattedStartHour = String.format("%02d", startHour);
        String formattedStartMinute = String.format("%02d", startMinute);
        this.startTimeString = formattedStartHour + "시 " + formattedStartMinute + "분";

        int endHour = endTime1.getHour();
        int endMinute = endTime1.getMinute();
        String formattedEndHour = String.format("%02d", endHour);
        String formattedEndMinute = String.format("%02d", endMinute);
        this.endTimeString = formattedEndHour + "시 " + formattedEndMinute + "분";
    }

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
