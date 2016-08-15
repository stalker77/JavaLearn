/*
* This class...
*
* Created by Evgeny Dobrokvashin (aka Stalker) on 25.07.16 
*
* Copyright (c) 2016 MegaFon, All Rights Reserved.
*/

package ru.evgenydobrokvashin.learn.cuncurrency.javacore;

/**
 * @author Evgeny Dobrokvashin
 *         <p/>
 *         Created by Stalker on 25.07.16.
 * @version 1.0 Jul 2016
 */
public class Producer implements Runnable {
	private final SingleElementBuffer buffer;

	private int startElement;

	private final int period;

	public Producer(SingleElementBuffer buffer, int startElement, int period) {
		this.buffer = buffer;
		this.startElement = startElement;
		this.period = period;
	}

	@Override
	public void run() {
		while (true) {
			try {
				System.out.println(startElement + " produced.");
				buffer.put(startElement++);
				Thread.sleep(period);
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName() + " stopped.");
			}
		}
	}
}
