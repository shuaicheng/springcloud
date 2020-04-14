package com.ccx.helloworld.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ccx.helloworld.springcloud.service.DemoFeignService;
import com.ccx.helloworld.springcloud.service.entity.UserDemo;
import com.ccx.helloworld.springcloud.service.thread.LogTraceThreadDemoService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DemoFeignController {
	
	@Autowired
	private DemoFeignService demoFeignService;
	
	@Autowired
	private LogTraceThreadDemoService logTraceThreadDemoService;
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String demoServiceTest() {
		StringBuffer sb = new StringBuffer();
		sb.append(demoFeignService.helloService("yuanyuan"));
//		log.info("result is :{}",demoFeignService.helloService("yuanyuan"));
		sb.append(demoFeignService.helloService("yjt","xixihaha"));
//		log.info("result is :{}",demoFeignService.helloService("yjt","xixihaha"));
		sb.append(demoFeignService.helloService(new UserDemo("yejingtao","123456")));
//		log.info("result is :{}",demoFeignService.helloService(new UserDemo("yejingtao","123456")));
		
		logTraceThreadDemoService.testThreadLogTrace();
		
		return sb.toString();
	}
}