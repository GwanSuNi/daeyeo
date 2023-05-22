package com.daeyeo.persistence;

import com.daeyeo.entity.UserEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MyRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void insertData(UserEntity userEntity) {
        System.out.println("JPA로 insertData() 처리");
        entityManager.persist(userEntity);
    }
    // 다 출력하는거라 매개변수 안줘도 됩니다~
    public List<UserEntity> getDataList(UserEntity userEntity) {
        System.out.println("JPA로 selectData() 처리");
        return entityManager.createQuery("From UserEntity tt order by tt.id desc ").getResultList();
    }
}
