package com.daeyeo.persistence;

import com.daeyeo.entity.RentalObject;
import com.daeyeo.entity.Review;
import com.daeyeo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review,Integer> {
//   Review findByReviewIndex(int reviewIndex);
//   Review findByObjectIndex(int objectIndex);
//   Review findByWriter(String writer);

   List<Review> findByReviewIndexAndRentalObjectAndUserEntity(int reviewIndex, RentalObject rentalObject , UserEntity userEntity);
   @Query("SELECT rv FROM Review rv LEFT JOIN UserEntity u ON rv.userEntity.userEmail = u.userEmail")
   List<Review> findReviewWithUser();

}
