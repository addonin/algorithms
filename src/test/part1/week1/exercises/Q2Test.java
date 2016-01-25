package part1.week1.exercises;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author dimon
 * @since 23/01/16.
 */
@RunWith(Parameterized.class)
public class Q2Test {

    private static WeightedQuickUnionUF weightedQuickUnionUF = new WeightedQuickUnionUF(10);

    private int p;
    private int q;

    public Q2Test(int p, int q) {
        this.p = p;
        this.q = q;
    }

    @Parameters
    public static Collection<Object[]> unions() {
        return Arrays.asList(new Object[][]{
                {6, 7}, {0, 6}, {8, 4}, {0, 3}, {6, 5}, {5, 9}, {2, 1}, {8, 2}, {3, 8}
        });
    }

    @Test
    public void testQ2() throws Exception {
        //System.out.println(weightedQuickUnionUF.union(p, q));
    }
}
