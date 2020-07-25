package com.uditagarwal.algoritms;

import com.uditagarwal.algoritms.exceptions.InvalidElementException;
import com.uditagarwal.algoritms.exceptions.InvalidNodeException;
import lombok.Getter;

/**
 * An object which support creating a list with non-contiguous memory allocation. You cannot access a random element
 * directly using index. But if you have a pointer to a node, then you can traverse the list both in forward and
 * backward direction in the list.
 *
 * @param <E> Type of element stored in list.
 */
@Getter
public class DoublyLinkedList<E> {

    DoublyLinkedListNode<E> first;
    DoublyLinkedListNode<E> last;

    public DoublyLinkedList() {
        first = null;
        last = null;
    }

    /**
     * Method to detach a random node from the doubly linked list. The node itself will not be removed from the memory.
     * Just that it will be removed from the list and becomes orphaned.
     *
     * @param node Node to be detached.
     */
    public void detachNode(DoublyLinkedListNode<E> node) {
        if (node == null) {
            return;
        }
        if (node.equals(first)) {
            first = first.next;
            if (first != null) {
                first.prev = null;
            }
        } else if (node.equals(last)) {
            last = last.prev;
            if (last.next != null) {
                last.next = null;
            }
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    /**
     * Helper method to add a node at the end of the list.
     *
     * @param node Node to be added.
     */
    public void addNodeAtLast(DoublyLinkedListNode<E> node) {
        if (node == null) {
            throw new InvalidNodeException();
        }
        if (last == null) {
            last = node;
            first = node;
        } else {
            last.next = node;
            node.prev = last;
            node.next = null;
            last = node;
        }
    }

    /**
     * Helper method to add an element at the end.
     *
     * @param element Element to be added.
     * @return Reference to new node created for the element.
     */
    public DoublyLinkedListNode<E> addElementAtLast(E element) {
        if (element == null) {
            throw new InvalidElementException();
        }
        DoublyLinkedListNode<E> newNode = new DoublyLinkedListNode<>(element);
        addNodeAtLast(newNode);
        return newNode;
    }
}
