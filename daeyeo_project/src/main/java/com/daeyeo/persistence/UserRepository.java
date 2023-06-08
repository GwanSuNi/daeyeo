package com.daeyeo.persistence;

import com.daeyeo.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, String>, CustomUserRepository, CustomUserEntityRepository {
    List<UserEntity> findByUserName(String userName);

    Optional<UserEntity> findByUserEmail(String userEmail);

    @Query("SELECT MIN(u.registDate) FROM UserEntity u")
    Date findByRegistDate();
    @Query("select SUM(u.paySum) FROM UserEntity u")
    int findByPaySum();
    void flush();

    List<UserEntity> findAll();


//    @Modifying
//    @Query("update UserEntity set userMemo = new(:content, :memoDate) where userEmail = :email")
//    int updateUserEntity(@Param("email") String email, @Param("content") String content, @Param("memoDate") LocalDate memoDate);

}
