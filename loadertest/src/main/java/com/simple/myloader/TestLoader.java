package com.simple.myloader;

public class TestLoader {
	public int v1 = 1;

	public TestLoader() {
		System.out.println("load by :" + this.getClass().getClassLoader());
	}
}
