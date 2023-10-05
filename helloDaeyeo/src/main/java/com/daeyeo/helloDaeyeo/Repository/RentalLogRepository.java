package com.daeyeo.helloDaeyeo.Repository;

import com.daeyeo.helloDaeyeo.Entity.RentalLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.management.remote.JMXPrincipal;
@Repository
public interface RentalLogRepository extends JpaRepository<RentalLog,Integer> {
}
