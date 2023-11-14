package com.daeyeo.helloDaeyeo.mapper;

import com.daeyeo.helloDaeyeo.dto.adminDto.*;
import com.daeyeo.helloDaeyeo.dto.memberDto.MemberDto;
import com.daeyeo.helloDaeyeo.dto.rental.RentalObjectDto;
import com.daeyeo.helloDaeyeo.dto.rental.RentalStatusDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdminMapper {
    @Mapping(source = "rentalObjectDto.objectIndex", target = "objectIndex")
    @Mapping(source = "rentalObjectDto.userEmail", target = "offerer")
    MemberRentalsResponseDto toMemberRentalsResponseDto(RentalObjectDto rentalObjectDto, RentalStatusDto rentalStatusDto);

    MemberRegistrationsResponseDto toMemberRegistrationsResponseDto(RentalObjectDto rentalObjectDto, RentalStatisticsDto rentalStatisticsDto);

    @Mapping(source = "rentalObjectDto.userEmail", target = "offerer")
    AllMembersRentalWritesResponseDto toAllMembersRentalWritesResponseDto(RentalObjectDto rentalObjectDto, RentalStatisticsDto rentalStatisticsDto);

    RentalWriteDetailResponseDto toRentalWriteDetailResponseDto(RentalObjectDto rentalObject, RentalStatisticsDto rentalStatistics, List<RentalUsersDetailDto> rentalUsersDetails);

    @Mapping(source = "memberDto.userEmail", target = "userEmail")
    RentalUsersDetailDto toRentalUsersDetailDto(RentalStatusDto rentalStatusDto, MemberDto memberDto);
}
