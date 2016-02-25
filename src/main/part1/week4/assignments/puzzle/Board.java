package part1.week4.assignments.puzzle;

/**
 * @author Dmytro_Adonin
 * @since 2/16/2016.
 */
public class Board {

    private int N;
    private int[][] blocks;
    private int counter = 0;

    public Board(int[][] blocks) {
        this.N = blocks.length;
        this.blocks = blocks;
    }

    public int dimension() {
        return N;
    }

    public int hamming() {
        int k = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - 1; j++) {
                if (blocks[i][j] != (j + 1) + (i * N)) {
                    k++;
                }
            }
        }
        return k + counter;
    }

    public int manhattan() {
        int k = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - 1; j++) {
                int block = blocks[i][j];
                if (block != 0 && block != (j + 1) + (i * N)) {
                    int targetX = (block - 1) / N;
                    int targetY = (block - 1) % N;
                    int dx = i - targetX;
                    int dy = j - targetY;
                    k += Math.abs(dx) + Math.abs(dy);
                }
            }
        }
        return k + counter;
    }

    public boolean isGoal() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == N - 1 && j == N - 1 && blocks[i][j] == 0) {
                    return true;
                } else if (blocks[i][j] != (j + 1) + (i * N)) {
                    return false;
                }
            }
        }
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
