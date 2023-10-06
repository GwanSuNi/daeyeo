package com.daeyeo.helloDaeyeo.service;

import com.daeyeo.helloDaeyeo.updateentity.MainCategory;
import com.daeyeo.helloDaeyeo.updateentity.SubCategory;
import com.daeyeo.helloDaeyeo.updaterepository.MainCategoryRepository;
import com.daeyeo.helloDaeyeo.updaterepository.SubCategoryRepository;
import com.daeyeo.helloDaeyeo.exception.SubAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class SubCategoryService {
    @Autowired
    MainCategoryRepository mainCategoryRepository;
    @Autowired
    SubCategoryRepository subCategoryRepository;

    /***
     *
     */
    public void insertSub(String mainId, String scId){
        Optional<MainCategory> mainCategory = mainCategoryRepository.findById(mainId);
        Optional<SubCategory> subCategory = subCategoryRepository.findById(scId);
        if(subCategory.isPresent()){
            throw new SubAlreadyExistsException("이미 존재하는 서브카테고리 입니다.");
        }else{
            SubCategory newSubCategory = new SubCategory(scId,mainCategory.get());
            subCategoryRepository.save(newSubCategory);
        }

    }

}
