package com.daeyeo.persistence;

import com.daeyeo.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubCategoryRepository extends JpaRepository<SubCategory, String> {
    Optional<SubCategory> findByScId(String scId);

}
