package com.ccx.helloworld.springcloud.cache.file.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.UnsupportedEncodingException;

import org.apache.tomcat.util.security.MD5Encoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ccx.helloworld.springcloud.cache.file.service.LocalFileCacheService;

@Service
public class LocalFileCacheServiceImpl implements LocalFileCacheService {

	private static final Logger logger = LoggerFactory.getLogger(LocalFileCacheServiceImpl.class);

	@Value("${spring.cache.local.filePath}")
	private String localCacheFilePath;

	private static final String CACHE_FILE_PATTERN = ".json";

	@Override
	public void clearLocalFileCache(Object key) {
		if(key==null) {
			return ;
		}
		StringBuilder sb = new StringBuilder(localCacheFilePath).append(File.separatorChar);
		try {
			sb.append(MD5Encoder.encode(key.toString().getBytes("UTF-8"))).append(CACHE_FILE_PATTERN);
			File file = new File(sb.toString());
			if (!file.exists()) {
				return;
			}
			if (file.isFile()) {
				file.delete();
			}
		} catch (UnsupportedEncodingException e) {
			logger.error("删除文件错误:{}", sb.toString(), e);
		}

	}

	@Override
	public void saveLocalFileCache(Object key, Object value) {
		if (key == null || value == null) {
			return;
		}
		StringBuilder sb = new StringBuilder(localCacheFilePath).append(File.separatorChar);
		File file = new File(sb.toString());
		if(!file.exists()) {
			file.mkdirs();
		}
		FileWriter fw = null;
		try {
			sb.append(MD5Encoder.encode(key.toString().getBytes("UTF-8"))).append(CACHE_FILE_PATTERN);
			File cachFile = new File(sb.toString());
			if(cachFile.exists()) {
				return;
			}
			fw = new FileWriter(sb.toString());
			fw.write(JSONObject.toJSONString(value));
		} catch (Exception e) {
			logger.error("保存本地文件缓存异常：{}",sb.toString(), e);
		} finally {
			try {
				if(fw!=null)
					fw.close();
			} catch (Exception e1) {
				logger.error("e1:{}", e1);
			}
		}
	}

	@Override
	public <T> T get(String key, Class<T> clazz) {
		if (key == null) {
			return null;
		}
		T t = null;
		StringBuilder sb = new StringBuilder(localCacheFilePath).append(File.separatorChar);
		String result = null;
		FileReader fr = null;
		BufferedReader bufr = null;
		try {
			sb.append(MD5Encoder.encode(key.getBytes("UTF-8"))).append(CACHE_FILE_PATTERN);
			fr = new FileReader(sb.toString());
			bufr = new BufferedReader(fr);
			result = bufr.readLine();
			t = JSONObject.parseObject(result, clazz);
		} catch (Exception e) {
			logger.error("e:{}", e);
			return null;
		} finally {
			try {
				if (bufr != null) {
					bufr.close();
				}
				if (fr != null) {
					fr.close();
				}
			} catch (Exception e1) {
				logger.error("e1:{}", e1);
			}
		}
		return t;
	}

}
