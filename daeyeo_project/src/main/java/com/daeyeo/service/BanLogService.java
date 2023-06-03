package com.daeyeo.service;

import com.daeyeo.entity.BanLog;
import com.daeyeo.entity.UserEntity;
import com.daeyeo.persistence.CustomUserRepositoryImpl;
import com.daeyeo.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service("banLogService")
@Transactional
public class BanLogService {
    @Autowired
    UserRepository userRepository;
    // ==================== Ban Log 관련 메서드 시작 ====================
    // User에게 Ban을 추가
    public void insertBanLog(String email, String reason, LocalDateTime duration) {
        UserEntity user = userRepository.findByUserEmail(email).get();
        BanLog newBanLog = new BanLog();
        newBanLog.setFlag(true);
        newBanLog.setBanReason(reason);
        newBanLog.setDuration(duration);
        newBanLog.setBanDate(LocalDateTime.now());
        List<BanLog> banLogs = user.getBanLog();
        banLogs.add(newBanLog);
        user.setBanLog(banLogs);
    }

    // User에게 Ban Log들을 가져오는 메서드
    public List<BanLog> getAllBanLogsByEmail(String email) {
        return userRepository.findByUserEmail(email).get().getBanLog();
    }

    // TODO: User의 가장 최신 Ban Log 하나를 가져오는 메서드, List일 때 편함
    //  이 메서드를 다시 사용하는 메서드는 로그인 과정에서 수행되어 banLog의 가장 max()의 duration의 값의 flag가 true일 시 로그인 불가
    /**
     * 로그인 과정에서 수행되어 banLog의 가장 max()의 duration의 값의 flag가 true일 시 로그인 불가
     * @param email 유저의 이메일
     * @return BanLog
     */
    public BanLog getOneBanLogByEmail(String email) {
        List<BanLog> banLogs = userRepository.findByUserEmail(email).get().getBanLog();
        return null;
    }

    // 해당 User의 Ban을 풀거나 세팅하는 메서드
    public void setBanFlag(String email, boolean flag) {
        CustomUserRepositoryImpl repository = new CustomUserRepositoryImpl();
        int id = repository.lastBanLogByEmail(email);
        BanLog foundBanLog = userRepository.findByUserEmail(email).get().getBanLog().stream().filter(banLog -> banLog.getBanId() == id).findFirst().get();
        if (flag) {
            foundBanLog.setBanFlagTrue();
        } else {
            foundBanLog.setBanFlagFalse();
        }
    }

    // ==================== Ban Log 관련 메서드 끝 ====================
}
