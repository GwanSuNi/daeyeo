package com.daeyeo.helloDaeyeo.Repository;

import com.daeyeo.helloDaeyeo.Entity.RentalObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalObjectRepository extends JpaRepository<RentalObject,Integer> {
}
