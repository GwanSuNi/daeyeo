package com.daeyeo.persistence;

import com.daeyeo.command.RentalListCmd;
import com.daeyeo.entity.RentalObject;
import com.daeyeo.entity.SubCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomRentalObjectRepository {
    List<RentalObject> findRentalObjectByCommand(RentalListCmd rentalListCmd);
}
