package stacksandqueues;

import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {
    @Test public void stack_canInstantiate() {
        Stack testStack = new Stack();
        testStack.top = new Node(5);
        assertTrue(testStack.top.value == 5);
    }
    @Test public void stack_canPush() {
        Stack testStack = new Stack();
        testStack.push(4);
        testStack.push(6);
        assertEquals(6, testStack.top.value);
        assertEquals(4, testStack.top.next.value);
    }
    @Test public void stack_canPop() {
        Stack testStack = new Stack();
        testStack.push(4);
        testStack.push(6);
        assertEquals(6, testStack.pop());
    }
    @Test public void stack_popRemovesNodes() {
        Stack testStack = new Stack();
        testStack.push(4);
        testStack.push(6);
        assertEquals(6, testStack.top.value);
        testStack.pop();
        assertEquals(4, testStack.top.value);
    }
    @Test public void stack_canPeek() {
        Stack testStack = new Stack();
        testStack.push(3);
        testStack.push(65);
        assertEquals(65, testStack.peek());
    }
    @Test public void stack_isEmptyWorks() {
        Stack testStack = new Stack();
        assertTrue(testStack.isEmpty());
        testStack.push(5);
        assertFalse(testStack.isEmpty());
    }
}
