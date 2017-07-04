
import edu.princeton.cs.algs4.*;
import java.awt.Color;
import java.util.*;

public class KdTree {

    private int size;
    private Node root;

    /**
     * returns if the size is equal to zero
     *
     * @return
     */
    public boolean isEmpty() {                      // is the set empty? 
        return size == 0;
    }

    /**
     * returns the current size of the tree
     *
     * @return
     */
    public int size() {                      // number of points in the set 
        return size;
    }

    /**
     * inserts a new node if not in the treeSet already the rectangles will
     * encompass the whole area and the point will lie inside
     *
     * @param p
     */
    public void insert(Point2D p) {
        checkIfNull(p);
        if (!contains(p)) {
            root = insert(p, root, false, new RectHV(0, 0, 1, 1));
        }
    }

    /**
     * helper method that inserts a node recursively and updates the Rectangle
     * with it - alternatively a Rectangle could be passed as a parameter to
     * free up space in the node class
     *
     * @param p
     * @param node
     * @param vertical vertical is current root and true being vertical line
     * @return
     */
    private Node insert(Point2D p, Node node, boolean vertical, RectHV box) {
        if (node == null) {
            size++;
            return new Node(p, box);
        }

        if (vertical) {
            if (p.y() < node.p.y()) {
                node.left = insert(p, node.left, false, new RectHV(node.area.xmin(), node.area.ymin(), node.area.xmax(), node.p.y()));
            } else if (p.y() >= node.p.y()) {
                node.right = insert(p, node.right, false, new RectHV(node.area.xmin(), node.p.y(), node.area.xmax(), node.area.ymax()));
            }
        } else if (!vertical) {
            if (p.x() < node.p.x()) {
                node.left = insert(p, node.left, true, new RectHV(node.area.xmin(), node.area.ymin(), node.p.x(), node.area.ymax()));
            } else if (p.x() >= node.p.x()) {
                node.right = insert(p, node.right, true, new RectHV(node.p.x(), node.area.ymin(), node.area.xmax(), node.area.ymax()));
            }
        }

        return node;
    }

    /**
     * recursively ascertains if a point is in the tree
     *
     * @param p
     * @return
     */
    public boolean contains(Point2D p) {           // does the set contain point p? 
        return contains(p, root, false);
    }

    private boolean contains(Point2D p, Node node, boolean vertical) {           // does the set contain point p? 
        if (node == null) {
            return false;
        } else if (p.equals(node.p)) {
            return true;
        }

        boolean cmp; //True if p has a larger value on axis than current node
        if (vertical) {
            cmp = p.y() >= node.p.y();
        } else {
            cmp = p.x() >= node.p.x();
        }

        if (cmp) {
            return contains(p, node.right, !vertical);
        } else {
            return contains(p, node.left, !vertical);
        }

    }

    /**
     * draws all points to standard draw
     */
    public void draw() {
        if (!isEmpty()) {

            StdDraw.setPenRadius(0.005);
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.line(root.p.x(), 0, root.p.x(), 1);

            draw(root, false, new RectHV(0, 0, 1, 1));
        }
    }

    /**
     * method recursively draws nodes and red vertical lines and blue horizontal
     * lines based on vertical
     *
     * @param node
     * @param vertical - true draws vertical red line inside node's rectangle
     * and blue horizontal line inside node's rectangle otherwise
     */
    private void draw(Node node, boolean vertical, RectHV box) {

        if (node == null) {
            return;
        }

        double nX = node.p.x(), nY = node.p.y();

        StdDraw.setPenRadius(0.015);
        StdDraw.setPenColor(StdDraw.BLACK);
        node.p.draw();

        StdDraw.setPenRadius(0.005);
        if (vertical) {
            StdDraw.setPenColor(StdDraw.RED);

            if (node.left != null) {
                StdDraw.line(node.left.p.x(), box.ymin(), node.left.p.x(), nY);
            }

            if (node.right != null) {
                StdDraw.line(node.right.p.x(), box.ymax(), node.right.p.x(), nY);
            }

        } else if (!vertical) {
            StdDraw.setPenColor(StdDraw.BLUE);

            if (node.left != null) {
                StdDraw.line(box.xmin(), node.left.p.y(), nX, node.left.p.y());
            }

            if (node.right != null) {
                StdDraw.line(box.xmax(), node.right.p.y(), nX, node.right.p.y());
            }

        }

        if (node.left != null) {
            draw(node.left, !vertical, node.left.area);
        }
        if (node.right != null) {
            draw(node.right, !vertical, node.right.area);
        }

    }

    /**
     * returns a data structure of all points that are inside the rectangle
     *
     * @param rect
     * @return
     */
    public Iterable<Point2D> range(RectHV rect) {
        checkIfNull(rect);

        ArrayList<Point2D> points = new ArrayList<>();
        range(rect, root, points);

        return points;
    }

    /**
     * helper method to add points that are inside the given rectangle
     *
     * @param rect
     * @param node
     * @param list
     */
    private void range(RectHV target, Node node, ArrayList<Point2D> list) {
        if (node == null || !node.area.intersects(target)) {
            return;
        }

        if (target.contains(node.p)) {
            list.add(node.p);
        }

        range(target, node.left, list);
        range(target, node.right, list);
    }

    /**
     * a nearest neighbor in the set to point p; null if the set is empty
     *
     * @param p
     * @return
     */
    public Point2D nearest(Point2D p) {
        checkIfNull(p);
        return nearest(p, root, false, Double.MAX_VALUE);
    }

    /**
     * helper method to recursively calculate closest point in tree to p with
     * pruning
     *
     * @param p
     * @param node
     * @param vertical
     */
    private Point2D nearest(Point2D p, Node node, boolean vertical, double bestDist) {
        if (node == null || node.area.distanceSquaredTo(p) > bestDist) {
            //if(node != null)
            //    node.area.draw();
            return null;
        }

        Point2D check, best = node.p;

        if (best.distanceSquaredTo(p) < bestDist) {
            bestDist = best.distanceSquaredTo(p);
        }

        check = nearest(p, node.left, !vertical, bestDist);
        if (check != null && check.distanceSquaredTo(p) < bestDist) {
            best = check;
            bestDist = best.distanceSquaredTo(p);
        }

        check = nearest(p, node.right, !vertical, bestDist);
        if (check != null && check.distanceSquaredTo(p) < bestDist) {
            best = check;
        }

        return best;
    }

    /**
     * throws an exception if a null reference is passed
     *
     * @param o
     */
    private void checkIfNull(Object o) {
        if (o == null) {
            throw new java.lang.NullPointerException();
        }
    }

    public static void main(String[] args) {                // unit testing of the methods (optional) 
        String filename = "circle10.txt"; // args[0];
        In in = new In(filename);

        StdDraw.enableDoubleBuffering();

        // initialize the data structures with N points from standard input
        //PointSET brute = new PointSET();
        KdTree kdtree = new KdTree();
        while (true && !in.isEmpty()) {
            double x = in.readDouble();
            double y = in.readDouble();
            Point2D p = new Point2D(x, y);
            //brute.insert(p);
            kdtree.insert(p);
        }

        /*kdtree.insert(new Point2D(0.5, 0.5));
        kdtree.insert(new Point2D(0.7, 0.4));
        kdtree.insert(new Point2D(0.3, 0.7));
        kdtree.insert(new Point2D(0.1, 0.1));
        kdtree.insert(new Point2D(0.05, 0.9));
        kdtree.insert(new Point2D(0.206107, 0.904508));*/
        kdtree.draw();
        //brute.draw();
        StdDraw.show();

    }

    /**
     * inner class that provides the functionality of a Node with references
     * left/right, a point and a RectHV object that is optional
     */
    private class Node {

        Node left, right;
        Point2D p;
        RectHV area;

        public Node(Point2D p) {
            this.p = p;
        }

        public Node(Point2D p, RectHV box) {
            this.p = p;
            this.area = box;
        }

    }
}
