package com.zero.cacheeasy.map;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import com.zero.cacheeasy.core.factory.EasyCacheManager;

@Component
public class MapManager implements EasyCacheManager {
	static ConcurrentHashMap<String, String> cacheMap = new ConcurrentHashMap<>();

	@Override
	public boolean hasCache(String key) {
		return cacheMap.containsKey(key);
	}

	@Override
	public boolean putCache(String key, Object cacheValue) {
		cacheMap.put(key, String.valueOf(cacheValue));
		return true;
	}

	@Override
	public String getCache(String key) {
		return cacheMap.get(key);
	}

}
