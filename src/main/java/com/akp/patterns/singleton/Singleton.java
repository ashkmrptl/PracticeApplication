package com.akp.patterns.singleton;

/**
 * This is a Thread safe singleton class
 * 
 * @author Ashish_Patel3
 *
 */
public class Singleton {
	private Singleton() {
	}

	private static Singleton singleton = null;

	/**
	 * Synchronizing this method will create performance problem as when multiple
	 * threads need the Singleton instance will have to wait until the lock is
	 * released
	 */
	/*
	 * public synchronized static Singleton getSingleton() { if(singleton == null) {
	 * singleton = new Singleton(); } return singleton; }
	 */

	/**
	 * Following method solves the performance issue caused by the synchronized
	 * method. Here as we are putting the code for creating the object object inside
	 * synchronized block. Hence it will not cause performance issue. Even this has
	 * some issues and before java 5 it may fail.
	 */
	/*public static Singleton getSingleton() {
		if (singleton == null) {
			synchronized (Singleton.class) {
				if (singleton == null) {
					singleton = new Singleton();
				}
			}
		}
		return singleton;
	}*/
	private static class InnerClass{
		private static final Singleton singleton = new Singleton();
	}
	
	public static Singleton getSingleton() {
		return InnerClass.singleton;
	}

}
