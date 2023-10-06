package com.daeyeo.helloDaeyeo.repository;

import com.daeyeo.helloDaeyeo.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Integer> {
}
