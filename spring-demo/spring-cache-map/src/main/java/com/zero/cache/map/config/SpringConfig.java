package com.zero.cache.map.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * 
 * SpringConfig.java
 * 
 * @description 配置类
 * @author ldm
 * @date 2016年12月18日
 */
@Configuration
@ComponentScan(basePackages = "com.zero.cache.map")
@ImportResource(locations = { "classpath:aop.xml" })
public class SpringConfig {
	@Bean
	public CacheManager cacheManager() {
		return new ConcurrentMapCacheManager();
	}
}
