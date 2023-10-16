package com.daeyeo.helloDaeyeo.service;

import com.daeyeo.helloDaeyeo.entity.PeriodTest;
import com.daeyeo.helloDaeyeo.repository.PeriodTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PeriodTestService {
    @Autowired
    PeriodTestRepository periodTestRepository;
    public boolean validPeriod(LocalDateTime startTime, LocalDateTime endTime){
        List<PeriodTest> periodTestList = periodTestRepository.findAll();
        for (PeriodTest periodTest : periodTestList) { // rentalStatus 의 시작시간과 끝나는시간을 다 갖고오는거지
            LocalDateTime periodStartTime = periodTest.getStartTime();
            LocalDateTime periodEndTime = periodTest.getEndTime();
            // 두 기간이 겹치는지 확인합니다.
            if (isOverlap(startTime, endTime, periodStartTime, periodEndTime)) {
                return false; // 겹치는 경우, 유효하지 않음
            }
        }
        return true; // 모든 기간이 겹치지 않으면 유효함
    }
    public void insertPeriod(LocalDateTime startTime , LocalDateTime endTime){
        PeriodTest periodTest = new PeriodTest();
        periodTest.setStartTime(startTime);
        periodTest.setEndTime(endTime);
        periodTestRepository.save(periodTest);
    }
    private boolean isOverlap(LocalDateTime startTime1, LocalDateTime endTime1, LocalDateTime startTime2, LocalDateTime endTime2) {
        return (startTime1.isBefore(endTime2) && endTime1.isAfter(startTime2));
    }
}
