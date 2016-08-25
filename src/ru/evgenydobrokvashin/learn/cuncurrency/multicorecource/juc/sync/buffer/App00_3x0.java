package ru.evgenydobrokvashin.learn.cuncurrency.multicorecource.juc.sync.buffer;

/**
 * Created by Stalker on 19.08.16.
 */
public class App00_3x0 {
	public static void main(String[] args) {
		final SynchronizedBuffer<String> buffer = new SynchronizedBuffer<>();
		// WRITER
		for (int k = 0; k < 3; k++) {
			final int finalK = k;
			new Thread(new Runnable() {
				@Override
				public void run() {
					for (char c = 'A'; c <= 'Z'; c++) {
						String value = "" + c + finalK;
						System.err.println(value + ".");
						try {
							buffer.put(value);
						} catch (InterruptedException e) { /*NOP*/ }
						System.err.println(value + "->");
					}
				}
			}).start();
		}
	}
}
