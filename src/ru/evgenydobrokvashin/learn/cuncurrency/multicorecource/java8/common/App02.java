package ru.evgenydobrokvashin.learn.cuncurrency.multicorecource.java8.common;

/**
 * Created by Stalker on 30.08.16.
 */
public class App02 {
	public static void main(String[] args) {
		new Thread(App02::f).start();
	}

	public static void f() throws Exception {
		System.out.println("Hello!");
	}
}
