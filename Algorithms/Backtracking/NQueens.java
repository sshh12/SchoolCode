
import java.util.Arrays;

public class NQueens {

    public static boolean solve(int n) {

        int[][] board = new int[n][n];

        if (recur(board, 0)) {

            for (int[] row : board) {
                System.out.println(Arrays.toString(row));
            }

            return true;

        }

        System.out.println("No Solution");
        return false;

    }

    private static boolean recur(int[][] board, int col) {

        if (col >= board.length) {
            return true;
        }

        for (int row = 0; row < board.length; row++) {

            if (canPlaceQueen(board, row, col)) {

                board[row][col] = 1;

                if (recur(board, col + 1)) {
                    return true;
                }

                board[row][col] = 0;

            }

        }

        return false;

    }

    private static boolean canPlaceQueen(int[][] board, int row, int col) {

        for (int c = 0; c < col; c++) {
            if (board[row][c] == 1) {
                return false;
            }
        }

        for (int r = row, c = col; r >= 0 && c >= 0; r--, c--) {
            if (board[r][c] == 1) {
                return false;
            }
        }

        for (int r = row, c = col; r < board.length && c >= 0; r++, c--) {
            if (board[r][c] == 1) {
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        solve(5);
    }

}
