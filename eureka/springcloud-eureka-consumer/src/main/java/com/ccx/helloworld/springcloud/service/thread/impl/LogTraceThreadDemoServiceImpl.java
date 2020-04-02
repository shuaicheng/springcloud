package com.ccx.helloworld.springcloud.service.thread.impl;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.instrument.async.TraceableExecutorService;
import org.springframework.stereotype.Service;

import com.ccx.helloworld.springcloud.service.thread.LogTraceThreadDemoService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LogTraceThreadDemoServiceImpl implements LogTraceThreadDemoService {

	@Autowired
	BeanFactory beanFactory;
	
	ExecutorService executorService = Executors.newFixedThreadPool(3);
	
	@Override
	public void testThreadLogTrace() {
		// TODO Auto-generated method stub
		TraceableExecutorService tService = new TraceableExecutorService(beanFactory,executorService,null);
		for(int i=0;i<3;i++) {
			tService.submit(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					log.info("this is thread!!!:{}",UUID.randomUUID());
				}
			});
		}
	}

}
