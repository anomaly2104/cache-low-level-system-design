package com.uditagarwal.cache.storage;

import com.uditagarwal.cache.exceptions.NotFoundException;
import com.uditagarwal.cache.exceptions.StorageFullException;

public class HashMapBasedStorage<Key, Value> implements Storage<Key, Value> {

    @Override
    public void add(Key key, Value value) throws StorageFullException {
    }

    @Override
    public void remove(Key key) throws NotFoundException {
    }

    @Override
    public Value get(Key key) throws NotFoundException {
        return null;
    }
}
