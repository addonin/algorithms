package part1.week1.assignments.percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author dimon
 * @since 26/01/16.
 */
public class PercolationTest {

    private Percolation percolation;
    private WeightedQuickUnionUF uf;

    @Before
    public void setUp() throws Exception {
        percolation = new Percolation(3);
    }

    @Test
    public void shouldReturnCorrectFlatIndexes() throws Exception {

    }

    @Test
    public void shouldConnectSites() throws Exception {

        int i1 = 1, j1 = 1, i2 = 1, j2 = 2;

        percolation.open(i1, j1);
        assertTrue(percolation.isOpen(i1, j1));

        percolation.open(i2, j2);
        assertTrue(percolation.isOpen(i2, j2));

        uf.connected(percolation.ijToFlatIndex(i1, j1), percolation.ijToFlatIndex(i2, j2));
    }
}