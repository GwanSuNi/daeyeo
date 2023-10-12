package com.daeyeo.helloDaeyeo.mapper;

import com.daeyeo.helloDaeyeo.dto.MemberDto;
import com.daeyeo.helloDaeyeo.entity.Member;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-12T01:17:36+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8.1 (Azul Systems, Inc.)"
)
@Component
public class MemberMapperImpl implements MemberMapper {

    @Override
    public MemberDto toDto(Member member) {
        if ( member == null ) {
            return null;
        }

        MemberDto memberDto = new MemberDto();

        memberDto.setUserId( member.getUserId() );
        memberDto.setUserPw( member.getUserPw() );
        memberDto.setUserEmail( member.getUserEmail() );
        memberDto.setUserName( member.getUserName() );

        return memberDto;
    }

    @Override
    public Member toEntity(MemberDto memberDto) {
        if ( memberDto == null ) {
            return null;
        }

        Member member = new Member();

        member.setUserId( memberDto.getUserId() );
        member.setUserPw( memberDto.getUserPw() );
        member.setUserEmail( memberDto.getUserEmail() );
        member.setUserName( memberDto.getUserName() );

        return member;
    }
}
