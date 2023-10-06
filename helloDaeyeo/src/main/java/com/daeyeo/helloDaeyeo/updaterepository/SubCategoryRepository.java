package com.daeyeo.helloDaeyeo.updaterepository;

import com.daeyeo.helloDaeyeo.updateentity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory,String> {
}
