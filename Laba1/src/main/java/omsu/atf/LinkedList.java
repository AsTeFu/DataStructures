package omsu.atf;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.Collector;
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

    public boolean isNonDecreasing(Comparator<T> comparator) {
        Node<T> curr = head.getNext();
        T prevValue = head.getValue();

        while (curr != null) {
            if (comparator.compare(prevValue, curr.getValue()) > 0) return false;
            prevValue = curr.getValue();
            curr = curr.getNext();
        }
        return true;
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
