package com.master.learning.firstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	
	
//*****************AS We Started implemented the stater security  AuthenticationService is not usable any more

	public boolean authenticateUser(String name, String password) {
		boolean isValidUserName=name.equalsIgnoreCase("Admin");
		boolean isValidPassword=password.equalsIgnoreCase("admin@123");
		
		return isValidPassword&&isValidUserName;
	}
}
