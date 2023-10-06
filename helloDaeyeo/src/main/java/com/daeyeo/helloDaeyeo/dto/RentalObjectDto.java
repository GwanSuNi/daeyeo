package com.daeyeo.helloDaeyeo.dto;

import com.daeyeo.helloDaeyeo.entity.Member;
import com.daeyeo.helloDaeyeo.entity.SubCategory;
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
