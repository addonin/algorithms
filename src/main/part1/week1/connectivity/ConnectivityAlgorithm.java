package part1.week1.connectivity;

/**
 * @author dimon
 * @since 23/01/16.
 */
public abstract class ConnectivityAlgorithm {

    protected int[] ids;

    public ConnectivityAlgorithm(int n) {
        ids = new int[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }
    }

    public abstract void union(int pIndex, int qIndex);

    public abstract boolean isConnected(int pIndex, int qIndex);

    public int[] getIds() {
        return ids;
    }

}
