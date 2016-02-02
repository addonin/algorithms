package part1.week2.assignments.queuesanddeques;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author dimon
 * @since 01/02/16.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

    private Node last;
    private int size;

    public RandomizedQueue() {
    }

    public static void main(String[] args) {
        RandomizedQueue<Integer> integers = new RandomizedQueue<>();
        integers.enqueue(1);
        integers.enqueue(2);
        integers.enqueue(3);
        integers.enqueue(4);
        integers.enqueue(5);

        int counter = 0;
        while (counter++ < 5) {
            System.out.println(integers.sample());
        }

        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        iterator = integers.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        while (integers.size() > 0) {
            System.out.println(integers.dequeue());
        }
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
            oldLast.prev = last;
        }
        last.item = item;
        size++;
    }

    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        int randomElementOrderNumber = getRandomNodeSerialNumber();
        int counter = 1;
        Node currentNode = last;
        while (++counter <= randomElementOrderNumber) currentNode = currentNode.next;
        Item item = currentNode.item;
        if (size == 1 || randomElementOrderNumber == size) {
            currentNode = null;
        } else if (randomElementOrderNumber == 1) {
            last = last.next;
            last.prev = null;
        } else {
            currentNode.prev.next = currentNode.next;
            currentNode.next.prev = currentNode.prev;
            currentNode = null;
        }
        size--;
        return item;
    }

    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException();
        int randomElementOrderNumber = getRandomNodeSerialNumber();
        int counter = 1;
        Node currentNode = last;
        while (++counter <= randomElementOrderNumber) currentNode = currentNode.next;
        return currentNode.item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {

        private int currentIndex;
        private Item[] randomizedSequence;

        public RandomizedQueueIterator() {
            randomizedSequence = (Item[]) new Object[size];
            int counter = 0;
            Node tempLast = last;
            do {
                randomizedSequence[counter] = tempLast.item;
                tempLast = tempLast.next;
                counter++;
            } while (tempLast != null);
            StdRandom.shuffle(randomizedSequence);
        }

        @Override
        public boolean hasNext() {
            return currentIndex < randomizedSequence.length;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = randomizedSequence[currentIndex];
            currentIndex++;
            return item;
        }

    }

    private class Node {
        private Node prev, next;
        private Item item;
    }

    private int getRandomNodeSerialNumber() {
        return StdRandom.uniform(1, size + 1);
    }

}
