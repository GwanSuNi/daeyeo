package com.daeyeo.service;

import com.daeyeo.entity.RentalLog;
import com.daeyeo.entity.RentalObject;
import com.daeyeo.entity.UserEntity;
import com.daeyeo.persistence.RentalLogRepository;
import com.daeyeo.persistence.RentalObjectRepository;
import com.daeyeo.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service("rentalLogService")
@Transactional
public class RentalLogService {
    @Autowired
    RentalObjectRepository rentalObjectRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RentalLogRepository rentalLogRepository;

    public void insertRentalLog(String userEmail, int objectIndex, LocalDate startDate, LocalDate endDate, int price) {
        System.out.println("service1");
        UserEntity user = userRepository.findByUserEmail(userEmail).get();
        System.out.println("service2");
        RentalObject rentalObject = rentalObjectRepository.findByObjectIndex(objectIndex).get();
        System.out.println("service3");

        RentalLog rentalLog = new RentalLog(user,rentalObject ,startDate, endDate, price);
        System.out.println("service4");
        user.addRentalLog(rentalLog);
        rentalObject.addRentalLog(rentalLog);
        rentalLogRepository.save(rentalLog);
    }
//     public void insert

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
