package com.company.cache.policies;


import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key> {
    LRUNode<Key> first;
    LRUNode<Key> last;

    Map<Key, LRUNode<Key>> mapper;

    public LRUEvictionPolicy() {
        mapper = new HashMap<>();
        first = null;
        last = null;
    }

    private void moveNodeToLast(LRUNode<Key> node) {
        if (node.equals(first)) {
            first = first.next;
            first.prev = null;
        } else if (node.equals(last)) {
            last = last.prev;
            last.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        addNodeAtLast(node);
    }


    private void addNodeAtLast(LRUNode node) {
        last.next = node;
        node.prev = last;
        node.next = null;
        last = node;
    }

    private void addToLRU(Key key) {
        if (mapper.containsKey(key)) {
            moveNodeToLast(mapper.get(key));
        } else {
            LRUNode<Key> newNode = new LRUNode<>(key);
            mapper.put(key, newNode);
            if (last == null) {
                last = newNode;
                first = newNode;
            } else {
                addNodeAtLast(newNode);
            }
        }
    }

    private void moveFirst() {
        if (first == null) {
            return;
        }
        first = first.next;
        first.prev = null;
    }

    @Override
    public void keyAccessed(Key key) {
        addToLRU(key);
    }

    @Override
    public Key evictKey() {
        if (first == null) {
            return null;
        }
        Key key = first.getKey();
        moveFirst();
        return key;
    }
}
