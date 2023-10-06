package com.daeyeo.helloDaeyeo.updaterepository;

import com.daeyeo.helloDaeyeo.updateentity.Member;
import com.daeyeo.helloDaeyeo.updateentity.RentalObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member,String> {
    /***
     * 회원의 이름을 검색하면 RentalObject를 알수있음 :userId가 매개변수로 들어가는 구조(어드민페이지)
     * @param member
     * @return
     */
    @Query("SELECT ro FROM RentalObject ro WHERE ro.member.userId = :userId")
    List<RentalObject> findRentalObjectsByMember(@Param("userId") String userId);

}
