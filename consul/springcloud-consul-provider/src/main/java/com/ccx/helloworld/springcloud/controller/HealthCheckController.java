package com.ccx.helloworld.springcloud.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class HealthCheckController {
 
    @Value("${server.port}")
    private String port;

    @GetMapping("/healthCheck")
    public String get() {
        return "Producer Server port: " + port;
    }
}
