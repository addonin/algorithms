package part1.week1.assignments.percolation;

/**
 * @author dimon
 * @since 23/01/16.
 */
public class Percolation {

    private int N;
    private int[][] grid;

    public Percolation(int N) {
        if (N <= 0) throw new IndexOutOfBoundsException();
        this.N = N;
        grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = 0;
            }
        }
    }

    public void open(int i, int j) {
        validate(i, j);
    }

    public boolean isOpen(int i, int j) {
        validate(i, j);
        return false;
    }

    public boolean isFull(int i, int j) {
        validate(i, j);
        return false;
    }

    public boolean percolates() {
        return false;
    }

    public static void main(String[] args) {

    }

    private void validate(int i, int j) {
        if ((i < 1 || i > N) || (j < 1 || j > N)) throw new IndexOutOfBoundsException();
    }

}
