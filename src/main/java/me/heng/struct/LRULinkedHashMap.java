package me.heng.struct;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * AUTHOR: wangdi
 * DATE: 2019-01-21
 * TIME: 14:06
 */
public class LRULinkedHashMap<K,V> extends LinkedHashMap {

    private int capacity;

    /**
     * Constructs an empty insertion-ordered <tt>LinkedHashMap</tt> instance
     * with the specified initial capacity and load factor.
     *
     * @param initialCapacity the initial capacity
     * @param loadFactor      the load factor
     * @throws IllegalArgumentException if the initial capacity is negative
     *                                  or the load factor is nonpositive
     */
    public LRULinkedHashMap(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
        this.capacity = initialCapacity;
    }


    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return this.size() > capacity;
    }
}
