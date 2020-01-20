package stacksandqueues;

import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {
    @Test public void queue_canInstantiate() {
        Queue testQueue = new Queue();
        assertTrue(testQueue.front == null);
        assertTrue(testQueue.rear == null);
    }
    @Test public void queue_canEnqueue() {
        Queue testQueue = new Queue();
        testQueue.enqueue(5);
        assertEquals(5, testQueue.front.value);
        assertEquals(5, testQueue.rear.value);
    }
    @Test public void queue_enqueueAddsInCorrectOrder() {
        Queue testQueue = new Queue();
        testQueue.enqueue(11);
        testQueue.enqueue(4);
        testQueue.enqueue(23);
        assertEquals(11, testQueue.front.value);
        assertEquals(23, testQueue.rear.value);
    }
    @Test public void queue_dequeueRemovesFront() {
        Queue testQueue = new Queue();
        testQueue.enqueue(11);
        testQueue.enqueue(4);
        testQueue.enqueue(23);
        assertEquals(11, testQueue.dequeue());
        assertEquals(4, testQueue.dequeue());
        assertEquals(23, testQueue.dequeue());
    }
    @Test public void queue_canPeek() {
        Queue testQueue = new Queue();
        testQueue.enqueue(11);
        assertEquals(11, testQueue.peek());
    }
    @Test(expected = NullPointerException.class) public void queue_peekThrowsExceptionOnEmptyQueue() {
        Queue testQueue = new Queue();
        testQueue.peek();
    }
    @Test public void queue_isEmptyWorks() {
        Queue testQueue = new Queue();
        assertTrue(testQueue.isEmpty());
        testQueue.enqueue(4);
        assertFalse(testQueue.isEmpty());
    }
}
