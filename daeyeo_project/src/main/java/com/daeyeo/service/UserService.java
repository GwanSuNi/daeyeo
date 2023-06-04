package com.daeyeo.service;

import com.daeyeo.dto.UserDTO;
import com.daeyeo.entity.UserEntity;
import com.daeyeo.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;


@Service("userService")
@RequiredArgsConstructor
public class UserService implements UserDetailsService { //newUserService 에 합치려고 했으나 충돌남 (빈 객체를 못 찾아옴)

    @Autowired
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUserEmail(userEmail)
                .orElseThrow(() -> new UsernameNotFoundException(userEmail));

        if(userEntity==null){

            return User.builder()
                    .username(userEntity.getUserEmail())
                    .password(userEntity.getUserPw())
                    .authorities(new SimpleGrantedAuthority("ROLE_USER"))
                    .build();

        }
        else{
            // 값이 있을때니까 로그인시켜주는
                return null;
        }
    }

    public UserEntity getUserByEmail(String userEmail) {
        return userRepository.findByUserEmail(userEmail)
                .orElseThrow(() -> new UsernameNotFoundException((userEmail)));
    }
    public UserDTO login(UserDTO userDTO){
        Optional<UserEntity> byMemberEmail = userRepository.findByUserEmail(userDTO.getUserEmail());
        if (byMemberEmail.isPresent()){
            UserEntity userEntity= byMemberEmail.get();
            if(userEntity.getUserPw().equals(userDTO.getUserPw())){
                //비밀번호 일치
                //entity -> dto 변환 후 리턴
                UserDTO dto = UserDTO.toUserDTO(userEntity);
                return dto;
            }else {
                // 비밀번호 불일치
                return null;
            }
        } else {
            // 해당 유저가 없음
            return null;
        }
    }
}