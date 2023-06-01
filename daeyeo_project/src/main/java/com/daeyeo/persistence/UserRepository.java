package com.daeyeo.persistence;

import com.daeyeo.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, String>, CustomUserRepository {
    List<UserEntity> findByUserName(String name);

    Optional<UserEntity> findByUserEmail(String email);

    void flush();

//    @Modifying
//    @Query("update UserEntity set userMemo = new(:content, :memoDate) where userEmail = :email")
//    int updateUserEntity(@Param("email") String email, @Param("content") String content, @Param("memoDate") LocalDate memoDate);

}
