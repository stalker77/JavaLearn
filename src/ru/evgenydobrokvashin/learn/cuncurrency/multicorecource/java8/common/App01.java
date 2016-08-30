package ru.evgenydobrokvashin.learn.cuncurrency.multicorecource.java8.common;

/**
 * Created by Stalker on 30.08.16.
 */
public class App01 {
	public static void main(String[] args) {
		new Thread(App01::run).start();
	}

	public static void run() {
		System.out.println("Hello!");
	}
}
