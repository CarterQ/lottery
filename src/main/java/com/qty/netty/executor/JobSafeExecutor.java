package com.qty.netty.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class JobSafeExecutor {
	private static final ScheduledExecutorService EXECUTOR = Executors.newScheduledThreadPool(10);
	private static LinkedBlockingQueue<Object> blockingQueue = new LinkedBlockingQueue<Object>(3);
	
	public static boolean execut(Object object) throws InterruptedException{
		return blockingQueue.offer(object,5,TimeUnit.SECONDS);
	}
	public static void main(String[] args) throws InterruptedException {
		EXECUTOR.execute(new Runnable() {
			@Override
			public void run() {
				for(;;){
					try {
						System.out.println("EXECUTOR---"+blockingQueue.take().toString());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		JobSafeExecutor.execut("1");
		JobSafeExecutor.execut("2");
		JobSafeExecutor.execut("3");
		Thread.sleep(1000);
		System.out.println(blockingQueue.size()+"--"+JobSafeExecutor.execut("4"));
	}
	
}
