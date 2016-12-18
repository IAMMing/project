package com.simple.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.simple.TestThread;

/**
 * 线程池学习
 * 
 * @author ldm
 *
 */
public class SingleThreadExcutor {
	public static void main(String[] args) {
		ExecutorService singlePool = Executors.newSingleThreadExecutor();
		singlePool.execute(new TestThread());
		singlePool.execute(new TestThread());
		singlePool.execute(new TestThread());
		singlePool.execute(new TestThread());
		singlePool.execute(new TestThread());

		System.out.println("t:" + singlePool.isTerminated());
		System.out.println("s:" + singlePool.isShutdown());
		System.out.println("======================================");
		singlePool.shutdown();

		System.out.println("t1:" + singlePool.isTerminated());
		System.out.println("s1:" + singlePool.isShutdown());
		System.out.println("======================================");
		try {

			while (!singlePool.awaitTermination(10, TimeUnit.SECONDS)) {
				// 如果线程没执行结束，继续执行
				System.out.println("继续执行...");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		singlePool.notify();
		
		System.out.println("t2:" + singlePool.isTerminated());
		System.out.println("s2:" + singlePool.isShutdown());
		System.out.println("======================================");

	}
}
