package cn.simple.threaddemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPoolDemo {
	ReentrantLock reentrantLock = new ReentrantLock();
	public static void main(String[] args) {
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(2);
		newFixedThreadPool.submit(new Runnable() {

			public void run() {
				for (int i = 0; i < 3; i++) {

					System.out.println("t1");
				}
			}
		});
		newFixedThreadPool.submit(new Runnable() {

			public void run() {
				for (int i = 0; i < 3; i++) {

					System.out.println("t2");
				}
			}
		});
		newFixedThreadPool.shutdown();
//		reentrantLock.lock();
//		reentrantLock.unlock();
	}
}
