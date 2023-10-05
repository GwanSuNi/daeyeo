package com.daeyeo.helloDaeyeo.Repository;

import com.daeyeo.helloDaeyeo.Entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory,String> {
}
