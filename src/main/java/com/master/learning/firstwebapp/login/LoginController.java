package com.master.learning.firstwebapp.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("username")
public class LoginController {
	
	@Autowired
	AuthenticationService authenticationService;
	
	@RequestMapping("/login")
    public String gotoLoginPage(ModelMap model) {
        return "login"; // Resolves to /WEB-INF/jsp/login.jsp
    }
	
	@PostMapping("/process-login")
    public String gotoWelcomePage(@RequestParam String username, @RequestParam String password, ModelMap model) {
		if(authenticationService.authenticateUser(username, password)) {
			model.put("username", username);
	        model.put("password", password);
	        return "welcome"; 
		}
		
		model.put("errorMessage","Invalid credential, Please try again!");
		return "login";
    }

}
