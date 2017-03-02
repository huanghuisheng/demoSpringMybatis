package iov.spring.controller;

import iov.spring.service.DeviceService;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;


@Controller("BasicController")
public class BasicController{ 
	
	@Resource(name="deviceService")
	 public DeviceService deviceService; 

	
	
}
