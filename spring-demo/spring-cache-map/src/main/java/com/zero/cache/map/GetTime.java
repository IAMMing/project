package com.zero.cache.map;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * 
 * GetTime.java
 * 
 * @description 测试bean
 * @author ldm
 * @date 2016年12月18日
 * @detail 用户测试缓存
 */
@Component
public class GetTime {

	@Cacheable(value = { "com.zero.cache.map.GetTime.getTimespan" })
	public long getTimespan() {
		System.out.println("第一次调用：" + System.currentTimeMillis());
		return System.currentTimeMillis();
	}

	public String testAop() {
		System.out.println(System.currentTimeMillis());
		return "testAop";
	}
}
