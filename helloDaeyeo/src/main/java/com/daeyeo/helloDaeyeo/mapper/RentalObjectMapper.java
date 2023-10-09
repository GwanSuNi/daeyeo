package com.daeyeo.helloDaeyeo.mapper;

import com.daeyeo.helloDaeyeo.dto.RentalObjectDto;
import com.daeyeo.helloDaeyeo.entity.RentalObject;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = SubCategoryMapper.class)
public interface RentalObjectMapper {
    RentalObjectDto toDto(RentalObject rentalObject);

    RentalObject toEntity(RentalObjectDto rentalObjectDto);

    List<RentalObjectDto> toDtoList(List<RentalObject> rentalObjects);
}
