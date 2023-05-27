package com.daeyeo.service;

import com.daeyeo.entity.UserEntity;
import com.daeyeo.persistence.UserRepository;
import org.apache.catalina.authenticator.SavedRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("uService")
@Transactional
public class NewUserService {
    @Autowired
    private UserRepository userRepository;

    public void insertUser(UserEntity user) {
        userRepository.save(user);
    }

    public List<UserEntity> getUserEntityList(UserEntity user) {
        return (List<UserEntity>) userRepository.findAll();
    }
}
