package com.daeyeo.helloDaeyeo.repository;

import com.daeyeo.helloDaeyeo.entity.Member;
import com.daeyeo.helloDaeyeo.entity.RentalStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalStatusRepository extends JpaRepository<RentalStatus, Integer>, CustomRentalStatusRepository {
    List<RentalStatus> findByMember(Member member);

    @Query("SELECT r FROM RentalStatus r " +
            "WHERE r.status = 'PENDING' " +
            "ORDER BY r.rentalDate ASC")
    List<RentalStatus> findPendingRentalStatus();
}
