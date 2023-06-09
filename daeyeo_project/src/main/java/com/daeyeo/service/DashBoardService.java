package com.daeyeo.service;

import com.daeyeo.entity.DashBoard;
import com.daeyeo.entity.MemberManagement;
import com.daeyeo.persistence.DashBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("dashBoardService")
@Transactional
public class DashBoardService {
    @Autowired
    DashBoardRepository dashBoardRepository;
    public List<DashBoard> findAll(){
        return  dashBoardRepository.findAll();
    }
}
