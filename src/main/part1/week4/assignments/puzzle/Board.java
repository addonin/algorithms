package part1.week4.assignments.puzzle;

import edu.princeton.cs.algs4.Stack;

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
        int k = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - 1; j++) {
                int block = blocks[i][j];
                if (block != 0 && block != (j + 1) + (i * N)) {
                    k++;
                }
            }
        }
        return k;
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
        return k;
    }

    public boolean isGoal() {
        boolean isGoal = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == N - 1 && j == N - 1 && blocks[i][j] == 0) {
                    isGoal = true;
                } else if (blocks[i][j] != (j + 1) + (i * N)) {
                    isGoal = false;
                }
            }
        }
        return isGoal;
    }

    public Board twin() {
        int [][] twin = new int[N][N];
        for (int i = 0; i < N; i++) {
            System.arraycopy(blocks[i], 0, twin[i], 0, N);
        }
        if (twin[0][0] != 0 && twin[0][1] != 0) {
            int temp = twin[0][0];
            twin[0][0] = twin[0][1];
            twin[0][1] = temp;
        } else {
            int temp = twin[1][0];
            twin[1][0] = twin[1][1];
            twin[1][1] = temp;
        }
        return null;
    }

    @Override
    public boolean equals(Object y) {
        if (y == this) return true;
        if (y == null) return false;
        if (y.getClass() != this.getClass()) return false;
        Board that = (Board) y;
        if (this.N == that.N) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (this.blocks[i][j] != that.blocks[i][j]) return false;
                }
            }
            return true;
        }
        return false;
    }

    public Iterable<Board> neighbors() {
        Stack<Board> neighbours = new Stack<>();
        return neighbours;
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
