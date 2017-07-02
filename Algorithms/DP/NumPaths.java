
public class NumPaths {

    private static boolean inBounds(char[][] grid, int row, int col) {

        return Math.min(row, col) >= 0 && row < grid.length && col < grid[0].length;

    }

    public static int countPathsAcross(char[][] grid, int row, int col) {

        if (!inBounds(grid, row, col) || grid[row][col] == '#') {

            return 0;

        } else if (row == 0 && col == 0) {

            return 1;

        } else {

            return countPathsAcross(grid, row - 1, col) + countPathsAcross(grid, row, col - 1);

        }

    }

    public static int countPathsAcross2(char[][] grid) {

        int[][] db = new int[grid.length][grid[0].length];

        db[0][0] = 1;

        for (int row = 0; row < grid.length; row++) {

            for (int col = 0; col < grid[0].length; col++) {

                if (row == 0 && col == 0 || grid[row][col] == '#') {

                    continue;

                } else {

                    if (col != 0) {

                        db[row][col] += db[row][col - 1];

                    }

                    if (row != 0) {

                        db[row][col] += db[row - 1][col];

                    }

                }

            }

        }

        return db[grid.length - 1][grid[0].length - 1];

    }

    public static void main(String[] args) {

        char[][] grid = new char[][]{
            {'S', '.', '.', '.', '.', '.'},
            {'.', '#', '.', '.', '#', '.'},
            {'.', '.', '.', '.', '.', '.'},
            {'.', '.', '#', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '#', '.'},
            {'.', '#', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', 'E'}
        };

        System.out.println(countPathsAcross(grid, grid.length - 1, grid[0].length - 1));

        System.out.println("------");

        System.out.println(countPathsAcross2(grid));

    }

}
