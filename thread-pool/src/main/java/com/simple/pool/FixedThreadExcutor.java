package com.simple.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.simple.TestThread;

public class FixedThreadExcutor {
	static ExecutorService fixedPool = Executors.newFixedThreadPool(4);
	public static void main(String[] args) {
		fixedPool.execute(new TestThread());
		fixedPool.execute(new TestThread());
		fixedPool.execute(new TestThread());
		fixedPool.execute(new TestThread());
		fixedPool.execute(new TestThread());
		fixedPool.execute(new TestThread());
		fixedPool.execute(new TestThread());
		fixedPool.execute(new TestThread());
		fixedPool.execute(new TestThread());
		fixedPool.execute(new TestThread());

		System.out.println("t:" + fixedPool.isTerminated());
		System.out.println("s:" + fixedPool.isShutdown());
		System.out.println("======================================");
		fixedPool.shutdown();

		System.out.println("t1:" + fixedPool.isTerminated());
		System.out.println("s1:" + fixedPool.isShutdown());
		System.out.println("======================================");
		try {

			while (!fixedPool.awaitTermination(10, TimeUnit.SECONDS)) {
				// 如果线程没执行结束，继续执行
				System.out.println("继续执行...");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fixedPool.notify();
		System.out.println("t2:" + fixedPool.isTerminated());
		System.out.println("s2:" + fixedPool.isShutdown());
		System.out.println("======================================");
	}
}
