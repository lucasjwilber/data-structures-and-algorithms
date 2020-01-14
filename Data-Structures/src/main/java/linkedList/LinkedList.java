package linkedList;

public class LinkedList {
    Node head = null;

    public class Node {
        int value;
        Node next;
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
        boolean answer = false;
        Node current = this.head;
        while (current.next != null) {
            if (current.value == value) {
                answer = true;
                break;
            }
            current = current.next;
        }
        return answer;
    }

    public void append(int value) {
        Node current = this.head;
        Node newNode = new Node(value);
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void insertBefore(int value, int newVal) throws ArrayIndexOutOfBoundsException {
        if (this.includes(value)) {
            Node current = this.head;
            Node newNode = new Node(value);

            while (current.next != null) {
                if (current.value == value) {
                    newNode.next = current.next;
                    current.next = newNode;
                    current.value = newVal;
                    break;
                }
                current = current.next;
            }
        }
    }

    public void insertAfter(int value, int newVal) {
        Node current = this.head;
        Node newNode = new Node(newVal);
        while (current.next != null) {
            if (current.value == value) {
                newNode.next = current.next;
                current.next = newNode;
                break;
            }
            current = current.next;
        }
    }
}
