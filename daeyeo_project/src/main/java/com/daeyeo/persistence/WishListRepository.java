package com.daeyeo.persistence;

import com.daeyeo.entity.UserEntity;
import com.daeyeo.entity.WishList;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.jar.JarEntry;

public interface WishListRepository extends JpaRepository<WishList,Integer> {
    Optional<WishList> findByWishListIndexAndUserEntity(int wishListIndex , UserEntity userEntity);
    List<WishList> findByUserEntity(UserEntity userEntity);

}
