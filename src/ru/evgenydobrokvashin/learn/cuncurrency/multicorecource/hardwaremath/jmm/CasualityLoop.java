package ru.evgenydobrokvashin.learn.cuncurrency.multicorecource.hardwaremath.jmm;

/**
 * Created by Stalker on 05.08.16.
 */
// "out of thin air" == "из воздуха"
public class CasualityLoop {
	static int x = 0;
	static int y = 0;

	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				if (x == 1) {
					y = 1;
				}
			}
		}).start();

		if (y == 1) {
			x = 1;
		}

		System.out.println(x); // 0
		System.out.println(y); // 0
	}
}
