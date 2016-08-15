/*
* This class...
*
* Created by Evgeny Dobrokvashin (aka Stalker) on 25.07.16 
*
* Copyright (c) 2016 MegaFon, All Rights Reserved.
*/

package ru.evgenydobrokvashin.learn.cuncurrency.javacore;

public class SingleElementBuffer {
	private Integer element = null;

	public synchronized void put(int newElement) throws InterruptedException {
		while (null != element) {
			this.wait();
		}

		this.element = newElement;
		this.notifyAll();
	}

	public synchronized int get() throws InterruptedException {
		while (null == element) {
			this.wait();
		}

		int result = this.element;
		this.element = null;
		this.notifyAll();
		return result;
	}
}
