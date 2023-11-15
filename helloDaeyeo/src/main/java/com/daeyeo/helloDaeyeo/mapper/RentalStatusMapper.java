package com.daeyeo.helloDaeyeo.mapper;

import com.daeyeo.helloDaeyeo.dto.rental.RentalStatusDto;
import com.daeyeo.helloDaeyeo.entity.Member;
import com.daeyeo.helloDaeyeo.entity.RentalObject;
import com.daeyeo.helloDaeyeo.entity.RentalStatus;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RentalStatusMapper {
    @Mapping(source = "member.id", target = "userId")
    @Mapping(source = "rentalObject.objectIndex", target = "objectIndex")
    RentalStatusDto toDto(RentalStatus rentalStatus);

    @Mapping(source = "member.userEmail", target = "userEmail") // 여기서는 원본 소스가 넘 많은데 뭘 써야될까요? 라는 에러를 보여줬었는데
    @Mapping(source = "member", target = "member")
        // 여기서 지맘대로 0으로 한 이유는 ??
    RentalStatus toEntity(RentalStatusDto rentalStatusDto, Member member, RentalObject rentalObject);

    List<RentalStatusDto> toDtoList(List<RentalStatus> rentalStatuses);

    @AfterMapping
    default void setMember(Member member, @MappingTarget RentalStatus rentalStatus) {
        rentalStatus.setMember(member);
    }

    @AfterMapping
    default void setRentalObject(RentalObject rentalObject, @MappingTarget RentalStatus rentalStatus) {
        rentalStatus.setRentalObject(rentalObject);
    }
}
