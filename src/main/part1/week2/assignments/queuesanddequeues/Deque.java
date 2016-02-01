package part1.week2.assignments.queuesanddequeues;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author dimon
 * @since 01/02/16.
 */
public class Deque<Item> implements Iterable<Item> {

    private Node first, last;
    private int size;

    public Deque() {
    }

    public static void main(String[] args) {

        Deque<Integer> integers = new Deque<>();

        integers.addFirst(1);
        integers.addFirst(2);
        integers.addFirst(3);

        for (Integer integer : integers) {
            System.out.println(integer);
        }

        System.out.println(integers.removeLast());
        System.out.println(integers.removeLast());
        System.out.println(integers.removeLast());
        integers.addLast(4);
        integers.addLast(5);
        integers.addLast(6);
        System.out.println(integers.removeFirst());
        System.out.println(integers.removeFirst());
        System.out.println(integers.removeFirst());
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        if (item == null) throw new NullPointerException();
        if (isEmpty()) {
            first = new Node();
            last = first;
        } else {
            Node oldFirst = first;
            first = new Node();
            first.next = oldFirst;
            oldFirst.prev = first;
        }
        first.item = item;
        size++;
    }

    public void addLast(Item item) {
        if (item == null) throw new NullPointerException();
        if (isEmpty()) {
            addFirst(item);
        } else {
            Node oldLast = last;
            oldLast.next = new Node();
            last = oldLast.next;
            last.prev = oldLast;
        }
        last.item = item;
        size++;
    }

    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        Node newFirst = first.next;
        Item item = first.item;
        size--;
        if (isEmpty()) {
            first = last = null;
        } else {
            first = newFirst;
        }
        return item;
    }

    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException();
        Item item = last.item;
        size--;
        if (isEmpty()) {
            first = last = null;
        } else {
            last = last.prev;
            last.next = null;
        }
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new DequeueIterator();
    }

    private class DequeueIterator implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (current == null) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    private class Node {
        private Node prev, next;
        private Item item;
    }

}
