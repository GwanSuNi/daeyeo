package com.daeyeo.helloDaeyeo.repository;

import com.daeyeo.helloDaeyeo.entity.RentalStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomRentalStatusRepository {
    List<RentalStatus> statusSort(List<RentalStatus> rentalStatuses);

    List<RentalStatus> statusSortPending(List<RentalStatus> rentalStatuses);
}
