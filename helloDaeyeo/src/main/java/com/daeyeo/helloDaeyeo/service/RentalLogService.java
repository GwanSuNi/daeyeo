package com.daeyeo.helloDaeyeo.service;

import com.daeyeo.helloDaeyeo.dto.RentalLogDto;
import com.daeyeo.helloDaeyeo.entity.Member;
import com.daeyeo.helloDaeyeo.entity.RentalLog;
import com.daeyeo.helloDaeyeo.entity.RentalObject;
import com.daeyeo.helloDaeyeo.repository.MemberRepository;
import com.daeyeo.helloDaeyeo.repository.RentalLogRepository;
import com.daeyeo.helloDaeyeo.repository.RentalObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class RentalLogService {
    @Autowired
    RentalObjectRepository rentalObjectRepository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    RentalLogRepository rentalLogRepository;

    /***
     *
     * @param rentalLogDto dto로 받아서 넘기기 (매개변수가 너무 많음)
     * @param rentalId
     * @param userId
     */

    /*
    public void insertRentalLog(RentalLogDto rentalLogDto, long rentalId , String userId){
        Optional<RentalObject> rentalObject = rentalObjectRepository.findById(rentalId);
        Optional<Member> member = memberRepository.findById(userId);
        RentalLog rentalLog = new RentalLog(rentalLogDto);
        rentalLog.setRentalObject(rentalObject.get());
        rentalLog.setMember(member.get());
        rentalLogRepository.save(rentalLog);
    }
     */
}
