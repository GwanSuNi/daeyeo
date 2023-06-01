package com.daeyeo.persistence;

import com.daeyeo.entity.RentalLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalLogRepository extends JpaRepository<RentalLog, Integer>, CustomRentalLogRepository {
}
