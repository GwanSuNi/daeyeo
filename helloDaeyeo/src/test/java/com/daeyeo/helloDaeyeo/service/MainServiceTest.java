package com.daeyeo.helloDaeyeo.service;

import com.daeyeo.helloDaeyeo.dto.*;
import com.daeyeo.helloDaeyeo.dto.memberDto.AdminMemberDto;
import com.daeyeo.helloDaeyeo.dto.memberRegistDto.MemberRegisterDto;
import com.daeyeo.helloDaeyeo.embedded.Address;
import com.daeyeo.helloDaeyeo.entity.Member;
import com.daeyeo.helloDaeyeo.repository.MemberRepository;
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
import java.util.List;

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
    MemberRepository memberRepository;
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
    public void makeTest(){
        Address address = new Address("address","01610","상계동","detailAddress");
        Member member = new Member();
        member.setUserEmail("test@test.com");
        member.setUserPw("1111");
        member.setUserName("서상현");
        member.setPhone("010-9948-1901");
        member.setDepartment("부서");
        member.setMemberAddress(address);
        memberRepository.save(member);
    }
    @Test
    public void makeMember() {
        mainCategoryService.insertMain("메인테스트");
        subCategoryService.insertSub("메인테스트", "서브테스트");



//        MemberRegisterDto memberRegisterDto = new MemberRegisterDto("testName","testEmail","testPw",address,"","testDepartment");
//        memberService.insertMember(memberRegisterDto);

        RentalObjectDto rentalObjectDto = new RentalObjectDto("testRentalName" , 1234, 3);
        rentalObjectService.insertRental(rentalObjectDto, "testEmail" , "서브테스트");
        ReviewDto reviewDto = new ReviewDto(LocalDateTime.now(),"test");
        reviewService.insertReview(reviewDto,"testEmail",1);
        List<Member> memberList = memberService.findAll();
        List<AdminMemberDto> adminMemberDtos = memberService.adminMemberPage(memberList);
        System.out.println(adminMemberDtos.get(0).getReviewCount());
//        List<Member> reviewCount = memberService.reviewCount();
//        System.out.println(memberList.get(0).getReviews().size()+"=================================");
//        System.out.println(reviewCount.get(0)+"*****************************");
//        RentalObjectDto rentalObjectDto = new RentalObjectDto("testRentalName", 1234, 1234);
//        rentalObjectService.insertRental(rentalObjectDto, "testEmail", "서브테스트");
    }

    @Test
    public void rentalTest() {
        mainCategoryService.insertMain("메인테스트");
        subCategoryService.insertSub("메인테스트", "서브테스트");
        for (int i = 0; i < 10; i++) {
//            MemberDto memberDto = new MemberDto("testId" + i, "test" + i, "testEmail" + i, "testName" + i);
//            memberService.insertMember(memberDto);
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
//                rentalLogService.insertRentalLog(rentalLogDto, i + 1, "testId" + i);
            }
        }
        List<Member> entities = memberService.findAll();
        for (Member entity : entities) {
            System.out.println(entity.getRentalObjects().toString()
                                +entity.getUserName().toString());
        }

    }
}
