package com.daeyeo.helloDaeyeo.dao;

import com.daeyeo.helloDaeyeo.Entity.Member;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MemberRepository extends CrudRepository<Member, Long> {
    List<Member> findByUserName(String name);
    List<Member> findByUserNameLike(String name);

    @Query(value = "select * from Member where User_Name = ?1 and age = ?2", nativeQuery = true) // false = JPQL, true = sql
    List<Member> findVIPList(String name, int age);

    @Query("from Member where userName = ?1 and age = ?2") // JPQL은 카멜케이스를 알아서 변경해주지만 네이티브는 실제 컬럼 이름 그대로 써야함!!! // 또한 select문 유무 차이
    List<Member> findVIPList2(String name, int age);
}
