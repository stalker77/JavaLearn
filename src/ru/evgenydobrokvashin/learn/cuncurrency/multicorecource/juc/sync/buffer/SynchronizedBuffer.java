/*
* This class...
*
* Created by Evgeny Dobrokvashin (aka Stalker) on 25.07.16 
*
* Copyright (c) 2016 MegaFon, All Rights Reserved.
*/

package ru.evgenydobrokvashin.learn.cuncurrency.multicorecource.juc.sync.buffer;

public class SynchronizedBuffer<T> {
	private T elem = null;
	private Object lock = new Object();

	public void put(T newElement) throws InterruptedException {
		synchronized(lock) {
			while (null != elem) {
				lock.wait();
			}

			elem = newElement;
			lock.notifyAll();
		}
	}

	public T take() throws InterruptedException {
		synchronized(lock) {
			while (null == elem) {
				lock.wait();
			}

			T tmp = elem;
			elem = null;
			lock.notifyAll();
			return tmp;
		}
	}
}
