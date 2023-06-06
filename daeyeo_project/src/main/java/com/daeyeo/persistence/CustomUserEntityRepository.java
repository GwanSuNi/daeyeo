package com.daeyeo.persistence;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface CustomUserEntityRepository {
    int userPaysum();
    void getOldestRegistDate();
}
