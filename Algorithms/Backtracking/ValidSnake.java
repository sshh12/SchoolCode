
import java.awt.Point;
import java.util.*;

public class ValidSnake {

    private static final int[][] DIRS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static boolean isValidSnake(char[][] grid) {

        Set<Point> snakePoints = new HashSet<>();

        for (int r = 0; r < grid.length; r++) {

            for (int c = 0; c < grid[r].length; c++) {

                if (grid[r][c] == 'S') {

                    snakePoints.add(new Point(r, c));

                }

            }

        }

        for (Point start : snakePoints) {

            if (recur(grid, snakePoints, start, new HashSet<>())) {

                return true;

            }

        }

        return false;

    }

    private static boolean recur(char[][] grid, Set<Point> snakePoints, Point cur, Set<Point> visited) {

        visited.add(cur);

        if (visited.size() == snakePoints.size()) {

            return true;

        } else {

            List<Point> nextPoints = new ArrayList<>();

            for (int[] dir : DIRS) {

                Point n = new Point(cur.x + dir[0], cur.y + dir[1]);

                if (snakePoints.contains(n) && !visited.contains(n)) {

                    nextPoints.add(n);

                }

            }

            if (nextPoints.isEmpty()) {

                return false;

            } else {

                for (Point next : nextPoints) {

                    if (recur(grid, snakePoints, next, visited)) {

                        return true;

                    }

                    visited.remove(next);

                }

                return false;

            }

        }

    }

    public static void main(String[] args) {

        char[][] grid1 = new char[][]{
            {'.', '.', '.', '.', '.', '.'},
            {'.', '.', 'S', 'S', '.', '.'},
            {'.', '.', 'S', '.', '.', '.'},
            {'.', '.', 'S', '.', '.', '.'},
            {'.', '.', 'S', 'S', 'S', '.'},
            {'.', '.', '.', '.', 'S', '.'},
            {'.', '.', '.', '.', '.', '.'}
        };

        char[][] grid2 = new char[][]{
            {'.', '.', '.', '.', '.', '.'},
            {'.', '.', 'S', 'S', 'S', '.'},
            {'.', '.', 'S', '.', 'S', '.'},
            {'.', 'S', 'S', 'S', 'S', '.'},
            {'.', '.', '.', '.', 'S', '.'},
            {'.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.'}
        };

        char[][] grid3 = new char[][]{
            {'.', '.', '.', '.', 'S', '.'},
            {'.', 'S', 'S', 'S', 'S', '.'},
            {'.', 'S', '.', '.', 'S', '.'},
            {'.', 'S', 'S', 'S', 'S', '.'},
            {'.', 'S', 'S', 'S', 'S', '.'},
            {'.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.'}
        };

        System.out.println(isValidSnake(grid1));

        System.out.println(isValidSnake(grid2));

        System.out.println(isValidSnake(grid3));

    }

}
