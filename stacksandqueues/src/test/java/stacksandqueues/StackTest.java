package stacksandqueues;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {
    Stack testStack;
    @Before
    public void setUp() {
        testStack = new Stack();
    }

    @Test public void stack_canInstantiate() {
        testStack.top = new Node(5);
        assertTrue(testStack.top.value == 5);
    }
    @Test public void stack_canPush() {
        testStack.push(1);
        assertEquals(1, testStack.top.value);
    }
    @Test public void stack_canPushMultiple() {
        testStack.push(4);
        testStack.push(6);
        testStack.push(10);
        assertEquals(10, testStack.top.value);
        assertEquals(6, testStack.top.next.value);
        assertEquals(4, testStack.top.next.next.value);
    }
    @Test public void stack_canPop() {
        testStack.push(4);
        testStack.push(6);
        assertEquals(6, testStack.pop());
    }
    @Test public void stack_popRemovesNodes() {
        testStack.push(4);
        testStack.push(6);
        assertEquals(6, testStack.top.value);
        testStack.pop();
        assertEquals(4, testStack.top.value);
    }
    @Test public void stack_popCanEmptyTheStack() {
        testStack.push(1);
        testStack.push(2);
        testStack.pop();
        testStack.pop();
        assertNull(testStack.top);
    }
    @Test public void stack_canPeek() {
        testStack.push(3);
        testStack.push(65);
        assertEquals(65, testStack.peek());
    }
    @Test public void stack_isEmptyWorks() {
        assertTrue(testStack.isEmpty());
        testStack.push(5);
        assertFalse(testStack.isEmpty());
    }
}
