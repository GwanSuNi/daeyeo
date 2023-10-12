package com.daeyeo.helloDaeyeo.entity;

import com.daeyeo.helloDaeyeo.embedded.Address;
import com.daeyeo.helloDaeyeo.embedded.CancellationPeriod;
import com.daeyeo.helloDaeyeo.embedded.UsagePeriod;
import com.daeyeo.helloDaeyeo.embedded.Phone;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
public class RentalObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long objectIndex;
    // scId
    @ManyToOne(fetch = FetchType.LAZY)
    private SubCategory subCategory;
    // userId
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @OneToMany(mappedBy = "rentalObject")
    Set<RentalStatus> rentalStatuses = new HashSet<RentalStatus>();

    @OneToMany(mappedBy = "rentalObject")
    List<Review> reviews = new ArrayList<Review>();

    // 빌릴 대상 이름
    private String objectName;
    // 장소
    private String place;
    // 주소
    @Embedded
    private Address address;
    // 사용 비용
    private int usageFee;
    // 이용 기간
    @Embedded
    private UsagePeriod usagePeriod;
    // 취소 기간
    @Embedded
    private CancellationPeriod cancellationPeriod;
    // 최대 인원
    private int maxPerson;
    // 웹 사이트
    private String webSite;
    // 문의 전화
    @Embedded
    private Phone inquiryPhone;


    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
        subCategory.getRentalObjects().add(this);
    }

    public void setMember(Member member) {
        this.member = member;
        member.getRentalObjects().add(this);
    }
}
