package com.master.learning.firstwebapp.logincontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
    public String gotoLoginPage() {
        return "login"; // Resolves to /WEB-INF/jsp/login.jsp
    }
	
	@PostMapping("/process-login")
    public String gotoWelcomePage() {
        return "welcome"; // Resolves to /WEB-INF/jsp/login.jsp
    }

}
