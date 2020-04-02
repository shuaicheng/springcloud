package com.ccx.helloworld.springcloud.cache;

import java.time.Duration;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ExpiryPolicyBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.core.RedisTemplate;


public class RedisEhcacheCacheManager implements CacheManager {
	
	private final Logger logger = LoggerFactory.getLogger(RedisEhcacheCacheManager.class);
	
	private ConcurrentMap<String, Cache> cacheMap = new ConcurrentHashMap<String, Cache>();
	
	private RedisEhcacheConfigProperties redisEhcacheConfigProperties;
	
	private RedisTemplate<Object, Object> stringKeyRedisTemplate;

	private boolean dynamic = true;

	private Set<String> cacheNames;
	
	private org.ehcache.CacheManager ehCacheManager;
	
	private CacheConfiguration<Object,Object> configuration;

	public RedisEhcacheCacheManager(RedisEhcacheConfigProperties redisEhcacheConfigProperties,
			RedisTemplate<Object, Object> stringKeyRedisTemplate) {
		super();
		this.redisEhcacheConfigProperties = redisEhcacheConfigProperties;
		this.stringKeyRedisTemplate = stringKeyRedisTemplate;
		this.dynamic = redisEhcacheConfigProperties.isDynamic();
		this.cacheNames = redisEhcacheConfigProperties.getCacheNames();
		logger.info("********************************************");
		logger.info("@@@@@@@@@@cacheNames:{}",cacheNames);
		logger.info("********************************************");
		setAboutEhCache();
	}

    private void setAboutEhCache(){
        long ehcacheExpire = redisEhcacheConfigProperties.getEhcache().getExpireAfterWrite();
        ResourcePoolsBuilder resourcePoolsBuilder = ResourcePoolsBuilder.heap(redisEhcacheConfigProperties.getEhcache().getMaximumSize());
        this.configuration = CacheConfigurationBuilder
                        		.newCacheConfigurationBuilder(Object.class, Object.class,resourcePoolsBuilder)
                        		.withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofMillis(ehcacheExpire)))
                        		.build();
        this.ehCacheManager = CacheManagerBuilder
                				.newCacheManagerBuilder()
                				.build();
        this.ehCacheManager.init();
    }
	
	@Override
	public Cache getCache(String name) {
		logger.info("getChcache--caChe name is :{}",name);
		Cache cache = cacheMap.get(name);
		if(cache != null) {
			return cache;
		}
		if(!dynamic && !cacheNames.contains(name)) {
			return cache;
		}
		
		cache = new RedisEhcacheCache(name, stringKeyRedisTemplate, getEhcache(name), redisEhcacheConfigProperties);
		Cache oldCache = cacheMap.putIfAbsent(name, cache);
		logger.debug("create cache instance, the cache name is : {}", name);
		return oldCache == null ? cache : oldCache;
	}
	
	public org.ehcache.Cache<Object, Object> getEhcache(String name){
		org.ehcache.Cache<Object, Object> res = ehCacheManager.getCache(name, Object.class, Object.class);
        if(res != null){
            return res;
        }
        return ehCacheManager.createCache(name, configuration);
	}

	@Override
	public Collection<String> getCacheNames() {
		return this.cacheNames;
	}
	
	public void clearLocal(String cacheName, Object key) {
		Cache cache = cacheMap.get(cacheName);
		if(cache == null) {
			return ;
		}
		
		RedisEhcacheCache redisCaffeineCache = (RedisEhcacheCache) cache;
		redisCaffeineCache.clearLocal(key);
	}
}
