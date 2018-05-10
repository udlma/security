package org.zerock.controller;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.extern.log4j.Log4j;

@Log4j
public class BcryptTests {
	
	@Test
	public void testEncrypt() {
		
		BCryptPasswordEncoder pwencoder = new BCryptPasswordEncoder();
		
		String str = "1111";
		
		String enStr = pwencoder.encode(str);
		
		log.info(enStr);
	}
	
	@Test
	public void testMatches() {
		
		String enStr = "$2a$10$ncmUepA47H/eIDzhzvu1tuAd/u7cMv719BBm/hD50TW2EFU9kja2O";
		
		String user = "1111";
		
		BCryptPasswordEncoder pwencoder = new BCryptPasswordEncoder();
		
		boolean matcing = pwencoder.matches(user, enStr);
		
		log.info(matcing);
	}
}
