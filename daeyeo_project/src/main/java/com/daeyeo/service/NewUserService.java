package com.daeyeo.service;

import com.daeyeo.entity.Address;
import com.daeyeo.entity.UserEntity;
import com.daeyeo.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.text.SimpleDateFormat;
import java.util.*;

@Service("uService")
@Transactional
public class NewUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EntityManager entityManager;

    private BanLogService banLogService;
    // ==================== 유저 관련 메서드 시작 ====================
    // User 엔티티 persist 해주는 메서드

    /**
     * @param userName
     * @param userEmail
     * @param userPw
     * @param phoneNum
     * @param userCategory
     * @param department
     * @param zipCode
     * @param roadAddress
     * @param jibunAddress
     * @param sido
     * @param sigungu
     * @return
     */
    public UserEntity userRegister(String userName, String userEmail, String userPw,
                                   String phoneNum, String userCategory, String department, int zipCode, String roadAddress, String jibunAddress,
                                   String sido, String sigungu) {
        Optional<UserEntity> dupleUser = userRepository.findByUserEmail(userEmail);
        if (dupleUser.isPresent()) {
            throw new IllegalStateException("이미 등록된 이메일 주소입니다.");
        }
        UserEntity user = new UserEntity();
        user.setUserName(userName);
        user.setUserEmail(userEmail);
        user.setUserPw(userPw);
        user.setPhoneNum(phoneNum);
        user.setUserCategory(userCategory);
        user.setDepartment(department);

        Address address = new Address();
        address.setZipCode(zipCode);
        address.setRoadAddress(roadAddress);
        address.setJibunAddress(jibunAddress);
        address.setSido(sido);
        address.setSigungu(sigungu);

        user.setAddress(address);

        this.userRepository.save(user);
        return user;
    }

    public void inserUser(UserEntity userEntity) {
        userRepository.save(userEntity);
    }

    // 직접 접근 안하고 이렇게 써야되나?
    public List<UserEntity> getUserEntityList() {
        return (List<UserEntity>) userRepository.findAll();
    }

    // 필요한가?
    public List<UserEntity> getUsersByName(String name) {
        return (List<UserEntity>) userRepository.findByUserName(name);
    }

    // 원래 List로 받아오는거였으나 어차피 PK 값으로 조회하는 것이기 때문에 단일 엔티티만 반환하기로 변경
    // 필요한가?
    // TODO: 없을 시에 할 작업
    public UserEntity findUserByEmail(String email) {
        return userRepository.findByUserEmail(email).get();
    }
// ==================== 유저 관련 메서드 끝 ====================


//    public int setUserMemoToUser(String email,UserMemo userMemo) {
//       return userRepository.updateUserEntity(email, userMemo.getContent(), userMemo.getMemoDate());
//    }

//    public int setUserMemo() {
//        TypedQuery<UserEntity> query = .createQuery(jpql, UserEntity.class);
//        query.setParameter("email", "ex@ex.com");
//        int resultList = query.executeUpdate();
//    }

    //    public Date getOldestRegistDate() {
//        String minRegistDate = userRepository.getOldestRegistDate();
//        minRegistDate = (Date) entityManager.createQuery(minDateQuery).getSingleResult();
//        return
//    }
    public int findByPaySum() {
        int paySum = userRepository.findByPaySum();
        return paySum;
    }

    public Date getOldesRegistDate() {
        Date minRegistDate = userRepository.findByRegistDate();
        return minRegistDate;
    }

    public List<String> createDateList(Date minRegistDate) {
        List<String> dateList = new ArrayList<>();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년MM월dd일");

        Calendar start = Calendar.getInstance();
        start.setTime(minRegistDate);
        Calendar end = Calendar.getInstance();

        while (!start.after(end)) {
            dateList.add(dateFormat.format(start.getTime()));
            start.add(Calendar.DATE, 1);
        }
        return dateList;
    }

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }
}
