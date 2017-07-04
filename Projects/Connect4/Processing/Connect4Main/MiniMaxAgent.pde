
class MiniMaxAgent extends Player {

  final int depth = 10;
  final int MAX = 100000, MIN = -MAX;

  public MiniMaxAgent(Connect4Game g) {
    super(g);
  }

  int getMove() {
    int[][] board = Helpers.copyMat(super.game.board);

    /*board = new int[][]{{0, 0, 0, 0, 0, 0, 0}, 
     {0, 0, 0, 0, 0, 0, 0}, 
     {0, 0, 0, 0, 0, 0, 0}, 
     {0, 0, 0, 0, 0, 0, 0}, 
     {1, 0, 0, 0, 0, 0, 1}, 
     {1, 1, 2, 2, 2, 0, 2}};*/

    int randMov = (int)(Math.random() * board[0].length);

    if (super.game.isEmpty()) {
      return randMov;
    }

    int highest = MIN;
    int high = randMov;
    println();
    for (int c = 0; c < board[0].length; c++) {
      if (board[0][c] == 0) {
        int r = Helpers.nextRow(board, c);
        board[r][c] = isRed ? 1:2;
        int score = alphabeta(board, depth, MIN, MAX, false);
        println(c + " " + score);
        if (score > highest) {
          high = c;
          highest = score;
        }
        board[r][c] = 0;
      }
    }
    println("->" + high);
    return high;
  }

  int alphabeta(int[][] current, int depth, int alpha, int beta, boolean maxP) {
    if (depth == 0) {
      return eval(current);
    } else if (maxP) {
      int v = MIN;
      for (int c = 0; c < current[0].length; c++) {
        if (current[0][c] == 0) {
          int r = Helpers.nextRow(current, c);
          current[r][c] = isRed ? 1:2;
          v = max(v, alphabeta(current, depth - 1, alpha, beta, !maxP));
          current[r][c] = 0;
          alpha = max(alpha, v);
          if (beta <= alpha) {
            break;
          }
        }
      }
      return v;
    } else {
      int v = MAX;
      for (int c = 0; c < current[0].length; c++) {
        if (current[0][c] == 0) {
          int r = Helpers.nextRow(current, c);
          current[r][c] = isRed ? 2:1;
          v = min(v, alphabeta(current, depth - 1, alpha, beta, !maxP));
          current[r][c] = 0;
          beta = min(alpha, v);
          if (beta <= alpha) {
            break;
          }
        }
      }
      return v;
    }
  }

  int eval(int[][] board) {
    int me = isRed ? 1 : 2;
    int them = isRed ? 2 : 1;

    int[] mePoints = new int[]{Helpers.mostVertical(board, me), Helpers.mostHorizontal(board, me), Helpers.mostIncDiag(board, me), Helpers.mostDecDiag(board, me)};
    int[] themPoints = new int[]{Helpers.mostVertical(board, them), Helpers.mostHorizontal(board, them), Helpers.mostIncDiag(board, them), Helpers.mostDecDiag(board, them)};

    if (Helpers.containsAtLeast(themPoints, 4)) {
      return MIN;
    }

    if (Helpers.containsAtLeast(mePoints, 4)) {
      return MAX;
    }

    int meScore = Helpers.sum(mePoints) * 20;
    int themScore = Helpers.sum(themPoints) * 20;

    meScore += Helpers.count(mePoints, 3) * 150;
    themScore += Helpers.count(themPoints, 3) * 200;

    return meScore - themScore;
  }
}