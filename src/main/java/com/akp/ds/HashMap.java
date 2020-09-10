package com.akp.ds;

import lombok.ToString;

@ToString
public class HashMap<K, V> {

    @ToString
    public static class Entry<K, V> {
        private Entry<K, V> next;
        private final K key;
        private V value;

        public Entry(final K key, final V value) {
            this.key = key;
            this.value = value;
        }
    }

    final int size;
    final Entry<K, V>[] entries;

    public HashMap() {
        size = 16;
        entries = new Entry[size];
    }

    public V put(final K key, final V value) {
        final int keyHash = key.hashCode();
        final int index = Math.abs(keyHash % size);

        final Entry<K, V> entry = entries[index];

        if (entry != null) { // Collision
            for (Entry<K, V> e = entries[index]; e != null; e = e.next) {
                if (e.key.equals(key)) {
                    final V tempVal = e.value;
                    e.value = value;
                    return tempVal;
                } else if (e.next == null) {// Reached end - Add new entry to the list
                    e.next = new Entry<>(key, value);
                }
            }
        } else { // Add new entry
            final Entry<K, V> newEntry = new Entry<>(key, value);
            entries[index] = newEntry;
        }

        return null;
    }

    public V get(final K key) {
        final int hash = key.hashCode();
        final int index = Math.abs(hash % size);

        final Entry<K, V> entry = entries[index];

        if (entry != null) {
            for (Entry<K, V> e = entries[index]; e != null; e = e.next) {
                if (e.key.equals(key)) {
                    return e.value;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        final HashMap<String, Integer> map = new HashMap<>();

        map.put("mister", 1);
        map.put("kumar", 2);
        map.put("ashish", 100);
        map.put("patel", 500);

        System.out.println("get(mister) : " + map.get("mister"));
        System.out.println("get(kumar) : " + map.get("kumar"));
        System.out.println("get(patel) : " + map.get("patel"));
        System.out.println("get(ashish) : " + map.get("ashish"));
    }
}
