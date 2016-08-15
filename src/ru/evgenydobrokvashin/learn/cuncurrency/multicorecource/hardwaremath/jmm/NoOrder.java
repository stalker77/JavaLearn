package ru.evgenydobrokvashin.learn.cuncurrency.multicorecource.hardwaremath.jmm;

/**
 * Created by Stalker on 05.08.16.
 */
public class NoOrder {
	static int x = 0;
	static int y = 0;

	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				// this code may out to console any from following results:
				// y=0 x=0
				// y=0 x=1
				// y=1 x=1
				// y=1 x=0 !!!
				System.out.println(" y=" + y);
				System.out.println(" x=" + x);
			}
		}).start();

		x = 1;
		y = 1;
	}
}
