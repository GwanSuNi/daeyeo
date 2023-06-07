package com.daeyeo.service;

import com.daeyeo.entity.UserEntity;
import com.daeyeo.entity.WishList;
import com.daeyeo.persistence.UserRepository;
import com.daeyeo.persistence.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service("wishListService")
@Transactional

public class WishService {
    @Autowired
    WishListRepository wishListRepository;
    @Autowired
    UserRepository userRepository;

    public void insertWishList(String userEmail , int objectIndex , LocalDateTime localDateTime){
        UserEntity userEntity = userRepository.findByUserEmail(userEmail).get();
        WishList wishList = new WishList(userEntity,objectIndex,localDateTime);
        userEntity.addWishList(wishList);
        wishListRepository.save(wishList);
    }
    public void deleteWishList(int wishIndex , String userEmail){
        UserEntity userEntity = userRepository.findByUserEmail(userEmail).get();
        Optional<WishList> wishLists = wishListRepository.findByWishListIndexAndUserEntity(wishIndex,userEntity);
        wishListRepository.delete(wishLists.get());
    }

}
