package ru.evgenydobrokvashin.learn.cuncurrency.multicorecource.java8.common;

/**
 * Created by Stalker on 30.08.16.
 */
public class App00 {
	public static void main(String[] args) {
		/*new Thread(new Runnable() {
			@Override
			public void f() {
				System.out.println("Hello!");
			}
		}).start();*/

		new Thread(() -> System.out.println("Hello!")).start();

		Runnable r = () -> System.out.println("Hello!");
		X x = () -> System.out.println("Hello!");
	}
}

interface X {
	public void run() throws Exception;
}
