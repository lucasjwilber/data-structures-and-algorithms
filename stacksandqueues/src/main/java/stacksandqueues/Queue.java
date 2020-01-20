package stacksandqueues;

public class Queue {
    public Node front;
    public Node rear;

    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (this.rear != null) {
            this.rear.next = newNode;
        }
        this.rear = newNode;
        if (this.front == null) {
            this.front = newNode;
        }
    }

    public int dequeue() {
        Node tempFront = this.front;
        this.front = this.front.next;
        return tempFront.value;
    }

    public int peek() throws NullPointerException {
        if (this.front == null) throw new NullPointerException();

        return this.front.value;
    }

    public boolean isEmpty() {
        return this.front == null;
    }
}