package com.daeyeo.helloDaeyeo.mapper;

import com.daeyeo.helloDaeyeo.dto.rental.RentalStatusDto;
import com.daeyeo.helloDaeyeo.entity.RentalStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RentalStatusMapper {
    @Mapping(source = "member.userEmail", target = "userEmail")
    @Mapping(source = "rentalObject.objectIndex", target = "objectIndex")
    RentalStatusDto toDto(RentalStatus rentalStatus);
}
