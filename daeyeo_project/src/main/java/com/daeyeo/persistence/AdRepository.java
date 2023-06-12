package com.daeyeo.persistence;

import com.daeyeo.entity.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdRepository extends JpaRepository<Advertisement,Integer> {
    
}
