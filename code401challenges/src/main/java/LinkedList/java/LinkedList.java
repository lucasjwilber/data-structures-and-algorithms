package LinkedList.java;

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
            if (length <= k) {
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

    
    public int onePassKthFromEnd(int k) {
        Node current = this.head;
        int[] lastK = new int[k];
        while (current.next != null) {
            if (k > 0) {
                for (int i = 1; i < k; i++) {
                    lastK[k - i] = lastK[k - i - 1];
                }
                lastK[0] = current.value;
            }
            current = current.next;
        }
        if (k <= 0) {
            return current.value;
        } else {
            return lastK[k - 1];
        }
    }


}
