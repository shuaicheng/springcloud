//package com.ccx.helloworld.springcloud.config;
//
//import java.util.Properties;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.alibaba.dubbo.config.ProtocolConfig;
//import com.alibaba.dubbo.config.ProviderConfig;
//import com.alibaba.dubbo.config.RegistryConfig;
//import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
//
//
//@Configuration
//@DubboComponentScan(basePackages = {"com.ccx.dp.data.router.service.system.service.dubbo"})
//public class DubboConfig {
//		
//	private static final Logger log = LoggerFactory.getLogger(DubboConfig.class);
//	
//	@Value("${custom.dubbo.config.path}") private String dubboConfigPath;  
//	
//	/*
//	 * @Bean public ApplicationConfig applicationConfig() { ApplicationConfig
//	 * applicationConfig = new ApplicationConfig();
//	 * applicationConfig.setName("CCX-DR-DRSS"); return applicationConfig; }
//	 */
//	
//	@Bean
//	public ProviderConfig providerConfig() {
//		ProviderConfig providerConfig = new ProviderConfig();
//		log.info("##############################################");
//		log.info("#########provider  dubboConfigPath is :" + dubboConfigPath);
//		Properties props = PropertyReader.load(dubboConfigPath);
//		log.info("#########provider dubbo.registry.zookeeper:{}", props.get("dubbo.registry.zookeeper"));
//		log.info("#########provider dubbo.version:{}", props.get("dubbo.version"));
//		log.info("##############################################");
//		providerConfig.setVersion(props.get("dubbo.version").toString());
//		return providerConfig;
//	}
//	
//	@Bean
//	public ProtocolConfig protocolConfig() {
//		ProtocolConfig protocolConfig = new ProtocolConfig();
//		protocolConfig.setName("dubbo");
//		protocolConfig.setPort(20001);
//		return protocolConfig;
//	}
//	
//	@Bean
//	public RegistryConfig registryConfig() {
//		RegistryConfig registryConfig = new RegistryConfig();
//		log.info("##############################################");
//		log.info("#########dubboConfigPath is :"+dubboConfigPath);
//		Properties props = PropertyReader.load(dubboConfigPath);
//		log.info("#########dubbo.registry.zookeeper:{}",props.get("dubbo.registry.zookeeper"));
//		log.info("#########dubbo.group:{}",props.get("dubbo.group"));
//		log.info("#########dubbo.version:{}",props.get("dubbo.version"));
//		log.info("##############################################");
//		registryConfig.setAddress(props.get("dubbo.registry.zookeeper").toString());
//		registryConfig.setGroup(props.get("dubbo.group").toString());
//		registryConfig.setVersion(props.get("dubbo.version").toString());
//		return registryConfig;
//	}
//	/*
//	 * @Bean public ConsumerConfig consumerConfig() { ConsumerConfig consumerConfig
//	 * = new ConsumerConfig(); consumerConfig.setTimeout(30000);
//	 * log.info("##############################################");
//	 * log.info("#########dubboConfigPath is :"+dubboConfigPath); Properties props =
//	 * PropertyReader.load(dubboConfigPath);
//	 * consumerConfig.setGroup(props.get("dubbo.group").toString());
//	 * consumerConfig.setVersion(props.get("dubbo.version").toString()); return
//	 * consumerConfig; }
//	 */
//}
