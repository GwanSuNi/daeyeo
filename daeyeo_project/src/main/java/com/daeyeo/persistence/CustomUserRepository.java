package com.daeyeo.persistence;

import com.daeyeo.entity.UserEntity;

public interface CustomUserRepository {
    UserEntity customFindMethod(String email);

    int memoCountByEmail(String email);

    int lastBanLogByEmail(String email);
}
