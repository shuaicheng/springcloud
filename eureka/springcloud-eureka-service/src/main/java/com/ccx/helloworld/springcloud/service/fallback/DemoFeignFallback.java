package com.ccx.helloworld.springcloud.service.fallback;

import org.springframework.stereotype.Component;

import com.ccx.helloworld.springcloud.service.DemoFeignService;
import com.ccx.helloworld.springcloud.service.entity.UserDemo;

@Component
public class DemoFeignFallback implements DemoFeignService{
	@Override
	public String helloService(String name) {
		return "get error";
	}

	@Override
	public String helloService(String name,String password) {
		return "head error";
	}
	
	@Override
	public String helloService(UserDemo userDemo) {
		return "post error";
	}
}