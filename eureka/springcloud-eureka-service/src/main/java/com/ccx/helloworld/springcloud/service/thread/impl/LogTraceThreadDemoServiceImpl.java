package com.ccx.helloworld.springcloud.service.thread.impl;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.stereotype.Service;

import com.ccx.helloworld.springcloud.service.thread.LogTraceThreadDemoService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LogTraceThreadDemoServiceImpl implements LogTraceThreadDemoService {

	
	@Override
	public void testThreadLogTrace() {
		// TODO Auto-generated method stub
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		for(int i=0;i<3;i++) {
			executorService.submit(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					log.info("this is thread!!!:{}",UUID.randomUUID());
				}
			});
		}
	}

}
