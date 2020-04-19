package com.ccx.helloworld.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@ImportResource("classpath:/spring/*.xml")
//@EnableTransactionManagement
//@EnableDubboConfiguration
//@EnableCaching
//@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
//@RemoteApplicationEventScan(basePackages = {"com.ccx.helloworld.springcloud.event"})
//@EnableDubbo
public class ConsulServiceProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsulServiceProviderApplication.class, args);
    }
}
