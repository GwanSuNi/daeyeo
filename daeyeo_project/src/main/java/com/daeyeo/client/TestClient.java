package com.daeyeo.client;

import com.daeyeo.config.SpringConfiguration;
import com.daeyeo.entity.*;
import com.daeyeo.persistence.*;
import com.daeyeo.service.*;
import net.bytebuddy.asm.Advice;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;


/**
 * @author gwansuni
 * <p>
 * 주석 처리돼 있는 코드들은 모두 테스트를 위한 코드들이므로
 * 각자 테스트를 해보고 싶을 때 해당 블럭을 주석 해제 후 실행해보세요
 *
 */
public class TestClient {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//          RentalObjectService rentalObjectService = (RentalObjectService) container.getBean("rentalObjectService");
        // 완료 -rentalObject CRUD 테스트 다함
//        rentalObjectService.insertRentalObject("test@test.com","scIdTest","test마지막입니다.",0,"0",
//                  "test1",LocalDate.now(),LocalDate.now(),LocalDateTime.now(),0,0,
//                  "test1","test1","test마지막입니다.");
        // 완료
//        rentalObjectService.deleteRentalObject(9,"scIdTest","test@test.com");
        // 완료
//        rentalObjectService.findRentalObject()
//          rentalObjectService.updateRentalObject(5,"scIdTest","test@test.com",
//                                                    "테스트업데이트",123,"테스트업데이트"
//                                                    ,"테스트업데이트",LocalDate.now(),LocalDate.now(),
//                                                    LocalDateTime.now(),123,123,
//                                            "테스트업데이트","테스트업데이트","테스트업데이트");
        // 완료

        // 미완료 -rentalLog CRUD 테스트 80% 완료
//        RentalLogService rentalLogService = (RentalLogService) container.getBean("rentalLogService");
        // 완료
//        rentalLogService.insertRentalLog(5,"test@test.com",LocalDate.now(),
//                                                                    LocalDate.now(),123456);
        // 완료
//        rentalLogService.deleteRentalLog(9,5,"test@test.com");
        // 검증중..
//        rentalLogService.updateRentalLog(8,5,"test@test.com", LocalDate.now() , LocalDate.now() ,123456,LocalDateTime.now());

        // Review CRUD 테스트 완료
//          ReviewService reviewService = (ReviewService) container.getBean("reviewService");
        // 완료
//          reviewService.insertReview("test@test.com",5,"테스트리뷰last");
        // 완료
//          reviewService.deleteReview(4,5,"test@test.com");
        // delete 되면 완료 review는 굳이 업데이트 할 필요가 없음 == 배민도 안함
//          reviewService.findReview(1,5,"test@test.com");
        /*===============양방향 관계 CRUD테스트====================== */

//
//        rentalLogService.findByRentalId(8);
//        rentalLogService.findRentalLog(8,"test@test.com",5);
//        rentalLogService.insertRentalLog("test@test.com", 5, LocalDate.now(), LocalDate.of(2024, 12, 25),0); // JPQL사용해야함
// 성공
//        System.out.println(review);


//        rentalLogService.findRentalLog(8,"test@test.com",5);

//        RentalLogRepository rentalLogRepository = (RentalLogRepository) container.getBean("rentalLogRepository");
//        rentalLogRepository.customFindRentalLogByEmail("test@test.com");

//        RentalObjectService rentalObjectService = (RentalObjectService)container.getBean("rentalObjectService");
////
//        SubCategory subCategory = rentalObjectService.findSubCategoryByScId("scIdTest");
//        // 찾음
//        System.out.println("1");
//        UserEntity userEntity = rentalObjectService.findEntityById("test@test.com");
//        // 찾음
////        String email = userEntity.getUserEmail();
////        UserEntity muckbur = new UserEntity();
////        muckbur.setUserEmail(email);
//        System.out.println("객체 생성!");
//        RentalObject rentalObject = new RentalObject();
//        rentalObject.setSubCategory(subCategory);
//        rentalObject.setUserEntity(userEntity);
//        rentalObject.setObjectIndex(1);
//        rentalObject.setObjectName("test");
//        rentalObject.setPrice(100);
//        rentalObject.setWishCount(100);
//        rentalObject.setWebsite("test");
//        rentalObject.setTarget("test");
//        rentalObject.setStartDuration(LocalDate.now());
//        rentalObject.setEndDuration(LocalDate.now());
//        rentalObject.setReceiptDuration(LocalDateTime.now());
//        rentalObject.setCapacity(100);
//        rentalObject.setRepresentNum(100);
//        rentalObject.setUserInfo("test");
//        rentalObject.setObjectImage("test");
//
//         //여기까지
////        userEntity.addRentalObject(rentalObject);
////        subCategory.addRentalObject(rentalObject);
////        rentalObjectService.insertEntityUser(userEntity);
////        rentalObjectService.insertSubCategory(subCategory);
////        rentalObjectService.insertRentalObject(rentalObject);
//        rentalObjectService.insertRentalObject(rentalObject,subCategory,userEntity);


//        MainCategoryService mainCategoryService = (MainCategoryService)container.getBean("mainCategoryService");
//        SubCategory subCategory = new SubCategory();
//        subCategory.setScId("scIdTest");
//        MainCategory mainCategory = new MainCategory();
//        mainCategory.setMcId("mcIdTest");
//        mainCategory.addSubCategory(subCategory);
//        mainCategoryService.insertSubCategory(subCategory);
//        mainCategoryService.insertMainCategory(mainCategory);




//        MainCategoryService mainCategoryService = (MainCategoryService)container.getBean("mainCategoryService");
//
//        SubCategory subCategory = new SubCategory();
//        subCategory.setScId("먼저찾고넣기");
//        System.out.println("1");
//        mainCategoryService.insertSubCategory(subCategory);
//        // 안됨 mainCategoryService.flushData();
//
//        // sc값이 있으면 값이 안들어가고 걍 잘 들어감
//        System.out.println("2");
//        MainCategory mainCategory1 = mainCategoryService.findMainCategoryByMcID("mcIdTest");
//        System.out.println("3");
//        mainCategory1.addSubCategory(subCategory);
//
//
//        System.out.println("4");
//        mainCategoryService.insertMainCategory(mainCategory1);


        NewUserService userService = (NewUserService) container.getBean("uService");
        UserEntity newUser  = new UserEntity();
        newUser.setUserEmail("test@test.com1");
        newUser.setUserPw("1234");
        newUser.setUserName("Hello World");
        newUser.setPhoneNum("010-1234-5678");
//        newUser.setDepartment("회사원");
//        newUser.setUserCategory("골드회원");
//        newUser.setRegistDate(LocalDateTime.now());
//        newUser.setPaySum(3000);
//        newUser.setCommissionSum(2000);
//        newUser.setRate(1000);
//        newUser.setQuitFlag(true);
        userService.insertUser(newUser);

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

// ==================== 메모 관련 메서드 시작 ====================
//        NewUserService userService = (NewUserService) container.getBean("uService");
        // 값 넣기 전 검증
//        UserEntity a = userService.findUserByEmail("ex@ex.com");

//        userService.insertUserMemo("ex@ex.com", "테스트 해볼게용");
//        userService.updateUserMemo(a.getUserEmail(), 2, "바꾼 내용");
//        userService.deleteUserMemo("ex@ex.com", 1);
//        System.out.println(userService.findUserMemo("ex@ex.com", 2));
//        userService.deleteAllUserMemos("ex@ex.com");
////        userService.deleteAllUserMemos("ex@ex.com");
//        Set<UserMemo> memos = userService.getMemos("ex@ex.com");
//        for (UserMemo memo : memos) {
//            System.out.println(memo);
//        }
//        UserRepository userRepository = (UserRepository) container.getBean("userRepository");
//        UserEntity user = userRepository.customFindMethod("ex@ex.com");
//        System.out.println(user);
//        int a = userRepository.memoCountByEmail("ex@ex.com");
//        System.out.println(a);
// ==================== 메모 관련 메서드 끝  ====================

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
//            userService.deleteAd(a,4);
        // 값 들어갔는 지 검증
//        System.out.println(a.getAdvertisement());


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
