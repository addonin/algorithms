package part1.week3.assignments.pointsonflat;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimon
 * @since 09/02/16.
 */
public class BruteCollinearPoints {

    private int segmentsNumber;
    private List<LineSegment> segments = new ArrayList<>();

    public BruteCollinearPoints(Point[] points) {
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                for (int k = 0; k < points.length; k++) {
                    for (int l = 0; l < points.length; l++) {
                        //if (points[i].slopeTo(points[j]) && points[i].slopeTo(points[k]) && points[i].)
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
