package com.daeyeo.persistence;

import com.daeyeo.entity.RentalObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RentalObjectRepository extends JpaRepository<RentalObject,Integer> {
    Optional<RentalObject> findByObjectIndex(int objectIndex);
}
