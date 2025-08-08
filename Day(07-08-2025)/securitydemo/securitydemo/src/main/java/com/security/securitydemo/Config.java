package com.security.securitydemo;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
 

@Configuration
public class Config {
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	{
		http.authorizeHttpRequests(
				auth->auth
				.requestMatchers("/greet")
				.permitAll()
				.anyRequest()
				.authenticated())		 	 
	            .formLogin(withDefaults());
		return http.build();	
	}
	@Bean
	UserDetailsService user()
	{
		UserDetails user=User.withUsername("vedanti")
				.password(encodePassword().encode("pass@123")).build();
		UserDetails user1=User.withUsername("john")
				.password(encodePassword().encode("pass")).build();
		  return new InMemoryUserDetailsManager(user,user1);
	}
	@Bean
	PasswordEncoder encodePassword()
	{
		return new BCryptPasswordEncoder();
	}

}
