package com.company.cache.policies;

public class LRUNode<Key> {
    Key key;
    LRUNode next;
    LRUNode prev;

    public Key getKey() {
        return key;
    }

    public LRUNode(Key key) {
        this.key = key;
        this.next = null;
        this.prev = null;
    }
}
