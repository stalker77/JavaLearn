package ru.evgenydobrokvashin.learn.cuncurrency.multicorecource.hardwaremath.jmm.doublecheckedlocking.demo;

/**
 * Created by Stalker on 10.08.16.
 */
// Singleton2.getInstance()
public class Singleton2 {
	private Singleton2() {}

	private static Singleton2 instance;
	public synchronized static Singleton2 getInstance() {
		if (null == instance) {
			instance = new Singleton2();
		}
		return instance;
	}
}
