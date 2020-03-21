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


    public LinkedList<T> getReverse() {
        LinkedList<T> reverse = new LinkedList<>();

        Node<T> curr = head;
        while (curr != null) {
            reverse.pushHead(curr.getValue());
            curr = curr.getNext();
        }

        return reverse;
    }

    public static <T> LinkedList<T> merge(final LinkedList<T> first, final LinkedList<T> second) {
        return fillList(second, fillList(first, new LinkedList<T>()));
    }

    private static <T> LinkedList<T> fillList(final LinkedList<T> fill, final LinkedList<T> list) {
        Node<T> curr = fill.head;
        while (curr != null) {
            list.pushTail(curr.getValue());
            curr = curr.getNext();
        }

        return list;
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
