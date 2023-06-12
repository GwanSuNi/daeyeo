package com.daeyeo.dto;

import com.daeyeo.entity.Address;
import com.daeyeo.entity.UserEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserDTO {
    private String userName;
    private String userEmail;
    private String userPw;
    private String phoneNum;
    private Address address;
    private String userCategory;
    private String department;

    @Builder
    public UserDTO(String userName, String userEmail, String userPw, String phoneNum, Address address, String userCategory, String department) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPw = userPw;
        this.phoneNum = phoneNum;
        this.address = address;
        this.userCategory = userCategory;
        this.department = department;
    }

    public static UserDTO toUserDTO(UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName(userEntity.getUserName());
        userDTO.setUserEmail(userEntity.getUserEmail());
        userDTO.setUserPw(userEntity.getUserPw());
        userDTO.setPhoneNum(userEntity.getPhoneNum());
        userDTO.setAddress(userEntity.getAddress());
        userDTO.setUserCategory(userEntity.getUserCategory());
        userDTO.setDepartment(userEntity.getDepartment());
        return userDTO;
    }
}