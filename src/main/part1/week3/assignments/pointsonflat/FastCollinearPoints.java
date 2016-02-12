package part1.week3.assignments.pointsonflat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dimon
 * @since 09/02/16.
 */
public class FastCollinearPoints {

    private int segmentsNumber;
    private List<LineSegment> segments = new ArrayList<>();

    public FastCollinearPoints(Point[] points) {
        Point source = points[0];
        Arrays.sort(points, source.slopeOrder());
        for (int i = 1; i < points.length - 2; i++) {
            int counter = 0;
            Point lastColPoint = null;
            while (source.slopeTo(points[i]) == source.slopeTo(points[i + 1])) {
                lastColPoint = points[i + 1];
                counter++;
            }
            if (lastColPoint != null && counter > 3) {
                segments.add(new LineSegment(source, lastColPoint));
                segmentsNumber++;
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
