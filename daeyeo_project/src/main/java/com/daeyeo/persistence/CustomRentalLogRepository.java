package com.daeyeo.persistence;

import com.daeyeo.entity.RentalLog;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomRentalLogRepository {
    List<RentalLog> customFindRentalLogByEmail(String email);
}
