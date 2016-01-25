package part1.week1.connectivity;

/**
 * @author dimon
 * @since 23/01/16.
 */
public class QuickUnion extends ConnectivityAlgorithm {

    public QuickUnion(int n) {
        super(n);
    }

    public void union(int pIndex, int qIndex) {
        ids[findRootIndex(pIndex)] = ids[findRootIndex(qIndex)];
    }

    public boolean isConnected(int pIndex, int qIndex) {
        return ids[findRootIndex(pIndex)] == ids[findRootIndex(qIndex)];
    }

    private int findRootIndex(int index) {
        int rootIndex = ids[index];
        while (rootIndex != ids[rootIndex]) {
            rootIndex = ids[rootIndex];
        }
        return rootIndex;
    }

}
