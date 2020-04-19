package com.ccx.helloworld.springcloud.service.demofeign.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	
	@Value("${server.port}")
	private String port;
	
	@Override
	public String helloService(String name) {
		// TODO Auto-generated method stub
//		logger.
		log.info("port:{},hello :{}",port,name);
		try {
			Thread.sleep(Integer.valueOf(name));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logTraceThreadDemoService.testThreadLogTrace();
		return "hello "+name+"! My port is :" + port;
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
