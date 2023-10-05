package com.daeyeo.helloDaeyeo.Dto;

import com.daeyeo.helloDaeyeo.Entity.Member;
import com.daeyeo.helloDaeyeo.Entity.SubCategory;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RentalObjectDto {
    private SubCategory subCategory;
    private Member member;
    private String objectName;
    private int usageFee;
    private int maxPerson;

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public RentalObjectDto(String objectName, int usageFee, int maxPerson) {
        this.objectName = objectName;
        this.usageFee = usageFee;
        this.maxPerson = maxPerson;
    }
}
