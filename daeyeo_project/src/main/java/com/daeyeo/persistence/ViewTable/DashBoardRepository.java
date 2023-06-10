package com.daeyeo.persistence.ViewTable;

import com.daeyeo.entity.ViewTable.DashBoard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DashBoardRepository extends JpaRepository<DashBoard,String> {
    public List<DashBoard> findAll();
}
