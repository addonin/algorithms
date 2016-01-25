package part1.week1.connectivity;

/**
 * @author dimon
 * @since 23/01/16.
 */
public class QuickFind extends ConnectivityAlgorithm {

    public QuickFind(int n) {
        super(n);
    }

    public void union(int pIndex, int qIndex) {
        if (!isConnected(pIndex, qIndex)) {
            int pid = ids[pIndex];
            int qid = ids[qIndex];
            for (int i = 0; i < ids.length; i++) {
                if (ids[i] == pid) ids[i] = qid;
            }
        }
    }

    public boolean isConnected(int p, int q) {
        return ids[p] == ids[q];
    }

}
