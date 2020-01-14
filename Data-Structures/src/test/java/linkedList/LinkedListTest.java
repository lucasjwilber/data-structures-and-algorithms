package linkedList;

import org.junit.Before;
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

//    LinkedList testList;
//    @Before
//    public void setUp() {
//        testList = new LinkedList();
//        testList.insert(1);
//        testList.insert(3);
//        testList.insert(43);
//        testList.insert(7);
//        testList.insert(2345);
//        testList.insert(324);
//        testList.insert(637);
//        testList.insert(45);
//        testList.insert(0);
//        testList.insert(0);
//    }

    @Test public void canCreateAnEmptyLinkedList() {
        LinkedList newList = new LinkedList();
        assertNull(newList.head);
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

        assertTrue(testList.head.toString().contains("135"));
        assertTrue(testList.head.toString().contains("4"));
        assertTrue(testList.head.toString().contains("6"));
        assertTrue(testList.head.toString().contains("7"));
        assertTrue(testList.head.toString().contains("65"));
    }
    @Test public void checkAppendAddsToEnd() {
        LinkedList testList = new LinkedList();
        testList.insert(135);
        testList.insert(4);
        testList.append(1);

        assertEquals(1, testList.head.next.next.value);
    }
    @Test public void checkInsertBefore() {
        LinkedList testList = new LinkedList();
        testList.insert(5);
        testList.insert(135);
        testList.insert(35);
        testList.insert(22);
        testList.insertBefore(135, 4);

        System.out.println(testList.head.toString());
    }

    @Test public void checkInsertAfter() {
        LinkedList testList = new LinkedList();
        testList.insert(135);
        testList.insert(4);
        testList.insert(6);
        testList.insertAfter(4, 99);
        //6 4 99 135
        assertEquals(99, testList.head.next.next.value);
    }
}
