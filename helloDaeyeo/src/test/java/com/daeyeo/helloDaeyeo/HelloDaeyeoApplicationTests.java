package com.daeyeo.helloDaeyeo;

import com.daeyeo.helloDaeyeo.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloDaeyeoApplicationTests {
	@Autowired
	MemberService memberService;
	@Test
	void 유저데이터테스트() {
	}

}
