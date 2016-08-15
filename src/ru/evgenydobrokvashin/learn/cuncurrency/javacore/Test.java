/*
* This class...
*
* Created by Evgeny Dobrokvashin (aka Stalker) on 26.07.16 
*
* Copyright (c) 2016 MegaFon, All Rights Reserved.
*/

package ru.evgenydobrokvashin.learn.cuncurrency.javacore;

/**
 * @author Evgeny Dobrokvashin
 *         <p/>
 *         Created by Stalker on 26.07.16.
 * @version 1.0 Jul 2016
 */
public class Test {
	public static void main(String[] args) throws InterruptedException {
		while (true) {
			System.out.println("sleep");
			Thread.sleep(5000);
			System.out.println("wake up");
			double d = 2;
			for (int k = 0; k < 50_000_000; k++) {
				d = Math.sin(d);
			}
		}
	}
}
