package com.springsecurity.service;

import java.util.List;

import com.springsecurity.dto.RegistrationDto;

/**
 * @author BGH58082
 *
 */
public interface RegistrationService {
	
	public List<RegistrationDto> registerMicroservices(RegistrationDto registrationDto);
	
	public void refreshRoutes();

	public List<RegistrationDto> deRegisterMicroservices(String serviceName, String serviceUrl);
}
