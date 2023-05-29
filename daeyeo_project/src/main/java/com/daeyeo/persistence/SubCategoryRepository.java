package com.daeyeo.persistence;

import com.daeyeo.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubCategoryRepository extends JpaRepository<SubCategory, String> {
}
