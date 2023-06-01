package com.daeyeo.service;

import com.daeyeo.entity.RentalObject;
import com.daeyeo.entity.SubCategory;
import com.daeyeo.entity.UserEntity;
import com.daeyeo.persistence.RentalObjectRepository;
import com.daeyeo.persistence.SubCategoryRepository;
import com.daeyeo.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service("rentalObjectService")
public class RentalObjectService {
    @Autowired
    SubCategoryRepository subCategoryRepository;
    @Autowired
    RentalObjectRepository rentalObjectRepository;
    @Autowired
    UserRepository userRepository;

    public SubCategory findSubCategoryByScId(String scId){
        Optional<SubCategory> subCategory = subCategoryRepository.findByScId(scId);
        return subCategory.orElse(null);
    }

    public UserEntity findEntityById(String email) {
        Optional<UserEntity> userEntity = userRepository.findByUserEmail(email);
        return userEntity.orElse(null);
    }
    public void insertRentalObject(RentalObject rentalObject , SubCategory subCategory , UserEntity userEntity){
        userEntity.addRentalObject(rentalObject);
        subCategory.addRentalObject(rentalObject);
        rentalObjectRepository.save(rentalObject);
    }
    public void insertSubCategory(SubCategory subCategory){
        try {
            subCategoryRepository.save(subCategory);
        } catch (Exception e) {
            System.err.println("Error occurred while inserting SubCategory: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public void insertEntityUser(UserEntity userEntity){
        userRepository.save(userEntity);
    }

//    public MainCategory findMainCategoryById(String id){
//        Optional<MainCategory> mainCategory = mainCategoryRepository.findByMcId(id);
//        return mainCategory.orElse(null);
//    }

//    public SubCategory findBySubCategoryById(String scId){
//        Optional<SubCategory> subCategory = subCategoryRepository.findByScId(scId);
//        return subCategory.orElse(null);
//    }
    public void insertRentalObject(RentalObject rentalObject) {

    }

}
