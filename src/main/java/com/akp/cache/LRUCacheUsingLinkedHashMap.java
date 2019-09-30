package com.akp.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/*
 * Cache should support fast look-up, so HashTable or HashMap is best choice for implementing.
 * Also, the insert and delete operation should be in O(1), and the best choice for this is LinkedList.
 * 
 */
public class LRUCacheUsingLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
	private static final long serialVersionUID = 6640774452670725286L;
	private int cacheSize;

	public LRUCacheUsingLinkedHashMap(int size) {
		super(size, 0.75f, true);
		System.out.println("size is : " + size);
		cacheSize = size;
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		return super.size() > cacheSize;
	}

	public static void main(String[] args) {
		LRUCacheUsingLinkedHashMap<Integer, String> cache = new LRUCacheUsingLinkedHashMap<>(4);

		cache.put(1, "a");
		cache.put(2, "b");
		cache.put(3, "c");
		cache.put(4, "d");
		cache.put(5, "e");
		cache.put(1, "f");
		System.out.println(cache);
	}
}
