package com.daeyeo.helloDaeyeo.updaterepository;

import com.daeyeo.helloDaeyeo.updateentity.RentalObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalObjectRepository extends JpaRepository<RentalObject,Integer> {
}
