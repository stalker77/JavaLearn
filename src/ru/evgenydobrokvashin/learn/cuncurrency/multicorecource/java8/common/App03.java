package ru.evgenydobrokvashin.learn.cuncurrency.multicorecource.java8.common;

/**
 * Created by Stalker on 30.08.16.
 */
public class App03 {
	public static void main(String[] args) {
		new Thread(App03::f).start();
	}

	public static void f(int k) {
		System.out.println("Hello!");
	}
}
