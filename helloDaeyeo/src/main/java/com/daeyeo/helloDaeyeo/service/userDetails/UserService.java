package com.daeyeo.helloDaeyeo.service.userDetails;

import com.daeyeo.helloDaeyeo.dto.memberRegistDto.MemberRegisterDto;
import com.daeyeo.helloDaeyeo.embedded.Address;
import com.daeyeo.helloDaeyeo.entity.Member;
import com.daeyeo.helloDaeyeo.entity.Role;
import com.daeyeo.helloDaeyeo.exception.IdAlreadyExistsException;
import com.daeyeo.helloDaeyeo.exception.NotFoundMemberException;
import com.daeyeo.helloDaeyeo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;

// 시큐리티 세션 방식으로 유저 회원가입해주는 서비스
@RequiredArgsConstructor
@Service
public class UserService {
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public String save(MemberRegisterDto dto) {
        Member member = memberRepository.findByUserEmail(dto.getUserEmail()).orElse(null);
        if(member != null) {
            throw new IdAlreadyExistsException("해당 이메일로 가입한 유저가 존재합니다.");
        }
        // 기본적으로 Member 롤을 가진 회원으로 가입
        dto.setRoles(Collections.singleton(Role.MEMBER));
        return memberRepository.save(Member.builder()
                .userEmail(dto.getUserEmail())
                .userPw(bCryptPasswordEncoder.encode(dto.getUserPw()))
                        .memberAddress(dto.getAddress())
                        .department(dto.getDepartment())
                        .userName(dto.getUserName())
                        .phone(dto.getPhone())
                        .registDate(LocalDateTime.now())
                        .roles(dto.getRoles())
                .build())
                .getUserEmail();
    }

    // 관리자가 사용자 역할을 업데이트 하는 서비스
    public Member updateMemberRoles(String userEmail, Set<Role> roles) {
        Member member = memberRepository.findByUserEmail(userEmail).orElse(null);
        if (member != null) {
            member.setRoles(roles);
            memberRepository.save(member);
        }
        return member;
    }

    public Member findByUserEmail(String userEmail) {
        return memberRepository.findByUserEmail(userEmail).orElseThrow(() -> new NotFoundMemberException("없는 사용자"));
    }
}
