package com.daeyeo.helloDaeyeo.Service;

import com.daeyeo.helloDaeyeo.Dto.RentalObjectDto;
import com.daeyeo.helloDaeyeo.Entity.Member;
import com.daeyeo.helloDaeyeo.Entity.RentalObject;
import com.daeyeo.helloDaeyeo.Entity.SubCategory;
import com.daeyeo.helloDaeyeo.Repository.MemberRepository;
import com.daeyeo.helloDaeyeo.Repository.RentalObjectRepository;
import com.daeyeo.helloDaeyeo.Repository.SubCategoryRepository;
import com.daeyeo.helloDaeyeo.exception.NotFoundRentalObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@Transactional
public class RentalObjectService {
    @Autowired
    SubCategoryRepository subCategoryRepository;
    @Autowired
    RentalObjectRepository rentalObjectRepository;
    @Autowired
    MemberRepository memberRepository;

    /***
     *
     * @param rentalObjectDto RentalObject를 넣기위한 Dto 연관관계가 없는 값들 넣음
     * @param userId
     * @param scId
     */
    public void insertRental(RentalObjectDto rentalObjectDto , String userId , String scId ) {
        Optional<SubCategory> subCategory = subCategoryRepository.findById(scId);
        Optional<Member> member = memberRepository.findById(userId);
        RentalObject rentalObject = new RentalObject(rentalObjectDto);
        rentalObject.setSubCategory(subCategory.get());
        rentalObject.setMember(member.get());
        rentalObjectRepository.save(rentalObject);
    }
    public void updateRental(){

    }
    public void removeRental(int objectIndex , String userId , String scId){
        Optional<RentalObject> rentalObject = rentalObjectRepository.findById(objectIndex);
        if(rentalObject.isPresent()){
            rentalObjectRepository.delete(rentalObject.get());
        }else{
            throw new NotFoundRentalObjectException("삭제하려고 하시는 대여 장소가 없습니다");
        }

    }
}
