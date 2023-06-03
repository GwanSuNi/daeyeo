package com.daeyeo.persistence;

import com.daeyeo.entity.BanLog;
import com.daeyeo.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface CustomUserRepository {
    UserEntity customFindMethod(String email);

    int memoCountByEmail(String email);

    BanLog getLastBanLogByEmail(String email);
}
