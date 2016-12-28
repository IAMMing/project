package com.zero.cacheeasy.core.factory;

/**
 * 
 * CacheManager.java
 * 
 * @description 缓存管理器
 * @author ldm
 * @date 2016年12月29日
 * @detail
 */
public interface EasyCacheManager {
	/**
	 * 判断是否有当key的缓存
	 * 
	 * @param key
	 * @return
	 */
	boolean hasCache(String key);

	/**
	 * 缓存值
	 * 
	 * @param key
	 * @param cacheValue
	 * @return
	 */
	boolean putCache(String key, Object cacheValue);

	/**
	 * 获取缓存值
	 * 
	 * @param key
	 * @return
	 */
	String getCache(String key);
}
