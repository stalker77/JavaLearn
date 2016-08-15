/*
* This class...
*
* Created by Evgeny Dobrokvashin (aka Stalker) on 25.07.16 
*
* Copyright (c) 2016 MegaFon, All Rights Reserved.
*/

package ru.evgenydobrokvashin.learn.cuncurrency.javacore;

public class ProducerConsumerEx_3x2 {
	public static void main(String[] args) throws InterruptedException {
		SingleElementBuffer buffer = new SingleElementBuffer();

		new Thread(new Producer(buffer, 1, 300)).start();
		new Thread(new Producer(buffer, 100, 500)).start();
		new Thread(new Producer(buffer, 1000, 700)).start();

		new Thread(new Consumer(buffer)).start();
		new Thread(new Consumer(buffer)).start();
	}
}
