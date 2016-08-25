package ru.evgenydobrokvashin.learn.cuncurrency.multicorecource.juc.sync.api;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Stalker on 16.08.16.
 */
public class App21_wait_set {
	public static void main(String[] args) throws InterruptedException {
		final Object lock = new Object();
		final CountDownLatch latch = new CountDownLatch(1);
		Thread newThread = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (lock) {
					latch.countDown();
					try {
						lock.wait();
					} catch (InterruptedException e) {
						throw new Error("NEVER!");
					}
				}
			}
		});
		newThread.start();

		latch.await();
		synchronized (lock) {
			lock.notify();
			System.out.println(newThread.getState());
			lock.notify();
		}
	}
}
