package part1.week1.assignments.percolation;

/**
 * @author dimon
 * @since 23/01/16.
 */
public class PercolationStats {

    private int N;
    private int T;

    public PercolationStats(int N, int T) {
        if (N <= 0 || T <= 0) throw new IllegalArgumentException();
        this.N = N;
        this.T = T;
    }

    public double mean() {
        return 0;
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

    }
}
