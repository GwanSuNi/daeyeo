package com.daeyeo.helloDaeyeo.service;

import com.daeyeo.helloDaeyeo.dto.adminDto.SuspendRequestDto;
import com.daeyeo.helloDaeyeo.dto.memberDto.*;
import com.daeyeo.helloDaeyeo.dto.memberRegistDto.MemberRegisterDto;
import com.daeyeo.helloDaeyeo.entity.Member;
import com.daeyeo.helloDaeyeo.entity.RentalObject;
import com.daeyeo.helloDaeyeo.exception.IdAlreadyExistsException;
import com.daeyeo.helloDaeyeo.exception.NotFoundMemberException;
import com.daeyeo.helloDaeyeo.mapper.MemberMapper;
import com.daeyeo.helloDaeyeo.repository.MemberRepository;
import com.daeyeo.helloDaeyeo.session.SessionUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
/*
  readOnly 속성은 값에대한 변화가 없을때 true 설정
  default 는 값에대한 변화가 있을때인 false 라서 값에대한 변화가 있는것들은 @Transactional만 적어줌
 */
// 이렇게 클래스에 설정해놓으면 클래스안에 메서드들이 리드온리값이 먹히고
// @Transactional 설정한 애들은 readonly = false 가 default 인 값들이 먹힌다
//
public class MemberService {
    private final MemberRepository memberRepository;
    private final MemberMapper mapper;
    private final Jackson2ObjectMapperBuilder builder = Jackson2ObjectMapperBuilder.json().modulesToInstall(new JavaTimeModule());
    private final ObjectMapper objectMapper = builder.build();

    @Transactional
    public void insertMember(MemberRegisterDto memberRegisterDto) {
        Optional<Member> member = memberRepository.findById(memberRegisterDto.getUserEmail());
        // 멤버의 갯수를 세서 멤버의 갯수가 0이면 허용 1이면 허용 x 해서 최적화하기 ?
        if (member.isPresent()) {
            throw new IdAlreadyExistsException("이미 아이디가 존재합니다.");
        } else {
            Member insertMember = new Member(memberRegisterDto);
            memberRepository.save(insertMember);
        }
    }
//TODO 현재는 급하게 만들었지만 나중에 값을 검증하는 로직도 추가해야함 ex) 주소값을 이상하게 적었다던지 , 번호형식이 이상하던지 등등 ..

    /***
     * myPage 에서 유저의 정보를 변환하는 메서드 MemberUpdateDto 로 값을 다 받아오고 클라이언트가 빈칸으로 정보를 보내면 원래 있던 정보로 저장하고
     * 그렇지 않으면 바꾸려는 정보로 저장해서 유저의 값을 변경함
     * @param memberId 멤버의 정보를 변환하려는 멤버의 아이디를 받음
     * @param memberUpdateDto null 값이 생기는걸 방지하기위해(사용자가 값을 입력하지 않았을경우)
     *                        Dto 를 사용해서 rest하게 바꾸었을때 코드변환을 자유롭게 하기위해
     */
    @Transactional
    public void updateMember(String memberId, MemberUpdateDto memberUpdateDto) {
        Optional<Member> member = memberRepository.findById(memberId);
        memberRepository.save(memberUpdateDto.memberUpdate(member.get()));
    }

    /***
     * 위와 로직이 같다고 보면 됨 이거는 패스워드 검증을 해야돼서 오류코드를 내보내기위해 String 으로 처리함
     * @param memberId
     * @param memberUpdatePwDto
     * @return
     */
    @Transactional
    public void updateMemberPw(String memberId, MemberUpdatePwDto memberUpdatePwDto) {
        Member member = findMember(memberId).get();
        member.setUserPw(memberUpdatePwDto.getNewPw());
        memberRepository.save(member);
    }


    /***
     * myPage의 wishList 에서 유저의 리뷰에 대한 리스트를 반환하는 메서드
     * @param memberId
     * @return
     */
    public Optional<Member> findMember(String memberId) {
        Optional<Member> member = memberRepository.findById(memberId);
        return member;
    }

    /***
     * 멤버를 모두 보여주는 메서드
     * @return
     */
    public List<Member> findAll() {
        List<Member> memberList = memberRepository.findAll();
        return memberList;
    }

    public List<AdminMemberDto> adminMemberPage(List<Member> member) {
        List<AdminMemberDto> adminMemberDtos = new ArrayList<>();
        for (Member value : member) {
            AdminMemberDto adminMemberDto = new AdminMemberDto(value);
            adminMemberDtos.add(adminMemberDto);
        }
        return adminMemberDtos;
    }

    // Member들을 JSON 타입으로 반환해주는 메서드
    // 가공한 데이터는 Member 엔티티가 아닌 AdminMemberDto가 갖고 있기 때문에 이 dto 타입으로 수정
    public List<String> adminMemberPageJson(List<AdminMemberDto> member) {
        List<String> adminMemberJsons = new ArrayList<>();
        for (AdminMemberDto value : member) {
            adminMemberJsons.add(adminMemberDtoToJson(value));
        }
        return adminMemberJsons;
    }

    // AdminMemberDto를 Json으로 변경해주는 과정을 메서드로 분리함 따라서 같은 기능 재활용 가능해짐
    public String adminMemberDtoToJson(AdminMemberDto memberDto) {
        try {
            return objectMapper.writeValueAsString(memberDto);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    // 유저 밴 기간을 업데이트 하는 로직
//    public boolean suspendUser(String userEmail) {
//        Optional<Member> optionalMember = memberRepository.findById(userEmail);
//        if (optionalMember.isPresent()) {
//            Member member = optionalMember.get();
//            // banEndDate 필드를 업데이트
//            // member.setBanEndDate(새로운 날짜);  // 필요한 업데이트 로직을 구현
//            memberRepository.save(member);
//            return true;
//        }
//        return false;
//    }
    @Transactional
    public boolean suspendUser(SuspendRequestDto request) {
        // SuspendRequest에서 필요한 데이터 추출
        String userEmail = request.getEmail();
        int duration = request.getDuration();
        String timeUnit = request.getBanUnit();
//        String reason = request.getReason();

        // 정지 기간 및 단위를 기반으로 정지 일자 계산
        LocalDateTime endDate = calculateEndDate(duration, timeUnit);

        // 사용자 정지 처리 (예를 들어, DB 업데이트)
        Optional<Member> optionalMember = memberRepository.findById(userEmail);
        if (optionalMember.isPresent()) {
            // 사용자 정지 일자 및 사유를 저장하고 정지 상태를 업데이트
            Member member = optionalMember.get();
            member.setBanEndDate(endDate);
            memberRepository.save(member);
            log.info("{}에 {}까지의 밴 적용", userEmail, endDate);
            return true;
        } else {
            log.warn(userEmail + "이 null");
            return false;
        }

    }

    // 정지 기간과 단위를 기반으로 정지 종료일을 계산하는 메서드
    private LocalDateTime calculateEndDate(int duration, String timeUnit) {
        LocalDateTime currentDate = LocalDateTime.now();
        if ("hour".equalsIgnoreCase(timeUnit)) {
            return currentDate.plusHours(duration);
        } else if ("day".equalsIgnoreCase(timeUnit)) {
            return currentDate.plusDays(duration);
        } else if ("month".equalsIgnoreCase(timeUnit)) {
            return currentDate.plusMonths(duration);
        } else {
            throw new IllegalArgumentException("지원하지 않는 시간 단위입니다.");
        }
    }

    public MemberDto getMember(String userId) {
        Member member = memberRepository.findById(userId).orElseThrow(() -> new NotFoundMemberException("존재하지 않는 회원입니다."));

        return mapper.toDto(member);
    }

    public void validateMember(HttpServletRequest request) {
        String userId = SessionUtils.getUserIdFromSession(request);
        verifyMember(userId);
    }

    public void verifyMember(String userId) {
        if (userId.isBlank() || !memberRepository.existsById(userId))
            throw new NotFoundMemberException("존재하지 않는 회원입니다.");
    }

    public List<MemberManageDto> memberManageList(List<Member> memberList, List<RentalObject> rentalObjectList) {
        List<MemberManageDto> memberManageDtoList = new ArrayList<>();
        for (Member member : memberList) {
            MemberManageDto memberManageDto = new MemberManageDto(member, rentalObjectList);
            memberManageDtoList.add(memberManageDto);
        }
        return memberManageDtoList;
    }
}
