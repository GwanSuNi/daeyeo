package com.daeyeo.helloDaeyeo.repository;

import com.daeyeo.helloDaeyeo.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory,String> {
}
