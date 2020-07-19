package com.uditagarwal.cache.policies;

public interface EvictionPolicy<T> {

    public void keyAccessed(T key);

    /**
     * Evict key from eviction policy and return it.
     */
    public T evictKey();
}
