package part1.week1.assignments.percolation;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * @author dimon
 * @since 23/01/16.
 */
public class Percolation {

    int N;
    int virtualTopFlatIndex;
    int virtualBottomFlatIndex;
    int[][] sites;
    WeightedQuickUnionUF weightedQuickUnionUF;

    public Percolation(int N) {
        if (N <= 0) throw new IndexOutOfBoundsException();
        this.N = N;
        this.virtualTopFlatIndex = N;
        this.virtualBottomFlatIndex = N * (N + 1);
        this.sites = new int[N + 1][N + 1];
        this.weightedQuickUnionUF = new WeightedQuickUnionUF((N + 1) * (N + 1));
    }

    public static void main(String[] args) {
        int N = 5;
        Percolation percolation = new Percolation(N);
        while (!percolation.percolates()) {
            int i = StdRandom.uniform(1, N + 1);
            int j = StdRandom.uniform(1, N + 1);
            percolation.open(i, j);
            for (int k = 1; k <= N; k++) {
                for (int l = 1; l <= N; l++) {
                    System.out.print(percolation.sites[k][l]);
                }
                System.out.println("");
            }
            System.out.println("");
        }
    }

    public void open(int i, int j) {
        validate(i, j);
        if (isOpen(i, j) || isFull(i, j)) return;
        sites[i][j] = 1;
        int currentFlatIndex = ijToFlatIndex(i, j);
        if (isTopRow(j)) {
            weightedQuickUnionUF.union(currentFlatIndex, virtualTopFlatIndex);
        } else if (isBottomRow(j)) {
            weightedQuickUnionUF.union(currentFlatIndex, virtualBottomFlatIndex);
        } else {
            if (hasUpstairsNeighbour(i, j)) {
                weightedQuickUnionUF.union(currentFlatIndex, upstairNeighbourFlatIndex(i, j));
            }
            if (hasDownstairsNeighbour(i, j)) {
                weightedQuickUnionUF.union(currentFlatIndex, downstairNeighbourFlatIndex(i, j));
            }
            if (hasLeftNeighbour(i, j)) {
                weightedQuickUnionUF.union(currentFlatIndex, leftNeighbourFlatIndex(i, j));
            }
            if (hasRightNeighbour(i, j)) {
                weightedQuickUnionUF.union(currentFlatIndex, rightNeighbourFlatIndex(i, j));
            }
        }
    }

    public boolean isOpen(int i, int j) {
        validate(i, j);
        return sites[i][j] == 1;
    }

    public boolean isFull(int i, int j) {
        validate(i, j);
        int flatIndex = ijToFlatIndex(i, j);
        return weightedQuickUnionUF.connected(flatIndex, virtualTopFlatIndex) ||
                weightedQuickUnionUF.connected(flatIndex, virtualBottomFlatIndex);
    }

    public boolean percolates() {
        return weightedQuickUnionUF.connected(virtualTopFlatIndex, virtualBottomFlatIndex);
    }

    void validate(int i, int j) {
        if ((i < 1 || i > N) || (j < 1 || j > N)) throw new IndexOutOfBoundsException();
    }

    int ijToFlatIndex(int i, int j) {
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
        return j > N && isOpen(i, j + 1);
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
