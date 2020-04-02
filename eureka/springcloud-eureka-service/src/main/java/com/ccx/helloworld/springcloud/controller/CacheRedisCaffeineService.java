//package com.ccx.helloworld.springcloud.controller;
//
//import java.util.Random;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.CachePut;
//import org.springframework.cache.annotation.Cacheable;
//import org.springframework.cache.annotation.Caching;
//import org.springframework.stereotype.Service;
//
//import com.ccx.helloworld.springcloud.entity.UserVO;
//
//@Service
//public class CacheRedisCaffeineService {
//	
//	private final Logger logger = LoggerFactory.getLogger(CacheRedisCaffeineService.class);
//	private static final String NAME_S = "ssss";
//
//	@Cacheable(key = "'cache_user_id_' + #id", value = "userIdCache", /* cacheManager = "cacheManager", */ sync = true)
//	public UserVO get(long id) {
//		logger.info("get by id from db");
//		UserVO user = new UserVO();
//		user.setId(id);
//		user.setName("name" + id);
//		user.setCreateTime(System.currentTimeMillis());
//		return user;
//	}
//	
//	@Cacheable(key = "'cache_user_name_' + #name", value = "userNameCache", cacheManager = "cacheManager")
//	public UserVO get(String name) {
//		logger.info("get by name from db");
//		UserVO user = new UserVO();
//		user.setId(new Random().nextLong());
//		user.setName(name);
//		user.setCreateTime(System.currentTimeMillis());
//		return user;
//	}
//	
//	@CachePut(key = "'cache_user_id_' + #userVO.id", value = "userIdCache", cacheManager = "cacheManager")
//	public UserVO update(UserVO userVO) {
//		logger.info("update to db");
//		userVO.setCreateTime(System.currentTimeMillis());
//		return userVO;
//	}
//	
//	@Caching(
//		evict = {
//				@CacheEvict(key = "'cache_user_id_' + #id", value = "userIdCache", cacheManager = "cacheManager"),
//				@CacheEvict(key = "'cache_user_name_' + #id", value = "userNameCache", cacheManager = "cacheManager")
//		}
//	)
//	public void delete(long id) {
//		logger.info("delete from db");
//	}
//	
//	
//}
