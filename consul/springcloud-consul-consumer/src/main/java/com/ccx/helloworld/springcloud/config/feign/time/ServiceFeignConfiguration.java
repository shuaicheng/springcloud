package com.ccx.helloworld.springcloud.config.feign.time;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Request;

import feign.okhttp.OkHttpClient;

@Configuration
public class ServiceFeignConfiguration {
	@Bean
    public Request.Options options() {
        return new Request.Options(1000, 30000);
    }
}

