package stacksandqueues;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {
    Queue testQueue;
    @Before
    public void setUp() {
        testQueue = new Queue();
    }

    @Test public void queue_canInstantiate() {
        assertNull(testQueue.front);
        assertNull(testQueue.rear);
    }
    @Test public void queue_canEnqueue() {
        testQueue.enqueue(5);
        assertEquals(5, testQueue.front.value);
        assertEquals(5, testQueue.rear.value);
    }
    @Test public void queue_enqueueAddsInCorrectOrder() {
        testQueue.enqueue(11);
        testQueue.enqueue(4);
        testQueue.enqueue(23);
        assertEquals(11, testQueue.front.value);
        assertEquals(23, testQueue.rear.value);
    }
    @Test public void queue_dequeueRemovesFront() {
        testQueue.enqueue(11);
        testQueue.enqueue(4);
        testQueue.enqueue(23);
        assertEquals(11, testQueue.dequeue());
        assertEquals(4, testQueue.dequeue());
        assertEquals(23, testQueue.dequeue());
    }
    @Test(expected = NullPointerException.class) public void queue_dequeuingEmptyQueue() {
        testQueue.dequeue();
    }
    @Test public void queue_canPeek() {
        testQueue.enqueue(11);
        assertEquals(11, testQueue.peek());
    }
    @Test(expected = NullPointerException.class) public void queue_peekThrowsExceptionOnEmptyQueue() {
        testQueue.peek();
    }
    @Test public void queue_isEmptyWorks() {
        assertTrue(testQueue.isEmpty());
        testQueue.enqueue(4);
        assertFalse(testQueue.isEmpty());
    }
}
