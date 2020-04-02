//package com.ccx.helloworld.springcloud.config;
//
//import java.net.UnknownHostException;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.AutoConfigureAfter;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.listener.ChannelTopic;
//import org.springframework.data.redis.listener.RedisMessageListenerContainer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
//import com.ccx.helloworld.springcloud.cache.CacheMessageListener;
//import com.ccx.helloworld.springcloud.cache.RedisEhcacheCacheManager;
//import com.ccx.helloworld.springcloud.cache.RedisEhcacheConfigProperties;
//
//@Configuration
//@AutoConfigureAfter(RedisAutoConfiguration.class)
//@EnableConfigurationProperties(RedisEhcacheConfigProperties.class)
//public class CacheRedisEhcacheAutoConfiguration {
//	
//	@Autowired
//	private RedisEhcacheConfigProperties redisEhcacheConfigProperties;
//	
//	
//	@Bean
//    public RedisEhcacheCacheManager cacheManager(RedisTemplate<Object, Object> redisTemplate) {
//        return new RedisEhcacheCacheManager(redisEhcacheConfigProperties, redisTemplate);
//    }
//	
//	@Bean
//	@ConditionalOnMissingBean(name = "stringKeyRedisTemplate")
//	public RedisTemplate<Object, Object> stringKeyRedisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
//		RedisTemplate<Object, Object> template = new RedisTemplate<Object, Object>();
//		template.setConnectionFactory(redisConnectionFactory);
//		template.setKeySerializer(new StringRedisSerializer());
//		template.setHashKeySerializer(new StringRedisSerializer());
//		return template;
//	}
//	
//	@Bean
//	@ConditionalOnBean(RedisEhcacheCacheManager.class)
//	public RedisMessageListenerContainer redisMessageListenerContainer(RedisTemplate<Object, Object> stringKeyRedisTemplate, 
//			RedisEhcacheCacheManager redisEhcacheCacheManager) {
//		RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
//		redisMessageListenerContainer.setConnectionFactory(stringKeyRedisTemplate.getConnectionFactory());
//		CacheMessageListener cacheMessageListener = new CacheMessageListener(stringKeyRedisTemplate, redisEhcacheCacheManager);
//		redisMessageListenerContainer.addMessageListener(cacheMessageListener, new ChannelTopic(redisEhcacheConfigProperties.getRedis().getTopic()));
//		return redisMessageListenerContainer;
//	}
//}
