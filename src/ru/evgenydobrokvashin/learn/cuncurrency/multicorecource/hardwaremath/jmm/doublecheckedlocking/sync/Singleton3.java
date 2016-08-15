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
public class Singleton3 {
	private final int state;
	private Singleton3(int state) {
		this.state = state;
	}
	public int getState() {
		return state; // НЕ может вернуть 0
	}

	private static Singleton3 instance;
	public static Singleton3 getInstance() {
		Singleton3 tmp = instance;
		if (null == tmp) {
			synchronized (Singleton3.class) {
				if (null == instance) {
					tmp = new Singleton3(1);
					instance = tmp;
				}
			}
		}
		return tmp; // НЕ МОЖЕТ ВЕРНУТЬ null
	}
}