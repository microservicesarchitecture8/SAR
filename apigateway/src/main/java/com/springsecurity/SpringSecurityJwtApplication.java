package com.springsecurity;

import java.util.HashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import com.springsecurity.utils.CommonUtils;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaServer
/**
 * 
 * @author shukotka
 *
 */
public class SpringSecurityJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtApplication.class, args);
		CommonUtils.registrationMap = new HashMap<>();
	}
	


}
