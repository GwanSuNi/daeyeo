package com.daeyeo.persistence;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CustomUseInfoRepositoryImpl implements CustomUseInfoRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public int countUseInfos() {
        Long count = (Long) entityManager
                .createQuery("select count(infoId) from UseInfo i")
                .setMaxResults(1)
                .getSingleResult();
        return count.intValue();
    }
}
