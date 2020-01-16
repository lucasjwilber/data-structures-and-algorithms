package LinkedList.java;

import org.checkerframework.framework.qual.LiteralKind;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class LinkedList {
    public Node head = null;

    public class Node {
        public int value;
        public Node next;
        public Node(int value) {
            this.next = null;
            this.value = value;
        }

        public String toString() {
            return "{ " + this.value + " } -> " + (this.next == null ? "NULL" : this.next.toString());
        }
    }

    public void insert(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    public boolean includes(int value) {
        Node current = this.head;
        while (current.next != null) {
            if (current.value == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (this.head == null) {
            this.head = newNode;
        } else {
            Node current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void insertBefore(int value, int newVal) throws NoSuchElementException {
        if (this.includes(value)) {
            Node current = this.head;
            Node newNode = new Node(value);

            while (current.next != null) {
                if (current.value == value) {
                    newNode.next = current.next;
                    current.next = newNode;
                    current.value = newVal;
                    return;
                }
                current = current.next;
            }
        } else {
            System.out.println("The given value does not exist in the list.");
            throw new NoSuchElementException();
        }
    }

    public void insertAfter(int value, int newVal) throws NoSuchElementException {
        if (this.includes(value)) {
            Node current = this.head;
            Node newNode = new Node(newVal);
            while (current.next != null) {
                if (current.value == value) {
                    newNode.next = current.next;
                    current.next = newNode;
                    return;
                }
                current = current.next;
            }
        } else {
            System.out.println("The given value does not exist in the list.");
            throw new NoSuchElementException();
        }
    }

    public int kthFromEnd(int k) throws IndexOutOfBoundsException {
        if (this.head == null) {
            System.out.println("The list is empty.");
            throw new IndexOutOfBoundsException();
        } else {
            Node current = this.head;
            int length = 1;
            while (current.next != null) {
                length++;
                current = current.next;
            }
            if (k == 0) return current.value;
            if (k > length) {
                System.out.println("The list doesn't have that many values.");
                throw new IndexOutOfBoundsException();
            } else {
                current = this.head;
                int position = 1;
                while (current.next != null) {
                    if (position == length - k) {
                        System.out.println("Found it!");
                        return current.value;
                    }
                    position++;
                    System.out.println(position);
                    current = current.next;
                }
            }
        }
        System.out.println("Use a positive value.");
        throw new IndexOutOfBoundsException();
    }


    public int onePassKthFromEnd(int k) throws IndexOutOfBoundsException {
        Node current = this.head;
        if (current == null || k < 0)  throw new IndexOutOfBoundsException();
        int[] lastK = new int[k];
        int listLength = 0;
        while (current.next != null) {
            listLength++;
            if (k > 0) {
                for (int i = 1; i < k; i++) {
                    lastK[k - i] = lastK[k - i - 1];
                }
                lastK[0] = current.value;
            }
            current = current.next;
        }
        if (listLength < k) throw new IndexOutOfBoundsException();
        return (k == 0) ? current.value : lastK[k-1];
    }

    public static LinkedList mergeLists(LinkedList one, LinkedList two) {
        Node oneCurrent = one.head;
        //if the first list is empty return the second one.
        if (oneCurrent == null) return two;
        Node twoCurrent = two.head;
        Node onePrev = oneCurrent;
        Node twoPrev = twoCurrent;
//        LinkedList newList = new LinkedList();
//        newList.head = oneCurrent;

        while (oneCurrent != null && twoCurrent != null) {
            //if the end of the first list is reached, splice them together
            //i don't know why but if the second list is shorter than the first this happens on its own
            if (oneCurrent.next == null) {
                oneCurrent.next = twoCurrent;
                break;
            }
            oneCurrent = oneCurrent.next;
            twoCurrent = twoCurrent.next;

            onePrev.next = twoPrev;
            twoPrev.next = oneCurrent;

            onePrev = oneCurrent;
            twoPrev = twoCurrent;
        }
        return one;
    }
}
