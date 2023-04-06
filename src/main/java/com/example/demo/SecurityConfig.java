package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {
	
	@Autowired
	public void globalConfig(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("123").roles("ADMIN","PROF");
		auth.inMemoryAuthentication().withUser("prof").password("123").roles("PROF");
		auth.inMemoryAuthentication().withUser("et").password("123").roles("ETUDIANT");

	}
	
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
		 
		 http
		     .csrf().disable()
		     .authorizeRequests()
		        .anyRequest()
		           .authenticated()
		               .and()
		               
		    .formLogin()
		      .loginPage("/login")
		        .permitAll()
		     
		        
		        .defaultSuccessUrl("/index.html");
		        
		     
		               
		        
		 
	 }
	
	 /*
	 @Bean
	 public BCryptPasswordEncoder passwordEncoder() {
	     return new BCryptPasswordEncoder();
	 }
  
  
  */
	
}
