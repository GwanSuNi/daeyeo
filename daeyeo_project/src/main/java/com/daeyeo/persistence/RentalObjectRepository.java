package com.daeyeo.persistence;

import com.daeyeo.entity.RentalObject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalObjectRepository extends JpaRepository<RentalObject,Integer> {


}
