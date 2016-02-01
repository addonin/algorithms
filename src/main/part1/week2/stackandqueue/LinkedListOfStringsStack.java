package part1.week2.stackandqueue;

/**
 * @author dimon
 * @since 30/01/16.
 */
public class LinkedListOfStringsStack {

    private Node first = null;

    private class Node {
        private String item;
        private Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(String item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    public String pop() {
        String item = first.item;
        first = first.next;
        return item;
    }

}
