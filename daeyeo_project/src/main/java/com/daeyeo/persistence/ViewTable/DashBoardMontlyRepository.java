package com.daeyeo.persistence.ViewTable;

import com.daeyeo.entity.ViewTable.DashBoardMonthly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DashBoardMontlyRepository extends JpaRepository<DashBoardMonthly, String> {
    public List<DashBoardMonthly> findAll();
}
