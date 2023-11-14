package com.daeyeo.helloDaeyeo.service;

import com.daeyeo.helloDaeyeo.dto.adminDto.*;
import com.daeyeo.helloDaeyeo.dto.memberDto.MemberDto;
import com.daeyeo.helloDaeyeo.dto.rental.RentalObjectDto;
import com.daeyeo.helloDaeyeo.dto.rental.RentalStatusDto;
import com.daeyeo.helloDaeyeo.entity.Status;
import com.daeyeo.helloDaeyeo.mapper.AdminMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final RentalStatusService rentalStatusService;
    private final RentalObjectService rentalObjectService;
    private final MemberService memberService;
    private final AdminMapper adminMapper;

    /**
     * 회원이 대여한 내역을 조회하는 서비스 메서드
     *
     * @param userEmail 회원
     * @return rentalObjectDto와 rentalStatusDto를 memberRentalsResponseDto에 넣어 반환
     */
    public List<MemberRentalsResponseDto> findMemberRentals(String userEmail) {
        // userEmail로 rentalStatus를 조회
        List<RentalStatusDto> statusDtos = rentalStatusService.findRentalStatuses(userEmail);
        List<MemberRentalsResponseDto> responseDtos = new ArrayList<>();

        for (RentalStatusDto statusDto : statusDtos) {
            // 조회한 rentalStatus의 objectIndex로 rentalObject를 조회
            RentalObjectDto objectDto = rentalObjectService.getRentalObject(statusDto.getObjectIndex());
            // 조회한 rentalStatus와 rentalObject를 mapper를 통해 memberRentalsResponse에 매핑
            responseDtos.add(adminMapper.toMemberRentalsResponseDto(objectDto, statusDto));
        }

        return responseDtos;
    }

    /**
     * 회원이 등록한 대여 항목을 조회하는 서비스 메서드
     *
     * @param userEmail 회원
     * @return MemberRegistrationsResponseDto 리스트
     */
    public List<MemberRegistrationsResponseDto> findMemberRegistrations(String userEmail) {
        List<RentalObjectDto> objectDtos = rentalObjectService.getRentalObjects(userEmail);

        return generateResponseFromRentalData(objectDtos, adminMapper::toMemberRegistrationsResponseDto);
    }

    /**
     * 모든 회원의 등록한 대여 항목을 조회하는 서비스 메서드
     *
     * @return AllMembersRentalWritesResponseDto 리스트
     */
    public List<AllMembersRentalWritesResponseDto> findAllMembersRentalWrites() {
        List<RentalObjectDto> objectDtos = rentalObjectService.findAll();

        return generateResponseFromRentalData(objectDtos, adminMapper::toAllMembersRentalWritesResponseDto);
    }

    /**
     * RentalObject을 기반으로 대여 수입, 대여 신청 횟수, 대여 성사 횟수가 포함된 응답 dto를 생성하는 메서드
     *
     * @param objectDtos RentalObjectDto 리스트
     * @param mapper     RentalObjectDto와 RentalStatistics를 응답 dto에 매핑해주는 메서드
     * @param <T>        응답 dto 타입
     * @return 응답 dto 리스트
     */
    private <T> List<T> generateResponseFromRentalData(List<RentalObjectDto> objectDtos, BiFunction<RentalObjectDto, RentalStatisticsDto, T> mapper) {
        List<T> responseDtos = new ArrayList<>();

        for (RentalObjectDto objectDto : objectDtos) {
            // RentalObject의 RentalStatus 조회
            List<RentalStatusDto> statusDtos = rentalStatusService.findRentalStatuses(objectDto.getObjectIndex());
            int income = 0; // 대여 수입
            int successCount = 0; // 대여 성사 횟수

            for (RentalStatusDto statusDto : statusDtos) {
                // 대여 수입 계산
                income += statusDto.getPayment();

                // 대여 상태가 COMPLETED인 경우에만 대여 성사 횟수 증가
                if (statusDto.getStatus() == Status.COMPLETED)
                    successCount++;
            }

            // RentalObjectDto와 RentalStatistics를 응답 dto에 매핑하고 리스트에 추가
            responseDtos.add(mapper.apply(objectDto, new RentalStatisticsDto(income, statusDtos.size(), successCount)));
        }

        return responseDtos;
    }

    public RentalWriteDetailResponseDto getRentalWriteDetail(Long objectIndex) {
        RentalObjectDto objectDto = rentalObjectService.getRentalObject(objectIndex);
        List<RentalStatusDto> statusDtos = rentalStatusService.findRentalStatuses(objectIndex);
        List<RentalUsersDetailDto> usersDetailDtos = new ArrayList<>();
        int income = 0;
        int successCount = 0;

        for (RentalStatusDto statusDto : statusDtos) {
            MemberDto memberDto = memberService.getMember(statusDto.getUserEmail());

            usersDetailDtos.add(adminMapper.toRentalUsersDetailDto(statusDto, memberDto));
            income += statusDto.getPayment();

            if (statusDto.getStatus() == Status.COMPLETED)
                successCount++;
        }

        RentalStatisticsDto statisticsDto = new RentalStatisticsDto(income, statusDtos.size(), successCount);

        return adminMapper.toRentalWriteDetailResponseDto(objectDto, statisticsDto, usersDetailDtos);
    }
}
