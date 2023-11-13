package com.daeyeo.helloDaeyeo.service;

import com.daeyeo.helloDaeyeo.dto.myPageDto.RentalObjectManageDto;
import com.daeyeo.helloDaeyeo.dto.rental.RentalObjectDto;
import com.daeyeo.helloDaeyeo.dto.rental.RentalRegisterDto;
import com.daeyeo.helloDaeyeo.dto.rental.RentalStatusDto;
import com.daeyeo.helloDaeyeo.dto.rental.SearchSpecDto;
import com.daeyeo.helloDaeyeo.entity.Member;
import com.daeyeo.helloDaeyeo.entity.RentalObject;
import com.daeyeo.helloDaeyeo.entity.SubCategory;
import com.daeyeo.helloDaeyeo.exception.NotFoundRentalObjectException;
import com.daeyeo.helloDaeyeo.mapper.MemberMapper;
import com.daeyeo.helloDaeyeo.mapper.RentalObjectMapper;
import com.daeyeo.helloDaeyeo.mapper.SubCategoryMapper;
import com.daeyeo.helloDaeyeo.repository.MemberRepository;
import com.daeyeo.helloDaeyeo.repository.RentalObjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
//@Transactional(readOnly = true)
public class RentalObjectService {
    private final RentalObjectRepository rentalObjectRepository;
    private final MemberRepository memberRepository;

    private final MemberService memberService;
    private final SubCategoryService subCategoryService;

    private final RentalObjectMapper rentalObjectMapper;
    private final MemberMapper memberMapper;
    private final SubCategoryMapper subCategoryMapper;

    //    @Transactional
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
                .orElseThrow(() -> new NotFoundRentalObjectException("삭제하려고 하시는 대여 장소가 없습니다"));
    }

    public RentalObjectDto getRentalObject(long objectIndex) {
        RentalObject rentalObject = rentalObjectRepository.findById(objectIndex)
                .orElseThrow(() -> new NotFoundRentalObjectException("해당 게시글을 찾을 수 없습니다."));

        return rentalObjectMapper.toDto(rentalObject);
    }

    public List<RentalObjectDto> getRentalObjects(List<RentalStatusDto> rentalStatusDtos) {
        List<RentalObjectDto> rentalObjectDtos = new ArrayList<>();

        for (RentalStatusDto rentalStatusDto : rentalStatusDtos)
            rentalObjectDtos.add(getRentalObject(rentalStatusDto.getObjectIndex()));

        return rentalObjectDtos;
    }

    public RentalObject getOneRentalObject(long objectIndex) {
        RentalObject rentalObject = rentalObjectRepository.findById(objectIndex)
                .orElseThrow(() -> new NotFoundRentalObjectException("해당 게시글을 찾을 수 없습니다."));
        return rentalObject;
    }


    public Page<RentalObjectDto> findListBySearchSpec(SearchSpecDto dto, Pageable pageable) {
        List<RentalObject> rentalObjects = rentalObjectRepository.findRentalObjectsByDto(dto);
        Page<RentalObject> pagedRentalObjects = rentalObjectRepository.findRentalObjectsByPage(pageable, rentalObjects);

        return pagedRentalObjects.map(rentalObjectMapper::toDto);
    }

    public List<RentalObject> findAll() {
        List<RentalObject> rentalObjectList = rentalObjectRepository.findAll();
        return rentalObjectList;
    }

    @Transactional
    public List<RentalObject> findAllMyRental(String memberId) {
        List<RentalObject> rentalObjectList = rentalObjectRepository.findAll();
        List<RentalObject> myRentalObjectList = new ArrayList<>();
        for (RentalObject rentalObject : rentalObjectList) {
            if (rentalObject.getMember().getUserEmail().equals(memberId)) {
                myRentalObjectList.add(rentalObject);
            }
        }
        return myRentalObjectList;
    }

    public List<RentalObjectManageDto> rentalObjectManagePage(List<RentalObject> rentalObjectList) {
        List<RentalObjectManageDto> rentalObjectManageDtoList = new ArrayList<>();
        // 걸러진 리스트들을 받아옴
        for (RentalObject rentalObject : rentalObjectList) {
            RentalObjectManageDto rentalObjectManageDto = new RentalObjectManageDto(rentalObject);
            // 얼마 벌었는지
            rentalObjectManageDtoList.add(rentalObjectManageDto);
        }
        return rentalObjectManageDtoList;
    }
}
