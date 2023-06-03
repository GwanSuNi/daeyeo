package com.daeyeo.service;

import com.daeyeo.entity.MainCategory;
import com.daeyeo.entity.SubCategory;
import com.daeyeo.persistence.MainCategoryRepository;
import com.daeyeo.persistence.SubCategoryRepository;
import org.jboss.jandex.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("mainCategoryService")
@Transactional
public class MainCategoryService {
    @Autowired
    private MainCategoryRepository mainCategoryRepository;
    @Autowired
    private SubCategoryRepository subCategoryRepository;

    public void insertMainCategory(MainCategory mainCategory) {
        mainCategoryRepository.save(mainCategory);
    }

    public void insertSubCategory(SubCategory subCategory) {
        subCategoryRepository.save(subCategory);
        System.out.println("service : " + subCategory);
    }

    public MainCategory findMainCategoryByMcID(String mcId){
        Optional<MainCategory> mainCategory = mainCategoryRepository.findByMcId(mcId);
        return mainCategory.orElse(null);
    }
    public Optional<MainCategory> getCategory(String mcId) {
        return mainCategoryRepository.findById(mcId);
    }

    public List<MainCategory> getAllCategories() {
        return mainCategoryRepository.findAll();
    }

    public void flushData() {
        mainCategoryRepository.flush();
    };

}
