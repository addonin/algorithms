import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * @author dimon
 * @since 23/01/16.
 */
public class Percolation {

    private int N;
    private int virtualTopFlatIndex;
    private int virtualBottomFlatIndex;
    private int[][] sites;
    private WeightedQuickUnionUF uf;

    public Percolation(int N) {
        if (N <= 0) throw new IllegalArgumentException();
        this.N = N;
        this.virtualTopFlatIndex = N;
        this.virtualBottomFlatIndex = N * (N + 1);
        this.sites = new int[N + 1][N + 1];
        this.uf = new WeightedQuickUnionUF((N + 1) * (N + 1));
        sites[N][0] = 1; //open virtual top
        sites[0][N] = 1; //open virtual bottom
    }

    public static void main(String[] args) {
        int N = 5;
        Percolation percolation = new Percolation(N);
        while (!percolation.percolates()) {

            int i = StdRandom.uniform(1, N + 1);
            int j = StdRandom.uniform(1, N + 1);

            for (int k = 1; k <= N; k++) {
                for (int l = 1; l <= N; l++) {
                    System.out.print(percolation.sites[l][k]);
                }
                System.out.println("");
            }
            System.out.println("");

            percolation.open(i, j);
        }
    }

    public void open(int i, int j) {
        validate(i, j);
        if (isOpen(i, j)) return;
        sites[i][j] = 1;
        int currentFlatIndex = ijToFlatIndex(i, j);
        if (isTopRow(j)) {
            uf.union(currentFlatIndex, virtualTopFlatIndex);
        } else if (isBottomRow(j)) {
            uf.union(currentFlatIndex, virtualBottomFlatIndex);
        }
        if (hasUpstairsNeighbour(i, j)) {
            uf.union(currentFlatIndex, upstairNeighbourFlatIndex(i, j));
        }
        if (hasDownstairsNeighbour(i, j)) {
            uf.union(currentFlatIndex, downstairNeighbourFlatIndex(i, j));
        }
        if (hasLeftNeighbour(i, j)) {
            uf.union(currentFlatIndex, leftNeighbourFlatIndex(i, j));
        }
        if (hasRightNeighbour(i, j)) {
            uf.union(currentFlatIndex, rightNeighbourFlatIndex(i, j));
        }
    }

    public boolean isOpen(int i, int j) {
        validate(i, j);
        return sites[i][j] == 1;
    }

    public boolean isFull(int i, int j) {
        validate(i, j);
        int flatIndex = ijToFlatIndex(i, j);
        return uf.connected(flatIndex, virtualTopFlatIndex) ||
                uf.connected(flatIndex, virtualBottomFlatIndex);
    }

    public boolean percolates() {
        return uf.connected(virtualTopFlatIndex, virtualBottomFlatIndex);
    }

    private void validate(int i, int j) {
        if ((i < 1 || i > N) || (j < 1 || j > N)) throw new IndexOutOfBoundsException();
    }

    private int ijToFlatIndex(int i, int j) {
        return i + j * (N + 1);
    }

    private boolean isTopRow(int j) {
        return j == 1;
    }

    private boolean isBottomRow(int j) {
        return j == N;
    }

    private boolean hasUpstairsNeighbour(int i, int j) {
        return j > 1 && isOpen(i, j - 1);
    }

    private boolean hasDownstairsNeighbour(int i, int j) {
        return j < N && isOpen(i, j + 1);
    }

    private boolean hasLeftNeighbour(int i, int j) {
        return i > 1 && isOpen(i - 1, j);
    }

    private boolean hasRightNeighbour(int i, int j) {
        return i < N && isOpen(i + 1, j);
    }

    private int upstairNeighbourFlatIndex(int i, int j) {
        return ijToFlatIndex(i, j - 1);
    }

    private int downstairNeighbourFlatIndex(int i, int j) {
        return ijToFlatIndex(i, j + 1);
    }

    private int leftNeighbourFlatIndex(int i, int j) {
        return ijToFlatIndex(i - 1, j);
    }

    private int rightNeighbourFlatIndex(int i, int j) {
        return ijToFlatIndex(i + 1, j);
    }

}
