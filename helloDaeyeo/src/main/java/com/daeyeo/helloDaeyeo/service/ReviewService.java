package com.daeyeo.helloDaeyeo.service;

import com.daeyeo.helloDaeyeo.dto.ReviewDto;
import com.daeyeo.helloDaeyeo.entity.Member;
import com.daeyeo.helloDaeyeo.entity.RentalObject;
import com.daeyeo.helloDaeyeo.entity.Review;
import com.daeyeo.helloDaeyeo.repository.MemberRepository;
import com.daeyeo.helloDaeyeo.repository.RentalObjectRepository;
import com.daeyeo.helloDaeyeo.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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

    public void insertReview(ReviewDto reviewDto ,String userId, long rentalId){
        Optional<Member> member = memberRepository.findById(userId);
        Optional<RentalObject> rentalObject = rentalObjectRepository.findById(rentalId);
        Review review = new Review(reviewDto);
        review.setMember(member.get());
        review.setRentalObject(rentalObject.get());
        reviewRepository.save(review);
    }
    public List<Review> findAll(){
        List<Review> reviewList = reviewRepository.findAll();
        return reviewList;
    }
    public void deleteReview(){

    }
    public void updateReview(){

    }
}
