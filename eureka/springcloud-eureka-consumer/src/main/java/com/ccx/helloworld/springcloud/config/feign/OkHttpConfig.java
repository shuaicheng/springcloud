package com.ccx.helloworld.springcloud.config.feign;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Feign;
import lombok.extern.slf4j.Slf4j;
import okhttp3.ConnectionPool;

@Configuration
@ConditionalOnClass(Feign.class)
@AutoConfigureBefore(FeignAutoConfiguration.class)
@Slf4j
public class OkHttpConfig {
	@Bean
	public okhttp3.OkHttpClient okHttpClient(){
		okhttp3.OkHttpClient okHttpClient = 
	     new okhttp3.OkHttpClient.Builder()
	            //设置连接超时
	            .connectTimeout(1 , TimeUnit.SECONDS)
	            //设置读超时
	            .readTimeout(100, TimeUnit.MILLISECONDS)
	            //设置写超时
	            .writeTimeout(10 , TimeUnit.SECONDS)
	            //是否自动重连
	            .retryOnConnectionFailure(true)
	            .connectionPool(new ConnectionPool(10 , 5L, TimeUnit.MINUTES))
	            .build();
		log.info("+++++++++++++++:{}",okHttpClient.readTimeoutMillis());
		return okHttpClient;
	}
}