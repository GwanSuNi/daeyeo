package com.daeyeo.service;

import com.daeyeo.entity.Advertisement;
import com.daeyeo.entity.UserEntity;
import com.daeyeo.entity.UserMemo;
import com.daeyeo.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service("uService")
@Transactional
public class NewUserService {
    @Autowired
    private UserRepository userRepository;

    // 이메일을 통해 광고 컬렉션 받아오는 메서드
    public Set<Advertisement> getAdvertisement(String email) {
        return userRepository.findByUserEmail(email).get(0).getAdvertisement();
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
        userRepository.flush();
        return (List<UserEntity>) userRepository.findByUserName(userEntity.getUserName());
    }

    public List<UserEntity> getUsersByEmail(UserEntity userEntity) {
        userRepository.flush();
        return (List<UserEntity>) userRepository.findByUserEmail(userEntity.getUserEmail());
    }

//    public int setUserMemoToUser(String email,UserMemo userMemo) {
//       return userRepository.updateUserEntity(email, userMemo.getContent(), userMemo.getMemoDate());
//    }

//    public int setUserMemo() {
//        TypedQuery<UserEntity> query = .createQuery(jpql, UserEntity.class);
//        query.setParameter("email", "ex@ex.com");
//        int resultList = query.executeUpdate();
//    }
}
