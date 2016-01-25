package part1.week1.connectivity;

/**
 * @author dimon
 * @since 23/01/16.
 */
public class WeightedQuickUnion extends ConnectivityAlgorithm {

    public WeightedQuickUnion(int n) {
        super(n);
    }

    @Override
    public void union(int pIndex, int qIndex) {
        //TODO
    }

    @Override
    public boolean isConnected(int pIndex, int qIndex) {
        return findRootIndex(pIndex) == findRootIndex(qIndex);
    }

    private int findRootIndex(int index) {
        return 0; //TODO
    }
}
