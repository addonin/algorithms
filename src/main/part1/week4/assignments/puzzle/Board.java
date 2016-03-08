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
        Board board = new Board(blocks);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                if (blocks[i][j] != 0 && blocks[i][j + 1] != 0) {
                    board.swap(i, j, i, j + 1);
                    return board;
                }
            }
        }
        return board;
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
        int i0 = 0, j0 = 0;
        boolean found = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (blocks[i][j] == 0) {
                    i0 = i;
                    j0 = j;
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }

        Stack<Board> boards = new Stack<Board>();
        Board board = new Board(blocks);
        boolean isNeighbor = board.swap(i0, j0, i0 - 1, j0);
        if (isNeighbor) {
            boards.push(board);
        }
        board = new Board(blocks);
        isNeighbor = board.swap(i0, j0, i0, j0 - 1);
        if (isNeighbor) {
            boards.push(board);
        }
        board = new Board(blocks);
        isNeighbor = board.swap(i0, j0, i0 + 1, j0);
        if (isNeighbor) {
            boards.push(board);
        }
        board = new Board(blocks);
        isNeighbor = board.swap(i0, j0, i0, j0 + 1);
        if (isNeighbor) {
            boards.push(board);
        }

        return boards;
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

    private boolean swap(int i, int j, int it, int jt) {
        if (it < 0 || it >= N || jt < 0 || jt >= N) {
            return false;
        }
        int temp = blocks[i][j];
        blocks[i][j] = blocks[it][jt];
        blocks[it][jt] = temp;
        return true;
    }

}
