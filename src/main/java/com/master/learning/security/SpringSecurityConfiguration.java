package com.master.learning.security;

import java.util.function.Function;

import javax.management.relation.Role;
import org.springframework.security.core.userdetails.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration {
	
		@Bean
		public  InMemoryUserDetailsManager configureUserDeatilsManager() {
			UserDetails userDeatil1 = createUser("admin","Admin@123");
			UserDetails userDeatil2 = createUser("Rahul","Rahul@123");
			return new InMemoryUserDetailsManager(userDeatil1,userDeatil2);
		}

		private UserDetails createUser(String username,String password) {
			Function<String,String> passwordEncoder
			=input->passwordEncoder().encode(input);
			
			UserDetails userDeatils= User.builder()
					.passwordEncoder(passwordEncoder)
					.username(username)
					.password(password)
					.roles("USER","ADMIN")
					.build();
			return userDeatils;
		}
		
		@Bean
		public PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}

}
