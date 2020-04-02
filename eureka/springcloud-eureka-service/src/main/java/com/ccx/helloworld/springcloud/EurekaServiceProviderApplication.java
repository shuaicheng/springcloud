package com.ccx.helloworld.springcloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
public class EurekaServiceProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServiceProviderApplication.class, args);
    }
}
