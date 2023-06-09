package com.daeyeo.persistence;

import com.daeyeo.entity.RentalObject;
import com.daeyeo.entity.SubCategory;
import com.daeyeo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RentalObjectRepository extends JpaRepository<RentalObject,Integer>, CustomRentalObjectRepository {
    Optional<RentalObject> findByObjectIndex(int objectIndex);
    List<RentalObject> findByUserEntity(UserEntity userEntity);
    Optional<RentalObject> findByObjectIndexAndSubCategoryAndUserEntity(int objectIndex , SubCategory subCategory, UserEntity user);
    List<RentalObject> findAll();
    @Query("SELECT ro FROM RentalObject ro LEFT JOIN UserEntity u ON ro.userEntity.userEmail = u.userEmail")
    List<RentalObject> findRentalObjectsWithUser();
}
