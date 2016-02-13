package part1.week3.assignments.pointsonflat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author dimon
 * @since 09/02/16.
 */
public class FastCollinearPoints {

    private int segmentsNumber;
    private List<LineSegment> segments = new ArrayList<>();

    public FastCollinearPoints(Point[] points) {
        if (points == null) throw new NullPointerException();

        for (int i = 0; i < points.length; i++) {

            Point source = points[i];
            if (source == null) throw new NullPointerException();

            List<Point> copy = new ArrayList<>(points.length - 1);
            for (Point point : points) {
                if (source.compareTo(point) != 0) copy.add(point);
            }
            Collections.sort(copy, source.slopeOrder());

            for (int j = 0; j < copy.size() - 1;) {
                if (source.compareTo(copy.get(j)) == 0 || source.compareTo(copy.get(j + 1)) == 0)
                    throw new IllegalArgumentException();
                List<Point> collinearPoints = new ArrayList<>(Collections.singletonList(source));
                while (j < copy.size() - 1 && source.slopeTo(copy.get(j)) == source.slopeTo(copy.get(j + 1))) {
                    if (!collinearPoints.contains(copy.get(j))) collinearPoints.add(copy.get(j));
                    if (!collinearPoints.contains(copy.get(j + 1))) collinearPoints.add(copy.get(j + 1));
                    j++;
                }
                if (collinearPoints.size() >= 3) {
                    Collections.sort(collinearPoints);
                    Point min = collinearPoints.get(0);
                    Point max = collinearPoints.get(collinearPoints.size() - 1);
                    LineSegment segment = new LineSegment(min, max);
                    if (!segments.contains(segment)) segments.add(segment);
                }
                j++;
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
