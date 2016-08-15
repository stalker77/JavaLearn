package ru.evgenydobrokvashin.learn.cuncurrency.multicorecource.juc.sync.api;

/**
 * Created by Stalker on 15.08.16.
 */
public class App00_naked_call {
	public static void main(String[] args) throws InterruptedException {
		Object lock = new Object();

		lock.wait();
//		lock.notify();
//		lock.notifyAll();
	}
}
