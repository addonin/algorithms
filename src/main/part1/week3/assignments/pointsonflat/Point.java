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

    public int compareTo(Point that) {
        if (this.x == that.x && this.y == that.y) {
            return 0;
        } else if (this.y < that.y || (this.y == that.y && this.x < that.x)) {
            return -1;
        } else {
            return 1;
        }
    }

    public double slopeTo(Point that) {
        int deltaX = this.x - that.x;
        int deltaY = this.y - that.y;
        if (deltaX == 0 && deltaY == 0) return Double.NEGATIVE_INFINITY;
        if (deltaX == 0) return Double.POSITIVE_INFINITY;
        if (deltaY == 0) return 0.0;
        return deltaY / deltaX;
    }

    public Comparator<Point> slopeOrder() {
        return (p1, p2) -> {
            double slope1 = Point.this.slopeTo(p1);
            double slope2 = Point.this.slopeTo(p2);
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
