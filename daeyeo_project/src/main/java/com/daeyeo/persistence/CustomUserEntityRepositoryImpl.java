package com.daeyeo.persistence;

import com.daeyeo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CustomUserEntityRepositoryImpl implements CustomUserEntityRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public int userPaysum() {
        return 0;
    }

    @Override
    public void getOldestRegistDate(){
//        String minDateQuery = "SELECT min(u.registDate) FROM UserEntity u";
//        // Date minRegistDate = (Date) entityManager.createQuery(minDateQuery).getSingleResult();
//         return minDateQuery;
//        String minDateQuery = "SELECT min(u.registDate) FROM UserEntity u";
//        Date minRegistDate = (Date) entityManager.createQuery(minDateQuery).getSingleResult();
    }
//        List<Date> dateList = new ArrayList<>();
//
//        Calendar start = Calendar.getInstance();
//        start.setTime(minRegistDate);
//        Calendar end = Calendar.getInstance();
//
//        while (!start.after(end)) {
//            dateList.add(start.getTime());
//            start.add(Calendar.DATE, 1);
//        }


}
