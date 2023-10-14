package com.daeyeo.helloDaeyeo.service.userDetails;

import com.daeyeo.helloDaeyeo.dto.memberRegistDto.MemberRegisterDto;
import com.daeyeo.helloDaeyeo.embedded.Address;
import com.daeyeo.helloDaeyeo.entity.Member;
import com.daeyeo.helloDaeyeo.exception.IdAlreadyExistsException;
import com.daeyeo.helloDaeyeo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

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
        return memberRepository.save(Member.builder()
                .userEmail(dto.getUserEmail())
                .userPw(bCryptPasswordEncoder.encode(dto.getUserPw()))
                        .memberAddress(dto.getAddress())
                        .department(dto.getDepartment())
                        .userName(dto.getUserName())
                        .phone(dto.getPhone())
                        .registDate(LocalDateTime.now())
                .build())
                .getUserEmail();
    }
}
