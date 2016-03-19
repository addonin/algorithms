package part1.week5.assignments.kdtree;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Dmytro_Adonin
 * @since 3/9/2016.
 */
public class KdTree {

    private Node root;
    private int N;

    public KdTree() {
        this.N = 0;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return N;
    }

    public void insert(Point2D p) {
        if (p == null) throw new NullPointerException();
        N++;
        if (root == null) {
            root = new Node(p, true, new RectHV(p.x(), 0, p.x(), 1));
        } else if (!contains(p)) {
            final Node parent = parent(root, p);
            final RectHV r = parent.rect;
            final boolean lvlEven = !parent.levelOdd;
            RectHV nr = null;

            if (less(parent.levelOdd, p, parent.p)) {
                if (!lvlEven) nr = new RectHV(0, p.y(), r.xmin(), p.y()); // LH
                else nr = new RectHV(p.x(), r.xmin(), p.x(), r.xmin()); // LV
                parent.lb = new Node(p, lvlEven, nr);
            } else {
                if (!lvlEven) nr = new RectHV(r.xmin(), p.y(), 1, p.y()); // RH
                else nr = new RectHV(p.x(), r.ymax(), p.x(), 1); // RV
                parent.rt = new Node(p, lvlEven, nr);
            }
        }
    }

    private Node parent(final Node n, final Point2D p) {
        if (less(n.levelOdd, p, n.p)) {
            if (n.lb == null) return n;
            else return parent(n.lb, p);
        } else {
            if (n.rt == null) return n;
            else return parent(n.rt, p);
        }
    }

    private boolean less(final boolean levelOdd, final Point2D p, final Point2D q) {
        if (!levelOdd) return p.y() < q.y();
        else return p.x() <= q.x();
    }

    public boolean contains(Point2D p) {
        if (p == null) throw new NullPointerException();
        return !isEmpty() && (p.equals(root.p) || find(root, p) != null);
    }

    private Node find(final Node n, final Point2D p) {
        if (n == null) return null;
        if (p.equals(n.p)) return n;

        Node node = null;
        final boolean isLess = less(n.levelOdd, p, n.p);
        if (isLess) {
            node = find(n.lb, p);
        } else {
            node = find(n.rt, p);
        }
        return node;
    }

    public void draw() {
    }

    public Iterable<Point2D> range(RectHV rect) {
        if (rect == null) throw new NullPointerException();
        return () -> new RangeIterator(root, rect);
    }

    public Point2D nearest(final Point2D p) {
        if (p == null) throw new NullPointerException();
        if (isEmpty()) return null;
        return nearest(root, root.p, p);
    }

    private Point2D nearest(final Node n, final Point2D c, final Point2D p) {
        if (p == null) throw new NullPointerException();
        Point2D nrl = c, nrr = c;
        if (n.lb != null) if (greater(c, n.lb, p)) nrl = nearest(n.lb, n.lb.p, p);
        if (n.rt != null) if (greater(c, n.rt, p)) nrr = nearest(n.rt, n.rt.p, p);
        if (nrl.distanceTo(p) > nrr.distanceTo(p)) return nrr;
        else return nrl;
    }

    private boolean greater(final Point2D c, final Node n, final Point2D p) {
        return c.distanceTo(p) > n.p.distanceTo(p);
    }

    public static void main(String[] args) {
    }

    private static class Node {

        private final boolean levelOdd;
        private final Point2D p;
        private final RectHV rect;
        private Node lb;
        private Node rt;

        public Node(final Point2D p, final boolean levelOdd, final RectHV newRect) {
            this.p = p;
            this.levelOdd = levelOdd;
            this.rect = newRect;
        }

    }

    private static class RangeIterator implements Iterator<Point2D> {

        private final Iterator<Point2D> it;

        public RangeIterator(final Node root, final RectHV r) {
            final List<Point2D> points = new ArrayList<>();
            range(root, r, points);
            this.it = points.iterator();
        }

        private void range(final Node n, final RectHV r, final List<Point2D> points) {
            if (r.contains(n.p)) points.add(n.p);
            if (n.lb != null) range(n.lb, r, points);
            if (n.rt != null) range(n.rt, r, points);
        }

        @Override
        public boolean hasNext() {
            return it.hasNext();
        }

        @Override
        public Point2D next() {
            return it.next();
        }

    }

}
