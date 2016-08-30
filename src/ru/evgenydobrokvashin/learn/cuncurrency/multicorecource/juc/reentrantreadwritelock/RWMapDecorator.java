package ru.evgenydobrokvashin.learn.cuncurrency.multicorecource.juc.reentrantreadwritelock;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Stalker on 25.08.16.
 */
public class RWMapDecorator<K, V> implements java.util.Map<K, V> {
	private final Map<K, V> origin;
	private final ReadWriteLock rwLock = new ReentrantReadWriteLock(true);
	private final Lock rLock = rwLock.readLock();
	private final Lock wLock = rwLock.writeLock();

	public RWMapDecorator(Map<K, V> origin) {
		this.origin = origin;
	}

	@Override
	public int size() {
		rLock.lock();
		try {
			return origin.size();
		} finally {
			rLock.unlock();
		}
	}

	@Override
	public boolean isEmpty() {
		rLock.lock();
		try {
			return origin.isEmpty();
		} finally {
			rLock.unlock();
		}
	}

	@Override
	public boolean containsKey(Object key) {
		rLock.lock();
		try {
			return origin.containsKey(key);
		} finally {
			rLock.unlock();
		}
	}

	@Override
	public boolean containsValue(Object value) {
		rLock.lock();
		try {
			return origin.containsValue(value);
		} finally {
			rLock.unlock();
		}
	}

	@Override
	public V get(Object key) {
		rLock.lock();
		try {
			return origin.get(key);
		} finally {
			rLock.unlock();
		}
	}

	@Override
	public V put(K key, V value) {
		wLock.lock();
		try {
			return origin.put(key, value);
		} finally {
			wLock.unlock();
		}
	}

	@Override
	public V remove(Object key) {
		wLock.lock();
		try {
			return origin.remove(key);
		} finally {
			wLock.unlock();
		}
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		wLock.lock();
		try {
			origin.putAll(m);
		} finally {
			wLock.unlock();
		}
	}

	@Override
	public void clear() {
		wLock.lock();
		try {
			origin.clear();
		} finally {
			wLock.unlock();
		}
	}

	@Override
	public Set<K> keySet() {
		rLock.lock();
		try {
			return origin.keySet();
		} finally {
			rLock.unlock();
		}
	}

	@Override
	public Collection<V> values() {
		rLock.lock();
		try {
			return origin.values();
		} finally {
			rLock.unlock();
		}
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		rLock.lock();
		try {
			return origin.entrySet();
		} finally {
			rLock.unlock();
		}
	}
}
