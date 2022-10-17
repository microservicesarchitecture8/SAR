package com.springsecurity.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.context.ApplicationEventPublisher;
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
	
	@Autowired
	  private ApplicationEventPublisher applicationEventPublisher;
	  
	
	@Override
	 public void refreshRoutes() {
	   applicationEventPublisher.publishEvent(new RefreshRoutesEvent(this));
	}
	    
	@Override
	public List<RegistrationDto> registerMicroservices(RegistrationDto registrationDto) {
		List<RegistrationDto> dtos= CommonUtils.registrationMap.get(registrationDto.getServiceName()) == null ? new ArrayList<>() : 
			CommonUtils.registrationMap.get(registrationDto.getServiceName()); 
		dtos.add(registrationDto);
		CommonUtils.registrationMap.put(registrationDto.getServiceName(), dtos);
		refreshRoutes();
		return dtos;
	}

}
