package com.daeyeo.helloDaeyeo.entity;

import com.daeyeo.helloDaeyeo.embedded.Address;
import com.daeyeo.helloDaeyeo.embedded.ApplicationPeriod;
import com.daeyeo.helloDaeyeo.embedded.UsagePeriod;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
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
    private String userEmail;
    @OneToMany(mappedBy = "rentalObject")
    List<RentalStatus> rentalStatuses = new ArrayList<>();
    @OneToMany(mappedBy = "rentalObject")
    List<WishList> wishListList = new ArrayList<>();
    // 빌릴 대상 이름
    private String objectName;

    // 주소
    @Embedded
    private Address address;

    // 사용 비용
    private int usageFee;

    // 접수 기간
    @Embedded
    private ApplicationPeriod applicationPeriod;

    // 이용 기간
    @Embedded
    private UsagePeriod usagePeriod;

    // 취소 기간
    int cancellation;

    // 최대 인원
    private int maxPerson;

    // 웹 사이트
    private String webSite;

    // 문의 전화
    private String inquiryPhone;
    private int visitCount;

    @ElementCollection
    @CollectionTable(name = "rental_object_images", joinColumns = @JoinColumn(name = "objectIndex"))
    @Lob
    private List<byte[]> images = new ArrayList<>();

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
        subCategory.getRentalObjects().add(this);
    }

    public void setMember(Member member) {
        this.member = member;
        member.getRentalObjects().add(this);
    }
}
