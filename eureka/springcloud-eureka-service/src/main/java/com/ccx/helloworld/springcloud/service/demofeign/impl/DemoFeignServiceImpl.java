package com.ccx.helloworld.springcloud.service.demofeign.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.ccx.helloworld.springcloud.service.DemoFeignService;
import com.ccx.helloworld.springcloud.service.entity.UserDemo;
import com.ccx.helloworld.springcloud.service.thread.LogTraceThreadDemoService;

import lombok.extern.slf4j.Slf4j;



@RestController
@Slf4j
//@RequestMapping("/feign-service")
public class DemoFeignServiceImpl implements DemoFeignService {

	@Autowired
	private LogTraceThreadDemoService logTraceThreadDemoService;
	
	@Override
	public String helloService(String name) {
		// TODO Auto-generated method stub
//		logger.
		try {
			Thread.sleep(500);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("hello :{}",name);
		logTraceThreadDemoService.testThreadLogTrace();
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
