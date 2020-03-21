package omsu.atf;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    private Stack<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new Stack<>();
    }

    @Test
    void testPushPop() {
        stack.push(4);
        stack.push(5);
        stack.push(6);
        assertEquals(6, stack.peek());
        assertEquals(6, stack.peek());
        assertEquals(6, stack.pop());
        assertEquals(5, stack.peek());
        assertEquals(5, stack.pop());
        assertEquals(4, stack.pop());
        assertEquals(null, stack.pop());
    }

    @Test
    void testPop() {
        stack.push(4);
        stack.push(5);
        stack.push(6);
        assertEquals(6, stack.pop());
        assertEquals(5, stack.pop());
        assertEquals(4, stack.pop());
        assertEquals(null, stack.pop());
    }

    @Test
    void testPeek() {
        stack.push(4);
        stack.push(5);
        stack.push(6);
        assertEquals(6, stack.peek());
        assertEquals(6, stack.peek());
    }

    @Test
    void testPeekNull() {
        assertEquals(null, stack.peek());
    }

    @Test
    void testPopNull() {
        assertEquals(null, stack.pop());
    }

}