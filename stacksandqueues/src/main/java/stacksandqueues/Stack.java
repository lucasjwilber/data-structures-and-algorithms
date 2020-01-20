package stacksandqueues;

public class Stack {
    public Node top;

    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = this.top;
        this.top = newNode;
    }

    public int pop() {
        Node poppedNode = this.top;
        this.top = poppedNode.next;
        return poppedNode.value;
    }

    public int peek() throws NullPointerException {
        if (this.top == null) throw new NullPointerException();

        return this.top.value;
    }

    public boolean isEmpty() {
        return this.top == null;
    }
}