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
public class Singleton0 {
	private int state;
	private Singleton0(int state) {
		this.state = state;
	}
	public int getState() {
		return this.state;
	}

	private static Singleton0 instance;
	public synchronized static Singleton0 getInstance() {
		if (null == instance) {
			instance = new Singleton0(1);
		}
		return instance;
	}
}