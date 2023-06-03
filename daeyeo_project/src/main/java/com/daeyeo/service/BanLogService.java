package com.daeyeo.service;

import com.daeyeo.entity.BanLog;
import com.daeyeo.entity.UserEntity;
import com.daeyeo.persistence.CustomUserRepository;
import com.daeyeo.persistence.CustomUserRepositoryImpl;
import com.daeyeo.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Service("banLogService")
@Transactional
public class BanLogService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    CustomUserRepositoryImpl customUserRepository;

    // ==================== Ban Log 관련 메서드 시작 ====================
    /**
     * User에게 Ban을 추가해주는 메서드
     * @param email 밴을 추가할 유저
     * @param reason
     * @param duration
     *
     */
    public void insertBanLog(String email, String reason, LocalDateTime duration) {
        UserEntity user = userRepository.findByUserEmail(email).get();
        // 밴 로그 생성
        BanLog newBanLog = new BanLog(true, reason, duration);
        newBanLog.setUserEntity(user);
//        newBanLog.setFlag(true);
//        newBanLog.setBanReason(reason);
//        newBanLog.setDuration(duration);
//        newBanLog.setBanDate(LocalDateTime.now());

//        Set<BanLog> banLogs = user.getBanLog();
//        banLogs.add(newBanLog);
//        user.setBanLog(banLogs);
        user.addBanLog(newBanLog);
        userRepository.save(user);
    }

    /**
     * User에게 Ban Log들을 가져오는 메서드
     * @param email 조회해올 유저 이메일
     * @return 해당 유저의 List<BanLog>
     */
    public List<BanLog> getAllBanLogsByEmail(String email) {
        return userRepository.findByUserEmail(email).get().getBanLogs();
    }

    // TODO: 로그인 과정에서 수행되어 banLog의 가장 max()의 duration의 값의 flag가 true일 시 로그인 불가
    /**
     * User의 가장 최신 Ban Log 하나를 가져오는 메서드
     * @param email 유저의 이메일
     * @return BanLog
     */
    public BanLog getLastBanLogByEmail(String email) {
        return customUserRepository.getLastBanLogByEmail(email);
    }

    /**
     * 해당 User의 Ban을 풀거나 세팅하는 메서드
     * @param email
     * @param flag 풀어줄거면 false
     */
    // TODO: 쿼리문 여러번 날라가는거 최적화
    public void setBanFlag(String email, boolean flag) {
//        CustomUserRepositoryImpl repository = new CustomUserRepositoryImpl();
        UserEntity user = userRepository.findByUserEmail(email).get();

        BanLog foundBanLog = customUserRepository.getLastBanLogByEmail(email);
        foundBanLog.switchBanFlag(flag);
        user.getBanLogs().set(foundBanLog.getBanId(), foundBanLog);
        userRepository.save(user);
    }
    
    /**
     * 로그인 가능한 상태인지 검증
     * 로그인 과정에서 수행되어 banLog의 가장 max()의 duration의 값의 flag가 true일 시 로그인 불가
     * @param email 유저 이메일
     * @param now 현재 시점
     * @return true일 때만 로그인할 수 있음
     */
    public boolean isUserCanLogin(String email, LocalDateTime now) {
//        LocalDateTime banEndDate = (LocalDateTime) entityManager // 날짜만 가져옴
//                .createQuery("select b.duration from BanLog b where b.userEntity.userEmail = :email order by b.duration desc ")
//                .setParameter("email", email)
//                .setMaxResults(1)
//                .getSingleResult();
        BanLog banLog = customUserRepository.getLastBanLogByEmail(email);
        LocalDateTime banEndDate = banLog.getDuration();
        boolean isBaned = banLog.isFlag(); // flag가 true면 Ban이라는 뜻이기 때문에 반전해서 사용
        if (now.isAfter(banEndDate)) {
            return false;
        } else {
            return !isBaned;
        }
    }

    /**
     * 밴 기한 연장 및 단축하는 메서드
     * @param email
     * @param date
     */
    public void changeBanDate(String email, LocalDateTime date) {
        UserEntity user = userRepository.findByUserEmail(email).get();
        BanLog foundBanLog = customUserRepository.getLastBanLogByEmail(email);
        foundBanLog.setDuration(date);
        user.getBanLogs().set(foundBanLog.getBanId(), foundBanLog);
        userRepository.save(user);
    }
    // ==================== Ban Log 관련 메서드 끝 ====================
}
