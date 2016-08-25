package ru.evgenydobrokvashin.learn.cuncurrency.multicorecource.juc.cyclicbarrier;

import java.util.Collections;
import java.util.concurrent.*;

/**
 * Created by Stalker on 23.08.16.
 */
public class App00 {
	public static void main(final String[] args) throws InterruptedException {
		final CountDownLatch latch = new CountDownLatch(2);
		final double[] array = new double[2001];
		array[500] = 1000000;
		final CyclicBarrier barrier = new CyclicBarrier(2, new Runnable() {
			@Override
			public void run() {
				array[1000] = (array[1000 - 1] + array[1000] + array[1000 + 1]) / 3;
			}
		});
		final ExecutorService pool = Executors.newFixedThreadPool(2);
		pool.submit(new Callable<Object>() {
			@Override
			public Void call() throws Exception {
				for (int count = 0; count < 10000; count++) {
					double[] newArray = new double[1000];
					for (int k = 1; k < 1000; k++) {
						newArray[k] = (array[k - 1] + array[k] + array[k + 1]) / 3;
					}
					System.arraycopy(newArray, 0, array, 0, 1000);
					barrier.await();
				}
				latch.countDown();
				return null;
			}
		});
		pool.submit(new Callable<Object>() {
			@Override
			public Void call() throws Exception {
				for (int count = 0; count < 10000; count++) {
					double[] newArray = new double[1000];
					for (int k = 1; k < 999; k++) {
						newArray[k] = (array[1001 + k - 1] + array[1001 + k] + array[1001 + k + 1]) / 3;
					}
					System.arraycopy(newArray, 0, array, 1001, 1000);
					barrier.await();
				}
				latch.countDown();
				return null;
			}
		});

		latch.await();
		for (int k = 0; k < 2001; k += 50) {
			String x = Collections.nCopies((int) array[k] / 100, " ").toString();
			System.out.println("|" + x.replace("[", "").replace("]", "").replace(" ", "*").replace(",", ""));
		}
	}
}
