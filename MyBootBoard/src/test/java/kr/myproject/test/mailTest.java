package kr.myproject.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.myprojcet.mail.service.MailService;
import kr.myproject.mail.domain.MailDTO;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class mailTest {

	@Autowired
	private MailService mailService;

//	@Test
	void sendSimpleMailTest() {
		mailService.sendSimpleMail(new MailDTO("han1459@cu.ac.kr", "안녕하세요", "내용"));
		log.info("텍스트 메일 발송됨 !!!");
	}

}
