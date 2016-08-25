package ru.evgenydobrokvashin.learn.cuncurrency.multicorecource.juc.reentrantreadwritelock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Stalker on 25.08.16.
 */
public class ReentrantReadWriteLockDemo {
	public static void main(String[] args) {
		// read/write lock
		// shared/exclusive lock
		ReadWriteLock lock = new ReentrantReadWriteLock(true);
		Lock rLock = lock.readLock();
		Lock rLock2 = lock.readLock();
		Lock wLock = lock.writeLock();
		Lock wLock2 = lock.writeLock();
		System.out.println(rLock == rLock2);
		System.out.println(wLock == wLock2);

	}
}
