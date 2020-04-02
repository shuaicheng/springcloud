package com.ccx.helloworld.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ccx.helloworld.springcloud.service.entity.UserDemo;
import com.ccx.helloworld.springcloud.service.fallback.DemoFeignFallback;

@FeignClient(contextId = "test",name="eurekaServiceProvider",fallback=DemoFeignFallback.class)
public interface DemoFeignService{
	

	@GetMapping(value="/feign-service/serviceGet")
	String helloService(@RequestParam("name") String name);
	
	@RequestMapping(value="/feign-service/serviceHead", method=RequestMethod.GET)
	String helloService(@RequestParam("name") String name,
			@RequestParam("password") String password);
	
	@RequestMapping(value="/feign-service/servicePost", method=RequestMethod.POST)
	String helloService(@RequestBody UserDemo userDemo);

}
