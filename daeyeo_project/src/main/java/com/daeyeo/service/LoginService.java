package com.daeyeo.service;

import com.daeyeo.entity.UserEntity;
import com.daeyeo.exception.NotCorrespondingEmailException;
import com.daeyeo.persistence.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class LoginService {

    private final UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UserEntity login(String userEmail,String userPw){
        Optional<UserEntity> findUser = userRepository.findByUserEmail(userEmail);
        if(!findUser.orElseThrow(()->new NotCorrespondingEmailException("해당 이메일이 존재하지 않습니다.")).checkPassword(userPw)){
            throw new IllegalStateException("이메일과 비밀번호가 일치하지 않습니다.");
        }
        return findUser.get();

    }
}