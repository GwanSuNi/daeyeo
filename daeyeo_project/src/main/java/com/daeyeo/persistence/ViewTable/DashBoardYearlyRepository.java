package com.daeyeo.persistence.ViewTable;

import com.daeyeo.entity.ViewTable.DashBoardYearly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DashBoardYearlyRepository extends JpaRepository<DashBoardYearly, String> {
    public List<DashBoardYearly> findAll();
}
