package com.ccx.helloworld.springcloud.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ccx.helloworld.springcloud.service.DemoFeignService;
import com.ccx.helloworld.springcloud.service.entity.UserDemo;



@RestController
//@RequestMapping("/feign-service")
public class DemoFeignServiceImpl implements DemoFeignService {

	@Override
	public String helloService(String name) {
		// TODO Auto-generated method stub
		return "hello "+name+"!";
	}

	@Override
	public String helloService(String name, String password) {
		// TODO Auto-generated method stub
		return "hello "+name+" your password is :"+password;
	}

	@Override
	public String helloService(UserDemo userDemo) {
		// TODO Auto-generated method stub
		return "hello "+userDemo.getName()+" userDemo.getPassword is "+userDemo.getPassword();
	}

}
