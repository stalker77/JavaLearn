package ru.evgenydobrokvashin.learn.cuncurrency.multicorecource.hardwaremath.jmm.doublecheckedlocking.valatile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Stalker on 12.08.16.
 */
public class Singleton01 {
	private List<Integer> state;
	public Singleton01(List<Integer> state) {
		this.state = state;
	}

	public List<Integer> getState() {
		return state;
	}

	private static volatile Singleton01 instance;
	public static Singleton01 getInstance() {
		if (null == instance) {
			instance = new Singleton01(Collections.synchronizedList(new ArrayList<Integer>()));
		}
		return instance;
	}
}
