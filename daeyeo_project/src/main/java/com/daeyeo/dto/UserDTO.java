package com.daeyeo.dto;

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
    private String location;
    private String phoneNum;

    @Builder
    public UserDTO(String userName, String userEmail, String userPw, String location, String phoneNum) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPw = userPw;
        this.location = location;
        this.phoneNum = phoneNum;
    }
    public static UserDTO toUserDTO(UserEntity userEntity){
        UserDTO userDTO = new UserDTO();
        userDTO.setUserEmail(userEntity.getUserEmail());
        userDTO.setUserPw(userEntity.getUserPw());
        userDTO.setUserName(userEntity.getUsername());
        userDTO.setPhoneNum(userEntity.getPhoneNum());
        return userDTO;
    }
    //회원가입할때 왜 필요한가 ban Log user 이게 지금 둘이 양방향인데 양방향에서 엔티티를접근해서 값을 집어넣어주려고 하면
    // 둘다 값을 집어넣어야함 양방향에서는 벤로그 , 유저 이 두개 다 접근가능해야돼서 벤로그에는 유저 엔티티 객체가잇고
    // 유저에는 벤로그 객체가 잇어서 한쪽에만 값을 집어넣으려고 하면 오류가 생김 너는 그냥 벤로그 무시하고 유저 넣으려고하니
    // 인텔리제이에서 얘 넣어주려면 벤로그도 같이 넣어야한다 그래서 너가 이걸 해결한게 jdbc를
}
