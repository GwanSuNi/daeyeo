package com.daeyeo.helloDaeyeo.Service;

import com.daeyeo.helloDaeyeo.Dto.RentalLogDto;
import com.daeyeo.helloDaeyeo.Entity.Member;
import com.daeyeo.helloDaeyeo.Entity.RentalLog;
import com.daeyeo.helloDaeyeo.Entity.RentalObject;
import com.daeyeo.helloDaeyeo.Repository.MemberRepository;
import com.daeyeo.helloDaeyeo.Repository.RentalLogRepository;
import com.daeyeo.helloDaeyeo.Repository.RentalObjectRepository;
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

    public void insertRentalLog(RentalLogDto rentalLogDto, int rentalId , String userId){
        Optional<RentalObject> rentalObject = rentalObjectRepository.findById(rentalId);
        Optional<Member> member = memberRepository.findById(userId);
        RentalLog rentalLog = new RentalLog(rentalLogDto);
        rentalLog.setRentalObject(rentalObject.get());
        rentalLog.setMember(member.get());
        rentalLogRepository.save(rentalLog);
    }


}
