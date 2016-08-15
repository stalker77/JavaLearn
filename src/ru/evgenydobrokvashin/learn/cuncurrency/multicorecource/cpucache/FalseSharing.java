package ru.evgenydobrokvashin.learn.cuncurrency.multicorecource.cpucache;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Stalker on 01.08.16.
 */
public class FalseSharing {
	volatile static long value0 = 0;
	volatile static long value1 = 0;
	volatile static long value2 = 0;
	volatile static long value3 = 0;
	volatile static long value4 = 0;
	volatile static long value5 = 0;
	volatile static long value6 = 0;
	volatile static long value7 = 0;
	volatile static long value8 = 0;

	public static void main(String[] args) throws InterruptedException {
		ExecutorService pool = Executors.newFixedThreadPool(2);
		final CountDownLatch latch0 = new CountDownLatch(2);
//		final CountDownLatch latch1 = new CountDownLatch(1);
		final CountDownLatch latch2 = new CountDownLatch(2);
		pool.submit(new Callable<Void>() {
			@Override
			public Void call() throws Exception {
				latch0.countDown(); // thread #1 ready
				latch0.await();     // wait for start signal
				long t0 = System.nanoTime();
				for (int k = 0; k < 100_000_000; k++) {
					value0 = value0 * k;
				}
				long t1 = System.nanoTime();
				System.out.println((t1 - t0) / 1000000 + "ms");
				latch2.countDown(); // thread #1 finished
				return null;
			}
		});
		pool.submit(new Callable<Void>() {
			@Override
			public Void call() throws Exception {
				latch0.countDown(); // thread #2 ready
				latch0.await();     // wait for start signal
				long t0 = System.nanoTime();
				for (int k = 0; k < 100_000_000; k++) {
					value8 = value8 * k;
				}
				long t1 = System.nanoTime();
				System.out.println((t1 - t0) / 1000000 + "ms");
				latch2.countDown(); // thread #2 finished
				return null;
			}
		});

		//latch0.await();             // wait for #1 + #2 threads ready
		//latch1.countDown();         // start signal
		latch2.await();             // wait for #1 + #2 threads finished

		pool.shutdownNow();         // kill threa≤d pool
	}
}