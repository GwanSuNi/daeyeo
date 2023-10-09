package com.daeyeo.helloDaeyeo.repository;

import com.daeyeo.helloDaeyeo.entity.RentalObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalObjectRepository extends JpaRepository<RentalObject, Integer>, CustomRentalObjectRepository {
}
