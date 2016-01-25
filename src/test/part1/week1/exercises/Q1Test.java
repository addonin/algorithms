package part1.week1.exercises;

import org.junit.Test;
import part1.week1.connectivity.QuickFind;

import java.util.Arrays;

/**
 * @author dimon
 * @since 23/01/16.
 */
public class Q1Test {

    private QuickFind quickFind = new QuickFind(10);

    @Test
    public void testQ1() throws Exception {
        quickFind.union(6, 3);
        quickFind.union(4, 5);
        quickFind.union(6, 0);
        quickFind.union(4, 9);
        quickFind.union(9, 8);
        quickFind.union(5, 2);
        System.out.printf(Arrays.toString(quickFind.getIds()));
    }
}
