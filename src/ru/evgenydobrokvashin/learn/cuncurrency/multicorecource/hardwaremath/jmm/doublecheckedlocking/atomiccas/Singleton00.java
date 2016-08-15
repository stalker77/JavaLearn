package ru.evgenydobrokvashin.learn.cuncurrency.multicorecource.hardwaremath.jmm.doublecheckedlocking.atomiccas;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by Stalker on 10.08.16.
 */
public class Singleton00 {
	private int state;
	private Singleton00(int state) {
		this.state = state;
	}
	public int getState() {
		return this.state;
	}

	private static AtomicReference<Singleton00> instance = new AtomicReference<>();
	public synchronized static Singleton00 getInstance() {
		if (instance.get() == null) {
			instance.compareAndSet(null, new Singleton00(1)); // CAS
		}
		return instance.get();
	}
}