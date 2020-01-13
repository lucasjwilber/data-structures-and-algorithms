package linkedList;

public class LinkedList {
    Node head = null;

    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.next = null;
            this.value = value;
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

    //instructions say the result should end in "NULL" but it would only say that if
    //it was printing 'next' values, not actual node values, so I didn't do it that way:
    public String listToString() {
        //get head value first. need to do it this way so that we can append the '->'s in between.
        StringBuilder stringResult = new StringBuilder();
        String stringFragment ="{ " + this.head.value + " }";
        stringResult.append(stringFragment);

        Node current = this.head;
        while (current.next != null) {
            current = current.next;
            stringFragment = " -> { " + current.value + " }";
            stringResult.append(stringFragment);
        }
        return stringResult.toString();
    }


}
