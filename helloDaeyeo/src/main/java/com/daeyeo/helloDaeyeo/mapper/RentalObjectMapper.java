package com.daeyeo.helloDaeyeo.mapper;

import com.daeyeo.helloDaeyeo.dto.RentalObjectDto;
import com.daeyeo.helloDaeyeo.dto.rental.RentalRegisterDto;
import com.daeyeo.helloDaeyeo.entity.Member;
import com.daeyeo.helloDaeyeo.entity.RentalObject;
import com.daeyeo.helloDaeyeo.entity.SubCategory;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = SubCategoryMapper.class)
public interface RentalObjectMapper {
    RentalObjectDto toDto(RentalObject rentalObject);

    RentalObject toEntity(RentalRegisterDto rentalRegisterDto, @Context SubCategory subCategory, @Context Member member);

    List<RentalObjectDto> toDtoList(List<RentalObject> rentalObjects);
}
