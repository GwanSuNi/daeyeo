package com.daeyeo.service;

import com.daeyeo.entity.*;
import com.daeyeo.persistence.RentalLogRepository;
import com.daeyeo.persistence.RentalObjectRepository;
import com.daeyeo.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service("rentalLogService")
@Transactional
public class RentalLogService {
    @Autowired
    private RentalObjectRepository rentalObjectRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RentalLogRepository rentalLogRepository;

    /**
     * 렌탈로그 만드는 메서드
     * @author 서상현
     * @param targetObject RentalObject에서 갖고온 외래키 값
     * @param targetUser User에서 갖고온 외래키 값
     */
    public void insertRentalLog(int targetObject, String targetUser, LocalDate startDate, LocalDate endDate, int price) {
        UserEntity userEntity = userRepository.findByUserEmail(targetUser).orElse(null);
        RentalObject rentalObject = rentalObjectRepository.findByObjectIndex(targetObject).orElse(null);

        if(userEntity != null && rentalObject != null) {
            RentalLog rentalLog = new RentalLog(userEntity, rentalObject, startDate, endDate, price);

            userEntity.addRentalLog(rentalLog);
            rentalObject.addRentalLog(rentalLog);
            rentalLogRepository.save(rentalLog);
        }
    }

    /**
     * 렌탈로그 찾아오는거 delete 로 검증함 나머지 내용은 같음
     */
    public void findRentalLog(int rentalId, int targetObject, String targetUser) {
        UserEntity userEntity = userRepository.findByUserEmail(targetUser).get();
        RentalObject rentalObject = rentalObjectRepository.findByObjectIndex(targetObject).get();
        Optional<RentalLog> rentalLogs= rentalLogRepository.findByRentalIdAndUserEntityAndRentalObject(rentalId,userEntity,rentalObject);
    }

    public void deleteRentalLog(int rentalId, int targetObject , String targetUser){
        UserEntity userEntity = userRepository.findByUserEmail(targetUser).get();
        RentalObject rentalObject = rentalObjectRepository.findByObjectIndex(targetObject).get();
        Optional<RentalLog> rentalLogs= rentalLogRepository.findByRentalIdAndUserEntityAndRentalObject(rentalId,userEntity,rentalObject);
        rentalLogRepository.delete(rentalLogs.get());
    }
//    TODO 업데이트가 되긴하는데 굳이 있을 필요 없을거같아서 일단 보류 업데이트는 되긴 하는데 기본키 값 검증이 아직 안들어가있음
    public void updateRentalLog(int targetObject , String targetUser , LocalDate startDuration
                               , LocalDate endDuration , int price , LocalDateTime rentalDate){
        UserEntity userEntity = userRepository.findByUserEmail(targetUser).get();
        RentalObject rentalObject = rentalObjectRepository.findByObjectIndex(targetObject).get();

        RentalLog changeRentalLog = new RentalLog();
        changeRentalLog.setUserEntity(userEntity);
        changeRentalLog.setRentalObject(rentalObject);
        changeRentalLog.setStartDuration(startDuration);
        changeRentalLog.setEndDuration(endDuration);
        changeRentalLog.setPrice(price);
        changeRentalLog.setRentalDate(rentalDate);
        rentalLogRepository.save(changeRentalLog);
    }

    public void findByRentalId(int rentalId){
        Optional<RentalLog> rentalLog = rentalLogRepository.findByRentalId(rentalId);
        // System.out.println(); 이거 찍으려고하면 갑자기 순환참조일어나서 지들끼리 서로 계속부름
    }


//    public void updateRentalLog(int rentalId , ){
//
//    }

    public List<RentalLog> findRentalLogByEmail(String email) {
        UserEntity user = userRepository.findByUserEmail(email).get();
//        rentalLogRepository.findByTargetUser();
        return null;
    }


    // userEmail을 통해 UserEntity 찾기
    public UserEntity findByUserEmail(String userEmail){
        Optional<UserEntity> userEntity = userRepository.findByUserEmail(userEmail);
        return userEntity.orElse(null);
    }

    // objectIndex 컬럼을 통해 RentalObject 엔티티 찾기
    public RentalObject findByObjectIndex(int objectIndex) {
        Optional<RentalObject> rentalObject = rentalObjectRepository.findByObjectIndex(objectIndex);
        return rentalObject.orElse(null);
    }
}
