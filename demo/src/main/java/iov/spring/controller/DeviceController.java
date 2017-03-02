package iov.spring.controller;

import iov.spring.entity.Device;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "basicController")
public class DeviceController extends BasicController {

	
	// 显示备用机交换信息
	@RequestMapping(value = "test01")
	@ResponseBody 
	public  Device afterSaleChangList(HttpServletRequest request, HttpServletResponse response, String region, String offset, String order, String sort) throws Exception {
      
		Device  deviec=new Device();
		deviec.setId(111111111);
		
		return deviec;
}
	
	
	
	
	
	
	
	
}