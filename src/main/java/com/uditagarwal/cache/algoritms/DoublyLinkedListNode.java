package com.uditagarwal.cache.algoritms;

public class DoublyLinkedListNode<Key> {
    Key key;
    DoublyLinkedListNode<Key> next;
    DoublyLinkedListNode<Key> prev;

    public Key getKey() {
        return key;
    }

    public DoublyLinkedListNode(Key key) {
        this.key = key;
        this.next = null;
        this.prev = null;
    }
}
