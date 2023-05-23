package com.daeyeo.client;

import com.daeyeo.entity.UserEntity;
import com.daeyeo.service.UserService;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class UserServiceClient {
    // 원래는 main() 안에 쓰는거에용
    static GenericXmlApplicationContext container = new GenericXmlApplicationContext("applicationCTX.xml");

    public static void main(String[] args) {
//        testInsert();
        UserService userService = (UserService) container.getBean("userService");
        List<UserEntity> userEntityList = userService.getUserList(new UserEntity());
        System.out.println("유저 목록");
        for (UserEntity user : userEntityList) {
            System.out.println("-> " + user.getId() + "의 이름 " + user.getUserName());
        }
    }

    public static void testInsert() {
        System.out.println("userService 가져오기");
        UserService userService = (UserService) container.getBean("userService");

        System.out.println("dataInsert() 실행");
        dataInsert(userService);

        System.out.println("close 전");
        container.close();
    }

    public static void dataInsert(UserService userService) {
        UserEntity user1 = new UserEntity();
        user1.setUserName("helloWorld!");
        userService.insertUser(user1);
        container.close();
    }
}
