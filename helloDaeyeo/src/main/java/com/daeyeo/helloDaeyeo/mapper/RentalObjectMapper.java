package com.daeyeo.helloDaeyeo.mapper;

import com.daeyeo.helloDaeyeo.dto.rental.RentalObjectDto;
import com.daeyeo.helloDaeyeo.dto.rental.RentalRegisterDto;
import com.daeyeo.helloDaeyeo.entity.Member;
import com.daeyeo.helloDaeyeo.entity.RentalObject;
import com.daeyeo.helloDaeyeo.entity.SubCategory;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RentalObjectMapper {
    @Mapping(source = "subCategory.mainCategory.mcId", target = "mcId")
    @Mapping(source = "subCategory.scId", target = "scId")
    @Mapping(source = "member.userEmail", target = "userEmail")
    RentalObjectDto toDto(RentalObject rentalObject);

    RentalObject toEntity(RentalRegisterDto rentalRegisterDto, SubCategory subCategory, Member member);

    @AfterMapping
    default void setSubCategory(SubCategory subCategory, @MappingTarget RentalObject rentalObject) {
        rentalObject.setSubCategory(subCategory);
    }

    @AfterMapping
    default void setMember(Member member, @MappingTarget RentalObject rentalObject) {
        rentalObject.setMember(member);
    }
}
