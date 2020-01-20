package stacksandqueues;

public class Queue<T> {
    public Node<T> front;
    public Node<T> rear;

    public void enqueue(T value) {
        Node<T> newNode = new Node<T>(value);
        if (this.rear != null) {
            this.rear.next = newNode;
        }
        this.rear = newNode;
        if (this.front == null) {
            this.front = newNode;
        }
    }

    public T dequeue() throws NullPointerException {
        if (this.front == null) {
            throw new NullPointerException("The queue is empty.");
        }
        Node<T> tempFront = this.front;
        this.front = this.front.next;
        return tempFront.value;
    }

    public T peek() throws NullPointerException {
        if (this.front == null) throw new NullPointerException("The queue is empty.");

        return this.front.value;
    }

    public boolean isEmpty() {
        return this.front == null;
    }
}