package ru.evgenydobrokvashin.test;

import java.util.HashMap;

/**
 * Created by Stalker on 29.07.16.
 */
public class TestSwitchVsHashMapVsAL {
	private static final HashMap<Integer, Intrf> commands;
	static {
		commands = new HashMap<>();
		for (int i = 0; i < 1000; i++) {
			commands.put(i, new Intrf() {
				@Override
				public void run() {
					System.out.println("Knock");
				}
			});
		}
	}

	public static void main(String[] args) {
		long time = System.nanoTime();
		testSwitch(1);
		System.out.println("switch1:" + (System.nanoTime() - time));

		time = System.nanoTime();
		testHashMap(1);
		System.out.println("HM1:" + (System.nanoTime() - time));

		time = System.nanoTime();
		testArrayList(1);
		System.out.println("AL1:" + (System.nanoTime() - time));

		time = System.nanoTime();
		testSwitch(9);
		System.out.println("switch9:" + (System.nanoTime() - time));

		time = System.nanoTime();
		testHashMap(999);
		System.out.println("HM9:" + (System.nanoTime() - time));

		time = System.nanoTime();
		testArrayList(9);
		System.out.println("AL9:" + (System.nanoTime() - time));

	}

	private static void testArrayList(int code) {

	}

	private static void testHashMap(int code) {
		Intrf i = commands.get(code);
		i.run();
	}

	private static void testSwitch(int code) {
		switch (code) {
			case 0:
				System.out.println("Knock");
				break;
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				break;
			case 9:
				System.out.println("Knock");
				break;
		}
	}
}

interface Intrf {
	public void run();
}