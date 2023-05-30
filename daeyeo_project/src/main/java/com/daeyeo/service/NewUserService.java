package com.daeyeo.service;

import com.daeyeo.entity.Advertisement;
import com.daeyeo.entity.UserEntity;
import com.daeyeo.entity.UserMemo;
import com.daeyeo.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service("uService")
@Transactional
public class NewUserService {
    @Autowired
    private UserRepository userRepository;

    // ==================== 메모 관련 메서드 시작 ====================
    // 유저 엔티티를 통해 유저 메모를 추가하는 메서드
    public void insertUserMemo(UserEntity user, String content) {
        UserMemo newMemo = new UserMemo(content);
        user.addMemoToUser(newMemo);
        this.insertUser(user);
    }

    // 이메일을 통해 유저 메모 컬렉션을 받아오는 메서드
    // TODO: 값 없을 때 할 일
    public Set<UserMemo> getMemos(String email) {
        return userRepository.findByUserEmail(email).get().getUserMemo();
    }

    // 인덱스로 유저의 메모를 하나 찾는 메서드
    public UserMemo findUserMemo(String email, int memoId) {
        Set<UserMemo> memos = findUserByEmail(email).getUserMemo();
        return memos.stream().filter(UserMemo -> UserMemo.getMemoId() == memoId).findFirst().get();
    }

    // 유저 이메일을 통해 유저 메모를 수정하는 메서드
    public void updateUserMemo(String email, int memoId, String newContent) {
        UserEntity user = this.findUserByEmail(email);
        Set<UserMemo> memos = user.getUserMemo(); // 해당 유저 메모 셋 가져오기
        // TODO: 메모 ID에 해당하는 값이 없을 경우 조건 추가
        // 검색한 memoId와 같은 메모 삭제
        UserMemo oldUserMemo = findUserMemo(email, memoId);
        memos.remove(oldUserMemo);
        // 새로운 메모를 할당
        UserMemo newUserMemo = new UserMemo(memoId, newContent);
        memos.add(newUserMemo);
        user.setUserMemo(memos);
    }

    // 유저 이메일을 통해 유저 메모를 삭제
    public void deleteUserMemo(String email, int memoId) {
        Set<UserMemo> memos = findUserByEmail(email).getUserMemo();
        UserMemo memo = findUserMemo(email, memoId);
        memos.remove(memo);
    }

    // 유저 이메일을 통해 유저 메모 전부 삭제
    public void deleteAllUserMemos(String email) {
        UserEntity user = findUserByEmail(email);
        Set<UserMemo> memos = new HashSet<>();
        user.setUserMemo(memos);
    }

    // ==================== 메모 관련 메서드 끝 ====================

    // ==================== 광고 관련 메서드 시작 ====================
    // 이메일을 통해 광고 컬렉션 받아오는 메서드
    public Set<Advertisement> getAdvertisement(String email) {
        return userRepository.findByUserEmail(email).get().getAdvertisement();
    }

    // 광고 추가 요청이 발생했을 때 Controller에서 사용
    // 광고 추가할 유저를 미리 찾아서, 광고 값들과 함께 넣어주시면 됩니다.
    public void insertNewAd(UserEntity user, String adCompany, LocalDate duration, int price, String adImage, String adLocation) {
        Advertisement newAd = new Advertisement(adCompany, duration, price, adImage, adLocation);
        user.getAdvertisement().add(newAd); // getAdvertisement() 가 set 이라 가져와서 다시 추가해줌
        // 추가한걸 다시 대입해줌 그래서 add(newAd)가 들어간거임
        // 우리는 이걸 메서드화 해서 만듬
        this.insertUser(user);
    }

    // 광고 검색하는 메소드
    public Optional<Advertisement> findAd(UserEntity user, int adId) {
        Set<Advertisement> advertisements = user.getAdvertisement();
        Optional<Advertisement> foundAdvertisement = advertisements.stream()
                .filter(advertisement -> advertisement.getAdId() == (adId))
                .findFirst();
        return foundAdvertisement;
    }

    // 광고 빼는 메소드
    public void deleteAd(UserEntity user, int adId) {
        Optional<Advertisement> targetAd = this.findAd(user, adId);
        if (targetAd.isPresent()) {
            Set<Advertisement> advertisements = user.getAdvertisement();
            advertisements.remove(targetAd.get());
        } else {
            System.out.println("대상 광고가 없습니다!");
        }
    }

    // ==================== 광고 관련 메서드 끝 ====================

    // ==================== 유저 관련 메서드 시작 ====================
    // User 엔티티 persist 해주는 메서드
    public void insertUser(UserEntity userEntity) {
        userRepository.save(userEntity);
        userRepository.flush();
    }

    //
    public List<UserEntity> getUserEntityList(UserEntity userEntity) {
        userRepository.flush();
        return (List<UserEntity>) userRepository.findAll();
    }

    public List<UserEntity> getUsersByName(UserEntity userEntity) {
        return (List<UserEntity>) userRepository.findByUserName(userEntity.getUserName());
    }

    // 원래 List로 받아오는거였으나 어차피 PK 값으로 조회하는 것이기 때문에 단일 엔티티만 반환하기로 변경
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
}
