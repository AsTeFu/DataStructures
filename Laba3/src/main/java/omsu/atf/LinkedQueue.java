package omsu.atf;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class LinkedQueue<T> {

    private final LinkedList<T> linkedList = new LinkedList<>();

    public T peek() {
        return linkedList.peekHead();
    }

    public T pop() {
        return linkedList.popHead();
    }

    public void push(T value) {
        linkedList.pushTail(value);
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    public int length() {
        return linkedList.length();
    }

    @Override
    public String toString() {
        return linkedList.toString();
    }
}
