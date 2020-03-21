package omsu.atf;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class LinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void pushHead(T value) {
        size++;
        if (head == null) {
            head = new Node<T>(value);
            tail = head;
            return;
        }

        head = new Node<T>(value, head);
    }

    public void pushTail(T value) {
        size++;
        if (tail == null) {
            tail = new Node<T>(value);
            head = tail;
            return;
        }

        tail.setNext(new Node<T>(value));
        tail = tail.getNext();
    }

    public T peekHead() {
        return head == null ? null : head.getValue();
    }

    public T peekTail() {
        return tail == null ? null : tail.getValue();
    }

    public T popHead() {
        if (size == 0) return null;

        size--;
        T value = head.getValue();
        this.head = head.getNext();
        return value;
    }

    public T popTail() {
        if (size == 0) return null;

        size--;
        T value = tail.getValue();
        this.tail = getPrevious(tail);
        this.tail.setNext(null);
        return value;
    }

    private Node<T> getPrevious(final Node<T> node) {
        Node<T> curr = head;
        while (curr.getNext() != node) {
            curr = curr.getNext();
        }
        return curr;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int length() {
        return size;
    }

    public LinkedList<T> getReverse() {
        LinkedList<T> reverse = new LinkedList<>();

        Node<T> curr = head;
        while (curr != null) {
            reverse.pushHead(curr.getValue());
            curr = curr.getNext();
        }

        return reverse;
    }

    @Override
    public String toString() {
        if (head == null) return "[ ]";
        ArrayList<T> list = new ArrayList<>();
        Node<T> curr = head;
        while (curr != null) {
            list.add(curr.getValue());
            curr = curr.getNext();
        }
        return "[" + list.stream().map(Object::toString).collect(Collectors.joining(", ")) + "]";
    }
}
