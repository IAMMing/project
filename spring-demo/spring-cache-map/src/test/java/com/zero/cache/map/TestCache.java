package com.zero.cache.map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zero.cache.map.config.SpringConfig;
import com.zero.cacheeasy.map.ExecBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringConfig.class })
public class TestCache {

	@Autowired
	GetTime getTime;

	@Autowired
	ExecBean execBean;

	@Test
	public void testEasy() {
		System.out.println(System.currentTimeMillis());
		System.out.println("第一次调用"+execBean.getTime());
		System.out.println("============================");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(System.currentTimeMillis());
		System.out.println("第二次调用"+execBean.getTime());
	}

	@Test
	public void testMap() {
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
	}

	@Test
	public void testAop() {
		System.out.println("==========" + getTime.testAop());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("=====**=====" + getTime.testAop());
	}
}
