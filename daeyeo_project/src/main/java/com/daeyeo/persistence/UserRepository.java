package com.daeyeo.persistence;

import com.daeyeo.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<UserEntity, String> {
    List<UserEntity> findByUserName(String name);

    List<UserEntity> findByUserEmail(String email);

    void flush();
}
