package com.springsecurity.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springsecurity.dto.RegistrationDto;
import com.springsecurity.service.RegistrationService;
import com.springsecurity.utils.CommonUtils;

/**
 * @author BGH58082
 *
 */
@Service
public class RegistrationServiceImpl implements RegistrationService {
	
	@Override
	public List<RegistrationDto> registerMicroservices(RegistrationDto registrationDto) {
		List<RegistrationDto> dtos= CommonUtils.registrationMap.get(registrationDto.getServiceName()) == null ? new ArrayList<>() : 
			CommonUtils.registrationMap.get(registrationDto.getServiceName()); 
		dtos.add(registrationDto);
		CommonUtils.registrationMap.put(registrationDto.getServiceName(), dtos);
		return dtos;
	}

}
