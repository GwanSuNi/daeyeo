package com.daeyeo.helloDaeyeo.repository;

import com.daeyeo.helloDaeyeo.entity.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishListRepository extends JpaRepository<WishList, Long> {

}
