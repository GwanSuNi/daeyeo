//package com.daeyeo.service;
//
//import com.daeyeo.entity.UserEntity;
//import com.daeyeo.persistence.MyRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//
//@Service("userService")
//public class UserService {
//    @Autowired
//    private MyRepository myRepository;
//
//    @Transactional
//    public void insertUser(UserEntity userEntity) {
//        myRepository.insertData(userEntity);
//    }
//
//    public List<UserEntity> getUserList(UserEntity userEntity) {
//        return myRepository.getDataList(userEntity);
//    }
//}
