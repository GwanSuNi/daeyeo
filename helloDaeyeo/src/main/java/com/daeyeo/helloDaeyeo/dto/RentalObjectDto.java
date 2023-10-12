package com.daeyeo.helloDaeyeo.dto;

import com.daeyeo.helloDaeyeo.dto.category.SubCategoryDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RentalObjectDto {
    private long objectIndex;
    private SubCategoryDto subCategory;
    private String objectName;
    private int usageFee;
    private int maxPerson;

    public RentalObjectDto(String objectName, int usageFee, int maxPerson) {
        this.objectName = objectName;
        this.usageFee = usageFee;
        this.maxPerson = maxPerson;
    }
}
