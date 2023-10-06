package com.daeyeo.helloDaeyeo.repository;

import com.daeyeo.helloDaeyeo.entity.MainCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainCategoryRepository extends JpaRepository<MainCategory,String> {

}
