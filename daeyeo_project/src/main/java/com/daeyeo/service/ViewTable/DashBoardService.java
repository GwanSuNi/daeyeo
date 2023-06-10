package com.daeyeo.service.ViewTable;

import com.daeyeo.entity.ViewTable.DashBoard;
import com.daeyeo.entity.ViewTable.DashBoardMonthly;
import com.daeyeo.entity.ViewTable.DashBoardYearly;
import com.daeyeo.persistence.ViewTable.DashBoardMontlyRepository;
import com.daeyeo.persistence.ViewTable.DashBoardRepository;
import com.daeyeo.persistence.ViewTable.DashBoardYearlyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("dashBoardService")
@Transactional
public class DashBoardService {
    @Autowired
    DashBoardRepository dashBoardRepository;
    @Autowired
    DashBoardMontlyRepository dashBoardMontlyRepository;

    @Autowired
    DashBoardYearlyRepository dashBoardYearlyRepository;

    public List<DashBoard> findDailyAll(){
        return  dashBoardRepository.findAll();
    }

    public List<DashBoardMonthly> findMonthlyAll() {
        return dashBoardMontlyRepository.findAll();
    }

    public List<DashBoardYearly> findYearlyAll() {
        return dashBoardYearlyRepository.findAll();
    }
}
