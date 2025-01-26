package com.master.learning.firstwebapp.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
//@SessionAttributes("username")
public class WelcomeController {
	
	@Autowired
	AuthenticationService authenticationService;
	
	@RequestMapping("/")
    public String gotoWelcomePage(ModelMap model) {
		model.put("username",getLoggedInUserName() );
        return "welcome"; // Resolves to /WEB-INF/jsp/login.jsp
    }
	
	
//	@PostMapping("/process-login")
//    public String gotoWelcomePage(@RequestParam String username, @RequestParam String password, ModelMap model) {
//		if(authenticationService.authenticateUser(username, password)) {
//			model.put("username", username);
//	        model.put("password", password);
//	        return "welcome"; 
//		}
//		
//		model.put("errorMessage","Invalid credential, Please try again!");
//		return "login";
//    }
	
	private String getLoggedInUserName() {
		Authentication authentication
		=SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}

}
