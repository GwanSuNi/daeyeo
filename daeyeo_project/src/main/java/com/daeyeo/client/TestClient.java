package com.daeyeo.client;

import com.daeyeo.config.SpringConfiguration;
import com.daeyeo.entity.*;
import com.daeyeo.service.NewUserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class TestClient {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(SpringConfiguration.class);


//        NewUserService userService = (NewUserService) container.getBean("uService");
//        UserEntity newUser  = new UserEntity();
//        newUser.setUserEmail("test@test.com");
//        newUser.setUserPw("1234");
//        newUser.setUserName("Hello World");
//        newUser.setPhoneNum("010-1234-5678");
//        userService.insertUser(newUser);

//        List<UserEntity> userEntityList = userService.getUserEntityList(new UserEntity());
//        System.out.println("찍업보기");
//        System.out.println(userEntityList.get(0).toString());
//        for (UserEntity user : userEntityList) {
//            System.out.println(user.getUserName() + " " + user.getWishLists());
//        }
//        System.out.println("이메일로 가져오기");
//        List<UserEntity> userEntities = userService.getUsersByEmail(newUser);
//        for (UserEntity user : userEntities) {
//            System.out.println(user.getUserName());
//        }
//        MainCategoryService service = (MainCategoryService) container.getBean("categoryService");
//        MainCategory mainCategory = new MainCategory();
//        mainCategory.setMcId("mcIdTest1");
//        service.insertMainCategory(mainCategory);
//        SubCategory subCategory = new SubCategory();
//        subCategory.setScId("scIdTest");
//        mainCategory.addSubCategory(subCategory);
//        service.insertCategory(mainCategory);
//        Optional<MainCategory> a = service.getCategory("mcIdTest1");
//        SubCategory subCategory = new SubCategory();
//        subCategory.setScId("scIdTest1");
//        service.insertSubCategory(subCategory);
//
//        if(a.isPresent()) {
//            System.out.println("찾음");
//            a.get().addSubCategory(subCategory);
//            service.flushData();
//            System.out.println("삽입 완료");
//        } else {
//            System.out.println("못 찾음");
//        }
//        System.out.println("가져오기");
//        System.out.println(service.getAllCategories());

        NewUserService userService = (NewUserService) container.getBean("uService");
        // 값 넣기 전 검증
        UserEntity a = userService.getUsersByEmail(new UserEntity("ex@ex.com")).get(0);

        // BanLog banLog = new BanLog();

//        Set<Advertisement> advertisements = userService.getAdvertisement("ex@ex.com");
//        Advertisement newAd = new Advertisement();
//        newAd.setAdCompany("몰라");
//        newAd.setAdLocation("집");
//        advertisements.add(newAd);
//        a.setAdvertisement(advertisements);
//        userService.insertUser(a);
//        a.setAdvertisement(Set.of(advertisement));


        // 광고 추가하는 과정
//        userService.insertNewAd(a, "테스트1", LocalDate.now(), 1000, "dlalwl1", "아무데나");
        // 광고 찾는 과정
//        System.out.println("!!! 찾은거 !!! " + userService.findAd(a,4).get()); // Optional이라 get(0)했지만 실제론 검증해야함
        // 광고 빼는 과정
            userService.deleteAd(a,4);
        // 값 들어갔는 지 검증
        System.out.println(a.getAdvertisement());
//        String jpql = "UPDATE UserEntity " +
//                "SET memoDate = (SELECT memoDate from UserMemo where userEmail = :email)";
//        String jpql1 = "select NEW com.daeyeo.entity.UserMemo from ";
//
//        TypedQuery<UserEntity> query = userService.createQuery(jpql, UserEntity.class);
//        query.setParameter("email", "ex@ex.com");
//        int resultList = query.executeUpdate();
//        userService.setUserMemoToUser("ex@ex.com", );
    }
}
