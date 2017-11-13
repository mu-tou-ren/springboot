package com.neo.springBoot;


import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.neo.springBoot.filter.MyFilter;

@Configuration
public class WebConfiguration {
	
	@Bean
	public RemoteIpFilter remoteIpFilter(){
		return new RemoteIpFilter();
	}
	
	@Bean
	public FilterRegistrationBean testFilterRegistratiponBean(){
		
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new MyFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("MyFilter");
        registration.setOrder(1);
		return registration;
		
	}

}
