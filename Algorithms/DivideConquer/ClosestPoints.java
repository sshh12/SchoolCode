
import java.awt.Point;
import java.util.*;

public class ClosestPoints {

    private static double bruteForceSmallest(Point[] points) {

        double min = Double.MAX_VALUE;

        for (int i = 0; i < points.length; i++) {

            for (int j = i + 1; j < points.length; j++) {

                min = Math.min(min, points[i].distance(points[j]));

            }

        }

        return min;

    }

    private static double findSmallest(Point[] pointsX, Point[] pointsY) {

        int n = pointsX.length;

        if (n <= 3) {
            return bruteForceSmallest(pointsX);
        }

        int middle = n / 2;
        Point midPoint = pointsX[middle];

        Point[] pointsLeft = new Point[middle + 1];
        Point[] pointsRight = new Point[n - middle - 1];

        for (int i = 0, leftIndex = 0, rightIndex = 0; i < n; i++) {

            if (pointsY[i].x <= midPoint.x) {

                pointsLeft[leftIndex++] = pointsY[i];

            } else {

                pointsRight[rightIndex++] = pointsY[i];

            }

        }

        double smallestLeft = findSmallest(Arrays.copyOfRange(pointsX, 0, middle + 1), pointsLeft);
        double smallestRight = findSmallest(Arrays.copyOfRange(pointsX, middle + 1, n), pointsRight);

        double smallest = Math.min(smallestLeft, smallestRight);

        Point[] splits = new Point[n];
        int numsplits = 0;
        for (int i = 0; i < n; i++) {

            if (Math.abs(pointsY[i].x - midPoint.x) < smallest) {

                splits[numsplits++] = pointsY[i];

            }

        }
        splits = Arrays.copyOf(splits, numsplits);

        Arrays.sort(splits, (Point a, Point b) -> a.y - b.y);

        for (int i = 0; i < numsplits; i++) {

            for (int j = i + 1; j < numsplits && (splits[j].y - splits[i].y) < smallest; j++) {

                smallest = Math.min(smallest, splits[i].distance(splits[j]));

            }

        }

        return smallest;

    }

    public static double getSmallestDistance(Point[] points) {

        Point[] pointsX = Arrays.copyOf(points, points.length);
        Point[] pointsY = Arrays.copyOf(points, points.length);

        Arrays.sort(pointsX, (Point a, Point b) -> a.x - b.x);
        Arrays.sort(pointsY, (Point a, Point b) -> a.y - b.y);

        return findSmallest(pointsX, pointsY);

    }

    public static void main(String[] args) {

        Point[] points = new Point[]{
            new Point(2, 3),
            new Point(11, 30),
            new Point(40, 50),
            new Point(5, 1),
            new Point(12, 10),
            new Point(3, 4)
        };

        System.out.println(getSmallestDistance(points));

    }

}
