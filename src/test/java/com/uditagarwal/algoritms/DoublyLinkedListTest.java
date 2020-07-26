package com.uditagarwal.algoritms;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {

    @Test
    void testDLLAddition() {
        DoublyLinkedListNode<Integer> node1 = new DoublyLinkedListNode<>(1);
        DoublyLinkedListNode<Integer> node2 = new DoublyLinkedListNode<>(2);
        DoublyLinkedListNode<Integer> node3 = new DoublyLinkedListNode<>(3);
        DoublyLinkedListNode<Integer> node4 = new DoublyLinkedListNode<>(4);

        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();

        dll.addNodeAtLast(node1);
        verifyDLL(dll, ImmutableList.of(1));

        dll.addNodeAtLast(node2);
        verifyDLL(dll, ImmutableList.of(1, 2));

        dll.addNodeAtLast(node3);
        verifyDLL(dll, ImmutableList.of(1, 2, 3));

        dll.addNodeAtLast(node4);
        verifyDLL(dll, ImmutableList.of(1, 2, 3, 4));

        dll.addElementAtLast(5);
        verifyDLL(dll, ImmutableList.of(1, 2, 3, 4, 5));
    }

    @Test
    void testDLLNodeDetachment() {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();

        DoublyLinkedListNode<Integer> node1 = dll.addElementAtLast(1);
        DoublyLinkedListNode<Integer> node2 = dll.addElementAtLast(2);
        DoublyLinkedListNode<Integer> node3 = dll.addElementAtLast(3);
        DoublyLinkedListNode<Integer> node4 = dll.addElementAtLast(4);
        DoublyLinkedListNode<Integer> node5 = dll.addElementAtLast(5);

        verifyDLL(dll, ImmutableList.of(1, 2, 3, 4, 5));

        dll.detachNode(node1);
        verifyDLL(dll, ImmutableList.of(2, 3, 4, 5));

        dll.detachNode(node5);
        verifyDLL(dll, ImmutableList.of(2, 3, 4));

        dll.detachNode(node3);
        verifyDLL(dll, ImmutableList.of(2, 4));

        dll.detachNode(null);
        verifyDLL(dll, ImmutableList.of(2, 4));
    }

    void verifyDLL(DoublyLinkedList<Integer> dll, List<Integer> expectedListElements) {
        assertEquals(expectedListElements.get(expectedListElements.size() - 1), dll.getLastNode().getElement());
        assertEquals(expectedListElements.get(0), dll.getFirstNode().getElement());

        DoublyLinkedListNode<Integer> currentNode = dll.getFirstNode();
        for (Integer expectedListElement : expectedListElements) {
            assertNotNull(currentNode);
            assertEquals(expectedListElement, currentNode.getElement());
            currentNode = currentNode.getNext();
        }
        assertNull(currentNode.next);
    }
}
