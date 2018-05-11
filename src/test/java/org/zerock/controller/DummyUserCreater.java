package org.zerock.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.MemberAuthVO;
import org.zerock.domain.MemberVO;
import org.zerock.mapper.MemberMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/security-context.xml" })
@Log4j
public class DummyUserCreater {

	@Autowired
	private PasswordEncoder pwencoder;

	@Autowired
	private MemberMapper mapper;

	@Test
	public void testInsert() {

		for (int i = 0; i < 100; i++) {

			MemberVO vo = new MemberVO();
			vo.setUid("userr" + i);
			vo.setUpw(pwencoder.encode("pw" + i));
			vo.setUname("uname" + i);

			mapper.insert(vo);

			if (i >= 0) {
				MemberAuthVO auth1 = new MemberAuthVO();

				auth1.setUid("userr" + i);
				auth1.setAuth("ROLE_USER");

				mapper.insertAuth(auth1);
			}

			if (i >= 80) {
				MemberAuthVO auth2 = new MemberAuthVO();

				auth2.setUid("userr" + i);
				auth2.setAuth("ROLE_MANAGER");

				mapper.insertAuth(auth2);
			}
			if (i >= 90) {
				MemberAuthVO auth3 = new MemberAuthVO();

				auth3.setUid("userr" + i);
				auth3.setAuth("ROLE_ADMIN");

				mapper.insertAuth(auth3);

			}

		}

	}
	
	@Test
	public void testRead() {
		
		MemberVO vo = mapper.read("userr99");
		
		log.info(vo);
		
		
	}

}
