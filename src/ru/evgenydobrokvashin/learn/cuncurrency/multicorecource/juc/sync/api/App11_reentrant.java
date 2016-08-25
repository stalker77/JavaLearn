package ru.evgenydobrokvashin.learn.cuncurrency.multicorecource.juc.sync.api;

/**
 * Created by Stalker on 16.08.16.
 */
public class App11_reentrant {
	public static void main(String[] args) {
		Object lock = new Object();
		synchronized (lock) {
			synchronized (lock) {
				synchronized (lock) {
					f();
				}
			}
		}
	}

	private synchronized static void f() {
		g();
	}

	private synchronized static void g() {
		h();
	}

	private synchronized static void h() { }
}
