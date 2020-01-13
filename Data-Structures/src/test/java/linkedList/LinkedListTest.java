package linkedList;

import org.junit.Test;
import static org.junit.Assert.*;

public class LinkedListTest {
    public int getListLength(LinkedList list) {
        if (list.head == null) {
            return 0;
        } else if (list.head.next == null) {
            return 1;
        } else {
            int length = 1;
            LinkedList.Node current = list.head;
            while (current.next != null) {
                length++;
                current = current.next;
            }
            return length;
        }
    }

    @Test public void canCreateAnEmptyLinkedList() {
        LinkedList newList = new LinkedList();
        assertTrue(newList.head == null);
    }
    @Test public void checkInsert() {
        LinkedList testList = new LinkedList();
        testList.insert(1);
        testList.insert(3);
        testList.insert(3);
        testList.insert(7);
        testList.insert(9);

        assertTrue(testList.head.value == 9);
        assertEquals(getListLength(testList), 5);
    }
    @Test public void checkHeadIsLastNodeAdded() {
        LinkedList testList = new LinkedList();
        testList.insert(4);
        testList.insert(8);

        assertTrue(testList.head.value == 8);
    }
    @Test public void testIncludesInsertedValues() {
        LinkedList testList = new LinkedList();
        testList.insert(23);
        testList.insert(3453);
        testList.insert(253);
        testList.insert(23456);
        testList.insert(9);

        assertTrue(testList.includes(23456));
        assertFalse(testList.includes(55));
    }
    @Test public void testOnlyIncludesInsertedValues() {
        LinkedList testList = new LinkedList();
        testList.insert(23);
        testList.insert(3453);
        testList.insert(253);
        testList.insert(23456);
        testList.insert(9);

        assertFalse(testList.includes(55));
    }
    @Test public void testToString() {
        LinkedList testList = new LinkedList();
        testList.insert(1);
        testList.insert(2);
        testList.insert(3);
        testList.insert(4);
        testList.insert(5);
    }
    @Test public void listToStringContainsAllValues() {
        LinkedList testList = new LinkedList();
        testList.insert(135);
        testList.insert(4);
        testList.insert(6);
        testList.insert(7);
        testList.insert(65);

        assertTrue(testList.listToString().contains("135"));
        assertTrue(testList.listToString().contains("4"));
        assertTrue(testList.listToString().contains("6"));
        assertTrue(testList.listToString().contains("7"));
        assertTrue(testList.listToString().contains("65"));
    }
}