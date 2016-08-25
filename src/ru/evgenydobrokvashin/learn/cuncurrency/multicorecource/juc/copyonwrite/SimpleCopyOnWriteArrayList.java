package ru.evgenydobrokvashin.learn.cuncurrency.multicorecource.juc.copyonwrite;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Stalker on 22.08.16.
 */
public class SimpleCopyOnWriteArrayList {
	private volatile Object[] array;
	/**  The lock protecting all mutators */
	private final ReentrantLock lock = new ReentrantLock();

	// one volatile read
	public boolean contains(Object key) {
		Object[] localRef = this.array;
		if (key == null) {
			for (Object elem : localRef) {
				if (elem == null) {
					return true;
				}
			}
		} else {
			for (Object elem: localRef) {
				if (key.equals(elem)) {
					return true;
				}
			}
		}
		return false;
	}

	// volatile read
	// ReentrantLock.lock()
	// volatile write
	// ReentrantLock.unlock()
	public void add(Object newElem) {
		Object[] localRef = this.array;
		lock.lock();
		try {
			Object[] newArray = Arrays.copyOf(localRef, localRef.length + 1);
			newArray[localRef.length] = newElem;
			array = newArray;
		} finally {
			lock.unlock();
		}
	}

	// one volatile read
	public List createSyncFreeCopy() {
		return null;
	}
}
