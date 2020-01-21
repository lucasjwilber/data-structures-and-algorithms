package stacksandqueues;

public class PseudoQueue {
    public Stack<Integer> front = new Stack<Integer>();
    public Stack<Integer> rear = new Stack<Integer>();

    public void enqueue(int value) {
        rear.push(value);

        if (front.top == null) {
            front.push(value);
        } else {
            //flip front into a temp stack
            Stack<Integer> tempStack = new Stack<Integer>();
            while (front.top != null) {
                tempStack.push(front.pop());
            }
            //add the new Node
            tempStack.push(value);
            //flip the temp stack back into front
            while (tempStack.top != null) {
                front.push(tempStack.pop());
            }
        }
    }

    public int dequeue() throws NullPointerException {
        Stack<Integer> tempStack = new Stack<Integer>();
        //flip rear into a temp stack
        while (rear.top != null) {
            tempStack.push(rear.pop());
        }
        //pop off the end Node
        tempStack.pop();
        //flip temp stack back into rear
        while (tempStack.top != null) {
            rear.push(tempStack.pop());
        }

        return front.pop();
    }
}
