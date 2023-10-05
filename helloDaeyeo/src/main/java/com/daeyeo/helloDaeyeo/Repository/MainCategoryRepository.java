package com.daeyeo.helloDaeyeo.Repository;

import com.daeyeo.helloDaeyeo.Entity.MainCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainCategoryRepository extends JpaRepository<MainCategory,String> {

}
