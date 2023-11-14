package com.daeyeo.helloDaeyeo.service.userDetails;

import com.daeyeo.helloDaeyeo.dto.memberDto.MemberDeleteDto;
import com.daeyeo.helloDaeyeo.dto.memberRegistDto.MemberRegisterDto;
import com.daeyeo.helloDaeyeo.entity.Member;
import com.daeyeo.helloDaeyeo.entity.Role;
import com.daeyeo.helloDaeyeo.exception.IdAlreadyExistsException;
import com.daeyeo.helloDaeyeo.exception.NotFoundMemberException;
import com.daeyeo.helloDaeyeo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Set;

// 시큐리티 세션 방식으로 유저 회원가입해주는 서비스
@RequiredArgsConstructor
@Slf4j
@Service
public class UserService {
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public String save(MemberRegisterDto dto) {
        Member member = memberRepository.findByUserEmail(dto.getUserEmail()).orElse(null);
        if (member != null) {
            throw new IdAlreadyExistsException("해당 이메일로 가입한 유저가 존재합니다.");
        }
        // 기본적으로 Member 롤을 가진 회원으로 가입
        dto.setRoles(Collections.singleton(Role.MEMBER));
        return memberRepository.save(Member.builder()
                        .userEmail(dto.getUserEmail())
                        .userPw(bCryptPasswordEncoder.encode(dto.getUserPw()))
                        .memberAddress(dto.getAddress())
                        .department(dto.getDepartment())
                        .nickname(dto.getUserName())
                        .phone(dto.getPhone())
                        .registDate(LocalDateTime.now())
                        .roles(dto.getRoles())
                        .build())
                .getUserEmail();
    }

    // 관리자가 사용자 역할을 업데이트 하는 서비스
    @Transactional
    public Member updateMemberRoles(String userEmail, Set<Role> roles) {
        Member member = memberRepository.findByUserEmail(userEmail).orElse(null);
        log.info("updateMemberRoles에서 Member: {}", member);
        if (member != null) {
            member.setRoles(roles);
            memberRepository.save(member);
        }
        return member;
    }

    // TODO: 어드민 페이지 모달에서 유저 비밀번호를 변경할 수 있게, 어드민 본인 비밀번호도 변경할 수 있게 화면 만들기
    @Transactional
    public boolean updateMemberPassword(String userEmail, String newPw) {
        Member member = memberRepository.findByUserEmail(userEmail).orElse(null);
        if (member != null) {
            member.setUserPw(bCryptPasswordEncoder.encode(newPw));
            memberRepository.save(member);
            log.info("{}에 대해 비밀번호 변경 성공", member);
            return true;
        }
        return false;
    }

    public Member findByUserEmail(String userEmail) {
        return memberRepository.findByUserEmail(userEmail).orElseThrow(() -> new NotFoundMemberException("없는 사용자"));
    }


    @Transactional
    public boolean deleteMember(String userEmail, MemberDeleteDto memberDeleteDto) {
        Member member = findByUserEmail(userEmail);
        if (member != null) {
            if (comparePassword(userEmail, memberDeleteDto.getMemberPw())) {
                memberRepository.delete(member);
                return true;
            }
        }
        return false;
    }

    @Transactional
    public boolean deleteMemberByAdmin(String userEmail) {
        Member member = findByUserEmail(userEmail);
        if (member != null) {
            memberRepository.delete(member);
            return true;
        }
        return false;
    }

    public boolean comparePassword(String userEmail, String password) {
        Member member = findByUserEmail(userEmail);
        if (member != null) {
            String storedPassword = member.getPassword();
            return bCryptPasswordEncoder.matches(password, storedPassword);
        }
        return false;
    }
}
