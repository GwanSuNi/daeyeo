package com.daeyeo.persistence;

import com.daeyeo.entity.UseInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UseInfoRepository extends JpaRepository<UseInfo, Integer>, CustomUseInfoRepository {
    UseInfo findByInfoId(int infoId);
}
