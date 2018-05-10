package org.zerock.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		log.info("loadUserByUsername......... : "+username);
		
		
		
		return new User(username, "$2a$10$ncmUepA47H/eIDzhzvu1tuAd/u7cMv719BBm/hD50TW2EFU9kja2O", Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN")));
	}

}
