package ru.evgenydobrokvashin.learn.cuncurrency.multicorecource.hardwaremath.jmm.doublecheckedlocking.sync;

/**
 * Created by Stalker on 10.08.16.
 */
// ПОТОКОЗАЩИЩЕННАЯ ИНИЦИАЛИЗАЦИЯ (thread-safe publishing):
// ...Всегда видим инициализированное Singleton.getInstance()!=null: Да
// ...Всегда видим инициализированное Singleton.getInstance().getState()==1: Да
// СИНГЛЕТОННОСТЬ (базове качества):
// ...Будет создан едиственный экземпляр Singleton: Да
// ...Все видят один и тотже экземпляр Singleton: Да
// СИНГЛЕТОННОСТЬ (дополнительные качества):
// ... Ленивая инициализация: Да
// - // Доступ Singleton.getInstance() обходится без синхронизации: Нет
// - // Доступ Singleton.getState() обходится без синхронизации: Да
// НЕИЗМЕННОСТЬ (immutability):
// ... Нельзя изменить поле instance: Да
// ... Нельзя изменить поле state: Да
public class Singleton1 {
	private Singleton1() { }

	private static Singleton1 instance;
	public static Singleton1 getInstance() {
		Singleton1 tmp = instance;
		if (null == tmp) {
			synchronized (Singleton1.class) {
				if (null == instance) {
					tmp = new Singleton1();
					instance = tmp;
				}
			}
		}
		return tmp; // НЕ МОЖЕТ ВЕРНУТЬ null
	}
}