package part1.week1.assignments.percolation;

import edu.princeton.cs.algs4.StdStats;

/**
 * @author dimon
 * @since 23/01/16.
 */
public class PercolationStats {

    private int N;
    private int T;
    private int[] openFractions;

    public PercolationStats(int N, int T) {
        if (N <= 0 || T <= 0) throw new IllegalArgumentException();
        this.N = N;
        this.T = T;
        openFractions = new int[T];
    }

    public double mean() {
        return StdStats.mean(openFractions);
    }

    public double stddev() {
        return 0;
    }

    public double confidenceLo() {
        return 0;
    }

    public double confidenceHi() {
        return 0;
    }

    public static void main(String[] args) {
        PercolationStats stats = new PercolationStats(10, 10);

    }
}
