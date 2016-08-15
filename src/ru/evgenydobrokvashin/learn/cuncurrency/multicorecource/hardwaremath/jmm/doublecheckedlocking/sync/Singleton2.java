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
public class Singleton2 {
	private int state;
	private Singleton2(int state) {
		this.state = state;
	}
	public int getState() {
		return state; // может вернуть 0
	}

	private static Singleton2 instance;
	public static Singleton2 getInstance() {
		Singleton2 tmp = instance;
		if (null == tmp) {
			synchronized (Singleton2.class) {
				if (null == instance) {
					tmp = new Singleton2(1);
					instance = tmp;
				}
			}
		}
		return tmp; // НЕ МОЖЕТ ВЕРНУТЬ null
	}
}