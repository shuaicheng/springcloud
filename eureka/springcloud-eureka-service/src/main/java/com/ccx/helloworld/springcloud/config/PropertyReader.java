package com.ccx.helloworld.springcloud.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertyReader {
	private static final Logger log = LoggerFactory.getLogger(PropertyReader.class);
	private static Map<String,Properties> propMap = new HashMap<>();
	public static Properties load(String filePath) {
		Properties props = propMap.get(filePath);
		if(props==null) {
			InputStream in = null;
			try {
				if(filePath.startsWith("classpath:")) {
					in = PropertyReader.class.getClassLoader().getResourceAsStream(filePath.replace("classpath:", ""));
				}else if(filePath.startsWith("file:")) {
						in = new FileInputStream(filePath.replace("file:", ""));
					
				}
				if(in!=null) {
					props = new Properties();
					props.load(in);
				}
			} catch (IOException e) {
				in = null;
				log.error(e.getMessage(),e);
				System.exit(-1);
			}

		}
		return props;
	}
}
