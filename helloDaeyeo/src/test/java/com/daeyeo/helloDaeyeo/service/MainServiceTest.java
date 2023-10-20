package com.daeyeo.helloDaeyeo.service;

import com.daeyeo.helloDaeyeo.dto.*;
import com.daeyeo.helloDaeyeo.dto.PeriodDto.ApplicationPeriodDto;
import com.daeyeo.helloDaeyeo.dto.PeriodDto.UsagePeriodDto;
import com.daeyeo.helloDaeyeo.dto.category.SubCategoryDto;
import com.daeyeo.helloDaeyeo.dto.memberDto.AdminMemberDto;
import com.daeyeo.helloDaeyeo.dto.memberRegistDto.MemberRegisterDto;
import com.daeyeo.helloDaeyeo.dto.rental.*;
import com.daeyeo.helloDaeyeo.embedded.Address;
import com.daeyeo.helloDaeyeo.embedded.ApplicationPeriod;
import com.daeyeo.helloDaeyeo.embedded.Phone;
import com.daeyeo.helloDaeyeo.embedded.UsagePeriod;
import com.daeyeo.helloDaeyeo.entity.Member;
import com.daeyeo.helloDaeyeo.entity.RentalObject;
import com.daeyeo.helloDaeyeo.repository.CustomRentalObjectRepositoryImpl;
import com.daeyeo.helloDaeyeo.repository.MemberRepository;
import org.junit.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    @Autowired
    CustomRentalObjectRepositoryImpl customRentalObjectRepository;

    private static final Logger logger = LoggerFactory.getLogger(RentalObjectServiceTest.class);


    @Test
    public void testMain() {
    }

    @Test
    @Transactional
    public void updateMain() {
        mainCategoryService.insertMain("공간시설");
        mainCategoryService.insertMain("체육시설");
        subCategoryService.insertSub("공간시설", "강의실");
        subCategoryService.insertSub("공간시설", "도서관");
        subCategoryService.insertSub("공간시설", "회의실");
        subCategoryService.insertSub("공간시설", "강당");
        subCategoryService.insertSub("체육시설", "운동장");
        subCategoryService.insertSub("체육시설", "체육관");
        subCategoryService.insertSub("체육시설", "수영장");
        List<SubCategoryDto> subCategoryList = subCategoryService.getSubCategories("공간시설");
        System.out.println("아시발");
        System.out.println(subCategoryList.get(0).getScId()+"아시발");
        System.out.println(subCategoryList.get(1).getScId());
        System.out.println(subCategoryList.get(2).getScId());
        System.out.println(subCategoryList.get(3).getScId());


        Address address1 = new Address("나주소입니다", "01610", "나계동", "detailAddress","나도","나군구");
        Address address2 = new Address("다주소입니다", "01610", "다계동", "detailAddress","다도","다군구");
        Address address3 = new Address("라주소입니다", "01610", "라계동", "detailAddress","라도","라군구");
        Address address4 = new Address("마주소입니다", "01610", "마계동", "detailAddress","마도","마군구");
        Address address5 = new Address("바주소입니다", "01610", "바계동", "detailAddress","바도","바군구");
        Address address6 = new Address("사주소입니다", "01610", "사계동", "detailAddress","사도","사군구");
        Address address7 = new Address("아주소입니다", "01610", "아계동", "detailAddress","아도","아군구");
        Address address8 = new Address("자주소입니다", "01610", "자계동", "detailAddress","자도","자군구");
        Address address9 = new Address("차주소입니다", "01610", "차계동", "detailAddress","차도","차군구");
        Address address10 = new Address("파주소입니다", "01610", "파계동", "detailAddress","파도","파군구");

        Address address = new Address("서울노원구동일로237바길17","01610","(상계동)","802호","서울","노원구");


        Member member = new Member();
        member.setUserEmail("test@test.com");
        member.setUserPw("1111");
        member.setUserName("서상현");
        member.setPhone("010-9948-1901");
        member.setDepartment("부서");
        member.setMemberAddress(address);
        memberRepository.save(member);


        ApplicationPeriodDto applicationPeriodDto = new ApplicationPeriodDto("2023-10-01","2023-10-31");
        UsagePeriodDto usagePeriodDto = new UsagePeriodDto("2023-10-01","2023-10-31","09:00","22:00");
        RentalRegisterFormDto rentalRegisterFormDto = new RentalRegisterFormDto("강의실","테스트아이디","오브젝트네임테스트",
                address,1000,applicationPeriodDto,usagePeriodDto,1,1,"웹사이트테스트","01099481901");
        RentalRegisterDto rentalRegisterDto = new RentalRegisterDto(rentalRegisterFormDto);
        rentalRegisterDto.setUserId("test@test.com");
        rentalRegisterFormDto.castLocalDate(rentalRegisterDto);
        rentalObjectService.insertRentalObject(rentalRegisterDto);

        RentalRegisterDto rentalRegisterDto11 = new RentalRegisterDto("강의실", "test@test.com", "testObjectName강의실1", address1);
        RentalRegisterDto rentalRegisterDto1 = new RentalRegisterDto("도서관", "test@test.com", "testObjectName도서관", address2);
        RentalRegisterDto rentalRegisterDto2 = new RentalRegisterDto("회의실", "test@test.com", "testObjectName회의실", address3);
        RentalRegisterDto rentalRegisterDto3 = new RentalRegisterDto("강당", "test@test.com", "testObjectName강당", address4);
        RentalRegisterDto rentalRegisterDto4 = new RentalRegisterDto("운동장", "test@test.com", "testObjectName운동장", address5);
        RentalRegisterDto rentalRegisterDto5 = new RentalRegisterDto("체육관", "test@test.com", "testObjectName체육관", address6);
        RentalRegisterDto rentalRegisterDto6 = new RentalRegisterDto("수영장", "test@test.com", "testObjectName수영장", address7);

        rentalObjectService.insertRentalObject(rentalRegisterDto);
        rentalObjectService.insertRentalObject(rentalRegisterDto1);
        rentalObjectService.insertRentalObject(rentalRegisterDto2);
        rentalObjectService.insertRentalObject(rentalRegisterDto3);
        rentalObjectService.insertRentalObject(rentalRegisterDto4);
        rentalObjectService.insertRentalObject(rentalRegisterDto5);
        rentalObjectService.insertRentalObject(rentalRegisterDto6);
        rentalObjectService.insertRentalObject(rentalRegisterDto11);

        SearchSpecDto specDto = new SearchSpecDto();
        specDto.setMainCategory("공간시설");
        specDto.setSubCategory("강의실");
//        specDto.setSido("address");
        specDto.setSearchWord("강의실");
//        specDto.setSort("addressName");

        Pageable pageable = null;

        Page<RentalObjectDto> rentalObjectDtos = rentalObjectService.findListBySearchSpec(specDto, pageable);
        System.out.println(rentalObjectDtos);
        System.out.println("chapter1");
        for (RentalObjectDto rentalObjectDto : rentalObjectDtos.getContent()) {
            System.out.println(rentalObjectDto.getObjectName()+"결과값이야");
        }
    }
//    @Test
//    public void makeTest(){
//    }
    /*
>>>>>>> feat/rental
    @Test
    public void makeMember() {
        mainCategoryService.insertMain("메인테스트");



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

     */
}