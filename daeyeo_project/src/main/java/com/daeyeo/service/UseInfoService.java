package com.daeyeo.service;

import com.daeyeo.entity.UseInfo;
import com.daeyeo.persistence.CustomUseInfoRepository;
import com.daeyeo.persistence.UseInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UseInfoService {
    @Autowired
    UseInfoRepository useInfoRepository;

    public void insertUseInfo(String question, String answer) {
        UseInfo useInfo = new UseInfo();
        useInfo.setQuestion(question);
        useInfo.setAnswer(answer);
        useInfoRepository.save(useInfo);
    }

    public List<UseInfo> getAllUseInfos() {
        return useInfoRepository.findAll();
    }

    public UseInfo getUseInfo(int id) {
        return useInfoRepository.findByInfoId(id);
    }

    public void deleteUseInfo(int id) {
        useInfoRepository.delete(useInfoRepository.findByInfoId(id));
    }

    public int countUseInfos() {
        return useInfoRepository.countUseInfos();
    }
}
