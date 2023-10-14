package com.daeyeo.helloDaeyeo.repository;

import com.daeyeo.helloDaeyeo.entity.PeriodTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeriodTestRepository extends JpaRepository<PeriodTest,Long> {
    List<PeriodTest> findAll();
}
