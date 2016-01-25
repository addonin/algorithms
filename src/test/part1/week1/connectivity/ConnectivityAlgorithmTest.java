package part1.week1.connectivity;

/**
 * @author dimon
 * @since 23/01/16.
 */
public abstract class ConnectivityAlgorithmTest {

    protected int pIndex;
    protected int qIndex;
    protected int[] expectedElementsAfterUnion;

    public ConnectivityAlgorithmTest(int pIndex, int qIndex, int[] expectedElementsAfterUnion) {
        this.pIndex = pIndex;
        this.qIndex = qIndex;
        this.expectedElementsAfterUnion = expectedElementsAfterUnion;
    }

}