package com.daeyeo.service;

import com.daeyeo.entity.ReportLog;
import com.daeyeo.entity.UserEntity;
import com.daeyeo.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Set;

@Service("reportLogService")
@Transactional
public class ReportLogService {
    @Autowired
    UserRepository userRepository;
    // ==================== Report Log 관련 메서드 시작 ====================

    // 해당 유저에게 리폿을 추가하는 메서드
    public void insertReportLog(String email) {
        UserEntity user = userRepository.findByUserEmail(email).get();
        ReportLog newReport = new ReportLog(email, LocalDateTime.now());
        Set<ReportLog> reports = user.getReportLog();
        reports.add(newReport);
        user.setReportLog(reports);
    }

    // 해당 유저의 모든 리폿 로그 조회
    public Set<ReportLog> getAllReportsByEmail(String email) {
        UserEntity user = userRepository.findByUserEmail(email).get();
        return user.getReportLog();
    }

    // ==================== Report Log 관련 메서드 끝 ====================
}
