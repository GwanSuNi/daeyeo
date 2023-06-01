package com.daeyeo.persistence;

import com.daeyeo.entity.RentalLog;
import com.daeyeo.entity.UserEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class CustomRentalLogRepositoryImpl implements CustomRentalLogRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<RentalLog> customFindRentalLogByEmail(String email){
        return entityManager
                .createQuery("Select l, u From RentalLog l left join l.userEntity u where u.userEmail = :email", RentalLog.class) // 쿼리문 문제인듯??
                .setParameter("email", email)
                .getResultList();
    }

}
