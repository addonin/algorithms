package part1.week2.assignments.queuesanddeques;

import edu.princeton.cs.algs4.StdIn;

import java.util.Iterator;

/**
 * @author dimon
 * @since 01/02/16.
 */
public class Subset {

    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> strings = new RandomizedQueue<>();
        while (!StdIn.isEmpty()) strings.enqueue(StdIn.readString());
        Iterator<String> iterator = strings.iterator();
        while (k > 0 && iterator.hasNext()) {
            System.out.println(iterator.next());
            k--;
        }
    }

}
