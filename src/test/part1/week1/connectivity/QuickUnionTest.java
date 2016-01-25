package part1.week1.connectivity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author dimon
 * @since 23/01/16.
 */
@RunWith(Parameterized.class)
public class QuickUnionTest extends ConnectivityAlgorithmTest {

    private static QuickUnion quickUnion = new QuickUnion(10);

    public QuickUnionTest(int pIndex, int qIndex, int[] expectedElementsAfterUnion) {
        super(pIndex, qIndex, expectedElementsAfterUnion);
    }

    @Parameters
    public static Collection<Object[]> unions() {
        return Arrays.asList(new Object[][] {
                {0, 1, new int[]{1, 1, 2, 3, 4, 5, 6, 7, 8, 9}},
                {2, 5, new int[]{1, 1, 5, 3, 4, 5, 6, 7, 8, 9}},
                {1, 5, new int[]{1, 5, 5, 3, 4, 5, 6, 7, 8, 9}},
                {9, 6, new int[]{1, 5, 5, 3, 4, 5, 6, 7, 8, 6}},
                {4, 8, new int[]{1, 5, 5, 3, 8, 5, 6, 7, 8, 6}},
                {3, 9, new int[]{1, 5, 5, 6, 8, 5, 6, 7, 8, 6}},
                {7, 1, new int[]{1, 5, 5, 6, 8, 5, 6, 5, 8, 6}},
                {0, 9, new int[]{1, 5, 5, 6, 8, 6, 6, 5, 8, 6}}
        });
    }

    @Test
    public void shouldConnectPtoQ() throws Exception {
        quickUnion.union(pIndex, qIndex);
        assertTrue(quickUnion.isConnected(pIndex, qIndex));
        assertArrayEquals(expectedElementsAfterUnion, quickUnion.getIds());
    }
}