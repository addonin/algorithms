package part1.week2.assignments.queuesanddequeues;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author dimon
 * @since 01/02/16.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

    private Node last;
    private int size = 5;

    public RandomizedQueue() {
    }

    public static void main(String[] args) {
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(Item item) {
        if (item == null) throw new NullPointerException();
        if (isEmpty()) {
            last = new Node();
        } else {
            Node oldLast = last;
            last = new Node();
            last.next = oldLast;
        }
        last.item = item;
        size++;
    }

    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        int randomElementOrderNumber = StdRandom.uniform(1, size + 1);
        int counter = 1;
        return null;
    }

    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException();
        return null;
    }

    @Override
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {

        private Node current = last;
        private RandomizedQueue randomizedQueue;

        public RandomizedQueueIterator() {

        }

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
