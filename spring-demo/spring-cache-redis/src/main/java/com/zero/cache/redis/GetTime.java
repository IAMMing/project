package com.zero.cache.redis;

import java.io.Serializable;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

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

	@CachePut(value = { "com.zero.cache.map.GetTime", "com.zero.cache.map.GetTime.getTimespan" }, key = "#result")
	public long putTimespan() {
		System.out.println("设置缓存：" + System.currentTimeMillis());
		return System.currentTimeMillis();
	}

	@Cacheable(value = { "com.zero.cache.map.GetTime.getTimespan" })
	public String getTime() {
		return "2016-12-18";
	}

	@Cacheable(value = { "com.zero.cache.map.GetTime.getTimespan" })
	public TimeEntry getEntry() {
		return new TimeEntry();
	}

	@Cacheable(value = { "com.zero.cache.map.GetTime.getTimespan" })
	public String getEntryStr() {
		System.out.println(JSON.toJSONString(new TimeEntry()));
		return JSON.toJSONString(new TimeEntry());
	}
	@CachePut(value = { "aa" })
	public String getEntryStr2() {
		System.out.println(JSON.toJSONString(new TimeEntry()));
		return JSON.toJSONString(new TimeEntry());
	}

	public class TimeEntry implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = -8704117752543575146L;
		public String t = "2016-12-18";
		public long l = System.currentTimeMillis();
	}
}