package com.uditagarwal.cache.factories;

import com.uditagarwal.cache.model.Cache;
import com.uditagarwal.cache.policies.LRUEvictionPolicy;
import com.uditagarwal.cache.storage.HashMapBasedStorage;

public class CacheFactory<Key, Value> {

    public Cache<Key, Value> defaultCache() {
        return new Cache<>(new LRUEvictionPolicy<>(), new HashMapBasedStorage<>());
    }
}
