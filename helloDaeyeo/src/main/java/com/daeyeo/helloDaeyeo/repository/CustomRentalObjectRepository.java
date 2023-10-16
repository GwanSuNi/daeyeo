package com.daeyeo.helloDaeyeo.repository;

import com.daeyeo.helloDaeyeo.dto.rental.SearchSpecDto;
import com.daeyeo.helloDaeyeo.entity.RentalObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomRentalObjectRepository {
    List<RentalObject> findRentalObjectsByDto(SearchSpecDto dto);
    Page<RentalObject> findRentalObjectsByPage(Pageable pageable , List<RentalObject> query);
}
