package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LoginController {
	
	@GetMapping("/myLogin")
	public void login() {
		
	}
	
	@PostMapping("/myLogout")
	public void logout() {
		
	}

}
