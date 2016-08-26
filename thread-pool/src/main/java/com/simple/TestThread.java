package com.simple;

public class TestThread implements Runnable {

	public void run() {
		System.out.println(Thread.currentThread().getId() + "\t执行中...");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
