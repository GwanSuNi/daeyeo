package com.daeyeo.helloDaeyeo.service;

import com.daeyeo.helloDaeyeo.entity.RentalLog;
import com.daeyeo.helloDaeyeo.entity.RentalStatus;
import com.daeyeo.helloDaeyeo.repository.MemberRepository;
import com.daeyeo.helloDaeyeo.repository.RentalLogRepository;
import com.daeyeo.helloDaeyeo.repository.RentalObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
public class RentalLogService {
    @Autowired
    RentalObjectRepository rentalObjectRepository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    RentalLogRepository rentalLogRepository;

    public void insertRentalLog(RentalStatus rentalStatus) {
        RentalLog rentalLog = new RentalLog();
        rentalLog.setRentalStatus(rentalStatus);
        rentalLog.setStatus(rentalStatus.getStatus());
        rentalLog.setAddress(rentalStatus.getRentalObject().getAddress().getAddress());
        rentalLog.setTimeStamp(LocalDateTime.now());
        rentalLogRepository.save(rentalLog);
    }
}
