//package com.ccx.helloworld.springcloud.controller;
//
//import javax.annotation.Resource;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.alibaba.fastjson.JSONObject;
//import com.ccx.helloworld.springcloud.entity.UserVO;
//
//@RestController
//@RequestMapping("user")
//public class CacheRedisCaffeineController {
//
//	@Resource
//	private CacheRedisCaffeineService cacheRedisCaffeineService;
//	
//	@GetMapping("id/{id}")
//	public String get(@PathVariable long id) {
//		UserVO user = cacheRedisCaffeineService.get(id);
//		return JSONObject.toJSONString(user);
//	}
//	
//	@GetMapping("name/{name}")
//	public String get(@PathVariable String name) {
//		UserVO user = cacheRedisCaffeineService.get(name);
//		return JSONObject.toJSONString(user);
//	}
//	
//	@GetMapping("update/{id}")
//	public String update(@PathVariable long id) {
//		UserVO user = cacheRedisCaffeineService.get(id);
//		cacheRedisCaffeineService.update(user);
//		return JSONObject.toJSONString(user);
//	}
//	
//	@GetMapping("delete/{id}")
//	public String delete(@PathVariable long id) {
//		cacheRedisCaffeineService.delete(id);
//		return "SUCCESS";
//	}
//}
