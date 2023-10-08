package com.daeyeo.helloDaeyeo.service;

import com.daeyeo.helloDaeyeo.dto.MemberRegisterDto;
import com.daeyeo.helloDaeyeo.entity.Member;
import com.daeyeo.helloDaeyeo.exception.NotFoundIdException;
import com.daeyeo.helloDaeyeo.repository.MemberRepository;
import com.daeyeo.helloDaeyeo.exception.IdAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
// 이렇게 클래스에 설정해놓으면 클래스안에 메서드들이 리드온리값이 먹히고
// @Transactional 설정한 애들은 readonly = false 가 default 인 값들이 먹힌다
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    @Transactional
    public void insertMember(MemberRegisterDto memberRegisterDto){
        Optional<Member> member = memberRepository.findById(memberRegisterDto.getUserEmail());
         // 멤버의 갯수를 세서 멤버의 갯수가 0이면 허용 1이면 허용 x 해서 최적화하기 ?
         if(member.isPresent()){
            throw new IdAlreadyExistsException("이미 아이디가 존재합니다.");
        }else{
            Member insertMember = new Member(memberRegisterDto);
            memberRepository.save(insertMember);
        }
    }
    @Transactional
    public void updateMember(MemberRegisterDto memberRegisterDto){
        Optional<Member> member = memberRepository.findById(memberRegisterDto.getUserEmail());
        if(member.isPresent()){

        }
            throw new NotFoundIdException("찾으시는 아이디가 없습니다");
    }

    /***
     * 멤버를 모두 보여주는 메서드
     * @return
     */
    public List<Member> findAll(){
        List<Member> memberList = memberRepository.findAll();
        return memberList;
    }

}
