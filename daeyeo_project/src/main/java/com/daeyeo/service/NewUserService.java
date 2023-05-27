package com.daeyeo.service;

import com.daeyeo.entity.UserEntity;
import com.daeyeo.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("uService")
@Transactional
public class NewUserService {
    @Autowired
    private UserRepository userRepository;

    public void insertUser(UserEntity userEntity) {
        userRepository.save(userEntity);
        userRepository.flush();
    }

    public List<UserEntity> getUserEntityList(UserEntity userEntity) {
        userRepository.flush();
        return (List<UserEntity>) userRepository.findAll();
    }

    public List<UserEntity> getUsersByName(UserEntity userEntity) {
        userRepository.flush();
        return (List<UserEntity>) userRepository.findByUserName(userEntity.getUserName());}

    public List<UserEntity> getUsersByEmail(UserEntity userEntity) {
        userRepository.flush();
        return (List<UserEntity>) userRepository.findByUserEmail(userEntity.getUserEmail());}
}
