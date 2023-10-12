package com.daeyeo.helloDaeyeo.mapper;

import com.daeyeo.helloDaeyeo.dto.rental.RentalObjectDto;
import com.daeyeo.helloDaeyeo.dto.rental.RentalRegisterDto;
import com.daeyeo.helloDaeyeo.entity.Member;
import com.daeyeo.helloDaeyeo.entity.RentalObject;
import com.daeyeo.helloDaeyeo.entity.SubCategory;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RentalObjectMapper {
    @Mapping(source = "subCategory.scId", target = "scId")
    @Mapping(source = "member.userEmail", target = "userEmail")
    RentalObjectDto toDto(RentalObject rentalObject);

    RentalObject toEntity(RentalRegisterDto rentalRegisterDto, @Context SubCategory subCategory, @Context Member member);

    List<RentalObjectDto> toDtoList(List<RentalObject> rentalObjects);
}
