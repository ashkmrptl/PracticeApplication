package com.akp.ds;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

public class LinkedHashMap {

    private int size;
    private Entry end;
    private Entry[] entries;

    public LinkedHashMap(final int size) {
        this.size = size;
        this.entries = new Entry[size];
    }

    @ToString
    @Getter
    @Setter
    public static class Entry {
        private Entry prev, next;
        private String key;
        private Integer value;

        public Entry(final String key, final Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    public Integer put(final String key, final Integer value) {
        final int hash = key.hashCode();
        final int index = hash % size;

        Entry entry = entries[index];

        if (Objects.nonNull(entry)) {
            

        } else {
            final Entry newEntry = new Entry(key, value);
            entries[index] = newEntry;
            end = newEntry;
        }

        return null;

    }
}
