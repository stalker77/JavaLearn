package ru.evgenydobrokvashin.learn.cuncurrency.multicorecource.juc.copyonwrite;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by Stalker on 22.08.16.
 */
public class App00 {
	List<String> list = new CopyOnWriteArrayList<>();
	Set<String> set = new CopyOnWriteArraySet<>();
}
