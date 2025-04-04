package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void newStackShouldBeEmpty() {
        Stack stack = new Stack();
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

    @Test
    void pushShouldAddElementToStack() {
        Stack stack = new Stack();
        stack.push(42);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
        assertEquals(42, stack.peek());
    }

    @Test
    void popShouldRemoveAndReturnTopElement() {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        assertEquals(20, stack.pop());
        assertEquals(1, stack.size());
        assertEquals(10, stack.peek());
    }

    @Test
    void peekShouldReturnTopElementWithoutRemovingIt() {
        Stack stack = new Stack();
        stack.push(7);
        assertEquals(7, stack.peek());
        assertEquals(1, stack.size());
    }

    @Test
    void popOnEmptyStackShouldThrowException() {
        Stack stack = new Stack();
        assertThrows(IllegalStateException.class, stack::pop);
    }

    @Test
    void peekOnEmptyStackShouldThrowException() {
        Stack stack = new Stack();
        assertThrows(IllegalStateException.class, stack::peek);
    }

    @Test
    void pushingMoreThanInitialCapacityShouldExpandStack() {
        Stack stack = new Stack();
        for (int i = 0; i < 15; i++) {
            stack.push(i);
        }
        assertEquals(15, stack.size());
        assertEquals(14, stack.peek());
    }
}
