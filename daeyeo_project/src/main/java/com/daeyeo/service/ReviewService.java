package com.daeyeo.service;

import com.daeyeo.entity.*;
import com.daeyeo.persistence.RentalObjectRepository;
import com.daeyeo.persistence.ReviewRepository;
import com.daeyeo.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Transactional
@Service("reviewService")
public class ReviewService {
    @Autowired
    private RentalObjectRepository rentalObjectRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ReviewRepository reviewRepository;
// =============update 는 리뷰에서 필요하지 않을거같아서 만들지않음==================
    /**
     * @author 서상현
     * 리뷰 추가하는 메서드임 양방향 메서드라서 설명 필요하면 물어보세요
     * @param objectIndex RentalObject에서 받아오는 외래키입니다.
     * @param writer UserEntity userEmail 에서 받아오는 외래키입니다.
     * @param content 리뷰에 적어야 할 내용입니다.
     */
    // 리뷰 데이터 삽입하기
    public void insertReview(int objectIndex ,String writer ,  String content){
        UserEntity user = userRepository.findByUserEmail(writer).get(); // 양방향이라 외래키를 찾아아야함
        RentalObject rentalObject = rentalObjectRepository.findByObjectIndex(objectIndex).get(); // 위와 같음
        Review review = new Review(user,rentalObject,content); // 추가할 리뷰를 넣기
        user.addReview(review); // 양방향이라 양방향관계에 있는 유저엔티티의 리뷰 추가하기
        rentalObject.addReview(review); // 양방향이라 양방향관계에 있는 렌탈오브젝트의 리뷰 추가하기
        reviewRepository.save(review); // 영속성 부여 하기 *제일중요합니다 == persist()하는것과 같음
    }

    /**
     * @author 서상현
     * 리뷰를 찾는 메서드입니다. System.out을 찍으면 순환참조가 일어나 테스트를 수학적 귀납법으로 delete를 만들어 테스트 했습니다.
     * @param reviewIndex 리뷰인덱스의 기본키입니다.
     * @param objectIndex 리뷰인덱스의 RentalObject에게 받아오는 외래키입니다.
     * @param writer 리뷰인덱스의 User에게 받아오는 외래키입니다.
     */
    public void findReview(int reviewIndex , int objectIndex , String writer){
        RentalObject rentalObject = rentalObjectRepository.findByObjectIndex(objectIndex).get();
        UserEntity userEntity = userRepository.findByUserEmail(writer).get();
        List<Review> review = reviewRepository.findByReviewIndexAndRentalObjectAndUserEntity(reviewIndex,rentalObject,userEntity);
        review.forEach(e-> System.out.println(e.getReviewIndex()));
    }
    public void deleteReview(int reviewIndex , int objectIndex , String writer){
        // 리뷰 클래스타입으로 받아와서 pk , fk 2개 를 찾는 메서드
        RentalObject rentalObject = rentalObjectRepository.findByObjectIndex(objectIndex).get();
        UserEntity userEntity = userRepository.findByUserEmail(writer).get();
         List<Review> review = reviewRepository.findByReviewIndexAndRentalObjectAndUserEntity(reviewIndex,rentalObject,userEntity);
         review.forEach(e-> System.out.println(e.getReviewIndex()));
         // 리뷰 조회 기능
//        System.out.println(review.toString()); 이거 쓰면 순환참조 일어남 조심하길 ..
//         조회된 리뷰가 존재하면 삭제
        if (review != null) {
            reviewRepository.delete(review.get(0));
        } else {
            // System.out.println("리뷰가없어요.");
        }
    }
}
