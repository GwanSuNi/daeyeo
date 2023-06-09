package com.daeyeo.service;

import com.daeyeo.entity.MainCategory;
import com.daeyeo.entity.SubCategory;
import com.daeyeo.persistence.MainCategoryRepository;
import com.daeyeo.persistence.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service("subCategoryService")
public class SubCategoryService {
    @Autowired
    private MainCategoryRepository mainCategoryRepository;
    @Autowired
    private SubCategoryRepository subCategoryRepository;

    public SubCategory findSubCategoryByScID(String scId){
        Optional<SubCategory> subCategory = subCategoryRepository.findByScId(scId);
        return subCategory.orElse(null);
    }

    /**
     * 메인 카테고리에 속하는 서브 카테고리들을 가져오는 메서드
     * @param mcId String 타입의 메인 카테고리(대분류)
     * @return mainCategory의 값이 없으면 null을 반환하고, 값이 있으면 findByMainCategory를 호출해 카테고리 값들을 가져와 반환
     */
    public List<SubCategory> findByMcId(String mcId) {
        Optional<MainCategory> mainCategory = mainCategoryRepository.findByMcId(mcId);
        return mainCategory.map(category -> subCategoryRepository.findByMainCategory(category)).orElse(null);
    }
}
