package com.daeyeo.persistence;

import com.daeyeo.entity.DashBoard;
import com.daeyeo.entity.MemberManagement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DashBoardRepository extends JpaRepository<DashBoard,String> {
    public List<DashBoard> findAll();
}
