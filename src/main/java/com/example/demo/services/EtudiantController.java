package com.example.demo.services;

import org.springframework.web.bind.annotation.RequestMapping;

public class EtudiantController {
	@RequestMapping("/login")
	
	public String login() {
		 return "login" ;
	}

}
