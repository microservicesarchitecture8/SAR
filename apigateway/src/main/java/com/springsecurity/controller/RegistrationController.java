package com.springsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurity.dto.RegistrationDto;
import com.springsecurity.service.RegistrationService;

/**
 * @author BGH58082
 *
 */
@RestController
@RequestMapping()
public class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService;
	
	@PostMapping({ "/register" })
	public List<RegistrationDto> registerMicroServices(@RequestBody RegistrationDto registrationDto) {
		return registrationService.registerMicroservices(registrationDto);
	}
}
