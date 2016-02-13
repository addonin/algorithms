package part1.week3.assignments.pointsonflat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dimon
 * @since 09/02/16.
 */
public class BruteCollinearPoints {

    private int segmentsNumber;
    private List<LineSegment> segments = new ArrayList<>();

    public BruteCollinearPoints(Point[] points) {
        if (points == null) throw new NullPointerException();
        for (int i = 0; i < points.length; i++) {
            for (int j = i; j < points.length; j++) {
                for (int k = j; k < points.length; k++) {
                    for (int l = k; l < points.length; l++) {
                        if (i == j || i == k || i == l || j == k || j == l || k == l) {
                            continue;
                        } else {
                            Point p = points[i];
                            Point q = points[j];
                            Point r = points[k];
                            Point s = points[l];
                            if (p == null || q == null || r == null || s == null) {
                                throw new NullPointerException();
                            }
                            if (p.compareTo(q) == 0 || p.compareTo(r) == 0 || p.compareTo(s) == 0
                                    || q.compareTo(r) == 0 || q.compareTo(s) == 0 || r.compareTo(s) == 0) {
                                throw new IllegalArgumentException();
                            }
                            if (p.slopeTo(q) == p.slopeTo(r) && p.slopeTo(q) == p.slopeTo(s)) {
                                Point[] minmax = {p, q, r, s};
                                Arrays.sort(minmax);
                                segments.add(new LineSegment(minmax[0], minmax[minmax.length - 1]));
                                segmentsNumber++;
                            }
                        }
                    }
                }
            }
        }
    }

    public int numberOfSegments() {
        return segmentsNumber;
    }

    public LineSegment[] segments() {
        return segments.toArray(new LineSegment[segments.size()]);
    }

}
