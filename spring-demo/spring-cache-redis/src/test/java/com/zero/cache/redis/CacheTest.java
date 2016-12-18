package com.zero.cache.redis;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zero.cache.redis.config.SpringConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringConfig.class })
public class CacheTest {
	@Resource
	GetTime getTime;

	@Test
	public void testCache() {
		System.out.println(System.currentTimeMillis());
		System.out.println("time:" + getTime.getTimespan());
		try {
			Thread.sleep(10 * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(System.currentTimeMillis());
		System.out.println("time:" + getTime.getTimespan());
		System.out.println("put:" + getTime.putTimespan());
		System.out.println("time:" + getTime.getTimespan());

	}

	@Test
	public void testTimeString() {
		System.out.println(System.currentTimeMillis());
		System.out.println("time:" + getTime.getTime());
	}

	@Test
	public void testTimeEntry() {
		System.out.println(System.currentTimeMillis());
		// System.out.println("time:" +
		// JSONObject.valueToString(getTime.getEntry()));
	}

	@Test
	public void testTimeEntryStr() {
		System.out.println(System.currentTimeMillis());
		System.out.println("time:" + getTime.getEntryStr());
	}

	@Test
	public void testTimeEntryStr2() {
		System.out.println(System.currentTimeMillis());
		System.out.println("time:" + getTime.getEntryStr2());
	}
}