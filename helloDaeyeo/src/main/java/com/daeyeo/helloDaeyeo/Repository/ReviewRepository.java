package com.daeyeo.helloDaeyeo.Repository;

import com.daeyeo.helloDaeyeo.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Integer> {
}
