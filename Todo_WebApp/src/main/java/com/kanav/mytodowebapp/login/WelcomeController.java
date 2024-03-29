package com.kanav.mytodowebapp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class WelcomeController {

	@GetMapping("/")
	public String gotoWelcomePage(ModelMap model) {
		model.put("user", getLoggedInUser());
		return "welcome";
	}
	
	public String getLoggedInUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}

	@GetMapping("dashboard")
	public String gotoDashboard() {
		return "welcome";
	}

	
}
