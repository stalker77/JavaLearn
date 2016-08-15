/*
* This class...
*
* Created by Evgeny Dobrokvashin (aka Stalker) on 25.07.16 
*
* Copyright (c) 2016 MegaFon, All Rights Reserved.
*/

package ru.evgenydobrokvashin.learn.cuncurrency.javacore;

public class Consumer implements Runnable {
	private final SingleElementBuffer buffer;

	public Consumer(SingleElementBuffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		while(true) {
			try {
				int element = buffer.get();
				System.out.println(element + " consumed.");
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName() + " stopped.");
			}
		}
	}
}
