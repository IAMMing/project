package com.zero.cacheeasy.map;

import org.springframework.stereotype.Component;

import com.zero.cacheeasy.core.annonation.Cacheable;
import com.zero.cacheeasy.core.enums.CacheContainer;
@Component
public class ExecBean {

	@Cacheable(key = "org.cacheeasy.map.ExecBean.getTime", container = CacheContainer.MAP)
	public long getTime() {
		long curr = System.currentTimeMillis();
		System.out.println(curr);
		return curr;
	}
}
