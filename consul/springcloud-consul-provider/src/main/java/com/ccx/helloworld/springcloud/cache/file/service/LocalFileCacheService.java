package com.ccx.helloworld.springcloud.cache.file.service;

public interface LocalFileCacheService {
	/**
	 * 根据key删除本地文件缓存
	 * @param key
	 */
	void clearLocalFileCache(Object key);
	
	/**
	 * 存储文件缓存，判断文件是否存在，存在则不保存
	 * @param key
	 * @param value
	 */
	void saveLocalFileCache(Object key,Object value);
	
	<T> T get(String key,Class<T> clazz);
}
