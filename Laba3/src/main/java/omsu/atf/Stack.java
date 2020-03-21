package omsu.atf;

public class Stack<T> {

    private final LinkedList<T> linkedList = new LinkedList<>();

    public void push(T value) {
        linkedList.pushHead(value);
    }

    public T pop() {
        return linkedList.popHead();
    }

    public T peek() {
        return linkedList.peekHead();
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    public int length() {
        return linkedList.length();
    }
}
