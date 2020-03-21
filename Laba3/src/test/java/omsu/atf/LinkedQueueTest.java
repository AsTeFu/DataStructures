package omsu.atf;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedQueueTest {

    private LinkedQueue<Integer> linkedQueue;

    @BeforeEach
    void setUp() {
        linkedQueue = new LinkedQueue<>();
    }

    @Test
    void testPeek() {
        linkedQueue.push(4);
        linkedQueue.push(5);
        assertEquals(4, linkedQueue.peek());
        linkedQueue.push(6);
        assertEquals(4, linkedQueue.peek());
    }

    @Test
    void testPop() {
        linkedQueue.push(4);
        linkedQueue.push(5);
        assertEquals(4, linkedQueue.pop());
        linkedQueue.push(6);
        assertEquals(5, linkedQueue.pop());
        assertEquals(6, linkedQueue.pop());
        assertNull(linkedQueue.pop());
        assertNull(linkedQueue.pop());
    }

    @Test
    void testPushPop() {
        linkedQueue.push(4);
        linkedQueue.push(5);
        linkedQueue.push(6);
        assertEquals(4, linkedQueue.peek());
        assertEquals(4, linkedQueue.peek());
        assertEquals(4, linkedQueue.pop());
        assertEquals(5, linkedQueue.peek());
        assertEquals(5, linkedQueue.pop());
        assertEquals(6, linkedQueue.pop());
        assertEquals(null, linkedQueue.peek());
        assertEquals(null, linkedQueue.pop());
    }

}