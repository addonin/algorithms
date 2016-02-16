package part1.week4.assignments.puzzle;

/**
 * @author Dmytro_Adonin
 * @since 2/16/2016.
 */
public class Board {

    private int N;
    private int[][] blocks;

    public Board(int[][] blocks) {
        this.N = blocks.length;
        this.blocks = blocks;
    }

    public int dimension() {
        return N;
    }

    public int hamming() {
        return 0;
    }

    public int manhattan() {
        return 0;
    }

    public boolean isGoal() {
        return false;
    }

    public Board twin() {
        return null;
    }

    public boolean equals(Object y) {
        return false;
    }

    public Iterable<Board> neighbors() {
        return null;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(N + "\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                s.append(String.format("%2d ", blocks[i][j]));
            }
            s.append("\n");
        }
        return s.toString();
    }

}
