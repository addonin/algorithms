package part1.week3.assignments.pointsonflat;

import edu.princeton.cs.algs4.StdDraw;

import java.util.Comparator;

/**
 * @author dimon
 * @since 09/02/16.
 */
public class Point implements Comparable<Point> {

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw() {
        StdDraw.point(x, y);
    }

    public void drawTo(Point that) {
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    public double slopeTo(Point that) {
        return (this.y - that.y)/(this.x - that.x);
    }

    public int compareTo(Point that) {
        if (this.x < that.x && (this.y < that.y || this.y == that.y)) {
            return -1;
        } else if (this.x > that.x && (this.y > that.y || this.y == that.y)) {
            return 1;
        } else {
            return 0;
        }
    }

    public Comparator<Point> slopeOrder() {
        return (p1, p2) -> {
            double slope1 = slopeTo(p1);
            double slope2 = slopeTo(p2);
            return Double.compare(slope1, slope2);
        };
    }


    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public static void main(String[] args) {
        /* YOUR CODE HERE */
    }
}
