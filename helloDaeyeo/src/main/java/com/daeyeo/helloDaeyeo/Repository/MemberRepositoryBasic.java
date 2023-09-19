package com.daeyeo.helloDaeyeo.Repository;

import com.daeyeo.helloDaeyeo.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepositoryBasic extends JpaRepository<Member,Integer> {
    public Member findById(Long number);
}
