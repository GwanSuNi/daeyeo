package com.daeyeo.helloDaeyeo.service;

import com.daeyeo.helloDaeyeo.dto.myPageDto.ModalStatusPendingDto;
import com.daeyeo.helloDaeyeo.entity.RentalObject;
import com.daeyeo.helloDaeyeo.entity.RentalStatus;
import com.daeyeo.helloDaeyeo.repository.RentalStatusRepository;
import org.junit.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@SpringBootTest
@RunWith(SpringRunner.class)
@Rollback(false)
public class RentalObjectServiceTest {
    private static final Logger logger = LoggerFactory.getLogger(RentalObjectServiceTest.class);

    @Autowired
    MemberService memberService;
    @Autowired
    SubCategoryService subCategoryService;
    @Autowired
    RentalObjectService rentalObjectService;
    @Autowired
    RentalStatusService rentalStatusService;
    @Autowired
    RentalStatusRepository rentalStatusRepository;


    /*
    @Test
    public void rentalTest(){
        RentalObjectDto rentalObjectDto = new RentalObjectDto("testRentalName",1234,1234);
        rentalObjectService.insertRental(rentalObjectDto,"testId","서브테스트");
    }

     */
    @Test
    @Transactional
    public void memberTest() {
        String memberEmail = "test@test.com";
//        List<RentalObject> rentalObjectList = rentalObjectService.findAllMyRental(memberEmail);
//        List<RentalStatus> rentalStatusList = rentalStatusService.beforeUseModal(rentalObjectList);
//        for (RentalStatus rentalStatus : rentalStatusList) {
//            System.out.println(rentalStatus.getStatus() + "====" + rentalStatus.getRentalDate());
//            System.out.println(rentalStatusList.size());
//        }
//        List<RentalStatus> rentalStatusList1 = rentalStatusService.rentalStatusPendingList(rentalStatusList);
//        for (RentalStatus rentalStatus : rentalStatusList1) {
//            System.out.println(rentalStatus.getStatus() + "====" + rentalStatus.getRentalDate());
//            System.out.println(rentalStatusList1.size());
//
//        List<ModalStatusPendingDto> modalStatusPendingDtoList = rentalStatusService.modalStatusPending(rentalStatusList1);
//        for (ModalStatusPendingDto modalStatusPendingDto : modalStatusPendingDtoList) {
//            System.out.println(modalStatusPendingDto.getStatus() + "====" + modalStatusPendingDto.getRentalDate());
//            System.out.println(modalStatusPendingDto.getObjectName() + "====" + modalStatusPendingDto.getNickName());
//            System.out.println(modalStatusPendingDto.getEndTime() + "====" + modalStatusPendingDto.getStartTime());
//        }
        RentalObject rentalObject = rentalObjectService.getOneRentalObject(1);
        List<RentalStatus> rentalStatusList = rentalObject.getRentalStatuses();
        List<ModalStatusPendingDto> result = rentalStatusService.modalStatusPending(rentalStatusList);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i).getRentalDate());
            System.out.println(result.get(i).getStartTime());
            System.out.println(result.get(i).getEndTime());
        }
    }
}

