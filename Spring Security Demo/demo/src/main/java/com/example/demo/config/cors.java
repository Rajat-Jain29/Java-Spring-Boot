package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class cors implements WebMvcConfigurer {
	//Access-Control-Allow-Origin: The origin that is allowed to make the request, or * if a request can be made from any origin
	//Access-Control-Allow-Methods: A comma-separated list of HTTP methods that are allowed
	//Access-Control-Allow-Headers: A comma-separated list of the custom headers that are allowed to be sent
	//Access-Control-Max-Age: The maximum duration that the response to the preflight request can be cached before another call is made
	
	
	@Bean
	public WebMvcConfigurer corConfigurer() {
		return new WebMvcConfigurer() {
			public void addConfig(CorsRegistry registry) {
				registry.addMapping("*")
				.allowedMethods("*")
				.allowedOrigins("http://localhost:101");
			}
		};
	}
}