package com.daeyeo.helloDaeyeo.Entity;

import com.daeyeo.helloDaeyeo.Dto.RentalObjectDto;
import com.daeyeo.helloDaeyeo.Repository.SubCategoryRepository;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class RentalObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int objectIndex;
    // scId
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subCategoryId")
    private SubCategory subCategory;
    // userId
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Member member;

    @OneToMany(mappedBy = "rentalObject")
    Set<RentalLog> rentalLogs = new HashSet<RentalLog>();

    @OneToMany(mappedBy = "reviewIndex")
    List<Review> reviews = new ArrayList<Review>();

    // 빌릴 대상 이름
    private String objectName;
    // 사용 비용
    private int usageFee;
    // 최대 인원
    private int maxPerson;

//    private Period period;

    public RentalObject(RentalObjectDto rentalObjectDto){
        this.objectName = rentalObjectDto.getObjectName();
        this.usageFee = rentalObjectDto.getUsageFee();
        this.maxPerson = rentalObjectDto.getMaxPerson();
    }
    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
        subCategory.getRentalObjects().add(this);
    }

    public void setMember(Member member) {
        this.member = member;
        member.getRentalObjects().add(this);
    }
}
