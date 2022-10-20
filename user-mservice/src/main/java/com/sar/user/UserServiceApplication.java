package com.sar.user;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.sar.user.entity.RegistrationDto;

@SpringBootApplication
/**
 * 
 * @author shukotka
 *
 */
public class UserServiceApplication {

	private static final String URL = "http://localhost:";
	private static final String TRUE = "true";

	@Value("${server.port}")
	private String port;

	@Value("${spring.application.name}")
	private String name;
	
	@Value("${discovery.service.enabled}")
	private String enabled;
	
	@Value("${discovery.service.url}")
	private String registerURL;
	
	@Value("${discovery.service.contextPath}")
	private String contextPath;
	
	@Bean
	public static RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}
	

	private void registerServiceWithGateway() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RegistrationDto regDto = new RegistrationDto();
		regDto.setServicePort(port);
		regDto.setServiceName(name);
		regDto.setServiceUrl(URL + port);
		regDto.setInstanceName(name);
		regDto.setContextPath(contextPath);
		getRestTemplate().postForEntity(registerURL, new HttpEntity<>(regDto, headers), String.class);
	}

	@PostConstruct
	private void postConstruct() {
		if(!StringUtils.isEmpty(enabled) && enabled.equals(TRUE)) {
			registerServiceWithGateway();
		}
	}
}