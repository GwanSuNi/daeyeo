package com.daeyeo.helloDaeyeo.service;

import com.daeyeo.helloDaeyeo.dto.rental.RentalStatusDto;
import com.daeyeo.helloDaeyeo.entity.Member;
import com.daeyeo.helloDaeyeo.entity.RentalObject;
import com.daeyeo.helloDaeyeo.entity.RentalStatus;
import com.daeyeo.helloDaeyeo.entity.Status;
import com.daeyeo.helloDaeyeo.exception.OverlapInTime;
import com.daeyeo.helloDaeyeo.mapper.MemberMapper;
import com.daeyeo.helloDaeyeo.mapper.RentalStatusMapper;
import com.daeyeo.helloDaeyeo.repository.RentalStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
        List<RentalStatus> rentalStatusList = rentalObjectService.getOneRentalObject(rentalObjectId).getRentalStatuses();
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

    public boolean isOverlap(LocalDateTime startTime1, LocalDateTime endTime1, LocalDateTime startTime2, LocalDateTime endTime2) {
        return (startTime1.isBefore(endTime2) && endTime1.isAfter(startTime2));
    }

    public RentalStatus findOne(int statusId) {
        RentalStatus rentalStatus = rentalStatusRepository.findById(statusId).get();
        return rentalStatus;
    }

    /***
     * 대여 신청 목록
     * 대여 상태 기록 메서드
     * 대여했을때 빌려준 입장에서 대여를 허락할지 안할지 보여주는 리스트
     * 값 검증을 위해 메서드를 따로만듬 현재시간보다 endDate가 앞서있으면 rentalStatus로 등록
     * @return
     */
    public List<RentalStatus> beforeUse(List<RentalObject> rentalObjectList) {
        List<RentalStatus> rentalStatuses = new ArrayList<>();
        for (RentalObject rentalObject : rentalObjectList) {
            for (RentalStatus rentalStatus : rentalObject.getRentalStatuses()) {
                if (LocalDateTime.now().isBefore(rentalStatus.getEndTime())) {
                    rentalStatuses.add(rentalStatus);
                }
            }
        }
        return rentalStatusRepository.statusSortPending(rentalStatuses);
    }

    /***
     * 대여 상태 기록 메서드 대여 했을때 빌려준 입장에서 대여가 끝난 상황에서의 기록
     * 누가 빌렸고 내가 대여를 허락해줬는지 안해줬는지 확인할 수 있음 리펙토링 나중에 하겠습니다
     * @param rentalObjectList
     * @return
     */
    public List<RentalStatus> afterUse(List<RentalObject> rentalObjectList) {
        List<RentalStatus> rentalStatuses = new ArrayList<>();
        for (RentalObject rentalObject : rentalObjectList) {
            for (RentalStatus rentalStatus : rentalObject.getRentalStatuses()) {
                if (LocalDateTime.now().isAfter(rentalStatus.getEndTime())) {
                    if (rentalStatus.getStatus() == Status.PENDING) {
                        rentalStatus.setStatus(Status.HOLD);
                        rentalStatusRepository.save(rentalStatus);
                        rentalStatuses.add(rentalStatus);
                    } else if (rentalStatus.getStatus() == Status.ACCEPTED) {
                        rentalStatus.setStatus(Status.COMPLETED);
                        rentalStatusRepository.save(rentalStatus);
                        rentalStatuses.add(rentalStatus);
                    } else {
                        rentalStatuses.add(rentalStatus);
                    }
                }
            }
        }
        return rentalStatuses;
    }

    public void cancelStatus(int statusId) {
        RentalStatus rentalStatus = rentalStatusRepository.findById(statusId).get();
        rentalStatus.setStatus(Status.CANCELED);
        rentalStatusRepository.save(rentalStatus);
        // rentalLog 생성로직 작성해야함
    }

    public void permitStatus(int statusId) {
        RentalStatus rentalStatus = rentalStatusRepository.findById(statusId).get();
        rentalStatus.setStatus(Status.ACCEPTED);
        rentalStatusRepository.save(rentalStatus);
        // rentalLog 생성로직 작성해야함
    }


    public List<RentalStatus> rentalStatusBefore(Member member) {
        List<RentalStatus> rentalStatuses = member.getRentalStatuses();
        List<RentalStatus> rentalStatusSet = new ArrayList<>();
        for (RentalStatus rentalStatus : rentalStatuses) {
            if (LocalDateTime.now().isBefore(rentalStatus.getEndTime())) {
                rentalStatusSet.add(rentalStatus);
            }
        }
        return rentalStatusSet;
    }

    public List<RentalStatus> rentalStatusAfter(Member member) {
        List<RentalStatus> rentalStatuses = member.getRentalStatuses();
        List<RentalStatus> rentalStatusSet = new ArrayList<>();
        for (RentalStatus rentalStatus : rentalStatuses) {
            if (LocalDateTime.now().isAfter(rentalStatus.getEndTime())) {
                rentalStatusSet.add(rentalStatus);
            }
        }
        return rentalStatusSet;
    }


}
