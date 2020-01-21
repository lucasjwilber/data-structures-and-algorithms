package stacksandqueues;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PseudoQueueTest {
    PseudoQueue ps;
    @Before public void setUp() {
        ps = new PseudoQueue();
        ps.enqueue(1);
        ps.enqueue(2);
        ps.enqueue(3);
        ps.enqueue(4);
        ps.enqueue(5);
    }


    @Test public void pseudoQueue_canInstantiate() {
        //shouldn't cause an error:
        PseudoQueue ps = new PseudoQueue();
    }
    @Test public void pseudoQueue_canEnqueue() {
        ps.enqueue(6);
        assertTrue(1 == ps.front.peek());
    }
    @Test public void pseudoQueue_canEnqueueMultiple() {
        ps.enqueue(6);
        ps.enqueue(7);
        ps.enqueue(8);
        ps.enqueue(9);
        ps.enqueue(10);
    }
    @Test public void pseudoQueue_frontAndRearAreAccurate() {
        assertTrue(ps.front.peek() == 1);
        assertTrue(ps.rear.peek() == 5);
    }
    @Test public void pseudoQueue_canDequeue() {
        assertTrue(ps.dequeue() == 1);
    }
    @Test public void pseudoQueue_canDequeueEntirePQ() {
        assertTrue(ps.dequeue() == 1);
        assertTrue(ps.dequeue() == 2);
        assertTrue(ps.dequeue() == 3);
        assertTrue(ps.dequeue() == 4);
        assertTrue(ps.dequeue() == 5);
    }
    @Test(expected = NullPointerException.class)
    public void pseudoQueue_cantDequeueEmptyPQ() {
        PseudoQueue ps = new PseudoQueue();
        ps.dequeue();
    }
}
