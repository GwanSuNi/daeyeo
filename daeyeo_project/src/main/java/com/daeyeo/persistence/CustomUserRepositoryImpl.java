package com.daeyeo.persistence;

import com.daeyeo.entity.UserEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class CustomUserRepositoryImpl implements CustomUserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public UserEntity customFindMethod(String email) {
        return (UserEntity) entityManager
                .createQuery("From UserEntity u where u.userEmail = :email")
                .setParameter("email", email)
                .getSingleResult();
    }

    @Override
    public int memoCountByEmail(String email) {
        Long count = entityManager
                .createQuery("select count(userMemo.size) From UserEntity u where u.userEmail = :email", Long.class)
                .setParameter("email", email)
                .getSingleResult();
        return count.intValue();
    }
}
