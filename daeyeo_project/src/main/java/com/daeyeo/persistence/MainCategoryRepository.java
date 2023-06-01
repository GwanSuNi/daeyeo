package com.daeyeo.persistence;

import com.daeyeo.entity.MainCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.validation.ObjectError;

import java.util.Optional;

public interface MainCategoryRepository  extends JpaRepository<MainCategory, String> {
//    void insertCategory(MainCategory mainCategory);
}
