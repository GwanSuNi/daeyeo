package com.daeyeo.service;

import com.daeyeo.entity.*;
import com.daeyeo.persistence.CustomUserRepositoryImpl;
import com.daeyeo.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service("uService")
@Transactional
public class NewUserService {
    @Autowired
    private UserRepository userRepository;
    // ==================== 유저 관련 메서드 시작 ====================
    // User 엔티티 persist 해주는 메서드
    public void insertUser(UserEntity userEntity) {
        userRepository.save(userEntity);
        userRepository.flush();
    }

    // 직접 접근 안하고 이렇게 써야되나?
    public List<UserEntity> getUserEntityList() {
        return (List<UserEntity>) userRepository.findAll();
    }

    // 필요한가?
    public List<UserEntity> getUsersByName(String name) {
        return (List<UserEntity>) userRepository.findByUserName(name);
    }

    // 원래 List로 받아오는거였으나 어차피 PK 값으로 조회하는 것이기 때문에 단일 엔티티만 반환하기로 변경
    // 필요한가?
    // TODO: 없을 시에 할 작업
    public UserEntity findUserByEmail(String email) {
        return userRepository.findByUserEmail(email).get();
    }
// ==================== 유저 관련 메서드 끝 ====================


//    public int setUserMemoToUser(String email,UserMemo userMemo) {
//       return userRepository.updateUserEntity(email, userMemo.getContent(), userMemo.getMemoDate());
//    }

//    public int setUserMemo() {
//        TypedQuery<UserEntity> query = .createQuery(jpql, UserEntity.class);
//        query.setParameter("email", "ex@ex.com");
//        int resultList = query.executeUpdate();
//    }
}
