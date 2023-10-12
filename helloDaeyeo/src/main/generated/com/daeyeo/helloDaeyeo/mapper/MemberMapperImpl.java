package com.daeyeo.helloDaeyeo.mapper;

import com.daeyeo.helloDaeyeo.dto.memberDto.MemberDto;
import com.daeyeo.helloDaeyeo.entity.Member;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-13T01:02:38+0900",
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

        return memberDto;
    }

    @Override
    public Member toEntity(MemberDto memberDto) {
        if ( memberDto == null ) {
            return null;
        }

        Member member = new Member();

        member.setUserEmail( memberDto.getUserEmail() );
        member.setMemberAddress( memberDto.getMemberAddress() );
        member.setPhone( memberDto.getPhone() );
        member.setUserPw( memberDto.getUserPw() );
        member.setUserName( memberDto.getUserName() );
        member.setRegistDate( memberDto.getRegistDate() );
        member.setDepartment( memberDto.getDepartment() );
        member.setStatusMsg( memberDto.getStatusMsg() );
        member.setPaySum( memberDto.getPaySum() );
        member.setMoneyEarned( memberDto.getMoneyEarned() );

        return member;
    }
}
