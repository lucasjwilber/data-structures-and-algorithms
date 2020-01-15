package code401challenges.java;

import LinkedList.java.LinkedList;
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

    LinkedList testList;
    @Before
    public void setUp() {
        testList = new LinkedList();
        testList.insert(1);
        testList.insert(3);
        testList.insert(43);
        testList.insert(-7);
        testList.insert(2345);
        testList.insert(-324);
        testList.insert(637);
        testList.insert(45);
        testList.insert(0);
        testList.insert(11);
    }

    @Test public void canCreateAnEmptyLinkedList() {
        LinkedList newList = new LinkedList();
        assertNull(newList.head);
    }
    @Test public void checkInsert() {
        assertTrue(testList.head.value == 11);
        assertEquals(getListLength(testList), 10);
    }
    @Test public void checkHeadIsLastNodeAdded() {
        testList.insert(8);

        assertTrue(testList.head.value == 8);
    }
    @Test public void testIncludesInsertedValues() {
        assertTrue(testList.includes(637));
    }
    @Test public void testOnlyIncludesInsertedValues() {
        assertFalse(testList.includes(666));
    }
    @Test public void testToString() {
        assertTrue(testList.head.toString().contains("43"));
        assertTrue(testList.head.toString().contains("11"));
        assertTrue(testList.head.toString().contains("0"));
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
    @Test public void appendWorksOnEmptyList() {
        LinkedList testList = new LinkedList();
        testList.append(5);
        assertEquals(5, testList.head.value);
    }
    @Test public void checkMultipleAppends() {
        testList.append(98);
        testList.append(99);
        testList.append(100);
        assertTrue(testList.head.toString().contains("{ 98 } -> { 99 } -> { 100 } -> NULL"));
    }
    @Test public void checkInsertBefore() {
        testList.insertBefore(-7, 4);
        assertTrue(testList.head.toString().contains("{ 4 } -> { -7 }"));
    }

    @Test public void checkInsertAfter() {
        testList.insertAfter(43, 99);
        assertTrue(testList.head.toString().contains("{ 43 } -> { 99 }"));
    }

    @Test public void kthFromEnd_getsCorrectValue() {
        testList = new LinkedList();
        testList.insert(1);
        testList.insert(3);
        testList.insert(43);
        testList.insert(-7);
        assertEquals(3, testList.kthFromEnd(2));
    }

    @Test(expected = IndexOutOfBoundsException.class) public void kthFromEnd_kIsTooHigh() {
        testList.kthFromEnd(999);
    }

    @Test(expected = IndexOutOfBoundsException.class) public void kthFromEnd_listIsEmpty() {
        testList = new LinkedList();
        testList.kthFromEnd(1);
    }

    @Test(expected = IndexOutOfBoundsException.class) public void kthFromEnd_kIsListLength() {
        assertEquals(testList.head.value, testList.kthFromEnd(10));
    }

    @Test(expected = IndexOutOfBoundsException.class) public void kthFromEnd_kIsZero() {
        testList.kthFromEnd(0);
    }

    @Test(expected = IndexOutOfBoundsException.class) public void kthFromEnd_kIsNegative() {
        testList.kthFromEnd(-1);
    }

    @Test public void kThFromEnd_kIsOne() {
        System.out.println(testList.head.toString());
        assertEquals(3, testList.kthFromEnd(1));
    }

    @Test public void onePassKWorks() {
        testList = new LinkedList();
        testList.insert(10);
        testList.insert(-3);
        testList.insert(12);
        testList.insert(43);
        testList.insert(-7);
        assertEquals(12, testList.onePassKthFromEnd(2));
        assertEquals(10, testList.onePassKthFromEnd(0));
        assertEquals(-7, testList.onePassKthFromEnd(4));
    }

}
