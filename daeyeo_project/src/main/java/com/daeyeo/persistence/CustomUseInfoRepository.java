package com.daeyeo.persistence;

import org.springframework.stereotype.Repository;

@Repository
public interface CustomUseInfoRepository {
    int countUseInfos();
}