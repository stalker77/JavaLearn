package ru.evgenydobrokvashin.learn.cuncurrency.multicorecource.hardwaremath.jmm.doublecheckedlocking.valatile;

/**
 * Created by Stalker on 12.08.16.
 */
// может быть
// [0]
// [1]
public class Singleton01Demo0 {
	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				Singleton01 instance = Singleton01.getInstance();
				instance.getState().add(0);
				System.out.println(instance.getState());
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				Singleton01 instance = Singleton01.getInstance();
				instance.getState().add(1);
				System.out.println(instance.getState());
			}
		}).start();
	}
}
