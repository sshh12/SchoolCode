
import java.awt.Point;
import java.util.HashSet;

public class QuickHull {

    private static int getLineDist(Point a, Point b, Point x) {
        return (x.y - a.y) * (b.x - a.x) - (b.y - a.y) * (x.x - a.x);
    }

    private static void findHull(Point[] points, HashSet<Point> hull, Point a, Point b, int side) {

        int maxIndex = -1, maxDist = 0;

        for (int i = 0; i < points.length; i++) {

            int dist = getLineDist(a, b, points[i]);

            int curDist = Math.abs(dist);
            int curSide = Integer.compare(dist, 0);

            if (curSide == side && curDist > maxDist) {

                maxIndex = i;
                maxDist = curDist;

            }

        }

        if (maxIndex == -1) {

            hull.add(a);
            hull.add(b);

        } else {

            findHull(points, hull, points[maxIndex], a, Integer.compare(0, getLineDist(points[maxIndex], a, b)));
            findHull(points, hull, points[maxIndex], b, Integer.compare(0, getLineDist(points[maxIndex], b, a)));

        }

    }

    public static HashSet<Point> getHull(Point[] points) {

        HashSet<Point> hull = new HashSet<>();

        int minX = 0, maxX = 0;

        for (int i = 0; i < points.length; i++) {

            if (points[i].x < points[minX].x) {
                minX = i;
            }

            if (points[i].x > points[maxX].x) {
                maxX = i;
            }

        }

        findHull(points, hull, points[minX], points[maxX], 1);
        findHull(points, hull, points[minX], points[maxX], -1);

        return hull;

    }

    public static void main(String[] args) {

        Point[] points = new Point[]{
            new Point(0, 3),
            new Point(1, 1),
            new Point(2, 2),
            new Point(4, 4),
            new Point(0, 0),
            new Point(1, 2),
            new Point(3, 1),
            new Point(3, 3)
        };

        for (Point p : getHull(points)) {
            System.out.println(p);
        }

    }

}
