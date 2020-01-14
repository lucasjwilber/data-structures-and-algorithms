package LinkedList.java;

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

    public void insertAfter(int value, int newVal) throws NoSuchElementException{
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
}
