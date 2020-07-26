package com.uditagarwal.cache.factories;

import com.uditagarwal.cache.Cache;
import com.uditagarwal.cache.policies.LRUEvictionPolicy;
import com.uditagarwal.cache.storage.HashMapBasedStorage;

public class CacheFactory<Key, Value> {

    public Cache<Key, Value> defaultCache(final int capacity) {
        return new Cache<Key, Value>(new LRUEvictionPolicy<Key>(),
                new HashMapBasedStorage<Key, Value>(capacity));
    }
}
