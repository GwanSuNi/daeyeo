package com.daeyeo.helloDaeyeo.service;

import com.daeyeo.helloDaeyeo.dto.rental.RentalStatusDto;
import com.daeyeo.helloDaeyeo.repository.RentalObjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RentalStatusService {
    private final RentalObjectRepository rentalObjectRepository;

    //    public void insertRentalObject(RentalRegisterDto dto) {
//        System.out.println("insertChapterStart");
//        Member member = memberMapper.toEntity(memberService.getMember(dto.getUserId()));
//        SubCategory subCategory = subCategoryMapper.toEntity(subCategoryService.getSubCategory(dto.getScId()));
//        RentalObject rentalObject = rentalObjectMapper.toEntity(dto, subCategory, member);
//        rentalObjectRepository.save(rentalObject);
//    }
    public void insertRentalStatus(RentalStatusDto rentalStatusDto) {

    }

}
