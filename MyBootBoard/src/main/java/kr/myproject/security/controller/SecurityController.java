package kr.myproject.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
	
	@GetMapping("/system/login")
	public String login() {
		return "/system/login";
	}
	
	@GetMapping("/system/logout")
	public String logout() {
		return "/system/logout";
	}
	
	@GetMapping("/system/accessDenied")
	public String accessDenied() {
		return "/system/accessDenied";
		
	}
	
	@GetMapping("/admin/adminPage")
	public String admin() {
		return "/admin/adminPage";
		
	}



}
