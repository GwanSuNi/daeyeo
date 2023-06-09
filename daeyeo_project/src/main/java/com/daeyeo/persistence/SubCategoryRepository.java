package com.daeyeo.persistence;

import com.daeyeo.entity.MainCategory;
import com.daeyeo.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, String> {
    Optional<SubCategory> findByScId(String scId);
    List<SubCategory> findByMainCategory(MainCategory mainCategory);
}
