package me.heng.algorithm;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheLinked {

    private int capacity;
    private Map<Integer, Integer> cache;

    public LRUCacheLinked(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            //大于capacity 就删除时间最久没有用到的
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }


    public int get(int key) {
        if (cache.containsKey(key)) {
            return cache.get(key);
        } else
            return -1;
    }

    public void set(int key, int value) {
        cache.put(key, value);
    }

}