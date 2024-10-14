package com.Taxi.TaxiBooking.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	private CustomLogoutHandler customLogoutHandler;
	
	@Autowired
	public void setCustomLogoutHandler(CustomLogoutHandler customLogoutHandler) {
		this.customLogoutHandler = customLogoutHandler;
	}


	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception
	{
		
		
		
		httpSecurity.
		  csrf(csrf->csrf.disable())

		  .authorizeHttpRequests(authorize->authorize
				  .requestMatchers("/admin/**").authenticated()
				  .requestMatchers("/**").permitAll()
				  
				  )
		          
		          .formLogin(form->form
		        		  .permitAll()
		        		  
		          )
		          .logout(logout->logout
		        	.addLogoutHandler(customLogoutHandler)	  
		        	.logoutUrl("/dologout")	  
		          );
		     
		
		return httpSecurity.build();
	}

}
