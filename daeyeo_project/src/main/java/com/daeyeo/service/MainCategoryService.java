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

@Service("categoryService")
@Transactional
public class MainCategoryService {
    @Autowired
    MainCategoryRepository mainCategoryRepository;
    @Autowired
    SubCategoryRepository subCategoryRepository;

    public void insertMainCategory(MainCategory mainCategory) {
        mainCategoryRepository.save(mainCategory);
    }

    public void insertSubCategory(SubCategory subCategory) {
        subCategoryRepository.save(subCategory);
        System.out.println("service : " + subCategory);
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