package ru.evgenydobrokvashin.learn.cuncurrency.multicorecource.hardwaremath.jmm.doublecheckedlocking.atomiccas;

import java.util.concurrent.atomic.AtomicReference;

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
// ... Нельзя изменить поле instance: Да
// ... Нельзя изменить поле state: Да
public class Singleton01 {
	private int state;
	private Singleton01(int state) {
		this.state = state;
	}
	public int getState() {
		return this.state;
	}

	private static AtomicReference<Singleton01> instance = new AtomicReference<>();
	public synchronized static Singleton01 getInstance() {
		// полный аналог volatile
		if (instance.get() == null) {
			instance.set(new Singleton01(1));
		}
		return instance.get();
	}
}