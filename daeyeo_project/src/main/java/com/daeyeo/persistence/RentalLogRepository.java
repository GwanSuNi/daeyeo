package com.daeyeo.persistence;

import com.daeyeo.entity.RentalLog;
import com.daeyeo.entity.RentalObject;
import com.daeyeo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RentalLogRepository extends JpaRepository<RentalLog, Integer>, CustomRentalLogRepository {
    Optional<RentalLog> findByRentalIdAndUserEntityAndRentalObject(int rentalId,UserEntity userEntity , RentalObject rentalObject);
    Optional<RentalLog> findByRentalId(int rentalId);

}
