package part1.week5.assignments.kdtree;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdDraw;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author Dmytro_Adonin
 * @since 3/9/2016.
 */
public class PointSET {

    private Set<Point2D> points = new TreeSet<>();

    public PointSET() {
    }

    public boolean isEmpty() {
        return points.isEmpty();
    }

    public int size() {
        return points.size();
    }

    // O(logN)
    public void insert(Point2D p) {
        if (p == null) throw new NullPointerException();
        if (!contains(p)) points.add(p);
    }

    // O(logN)
    public boolean contains(Point2D p) {
        if (p == null) throw new NullPointerException();
        return points.contains(p);
    }

    public void draw() {
        for (final Point2D p : points) {
            StdDraw.point(p.x(), p.y());
        }
    }

    // O(N)
    public Iterable<Point2D> range(RectHV rect) {
        if (rect == null) throw new NullPointerException();
        return () -> {
            final Set<Point2D> nrPoints =
                    points.stream().filter(rect::contains)
                            .collect(Collectors.toCollection(TreeSet::new));
            return new PointIterator(nrPoints);
        };
    }

    // O(N)
    public Point2D nearest(Point2D p) {
        if (p == null) throw new NullPointerException();
        if (isEmpty()) {
            return null;
        }
        Point2D n = null;
        for (final Point2D point : points) {
            if (n == null) {
                n = point;
                continue;
            }
            if (point.distanceTo(p) < n.distanceTo(p)) {
                n = point;
            }
        }
        return n;
    }

    public static void main(String[] args) {
    }

    private static final class PointIterator implements Iterator<Point2D> {

        private final Set<Point2D> nrPoints;
        private final Iterator<Point2D> iterator;

        public PointIterator(final Set<Point2D> points) {
            this.nrPoints = points;
            this.iterator = nrPoints.iterator();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public Point2D next() {
            return iterator.next();
        }

    }

}
