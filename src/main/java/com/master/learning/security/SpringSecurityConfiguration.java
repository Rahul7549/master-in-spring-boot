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
	
	
		Function<String,String> passwordEncoder
		=input->passwordEncoder().encode(input);

		@Bean
		public  InMemoryUserDetailsManager configureUserDeatilsManager() {
			UserDetails userDeatils= User.builder()
					.passwordEncoder(passwordEncoder)
					.username("admin")
					.password("Admin@123")
					.roles("USER","ADMIN")
					.build();
			
			return new InMemoryUserDetailsManager(userDeatils);
		}
		
		@Bean
		public PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}

}
