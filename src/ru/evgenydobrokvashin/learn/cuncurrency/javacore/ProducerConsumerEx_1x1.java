/*
* This class...
*
* Created by Evgeny Dobrokvashin (aka Stalker) on 25.07.16 
*
* Copyright (c) 2016 MegaFon, All Rights Reserved.
*/

package ru.evgenydobrokvashin.learn.cuncurrency.javacore;

public class ProducerConsumerEx_1x1 {
	public static void main(String[] args) throws InterruptedException {
		SingleElementBuffer buffer = new SingleElementBuffer();
		new Thread(new Producer(buffer, 1, 1000)).start();
		Thread.sleep(5000);
		new Thread(new Consumer(buffer)).start();
	}
}
