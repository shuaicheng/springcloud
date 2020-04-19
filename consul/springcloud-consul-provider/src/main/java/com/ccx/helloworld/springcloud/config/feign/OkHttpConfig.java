//package com.ccx.helloworld.springcloud.config.feign;
//
//import java.util.concurrent.TimeUnit;
//
//import org.springframework.boot.autoconfigure.AutoConfigureBefore;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
//import org.springframework.cloud.openfeign.FeignAutoConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import feign.Feign;
//import lombok.extern.slf4j.Slf4j;
//import okhttp3.ConnectionPool;
//
//@Configuration
//@ConditionalOnClass(Feign.class)
//@AutoConfigureBefore(FeignAutoConfiguration.class)
//@Slf4j
//public class OkHttpConfig {
//	@Bean
//	public okhttp3.OkHttpClient okHttpClient(){
//		log.info("+++++++++++++++++++++++","");
//		log.info("+++++++++++++++++++++++","");
//		log.info("+++++++++++++++++++++++","");
//	    return new okhttp3.OkHttpClient.Builder()
//	            //设置连接超时
//	            .connectTimeout(10 , TimeUnit.SECONDS)
//	            //设置读超时
//	            .readTimeout(3 , TimeUnit.SECONDS)
//	            //设置写超时
//	            .writeTimeout(10 , TimeUnit.SECONDS)
//	            //是否自动重连
//	            .retryOnConnectionFailure(true)
//	            .connectionPool(new ConnectionPool(10 , 5L, TimeUnit.MINUTES))
//	            .build();
//	}
//}