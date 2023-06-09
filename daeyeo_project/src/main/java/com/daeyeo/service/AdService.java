package com.daeyeo.service;

import com.daeyeo.entity.Advertisement;
import com.daeyeo.entity.UserEntity;
import com.daeyeo.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

@Service("adService")
@Transactional
public class AdService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    NewUserService userService;
    // ==================== 광고 관련 메서드 시작 ====================
    // 이메일을 통해 광고 컬렉션 받아오는 메서드
    public Set<Advertisement> getAdvertisement(String email) {
        return userRepository.findByUserEmail(email).get().getAdvertisement();
    }

    // 광고 추가 요청이 발생했을 때 Controller에서 사용
    // 광고 추가할 유저를 미리 찾아서, 광고 값들과 함께 넣어주시면 됩니다.
    /**
     *
     * @param email : 해당 유저의 이메일
     * @param adCompany : 소속 회사
     * @param duration : 광고 기재 기간
     * @param price : 광고 가격
     * @param adImage : 광고 이미지
     * @param adLocation : 광고가 기재될 위치
     */
    public void insertNewAd(String email, String adCompany, LocalDate startDuration , LocalDate endDuration , int price, String adImage, String adLocation) {
        UserEntity user = userRepository.findByUserEmail(email).get();
        Advertisement newAd = new Advertisement(adCompany, startDuration,endDuration, price, adImage, adLocation);
        user.getAdvertisement().add(newAd); // getAdvertisement() 가 set 이라 가져와서 다시 추가해줌
        // 추가한걸 다시 대입해줌 그래서 add(newAd)가 들어간거임
        // 우리는 이걸 메서드화 해서 만듬
//        userService.insertUser(user);
        userRepository.save(user);
    }

    // 광고 검색하는 메소드
    public Optional<Advertisement> findAd(String email, int adId) {
        UserEntity user = userRepository.findByUserEmail(email).get();
        Set<Advertisement> advertisements = user.getAdvertisement();
        return advertisements.stream()
                .filter(advertisement -> advertisement.getAdId() == (adId))
                .findFirst();
    }

    // 광고 빼는 메소드
    public void deleteAd(String email, int adId) {
        UserEntity user = userRepository.findByUserEmail(email).get();
        Optional<Advertisement> targetAd = this.findAd(email, adId);
        if (targetAd.isPresent()) {
            Set<Advertisement> advertisements = user.getAdvertisement();
            advertisements.remove(targetAd.get());
        } else {
            System.out.println("대상 광고가 없습니다!");
        }
    }

    // ==================== 광고 관련 메서드 끝 ====================
}
