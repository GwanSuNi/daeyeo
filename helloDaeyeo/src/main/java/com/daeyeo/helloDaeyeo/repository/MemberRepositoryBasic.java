package com.daeyeo.helloDaeyeo.repository;

import com.daeyeo.helloDaeyeo.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepositoryBasic extends JpaRepository<Member,Integer> {
    public Member findById(Long number);
}
