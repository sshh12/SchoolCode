
import java.awt.Point;
import java.util.*;

public class AStar {

    private static final int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static boolean inBounds(char[][] mat, Point p) {
        return Math.min(p.x, p.y) >= 0 && p.x < mat.length && p.y < mat[0].length;
    }

    public static List<Point> solve(char[][] mat, Point start, Point end) {

        Set<Point> visited = new HashSet<>();
        Map<Point, Point> parents = new HashMap<>();

        PriorityQueue<Point> q = new PriorityQueue<>((Point a, Point b)  -> Double.compare(a.distanceSq(end), b.distanceSq(end)));
        q.add(start);

        while (!q.isEmpty()) {

            Point cur = q.remove();
            visited.add(cur);

            if (cur.equals(end)) {

                LinkedList<Point> path = new LinkedList<>();
                Point node = cur;

                while (node != null) {

                    path.addFirst(node);
                    node = parents.get(node);

                }

                return path;

            } else {

                for (int[] dir : dirs) {

                    Point n = new Point(cur.x + dir[0], cur.y + dir[1]);

                    if (inBounds(mat, n) && !visited.contains(n) && mat[n.x][n.y] == '.') {

                        q.add(n);
                        parents.put(n, cur);

                    }

                }

            }

        }

        return null;

    }

    public static void main(String[] args) {

        char[][] grid = new char[][]{
            {'.', '#', '#', '#', '#'},
            {'.', '#', '.', '.', '.'},
            {'.', '#', '.', '#', '.'},
            {'.', '.', '.', '#', '.'},
            {'.', '#', '#', '.', '.'}
        };

        for (Point point : solve(grid, new Point(0, 0), new Point(4, 4))) {
            System.out.println(point);
        }

    }

}
