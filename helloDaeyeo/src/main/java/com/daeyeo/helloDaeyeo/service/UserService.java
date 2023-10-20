//package com.daeyeo.helloDaeyeo.service;
//
//import com.daeyeo.helloDaeyeo.dto.AddUserRequest;
//import com.daeyeo.helloDaeyeo.entity.User;
//import com.daeyeo.helloDaeyeo.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@RequiredArgsConstructor
//@Service
//public class UserService {
//    private final UserRepository userRepository;
//    private final BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    public Long save(AddUserRequest dto) {
//        return userRepository.save(User.builder()
//                .email(dto.getEmail())
//                .password(bCryptPasswordEncoder.encode(dto.getPassword()))
//                .build())
//                .getId();
//    }
//
//    public User findById(Long userId) {
//        return userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("Unexpected User"));
//    }
//
//}
