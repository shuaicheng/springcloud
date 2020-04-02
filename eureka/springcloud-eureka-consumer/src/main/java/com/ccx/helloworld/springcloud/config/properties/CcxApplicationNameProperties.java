package com.ccx.helloworld.springcloud.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:configs/springcloud/ccx-application-info.properties")
@ConfigurationProperties(prefix = "ccx.springcloud.application.name")
public class CcxApplicationNameProperties {
	private String pccredit;

	public String getPccredit() {
		return pccredit;
	}

	public void setPccredit(String pccredit) {
		this.pccredit = pccredit;
	}
}
