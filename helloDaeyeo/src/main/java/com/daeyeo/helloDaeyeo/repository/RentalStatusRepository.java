package com.daeyeo.helloDaeyeo.repository;

import com.daeyeo.helloDaeyeo.entity.Member;
import com.daeyeo.helloDaeyeo.entity.RentalStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentalStatusRepository extends JpaRepository<RentalStatus,Integer> {
    List<RentalStatus> findByMember_UserEmail(String userEmail);
    List<RentalStatus> findByMember_UserEmailOrderByRentalStatusIdDesc(String userEmail);
    List<RentalStatus> findByRentalObject_ObjectIndex(Long objectIndex);
}
