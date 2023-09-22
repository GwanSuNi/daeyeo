package com.daeyeo.helloDaeyeo.controller;

import com.daeyeo.helloDaeyeo.entity.Member;
import com.daeyeo.helloDaeyeo.repository.MemberRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {
    private MemberRepository repository;

    public MemberController(MemberRepository repository) {
        this.repository = repository;
    }

    // Insert
    @PutMapping("/member")
    public Member putMember(Member member) {
        return repository.save(member);
    }

    // Update
    @PostMapping("/member")
    public Member postMember(Member member) {
        return repository.save(member);
    }

    // Delete
    @DeleteMapping("/member")
    public void deleteMember(Long id) {
        repository.deleteById(id);
    }

    @GetMapping("/member")
    public Member getMember(Long id){
        return repository.findById(id).orElseThrow();
    }
    @GetMapping("/member/name")
    public List<Member> getMember(String userName){ // 컬럼명 반드시 일치!!
        return repository.findByUserName(userName);
    }
    @GetMapping("/member/search")
    public List<Member> getMemberLike(String userName){
        return repository.findByUserNameLike("%" + userName + "%");
    }

    @GetMapping("/member/list")
    public List<Member> getMemberList(){
        return (List<Member>) repository.findAll();
    }


}
