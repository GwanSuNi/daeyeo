package com.daeyeo.helloDaeyeo.service;

import com.daeyeo.helloDaeyeo.entity.RentalStatus;
import com.daeyeo.helloDaeyeo.entity.Status;
import org.junit.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;


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

    /*
    @Test
    public void rentalTest(){
        RentalObjectDto rentalObjectDto = new RentalObjectDto("testRentalName",1234,1234);
        rentalObjectService.insertRental(rentalObjectDto,"testId","서브테스트");
    }

     */
    @Test
    public void memberTest() {
        RentalStatus rentalStatus = rentalStatusService.findOne(1);
        System.out.println(rentalStatus.getStatus() == Status.PENDING);
    }

}
