package ru.evgenydobrokvashin.learn.cuncurrency.multicorecource.hardwaremath.jmm.doublecheckedlocking.valatile;

/**
 * Created by Stalker on 10.08.16.
 */
// ПОТОКОЗАЩИЩЕННАЯ ИНИЦИАЛИЗАЦИЯ (thread-safe publishing):
// ...Всегда видим инициализированное Singleton.getInstance()!=null: Да
// ...Всегда видим инициализированное Singleton.getInstance().getState()==1: Да
// СИНГЛЕТОННОСТЬ (базове качества):
// ...Будет создан едиственный экземпляр Singleton: Нет
// ...Все видят один и тотже экземпляр Singleton: Нет
// СИНГЛЕТОННОСТЬ (дополнительные качества):
// ... Ленивая инициализация: Да
// - // Доступ Singleton.getInstance() обходится без синхронизации: Нет
// - // Доступ Singleton.getState() обходится без синхронизации: Да
// НЕИЗМЕННОСТЬ (immutability):
// ... Нельзя изменить поле instance: Нет
// ... Нельзя изменить поле state: Нет
public class Singleton00 {
	private int state;
	private Singleton00(int state) {
		this.state = state;
	}
	public int getState() {
		return this.state;
	}

	private static volatile Singleton00 instance;
	public synchronized static Singleton00 getInstance() {
		if (null == instance) {
			instance = new Singleton00(1);
		}
		return instance;
	}
}