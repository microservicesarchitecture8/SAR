package com.springsecurity.service.impl;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.server.ServerWebExchange;

import com.springsecurity.dto.RegistrationDto;
import com.springsecurity.utils.CommonUtils;

import reactor.core.publisher.Flux;

/**
 * @author BGH58082
 *
 */
@Service
public class RouterImpl implements RouteLocator {
	
	 private final RouteLocatorBuilder routeLocatorBuilder;
	
	  public RouterImpl(RouteLocatorBuilder routeLocatorBuilder) {
		  this.routeLocatorBuilder = routeLocatorBuilder;
	  }
	
	  @Override
	  public Flux<Route> getRoutes() {
		  RouteLocatorBuilder.Builder routesBuilder = routeLocatorBuilder.routes();
		  if(!CollectionUtils.isEmpty(CommonUtils.registrationMap)) {
			  CommonUtils.registrationMap.keySet().forEach(serviceName -> {
				  List<RegistrationDto> registeredDtos = CommonUtils.registrationMap.get(serviceName);
				  registeredDtos.forEach(dto -> {
					  routesBuilder.route(dto.getInstanceName(), r -> r.path(dto.getContextPath())
							  .uri(dto.getServiceUrl()).predicate(apply(serviceName, registeredDtos.indexOf(dto))));
				  });
			  });
		  }
		  
	    return routesBuilder.build().getRoutes();
	  }
	  
	  
	  public Predicate<ServerWebExchange> apply(String instance, int value) {        
		  return (ServerWebExchange t) -> {
			  return Integer.valueOf(t.hashCode()) % CommonUtils.registrationMap.get(instance).size() == value;           
		  };        
	    }

}
