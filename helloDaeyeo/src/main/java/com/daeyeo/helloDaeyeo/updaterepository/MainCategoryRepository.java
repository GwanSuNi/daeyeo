package com.daeyeo.helloDaeyeo.updaterepository;

import com.daeyeo.helloDaeyeo.updateentity.MainCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainCategoryRepository extends JpaRepository<MainCategory,String> {

}
