import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 * @author dimon
 * @since 23/01/16.
 */
public class PercolationStats {

    private int N;
    private int T;
    private double[] openFractions;
    private double meanValue = 0;
    private double stdDevValue = 0;

    public PercolationStats(int N, int T) {
        if (N <= 0 || T <= 0) throw new IllegalArgumentException();
        this.N = N;
        this.T = T;
        calculateOpenFractions();
    }

    public static void main(String[] args) {

        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[0]);
        PercolationStats stats = new PercolationStats(N, T);

        System.out.println("mean                    = " + stats.mean());
        System.out.println("stddev                  = " + stats.stddev());
        System.out.println("95% confidence interval = " + stats.confidenceLo() + ", " + stats.confidenceHi());
    }

    public double mean() {
        if (meanValue == 0) {
            meanValue = StdStats.mean(openFractions);
        }
        return meanValue;
    }

    public double stddev() {
        if (stdDevValue == 0) {
            double counter = 0;
            double mean = mean();
            for (int i = 0; i < T; i++) {
                counter += Math.pow((openFractions[i] - mean), 2);
            }
            stdDevValue = Math.sqrt(counter / (T - 1));
        }
        return stdDevValue;
    }

    public double confidenceLo() {
        double mean = mean();
        double stddev = stddev();
        return mean - (1.96 * stddev) / Math.sqrt(T);
    }

    public double confidenceHi() {
        double mean = mean();
        double stddev = stddev();
        return mean + (1.96 * stddev) / Math.sqrt(T);
    }

    private void calculateOpenFractions() {
        openFractions = new double[T];
        for (int k = 0; k < T; k++) {
            Percolation percolation = new Percolation(N);
            while (!percolation.percolates()) {
                int i = StdRandom.uniform(1, N + 1);
                int j = StdRandom.uniform(1, N + 1);
                percolation.open(i, j);
            }
            int counter = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (percolation.isFull(i, j) || percolation.isOpen(i, j)) {
                        counter++;
                    }
                }
            }
            openFractions[k] = counter;
        }
    }

}
