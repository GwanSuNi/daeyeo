package com.daeyeo.helloDaeyeo.mapper;

import com.daeyeo.helloDaeyeo.dto.rental.RentalStatusDto;
import com.daeyeo.helloDaeyeo.entity.Member;
import com.daeyeo.helloDaeyeo.entity.RentalObject;
import com.daeyeo.helloDaeyeo.entity.RentalStatus;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RentalStatusMapper {
    @Mapping(source = "member.userEmail", target = "userEmail")
    @Mapping(source = "rentalObject.objectIndex", target = "objectIndex")
    RentalStatusDto toDto(RentalStatus rentalStatus);

    RentalStatus toEntity(RentalStatusDto rentalStatusDto, Member member, RentalObject rentalObject);

    @AfterMapping
    default void setMember(Member member, @MappingTarget RentalStatus rentalStatus) {
        rentalStatus.setMember(member);
    }

    @AfterMapping
    default void setRentalObject(RentalObject rentalObject, @MappingTarget RentalStatus rentalStatus) {
        rentalStatus.setRentalObject(rentalObject);
    }
}
