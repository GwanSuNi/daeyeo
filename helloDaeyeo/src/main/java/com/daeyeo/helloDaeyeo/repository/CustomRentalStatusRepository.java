package com.daeyeo.helloDaeyeo.repository;

import com.daeyeo.helloDaeyeo.entity.RentalStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomRentalStatusRepository {

    List<RentalStatus> statusSortDate(List<RentalStatus> rentalStatuses);

    List<RentalStatus> statusModalSortPending(List<RentalStatus> rentalStatuses);
}
