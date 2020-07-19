package com.uditagarwal.cache.storage;

import com.uditagarwal.cache.exceptions.NotFoundException;
import com.uditagarwal.cache.exceptions.StorageFullException;

import java.util.HashMap;
import java.util.Map;

public class HashMapBasedStorage<Key, Value> implements Storage<Key, Value> {

    Map<Key, Value> mp = new HashMap<>();

    @Override
    public void add(Key key, Value value) throws StorageFullException {
        mp.put(key, value);
    }

    @Override
    public void remove(Key key) throws NotFoundException {
        mp.remove(key);
    }

    @Override
    public Value get(Key key) throws NotFoundException {
        return mp.get(key);
    }
}
