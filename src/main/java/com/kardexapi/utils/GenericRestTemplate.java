package com.kardexapi.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class GenericRestTemplate {
	static RestTemplate restTemplate = new RestTemplate();
	
	@Bean
	public static RestTemplate restTemplate(){
		return restTemplate;
	}
}
