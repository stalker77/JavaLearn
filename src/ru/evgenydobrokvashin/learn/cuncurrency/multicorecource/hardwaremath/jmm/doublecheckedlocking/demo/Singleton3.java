package ru.evgenydobrokvashin.learn.cuncurrency.multicorecource.hardwaremath.jmm.doublecheckedlocking.demo;

/**
 * Created by Stalker on 10.08.16.
 */
// Singleton2.getInstance()
public class Singleton3 {
	private Singleton3() {}

	private static Singleton3 instance;
	public static Singleton3 getInstance() {
		if (null == instance) {
			synchronized (Singleton3.class) {
				if (null == instance) {
					instance = new Singleton3();
				}
			}
		}
		return instance; // МОЖЕТ ВЕРНУТЬ null из-за спецификации JMM (повторное чтение переенной без happends-before может прочитать старое значение)
	}
}
