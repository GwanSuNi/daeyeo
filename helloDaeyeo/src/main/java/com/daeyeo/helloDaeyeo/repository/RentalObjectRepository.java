package com.daeyeo.helloDaeyeo.repository;

import com.daeyeo.helloDaeyeo.entity.RentalObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalObjectRepository extends JpaRepository<RentalObject, Long>, CustomRentalObjectRepository {
    //    List<RentalObject> findRentalObjectsByDto(SearchSpecDto dto);
    List<RentalObject> findAll();
}
