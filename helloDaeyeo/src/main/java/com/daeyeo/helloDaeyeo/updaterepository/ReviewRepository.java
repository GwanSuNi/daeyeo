package com.daeyeo.helloDaeyeo.updaterepository;

import com.daeyeo.helloDaeyeo.updateentity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Integer> {
}
