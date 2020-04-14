package com.ccx.helloworld.springcloud.config.tomcat;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//@Configuration
public class TomcatSpringBoot2 implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {
 
    @Override
    public void customize(TomcatServletWebServerFactory factory) {
//        factory.setContextPath("");
        factory.setPort(18080);
        log.info("##########################################################");
//        log.info("",factory.get);
    	System.out.println("factory string is :::["+factory.toString()+"]");
    }
}
