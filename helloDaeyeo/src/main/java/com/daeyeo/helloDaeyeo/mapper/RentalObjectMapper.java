package com.daeyeo.helloDaeyeo.mapper;

import com.daeyeo.helloDaeyeo.dto.rental.RentalObjectDto;
import com.daeyeo.helloDaeyeo.dto.rental.RentalRegisterDto;
import com.daeyeo.helloDaeyeo.entity.Member;
import com.daeyeo.helloDaeyeo.entity.RentalObject;
import com.daeyeo.helloDaeyeo.entity.SubCategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RentalObjectMapper {
    @Mapping(source = "subCategory.scId", target = "scId")
    @Mapping(source = "member.userEmail", target = "userEmail")
    RentalObjectDto toDto(RentalObject rentalObject);

    @Mapping(source = "subCategory", target = "subCategory")
    @Mapping(source = "member", target = "member")
    RentalObject toEntity(RentalRegisterDto rentalRegisterDto, SubCategory subCategory, Member member);

    List<RentalObjectDto> toDtoList(List<RentalObject> rentalObjects);
}
