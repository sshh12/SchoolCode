class Connect4Game {

  int w, h;
  Player y, r;
  int[][] board;

  public Connect4Game(int w, int h) {
    this.w = w;
    this.h = h;

    board = new int[h][w];
    Helpers.fillMat(board, 0);
  }

  void setYellow(Player p) {
    y = p;
    y.setRed(false);
  }

  void setRed(Player p) {
    r = p;
    r.setRed(true);
  }

  boolean play(Player p) {
    int mov = p.getMove();
    if (mov > -1) {
      return move(mov, p.isRed ? 1:2);
    }
    return false;
  }

  private boolean move(int col, int p) {
    if (board[0][col] == 0) {
      board[Helpers.nextRow(board, col)][col] = p;
      return true;
    }
    return move((int)(Math.random() * w), p); //Invalid Move -> Random Move
  }

  Player getWinner() {
    if (Helpers.mostVertical(board, 1) == 4 || 
      Helpers.mostHorizontal(board, 1) == 4 ||
      Helpers.mostIncDiag(board, 1) == 4 ||
      Helpers.mostDecDiag(board, 1) == 4) {
      return r;
    } else if (Helpers.mostVertical(board, 2) == 4 || 
      Helpers.mostHorizontal(board, 2) == 4 ||
      Helpers.mostIncDiag(board, 2) == 4 ||
      Helpers.mostDecDiag(board, 2) == 4) {
      return y;
    }
    return null;
  }

  void render() {

    background(#3F51B5);
    noStroke();
    ellipseMode(CORNER);
    for (int r = 0; r < h; r++) {
      for (int c = 0; c < w; c++) {
        if (board[r][c] == 1) {
          fill(#E53935);//Red
        } else if (board[r][c] == 2) {
          fill(#FFEB3B);//Yellow
        } else {
          fill(#EEEEEE);//White
        }
        renderSlot(r, c);
      }
    }
  }

  private void renderSlot(int r, int c) {
    int xdis = width / w;
    int ydis = height / h;
    ellipse(c*xdis + 8, r*ydis + 8, xdis-16, ydis-16);
  }

  void highlightWinner(int alpha) {
    fill(255, 0, 255);
    for (int r = 0; r < h; r++) {
      for (int c = 0; c < w; c++) {
        if (board[r][c] != 0) {

          if (board[r][c] == 1) {
            fill(#ff3d00, alpha);
          } else {
            fill(#ff6f00, alpha);
          }

          if (r + 3 < h) {
            if (board[r][c] == board[r + 1][c] && board[r][c] == board[r + 2][c] && board[r][c] == board[r + 3][c]) {
              renderSlot(r, c);
              renderSlot(r + 1, c);
              renderSlot(r + 2, c);
              renderSlot(r + 3, c);
            }
          }
          if (c + 3 < w) {
            if (board[r][c] == board[r][c + 1] && board[r][c] == board[r][c + 2] && board[r][c] == board[r][c + 3]) {
              renderSlot(r, c);
              renderSlot(r, c + 1);
              renderSlot(r, c + 2);
              renderSlot(r, c + 3);
            }
          }
          if (c + 3 < w && r + 3 < h) {
            if (board[r][c] == board[r + 1][c + 1] && board[r][c] == board[r + 2][c + 2] && board[r][c] == board[r + 3][c + 3]) {
              renderSlot(r, c);
              renderSlot(r + 1, c + 1);
              renderSlot(r + 2, c + 2);
              renderSlot(r + 3, c + 3);
            }
          }
          if (c > 2 && r + 3 < h) {
            if (board[r][c] == board[r + 1][c - 1] && board[r][c] == board[r + 2][c - 2] && board[r][c] == board[r + 3][c - 3]) {
              renderSlot(r, c);
              renderSlot(r + 1, c - 1);
              renderSlot(r + 2, c - 2);
              renderSlot(r + 3, c - 3);
            }
          }
        }
      }
    }
  }

  void reset() {
    Helpers.fillMat(board, 0);
  }

  boolean isEmpty() {
    for (int c = 0; c < w; c++) {
      if (board[h-1][c] != 0) {
        return false;
      }
    }
    return true;
  }

  boolean isFull() {
    for (int c = 0; c < w; c++) {
      if (board[0][c] == 0) {
        return false;
      }
    }
    return true;
  }
}