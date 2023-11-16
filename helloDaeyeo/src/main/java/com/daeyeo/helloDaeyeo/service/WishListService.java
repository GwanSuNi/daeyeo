package com.daeyeo.helloDaeyeo.service;

import com.daeyeo.helloDaeyeo.entity.Member;
import com.daeyeo.helloDaeyeo.entity.WishList;
import com.daeyeo.helloDaeyeo.repository.WishListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WishListService {
    final private WishListRepository wishListRepository;
    final private RentalObjectService rentalObjectService;
    final private MemberService memberService;

    public void insertWishList(long rentalObjectIndex, String memberId) {
        WishList wishList = new WishList();
        wishList.setRentalObject(rentalObjectService.getOneRentalObject(rentalObjectIndex));
        wishList.setMember(memberService.findMember(memberId).get());
        wishListRepository.save(wishList);
    }

    public void deleteWishList(long wishIndex) {
        WishList wishList = wishListRepository.findById(wishIndex).get();
        System.out.println(wishList.getRentalObject() + "=====================");
        wishList.setRentalObject(null);
        wishList.setMember(null);
        wishListRepository.delete(wishList);
    }

    public boolean hasWishList(long rentalObjectIndex, String memberId) {
        List<WishList> wishListList = memberService.findMember(memberId).get().getWishListList();
        for (WishList wishList : wishListList) {
            if (wishList.getRentalObject().getObjectIndex().equals(rentalObjectIndex)) {
                return true;
            }
        }
        return false;
    }

    public WishList findWish(long rentalObjectIndex, String memberId) {
        List<WishList> wishListList = memberService.findMember(memberId).get().getWishListList();
        for (WishList wishList : wishListList) {
            if (wishList.getRentalObject().getObjectIndex().equals(rentalObjectIndex)) {
                return wishList;
            }
        }
        // TODO 에러 처리 해야댐
        return null;
    }

    public List<WishList> findAll(String memberId) {
        Member member = memberService.findMember(memberId).get();
        return member.getWishListList();
    }
}
