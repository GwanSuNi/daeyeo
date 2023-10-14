package com.daeyeo.helloDaeyeo.repository;

import com.daeyeo.helloDaeyeo.entity.Member;
import com.daeyeo.helloDaeyeo.entity.RentalObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member,String> {
    /***
     * 회원의 이름을 검색하면 RentalObject를 알수있음 :userId가 매개변수로 들어가는 구조(어드민페이지)
     * @param member
     * @return
     */
    @Query("SELECT ro FROM RentalObject ro WHERE ro.member.userEmail = :userId")
    List<RentalObject> findRentalObjectsByMember(@Param("userId") String userId);
    // 모든 유저를 한꺼번에 가져오는데, JPA 페이징 레파지토리를 쓰지 않으면 추후에 부하가 많이 걸리지 않을까?
    List<Member> findAll();
// 망가짐
//    @Query("SELECT m, COUNT(r) FROM Member m LEFT JOIN m.reviews r GROUP BY m")
//    List<Member> findByReviewsCount();

    Optional<Member> findByUserEmail(String email);
    List<Member> findByUserEmailLike(String email);
}
