package com.daeyeo.helloDaeyeo.repository;

import com.daeyeo.helloDaeyeo.dto.rental.SearchSpecDto;
import com.daeyeo.helloDaeyeo.entity.RentalObject;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomRentalObjectRepository {
    List<RentalObject> findRentalObjectsByDto(SearchSpecDto dto);
}
