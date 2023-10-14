package com.daeyeo.helloDaeyeo.service;

import com.daeyeo.helloDaeyeo.dto.rental.RentalObjectDto;
import com.daeyeo.helloDaeyeo.dto.rental.RentalRegisterDto;
import com.daeyeo.helloDaeyeo.dto.rental.SearchSpecDto;
import com.daeyeo.helloDaeyeo.entity.Member;
import com.daeyeo.helloDaeyeo.entity.RentalObject;
import com.daeyeo.helloDaeyeo.entity.SubCategory;
import com.daeyeo.helloDaeyeo.exception.NotFoundRentalObjectException;
import com.daeyeo.helloDaeyeo.mapper.MemberMapper;
import com.daeyeo.helloDaeyeo.mapper.RentalObjectMapper;
import com.daeyeo.helloDaeyeo.mapper.SubCategoryMapper;
import com.daeyeo.helloDaeyeo.repository.RentalObjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RentalObjectService {
    private final RentalObjectRepository rentalObjectRepository;

    private final MemberService memberService;
    private final SubCategoryService subCategoryService;

    private final RentalObjectMapper rentalObjectMapper;
    private final MemberMapper memberMapper;
    private final SubCategoryMapper subCategoryMapper;

    @Transactional
    public void insertRentalObject(RentalRegisterDto dto) {
        Member member = memberMapper.toEntity(memberService.getMember(dto.getUserId()));
        SubCategory subCategory = subCategoryMapper.toEntity(subCategoryService.getSubCategory(dto.getScId()));
        RentalObject rentalObject = rentalObjectMapper.toEntity(dto, subCategory, member);

        rentalObjectRepository.save(rentalObject);
    }

    @Transactional
    public void updateRental() {

    }

    @Transactional
    public void removeRental(long objectIndex, String userId, String scId) {
        RentalObject rentalObject = rentalObjectRepository.findById(objectIndex)
                .orElseThrow(()->new NotFoundRentalObjectException("삭제하려고 하시는 대여 장소가 없습니다"));
    }

    public RentalObjectDto getRentalObject(long objectIndex) {
        RentalObject rentalObject = rentalObjectRepository.findById(objectIndex)
                .orElseThrow(() -> new NotFoundRentalObjectException("해당 게시글을 찾을 수 없습니다."));

        return rentalObjectMapper.toDto(rentalObject);
    }

    public List<RentalObjectDto> findListBySearchSpec(SearchSpecDto dto) {
        return rentalObjectMapper.toDtoList(rentalObjectRepository.findRentalObjectsByDto(dto));
    }
}
