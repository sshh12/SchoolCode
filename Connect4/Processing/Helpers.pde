static class Helpers {

  static int mostVertical(int[][] board, int p) {
    int most = 0;
    for (int c = 0; c < board[0].length; c++) {
      for (int r = 0; r < board.length; r++) {
        if (board[r][c] == p) {
          int count = 1;
          while (r + count < board.length && board[r + count][c] == p) {
            count++;
          }
          most = max(most, count);
        }
      }
    }
    return most;
  }

  static int mostHorizontal(int[][] board, int p) {
    int most = 0;
    for (int r = 0; r < board.length; r++) {
      for (int c = 0; c < board[0].length; c++) {
        if (board[r][c] == p) {
          int count = 1;
          while (c + count < board[0].length && board[r][c + count] == p) {
            count++;
          }
          most = max(most, count);
        }
      }
    }
    return most;
  }

  static int mostIncDiag(int[][] board, int p) {
    int most = 0;
    for (int r = 0; r < board.length; r++) {
      for (int c = 0; c < board[0].length; c++) {
        int rr = r, cc = c, count = 0;

        while (rr > 0 && cc < board[rr].length && board[rr][cc] == p) {
          rr--;
          cc++;
          count++;
        }
        most = max(most, count);
      }
    }
    return most;
  }

  static int mostDecDiag(int[][] board, int p) {
    int most = 0;
    for (int r = 0; r < board.length; r++) {
      for (int c = 0; c < board[0].length; c++) {
        int rr = r, cc = c, count = 0;
        while (rr < board.length && cc < board[rr].length && board[rr][cc] == p) {
          rr++;
          cc++;
          count++;
        }
        most = max(most, count);
      }
    }
    return most;
  }

  static int nextRow(int[][] board, int c) {
    if (board[0][c] == 0) {
      int row = 0;
      while (row < board.length && board[row][c] == 0) {
        row++;
      }
      return row-1;
    }
    return -1;
  }

  static int sum(int[] v) {
    int s = 0;
    for (int j : v) {
      s += j;
    }
    return s;
  }

  static int count(int[] v, int n) {
    int c = 0;
    for (int j : v) {
      if (j == n) {
        c++;
      }
    }
    return c;
  }

  static boolean containsAtLeast(int[] v, int n) {
    for (int j : v) {
      if (j >= n) {
        return true;
      }
    }
    return false;
  }

  static void fillMat(int[][] board, int v) {
    for (int[] row : board) {
      for (int c = 0; c < row.length; c++) {
        row[c] = v;
      }
    }
  }

  static int[][] copyMat(int[][] board) {
    int[][] m = new int[board.length][board[0].length];
    for (int r = 0; r < board.length; r++) {
      for (int c = 0; c < board[r].length; c++) {
        m[r][c] = board[r][c];
      }
    }
    return m;
  }

  static String showMat(int[][] board) {
    String s = "";
    for (int[] row : board) {
      for (int c : row) {
        s += c + " ";
      }
      s += "\n";
    }
    return s;
  }

  static String indent(int v, int i) {
    String s = "";
    for (; i >= 0; i--) {
      s += " ";
    }
    return s + v;
  }
}