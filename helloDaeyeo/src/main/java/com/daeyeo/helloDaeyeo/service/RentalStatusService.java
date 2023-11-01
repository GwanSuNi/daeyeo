package com.daeyeo.helloDaeyeo.service;

import com.daeyeo.helloDaeyeo.dto.rental.RentalStatusDto;
import com.daeyeo.helloDaeyeo.entity.Member;
import com.daeyeo.helloDaeyeo.entity.RentalObject;
import com.daeyeo.helloDaeyeo.entity.RentalStatus;
import com.daeyeo.helloDaeyeo.exception.OverlapInTime;
import com.daeyeo.helloDaeyeo.mapper.MemberMapper;
import com.daeyeo.helloDaeyeo.mapper.RentalObjectMapper;
import com.daeyeo.helloDaeyeo.mapper.RentalStatusMapper;
import com.daeyeo.helloDaeyeo.repository.RentalStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RentalStatusService {
    final private RentalStatusRepository rentalStatusRepository;

    final private RentalObjectService rentalObjectService;
    final private MemberService memberService;

    final private RentalStatusMapper rentalStatusMapper;
    final private MemberMapper memberMapper;

    public void insertRentalStatus(RentalStatusDto rentalStatusDto) {
        Member member = memberMapper.toEntity(memberService.getMember(rentalStatusDto.getUserEmail()));
        RentalObject rentalObject = rentalObjectService.getOneRentalObject(rentalStatusDto.getObjectIndex());
        RentalStatus rentalStatus = rentalStatusMapper.toEntity(rentalStatusDto, member, rentalObject);

        rentalStatusRepository.save(rentalStatus);
    }

    public List<RentalStatusDto> getRentalStatuses(String userEmail) {
        Member member = memberMapper.toEntity(memberService.getMember(userEmail));
        List<RentalStatus> rentalStatuses = rentalStatusRepository.findByMember(member);

        return rentalStatusMapper.toDtoList(rentalStatuses);
    }

    public boolean validPeriod(long rentalObjectId, LocalDateTime startTime, LocalDateTime endTime) {
        // 해당 rentalObject 의 id를 갖고 와서 rentalObject의 Set<RentalStatus>를 갖고와서
        // 현재 고객이 고른시간이랑 rentalStatus 랑 비교하기 ( 시간이 안겹치는지 비교하기 )
        Set<RentalStatus> rentalStatusList = rentalObjectService.getOneRentalObject(rentalObjectId).getRentalStatuses();
        for (RentalStatus rentalStatus : rentalStatusList) { // rentalStatus 의 시작시간과 끝나는시간을 다 갖고오는거지
            System.out.println(rentalStatusList.size());
            System.out.println("시간검증횟수");
            LocalDateTime statusStartTime = rentalStatus.getStartTime();
            LocalDateTime statusEndTime = rentalStatus.getEndTime();
            // 두 기간이 겹치는지 확인
            if (isOverlap(startTime, endTime, statusStartTime, statusEndTime)) {
                // 시간이 겹친다는 뜻
                throw new OverlapInTime("시간이 겹칩니다 시간을 다시 설정해주세요");
            }
        }
        // 시간이 겹치지않아서 true
        return true;
    }

    private boolean isOverlap(LocalDateTime startTime1, LocalDateTime endTime1, LocalDateTime startTime2, LocalDateTime endTime2) {
        return (startTime1.isBefore(endTime2) && endTime1.isAfter(startTime2));
    }

}
