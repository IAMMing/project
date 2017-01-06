package com.cacheeasy.map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zero.cacheeasy.map.ExecBean;
import com.zero.cacheeasy.map.SpringConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringConfig.class })
public class TestCache {
	@Resource
	ExecBean execBean;

	@Test
	public void testTime() {
		System.out.println(System.currentTimeMillis());
		System.out.println(execBean.getTime());
		System.out.println("============================");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(System.currentTimeMillis());
		System.out.println(execBean.getTime());
	}
}
