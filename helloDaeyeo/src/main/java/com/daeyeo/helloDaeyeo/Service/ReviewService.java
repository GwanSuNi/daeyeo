package com.daeyeo.helloDaeyeo.Service;

import com.daeyeo.helloDaeyeo.Dto.ReviewDto;
import com.daeyeo.helloDaeyeo.Entity.Member;
import com.daeyeo.helloDaeyeo.Entity.RentalObject;
import com.daeyeo.helloDaeyeo.Entity.Review;
import com.daeyeo.helloDaeyeo.Repository.MemberRepository;
import com.daeyeo.helloDaeyeo.Repository.RentalObjectRepository;
import com.daeyeo.helloDaeyeo.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ReviewService {
    @Autowired
    RentalObjectRepository rentalObjectRepository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    ReviewRepository reviewRepository;

    public void insertReview(ReviewDto reviewDto ,String userId, int rentalId){
        Optional<Member> member = memberRepository.findById(userId);
        Optional<RentalObject> rentalObject = rentalObjectRepository.findById(rentalId);
        Review review = new Review(reviewDto);
        review.setMember(member.get());
        review.setRentalObject(rentalObject.get());
        reviewRepository.save(review);
    }
    public void deleteReview(){

    }
    public void updateReview(){

    }
}
