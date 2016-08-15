package ru.evgenydobrokvashin.learn.cuncurrency.multicorecource.hardwaremath.jmm.doublecheckedlocking.holder;


/**
 * Created by Stalker on 12.08.16.
 */
public class Singleton00 {
	private int state;

	private Singleton00(int state) {
		this.state = state;
		System.out.println("new");
	}

	public int getState() {
		return state;
	}

	private static class Holder {
		private static Singleton00 instance = new Singleton00(1);
	}

	public static Singleton00 getInstance() {
		return Holder.instance;
	}



	public static void test() {}
}

class Test {
	public static void main(String[] args) {
		//Singleton00.test();
		Singleton00.getInstance();
	}
}