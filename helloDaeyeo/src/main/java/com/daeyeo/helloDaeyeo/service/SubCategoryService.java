package com.daeyeo.helloDaeyeo.service;

import com.daeyeo.helloDaeyeo.dto.category.MainCategoryDto;
import com.daeyeo.helloDaeyeo.dto.category.SubCategoryDto;
import com.daeyeo.helloDaeyeo.dto.rental.SearchSpecDto;
import com.daeyeo.helloDaeyeo.entity.MainCategory;
import com.daeyeo.helloDaeyeo.entity.SubCategory;
import com.daeyeo.helloDaeyeo.exception.NotFoundSubCategoryException;
import com.daeyeo.helloDaeyeo.exception.SubAlreadyExistsException;
import com.daeyeo.helloDaeyeo.mapper.SubCategoryMapper;
import com.daeyeo.helloDaeyeo.repository.MainCategoryRepository;
import com.daeyeo.helloDaeyeo.repository.SubCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SubCategoryService {
    private final MainCategoryRepository mainCategoryRepository;
    private final SubCategoryRepository subCategoryRepository;
    private final MainCategoryService mainCategoryService;
    private final SubCategoryMapper mapper;

    @Transactional
    public void insertSub(String mainId, String scId) {
        Optional<MainCategory> mainCategory = mainCategoryRepository.findById(mainId);
        Optional<SubCategory> subCategory = subCategoryRepository.findById(scId);
        if (subCategory.isPresent()) {
            throw new SubAlreadyExistsException("이미 존재하는 서브카테고리 입니다.");
        } else {
            SubCategory newSubCategory = new SubCategory(scId, mainCategory.get());
            subCategoryRepository.save(newSubCategory);
        }

    }

    public SubCategoryDto getSubCategory(String scId) {
        SubCategory subCategory = subCategoryRepository.findById(scId)
                .orElseThrow(() -> new NotFoundSubCategoryException("존재하지 않는 하위 카테고리입니다."));

        return mapper.toDto(subCategory);
    }

    public List<SubCategoryDto> getSubCategories(String mcId) {
        List<SubCategory> subCategories = subCategoryRepository.findByMainCategory_McId(mcId);

        if (subCategories.isEmpty())
            throw new NotFoundSubCategoryException("하위 카테고리를 찾을 수 없습니다.");

        return mapper.toDtoList(subCategories);
    }

    public List<String> getCategories(SearchSpecDto specDto) {
        if (specDto.getMainCategory() == null || specDto.getMainCategory().isBlank())
            return mainCategoryService.getAllCategories().stream().map(MainCategoryDto::getMcId).collect(Collectors.toList());
        else
            return getSubCategories(specDto.getMainCategory()).stream().map(SubCategoryDto::getScId).collect(Collectors.toList());
    }
}
