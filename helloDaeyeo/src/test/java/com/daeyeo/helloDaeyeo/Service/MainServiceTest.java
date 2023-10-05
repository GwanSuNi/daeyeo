package com.daeyeo.helloDaeyeo.Service;

import com.daeyeo.helloDaeyeo.Dto.MemberDto;
import com.daeyeo.helloDaeyeo.Dto.RentalLogDto;
import com.daeyeo.helloDaeyeo.Dto.RentalObjectDto;
import com.daeyeo.helloDaeyeo.Dto.ReviewDto;
import com.daeyeo.helloDaeyeo.Entity.Member;
import com.daeyeo.helloDaeyeo.Repository.MainCategoryRepository;
import com.daeyeo.helloDaeyeo.Repository.MemberRepository;
import org.junit.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
@DirtiesContext
@Rollback(false)
public class MainServiceTest {
    @Autowired
    MainCategoryService mainCategoryService;
    @Autowired
    SubCategoryService subCategoryService;
    @Autowired
    MemberService memberService;
    @Autowired
    RentalObjectService rentalObjectService;
    @Autowired
    RentalLogService rentalLogService;
    @Autowired
    ReviewService reviewService;
    private static final Logger logger = LoggerFactory.getLogger(RentalObjectServiceTest.class);


    @Test
    public void testMain() {
    }

    @Test
    public void updateMain() {
        mainCategoryService.insertMain("업데이트테스트");
        mainCategoryService.updateMain("업데이트테스트", "updateTestSuccess");
    }

    @Test
    public void makeMember() {
        mainCategoryService.insertMain("메인테스트");
        subCategoryService.insertSub("메인테스트", "서브테스트");
        MemberDto memberDto = new MemberDto("testId", "test1234", "testEmail", "testName");
        memberService.insertMember(memberDto);
        RentalObjectDto rentalObjectDto = new RentalObjectDto("testRentalName", 1234, 1234);
        rentalObjectService.insertRental(rentalObjectDto, "testId", "서브테스트");
        RentalLogDto rentalLogDto = new RentalLogDto(1234);
        rentalLogService.insertRentalLog(rentalLogDto, 1, "testId");
        ReviewDto reviewDto = new ReviewDto(LocalDateTime.now(),"reviewTest");
        reviewService.insertReview(reviewDto,"testId",1);
    }

    @Test
    public void rentalTest() {
        mainCategoryService.insertMain("메인테스트");
        subCategoryService.insertSub("메인테스트", "서브테스트");
        for (int i = 0; i < 10; i++) {
            MemberDto memberDto = new MemberDto("testId" + i, "test" + i, "testEmail" + i, "testName" + i);
            memberService.insertMember(memberDto);
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                RentalObjectDto rentalObjectDto = new RentalObjectDto("testRentalName" + j, 1234, i + j);
                rentalObjectService.insertRental(rentalObjectDto, "testId" + i, "서브테스트");
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                RentalLogDto rentalLogDto = new RentalLogDto(1234 + i);
                rentalLogService.insertRentalLog(rentalLogDto, i + 1, "testId" + i);
            }
        }
        List<Member> entities = memberService.findAll();
        for (Member entity : entities) {
            System.out.println(entity.getRentalObjects().toString()
                                +entity.getUserName().toString());
        }

    }
}
