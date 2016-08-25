package ru.evgenydobrokvashin.learn.cuncurrency.multicorecource.juc.sync.api;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Stalker on 16.08.16.
 */
public class App21_wait_set_x {
	public static void main(String[] args) throws InterruptedException {
		final Object lock = new Object();
		Thread newThread = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (lock) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						throw new Error("NEVER!");
					}
				}
			}
		});
		newThread.start();

		Thread.sleep(1000);
		synchronized (lock) {
			lock.notify();
			System.out.println(newThread.getState());
		}
	}
}
