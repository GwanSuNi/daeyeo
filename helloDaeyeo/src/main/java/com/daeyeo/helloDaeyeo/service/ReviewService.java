package com.daeyeo.helloDaeyeo.service;

import com.daeyeo.helloDaeyeo.dto.ReviewDto;
import com.daeyeo.helloDaeyeo.updateentity.Member;
import com.daeyeo.helloDaeyeo.updateentity.RentalObject;
import com.daeyeo.helloDaeyeo.updateentity.Review;
import com.daeyeo.helloDaeyeo.updaterepository.MemberRepository;
import com.daeyeo.helloDaeyeo.updaterepository.RentalObjectRepository;
import com.daeyeo.helloDaeyeo.updaterepository.ReviewRepository;
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
