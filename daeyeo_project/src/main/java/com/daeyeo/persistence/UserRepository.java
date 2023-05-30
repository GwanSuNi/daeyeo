package com.daeyeo.persistence;

import com.daeyeo.entity.UserEntity;
import com.daeyeo.entity.UserMemo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, String> {
    List<UserEntity> findByUserName(String name);

    Optional<UserEntity> findByUserEmail(String email);

    void flush();

//    @Modifying
//    @Query("update UserEntity set userMemo = new(:content, :memoDate) where userEmail = :email")
//    int updateUserEntity(@Param("email") String email, @Param("content") String content, @Param("memoDate") LocalDate memoDate);

}
