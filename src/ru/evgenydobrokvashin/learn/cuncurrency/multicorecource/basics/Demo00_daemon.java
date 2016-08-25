package ru.evgenydobrokvashin.learn.cuncurrency.multicorecource.basics;

/**
 * Created by Stalker on 19.08.16.
 */
public class Demo00_daemon {
	public static void main(String[] args) {
		Thread newThread = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) ;
			}
		});
		newThread.setDaemon(true);
		newThread.start();

		System.out.println("Bye!");
	}
}
