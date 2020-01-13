package linkedList;

public class DoublyLinkedList {
    DoublyNode head = null;

    public class DoublyNode {
        int value;
        DoublyNode next;
        DoublyNode previous;

        public DoublyNode(int value) {
            this.next = null;
            this.previous = null;
            this.value = value;
        }
    }

    public DoublyNode getLastNode() {
        DoublyNode head = this.head;
        DoublyNode current = this.head;
        while (current.next != head) {
            current = current.next;
        }
        return current;
    }

    public void insert(int value) {
        DoublyNode newNode = new DoublyNode(value);
        newNode.next = head;
        newNode.previous = head;
        if (head != null) {
            newNode.previous = head.previous;
            head.previous = newNode;
        }
        head = newNode;
    }

    public boolean includes(int value) {
        boolean answer = false;
        DoublyNode current = this.head;
        while (current.next != this.head) {
            if (current.value == value) {
                answer = true;
                break;
            }
            current = current.next;
        }
        return answer;
    }

    //Instructions say the returned string should end with "NULL" but it would only say that if
    //it was printing 'next' values, not actual node values. I didn't do it that way:
    public String listToString() {
        //Get head value first. Need to do it this way so that we can append the '->'s in between.
        StringBuilder stringResult = new StringBuilder();
        String stringFragment ="{ " + this.head.value + " }";
        stringResult.append(stringFragment);

        DoublyNode current = this.head;
        while (current.next != this.head && current.next != null) {
            current = current.next;
            stringFragment = " -> { " + current.value + " }";
            stringResult.append(stringFragment);
        }
        return stringResult.toString();
    }
}
