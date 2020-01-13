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

    @Test public void checkListLength() {
        LinkedList testList = new LinkedList();
        testList.insert(1);
        testList.insert(2);
        testList.insert(3);
        testList.insert(4);
        testList.insert(5);
        assertEquals(getListLength(testList), 5);
    }
}
