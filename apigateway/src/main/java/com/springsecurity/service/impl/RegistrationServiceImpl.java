package com.springsecurity.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
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

	@Override
	public List<RegistrationDto> deRegisterMicroservices(String serviceName, String serviceUrl) {
		List<RegistrationDto> dtos= CommonUtils.registrationMap.get(serviceName) == null ? new ArrayList<>() : 
			CommonUtils.registrationMap.get(serviceName);
		Iterator dtoList = dtos.iterator();
		List<RegistrationDto> newDtos = new ArrayList<>();
		while(dtoList.hasNext()) {
			RegistrationDto dto = (RegistrationDto) dtoList.next();
			if(!dto.getServiceUrl().equals(serviceUrl)) {
				newDtos.add(dto);
			}
		}
		CommonUtils.registrationMap.put(serviceName, newDtos);
		return newDtos;
	}
	
}
