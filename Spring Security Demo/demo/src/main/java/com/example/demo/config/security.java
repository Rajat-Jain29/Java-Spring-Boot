package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class security extends WebSecurityConfigurerAdapter{
		@Override
		public void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.inMemoryAuthentication()
			.withUser("Raja")
			.password("1234")
			.roles("admin")
			.and()
			.withUser("Hello")
			.password("123")
			.roles("user");
		}
		
		@Bean
		public PasswordEncoder getPasswordEncoder() {
			return NoOpPasswordEncoder.getInstance();
		}
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.httpBasic().and().authorizeRequests()
			.antMatchers("/user").hasAnyRole("user","admin")
			.antMatchers("/admin").hasRole("admin")
			.antMatchers("/").permitAll()
			.and().formLogin();
//			 http
//	         .csrf().disable()
//	         .authorizeRequests().anyRequest().authenticated()
//	         .and()
//	         .httpBasic();
		}
}