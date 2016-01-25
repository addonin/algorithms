package part1.week1.connectivity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.runners.Parameterized.Parameters;

/**
 * @author dimon
 * @since 23/01/16.
 */
@RunWith(Parameterized.class)
public class WeightedQuickUnionTest extends ConnectivityAlgorithmTest {

    private WeightedQuickUnion weightedQuickUnion = new WeightedQuickUnion(10);

    public WeightedQuickUnionTest(int pIndex, int qIndex, int[] expectedElementsAfterUnion) {
        super(pIndex, qIndex, expectedElementsAfterUnion);
    }

    @Parameters
    public static Collection<Object[]> unions() {
        return Arrays.asList(new Object[][]{
                {3, 4, new int[]{0, 1, 2, 4, 4, 5, 6, 7, 8, 9}},
                {3, 8, new int[]{0, 1, 2, 4, 4, 5, 6, 7, 4, 9}},
                {6, 5, new int[]{0, 1, 2, 4, 4, 6, 6, 7, 4, 9}},
                {9, 4, new int[]{0, 1, 2, 4, 4, 6, 6, 7, 4, 4}},
                {2, 1, new int[]{0, 2, 2, 4, 4, 6, 6, 7, 4, 4}},
                {5, 0, new int[]{6, 2, 2, 4, 4, 6, 6, 2, 4, 4}},
                {6, 1, new int[]{6, 2, 6, 4, 4, 6, 6, 2, 4, 4}},
                {7, 3, new int[]{6, 2, 6, 4, 6, 6, 6, 2, 4, 4}}
        });
    }

    @Test
    public void shouldConnectPtoQ() throws Exception {
/*
        weightedQuickUnion.union(pIndex, qIndex);
        assertTrue(weightedQuickUnion.isConnected(pIndex, qIndex));
        assertArrayEquals(expectedElementsAfterUnion, weightedQuickUnion.getIds());
*/
    }

}