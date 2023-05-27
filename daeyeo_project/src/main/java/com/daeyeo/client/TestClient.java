package com.daeyeo.client;

import com.daeyeo.config.SpringConfiguration;
import com.daeyeo.entity.BanLog;
import com.daeyeo.entity.UserEntity;
import com.daeyeo.service.NewUserService;
import org.apache.catalina.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class TestClient {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        NewUserService userService = (NewUserService) container.getBean("uService");
        UserEntity newUser  = new UserEntity();
//        newUser.setUserEmail("test@test.com");
//        newUser.setUserPw("1234");
//        newUser.setUserName("Hello World");
//        newUser.setPhoneNum("010-1234-5678");
//        userService.insertUser(newUser);

        List<UserEntity> userEntityList = userService.getUserEntityList(new UserEntity());
        for (UserEntity user : userEntityList) {
            System.out.println(user.getUserName() + " " + user.getWishLists());
        }
        System.out.println("이메일로 가져오기");
        List<UserEntity> userEntities = userService.getUsersByEmail(newUser);
        for (UserEntity user : userEntities) {
            System.out.println(user.getUserName());
        }
    }
}
