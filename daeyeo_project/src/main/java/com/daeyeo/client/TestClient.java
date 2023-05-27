package com.daeyeo.client;

import com.daeyeo.config.SpringConfiguration;
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
        newUser.setUserName("Hello World");
        userService.insertUser(newUser);
        List<UserEntity> userEntityList = userService.getUserEntityList(new UserEntity());
        for (UserEntity user : userEntityList) {
            System.out.println(user);
        }
    }
}
