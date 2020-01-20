package stacksandqueues;

public class Stack<T> {
    public Node<T> top;

    public void push(T value) {
        Node<T> newNode = new Node<T>(value);
        newNode.next = this.top;
        this.top = newNode;
    }

    public T pop() {
        if (this.top == null) throw new NullPointerException("The stack is empty.");
        Node<T> poppedNode = this.top;
        this.top = poppedNode.next;
        return poppedNode.value;
    }

    public T peek() throws NullPointerException {
        if (this.top == null) throw new NullPointerException("The stack is empty.");

        return this.top.value;
    }

    public boolean isEmpty() {
        return this.top == null;
    }
}