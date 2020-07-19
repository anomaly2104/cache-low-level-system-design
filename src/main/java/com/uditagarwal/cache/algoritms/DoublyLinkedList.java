package com.uditagarwal.cache.algoritms;

import lombok.Getter;

@Getter
public class DoublyLinkedList<E> {

    DoublyLinkedListNode<E> first;
    DoublyLinkedListNode<E> last;

    public DoublyLinkedList() {
        first = null;
        last = null;
    }

    public void detachNode(DoublyLinkedListNode<E> node) {
        if (node == null) {
            return;
        }
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
    }

    public void addNodeAtLast(DoublyLinkedListNode<E> node) {
        if (node == null) {
            throw new InvalidItemException();
        }
        last.next = node;
        node.prev = last;
        node.next = null;
        last = node;
    }

    public DoublyLinkedListNode<E> addElementAtLast(E element) {
        DoublyLinkedListNode<E> newNode = new DoublyLinkedListNode<>(element);
        if (last == null) {
            last = newNode;
            first = newNode;
        } else {
            addNodeAtLast(newNode);
        }
        return newNode;
    }
}
