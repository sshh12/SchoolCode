
import java.awt.Point;
import java.util.*;

public class DFS {

    private static final int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static boolean inBounds(char[][] mat, Point p) {
        return Math.min(p.x, p.y) >= 0 && p.x < mat.length && p.y < mat[0].length;
    }

    public static List<Point> solve(char[][] mat, Point start, Point end) {

        Set<Point> visited = new HashSet<>();
        Map<Point, Point> parents = new HashMap<>();

        Stack<Point> s = new Stack<>();
        s.add(start);

        while (!s.isEmpty()) {

            Point cur = s.pop();
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
                        s.add(n);
                        parents.put(n, cur);
                    }

                }

            }

        }

        return null;

    }

    public static List<Point> solve2(char[][] mat, Point start, Point end) {
        return recur(mat, start, end, new HashSet<Point>(), new ArrayList<Point>());
    }

    private static List<Point> recur(char[][] mat, Point cur, Point end, Set<Point> visited, List<Point> path) {
        visited.add(cur);
        if (cur.equals(end)) {
            path.add(cur);
            return path;
        } else {

            for (int[] dir : dirs) {

                Point n = new Point(cur.x + dir[0], cur.y + dir[1]);
                if (inBounds(mat, n) && !visited.contains(n) && mat[n.x][n.y] == '.') {
                    path.add(cur);
                    List<Point> p = recur(mat, n, end, visited, path);
                    if (p != null) {
                        return p;
                    } else {
                        path.remove(cur);
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

        for (Point p : solve2(grid, new Point(0, 0), new Point(4, 4))) {
            System.out.println(p);
        }

        System.out.println("------");

        for (Point p : solve(grid, new Point(0, 0), new Point(4, 4))) {
            System.out.println(p);
        }

    }

}
