package com.daeyeo.service;

import com.daeyeo.entity.MemberManagement;
import com.daeyeo.persistence.MemberManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("manageService")
@Transactional

public class MemberManagementService {
    @Autowired
    MemberManagementRepository memberManagementRepository;
    public List<MemberManagement> findAll(){
        return  memberManagementRepository.findAll();
    }
}
