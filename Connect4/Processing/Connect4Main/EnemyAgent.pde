import java.util.Random;

class EnemyAgent extends Player {

  boolean iAmRed;
  GameWrapper myGame;
  Random r = new Random();

  public EnemyAgent(Connect4Game g) {
    super(g);
    iAmRed = isRed;
    myGame = new GameWrapper(super.game);
  }

  private class GameWrapper {

    Connect4Game game;

    public GameWrapper(Connect4Game g) {
      game = g;
    }

    Connect4Column getColumn(int col) {
      return new Connect4Column(game.board, col);
    }

    int getRowCount() {
      return game.h;
    }

    int getColumnCount() {
      return game.w;
    }
  }

  private class Connect4Column {

    int[] values;

    public Connect4Column(int[][] board, int col) {
      values = new int[board[0].length];
      for (int r = 0; r < board.length; r++) {
        values[r] = board[r][col];
      }
    }

    Connect4Slot getSlot(int r) {
      return new Connect4Slot(values[r]);
    }

    boolean getIsFull() {
      return values[0] != 0;
    }

    int getRowCount() {
      return values.length;
    }
  }

  private class Connect4Slot {

    int v;

    public Connect4Slot(int n) {
      v = n;
    }

    boolean getIsRed() {
      return v == 1;
    }

    boolean getIsFilled() {
      return v != 0;
    }
  }

  int getMove() {
    int count;
    int rand;
    if (!iAmRed) {
      count = 0;
      rand = (int) (Math.random() * 2D);
      if (theyCanWin() > -1) {
        return theyCanWin();
      } else if (iCanWin() > -1) {
        return iCanWin();
      } else if (myGame.getColumn(3).getSlot(myGame.getRowCount() - 1).getIsFilled() && myGame.getColumn(3).getSlot(myGame.getRowCount() - 1).getIsRed() && !myGame.getColumn(2).getSlot(myGame.getRowCount() - 1).getIsFilled()) {
        return 2;
      } else if (myGame.getColumn(3).getSlot(myGame.getRowCount() - 2).getIsFilled() && myGame.getColumn(3).getSlot(myGame.getRowCount() - 2).getIsRed() && myGame.getColumn(4).getSlot(myGame.getRowCount() - 2).getIsFilled() && myGame.getColumn(4).getSlot(myGame.getRowCount() - 2).getIsRed() && getLowestEmptyIndex(myGame.getColumn(2)) == myGame.getRowCount() - 2 && theyCanWinOffOfMyPlay(2) == -1 && ICanWinOffOfMyPlay(2) == -1) {
        return 2;
      } else if (myGame.getColumn(3).getSlot(myGame.getRowCount() - 2).getIsFilled() && myGame.getColumn(3).getSlot(myGame.getRowCount() - 2).getIsRed() && myGame.getColumn(2).getSlot(myGame.getRowCount() - 2).getIsFilled() && myGame.getColumn(2).getSlot(myGame.getRowCount() - 2).getIsRed() && getLowestEmptyIndex(myGame.getColumn(4)) == myGame.getRowCount() - 2 && theyCanWinOffOfMyPlay(4) == -1 && ICanWinOffOfMyPlay(4) == -1) {
        return 4;
      } else if (getLowestEmptyIndex(myGame.getColumn(3)) > 0 && theyCanWinOffOfMyPlay(3) == -1 && ICanWinOffOfMyPlay(3) == -1) {
        return 3;
      } else if (rand % 2 == 0 && getLowestEmptyIndex(myGame.getColumn(2)) > 0 && theyCanWinOffOfMyPlay(2) == -1 && ICanWinOffOfMyPlay(2) == -1 && setsUp3fromCol2(2) == 2) {
        return 2;
      } else if (rand % 2 == 1 && getLowestEmptyIndex(myGame.getColumn(4)) > 0 && theyCanWinOffOfMyPlay(4) == -1 && ICanWinOffOfMyPlay(4) == -1 && setsUp3fromCol4(4) == 4) {
        return 4;
      } else if (rand % 2 == 0 && getLowestEmptyIndex(myGame.getColumn(1)) > 0 && theyCanWinOffOfMyPlay(1) == -1 && ICanWinOffOfMyPlay(1) == -1) {
        return 1;
      } else if (rand % 2 == 1 && getLowestEmptyIndex(myGame.getColumn(5)) > 0 && theyCanWinOffOfMyPlay(5) == -1 && ICanWinOffOfMyPlay(5) == -1) {
        return 5;
      } else {
        count = 0;
        do {
          if (count >= 200) {
            break;
          }
          int i = randomMove();
          if (i != theyCanWinOffOfMyPlay(i) && ICanWinOffOfMyPlay(i) != i) {
            return i;
          }
          count++;
        } while (true);
      }
      if (count == 200) {
        for (int x = 0; x < myGame.getColumnCount(); x++) {
          if (getLowestEmptyIndex(myGame.getColumn(x)) != -1) {
            return x;
          }
        }

        return randomMove();
      }
    }
    count = 0;
    rand = (int) (Math.random() * 2D);
    if (iCanWin() > -1) {
      return iCanWin();
    } else if (theyCanWin() > -1) {
      return theyCanWin();
    } else if (myGame.getColumn(3).getSlot(myGame.getRowCount() - 1).getIsFilled() && !myGame.getColumn(3).getSlot(myGame.getRowCount() - 1).getIsRed() && !myGame.getColumn(2).getSlot(myGame.getRowCount() - 1).getIsFilled()) {
      return 2;
    } else if (myGame.getColumn(3).getSlot(myGame.getRowCount() - 2).getIsFilled() && !myGame.getColumn(3).getSlot(myGame.getRowCount() - 2).getIsRed() && myGame.getColumn(4).getSlot(myGame.getRowCount() - 2).getIsFilled() && !myGame.getColumn(4).getSlot(myGame.getRowCount() - 2).getIsRed() && getLowestEmptyIndex(myGame.getColumn(2)) == myGame.getRowCount() - 2 && theyCanWinOffOfMyPlay(2) == -1 && ICanWinOffOfMyPlay(2) == -1) {
      return 2;
    } else if (myGame.getColumn(3).getSlot(myGame.getRowCount() - 2).getIsFilled() && !myGame.getColumn(3).getSlot(myGame.getRowCount() - 2).getIsRed() && myGame.getColumn(2).getSlot(myGame.getRowCount() - 2).getIsFilled() && !myGame.getColumn(2).getSlot(myGame.getRowCount() - 2).getIsRed() && getLowestEmptyIndex(myGame.getColumn(4)) == myGame.getRowCount() - 2 && theyCanWinOffOfMyPlay(4) == -1 && ICanWinOffOfMyPlay(4) == -1) {
      return 4;
    } else if (getLowestEmptyIndex(myGame.getColumn(3)) > 0 && theyCanWinOffOfMyPlay(3) == -1 && ICanWinOffOfMyPlay(3) == -1) {
      return 3;
    } else if (rand % 2 == 0 && getLowestEmptyIndex(myGame.getColumn(2)) > 0 && theyCanWinOffOfMyPlay(2) == -1 && ICanWinOffOfMyPlay(2) == -1 && setsUp3fromCol2(2) == 2) {
      return 2;
    } else if (rand % 2 == 1 && getLowestEmptyIndex(myGame.getColumn(4)) > 0 && theyCanWinOffOfMyPlay(4) == -1 && ICanWinOffOfMyPlay(4) == -1 && setsUp3fromCol4(4) == 4) {
      return 4;
    } else if (rand % 2 == 0 && getLowestEmptyIndex(myGame.getColumn(1)) > 0 && theyCanWinOffOfMyPlay(1) == -1 && ICanWinOffOfMyPlay(1) == -1) {
      return 1;
    } else if (rand % 2 == 1 && getLowestEmptyIndex(myGame.getColumn(5)) > 0 && theyCanWinOffOfMyPlay(5) == -1 && ICanWinOffOfMyPlay(5) == -1) {
      return 5;
    } else {
      count = 0;
      do {
        if (count >= 200) {
          break;
        }
        int i = randomMove();
        if (i != theyCanWinOffOfMyPlay(i) && ICanWinOffOfMyPlay(i) != i) {
          return i;
        }
        count++;
      } while (true);
    }
    if (count == 200) {
      for (int x = 0; x < myGame.getColumnCount(); x++) {
        if (getLowestEmptyIndex(myGame.getColumn(x)) != -1) {
          return x;
        }
      }

      return randomMove();
    }
    return 0;
  }

  public int setsUp3fromCol2(int spot) {
    int lowest = getLowestEmptyIndex(myGame.getColumn(spot));
    return lowest - 1 <= 3 || !myGame.getColumn(spot + 1).getSlot(lowest - 1).getIsFilled() || myGame.getColumn(spot + 1).getSlot(lowest - 1).getIsRed() || !myGame.getColumn(spot + 2).getSlot(lowest - 1).getIsFilled() || myGame.getColumn(spot + 2).getSlot(lowest - 1).getIsRed() ? 2 : -1;
  }

  public int setsUp3fromCol4(int spot) {
    int lowest = getLowestEmptyIndex(myGame.getColumn(spot));
    return lowest - 1 <= 3 || !myGame.getColumn(spot - 1).getSlot(lowest - 1).getIsFilled() || myGame.getColumn(spot - 1).getSlot(lowest - 1).getIsRed() || !myGame.getColumn(spot - 2).getSlot(lowest - 1).getIsFilled() || myGame.getColumn(spot - 2).getSlot(lowest - 1).getIsRed() ? 4 : -1;
  }

  public int getLowestEmptyIndex(Connect4Column column) {
    int lowestEmptySlot = -1;
    for (int i = 0; i < column.getRowCount(); i++) {
      if (!column.getSlot(i).getIsFilled()) {
        lowestEmptySlot = i;
      }
    }

    return lowestEmptySlot;
  }

  public int randomMove() {
    int i;
    for (i = r.nextInt(myGame.getColumnCount()); getLowestEmptyIndex(myGame.getColumn(i)) == -1; i = r.nextInt(myGame.getColumnCount()));
    return i;
  }

  public int iCanWin() {
    for (int i = 0; i < myGame.getColumnCount(); i++) {
      Connect4Column test = myGame.getColumn(i);
      if (test.getIsFull()) {
        continue;
      }
      int count = 0;
      for (int j = 0; j < test.getRowCount(); j++) {
        if (!test.getSlot(j).getIsFilled()) {
          continue;
        }
        if (!test.getSlot(j).getIsRed()) {
          break;
        }
        if (++count == 3) {
          return i;
        }
      }
    }

    for (int i = 0; i < myGame.getColumnCount(); i++) {
      Connect4Column test = myGame.getColumn(i);
      if (test.getIsFull()) {
        continue;
      }
      int spot = test.getRowCount() - 1;
      int j = 0;
      do {
        if (j >= test.getRowCount()) {
          break;
        }
        if (test.getSlot(j).getIsFilled()) {
          spot = j - 1;
          break;
        }
        j++;
      } while (true);
      int count = 0;
      for (int col = i - 1; col >= 0 && myGame.getColumn(col).getSlot(spot).getIsFilled() && myGame.getColumn(col).getSlot(spot).getIsRed(); col--) {
        count++;
      }

      for (int col = i + 1; col < myGame.getColumnCount() && myGame.getColumn(col).getSlot(spot).getIsFilled() && myGame.getColumn(col).getSlot(spot).getIsRed(); col++) {
        count++;
      }

      if (count >= 3) {
        return i;
      }
    }

    for (int i = 0; i < myGame.getColumnCount(); i++) {
      Connect4Column test = myGame.getColumn(i);
      int emptySpot = getLowestEmptyIndex(test);
      if (emptySpot == -1) {
        continue;
      }
      int count = 0;
      int col = i - 1;
      int row;
      for (row = emptySpot - 1; col >= 0 && row >= 0 && myGame.getColumn(col).getSlot(row).getIsFilled() && myGame.getColumn(col).getSlot(row).getIsRed(); row--) {
        count++;
        col--;
      }

      row = emptySpot + 1;
      for (col = i + 1; col < myGame.getColumnCount() && row < test.getRowCount() && myGame.getColumn(col).getSlot(row).getIsFilled() && myGame.getColumn(col).getSlot(row).getIsRed(); row++) {
        count++;
        col++;
      }

      if (count >= 3) {
        return i;
      }
      count = 0;
      col = i - 1;
      for (row = emptySpot + 1; col >= 0 && row < test.getRowCount() && myGame.getColumn(col).getSlot(row).getIsFilled() && myGame.getColumn(col).getSlot(row).getIsRed(); row++) {
        count++;
        col--;
      }

      row = emptySpot - 1;
      for (col = i + 1; col < myGame.getColumnCount() && row >= 0 && myGame.getColumn(col).getSlot(row).getIsFilled() && myGame.getColumn(col).getSlot(row).getIsRed(); row--) {
        count++;
        col++;
      }

      if (count >= 3) {
        return i;
      }
    }

    return -1;
  }

  public int theyCanWin() {
    for (int i = 0; i < myGame.getColumnCount(); i++) {
      Connect4Column test = myGame.getColumn(i);
      if (test.getIsFull()) {
        continue;
      }
      int count = 0;
      for (int j = 0; j < test.getRowCount(); j++) {
        if (!test.getSlot(j).getIsFilled()) {
          continue;
        }
        if (test.getSlot(j).getIsRed()) {
          break;
        }
        if (++count == 3) {
          return i;
        }
      }
    }

    for (int i = 0; i < myGame.getColumnCount(); i++) {
      Connect4Column test = myGame.getColumn(i);
      if (test.getIsFull()) {
        continue;
      }
      int spot = test.getRowCount() - 1;
      int j = 0;
      do {
        if (j >= test.getRowCount()) {
          break;
        }
        if (test.getSlot(j).getIsFilled()) {
          spot = j - 1;
          break;
        }
        j++;
      } while (true);
      int count = 0;
      for (int col = i - 1; col >= 0 && myGame.getColumn(col).getSlot(spot).getIsFilled() && !myGame.getColumn(col).getSlot(spot).getIsRed(); col--) {
        count++;
      }

      for (int col = i + 1; col < myGame.getColumnCount() && myGame.getColumn(col).getSlot(spot).getIsFilled() && !myGame.getColumn(col).getSlot(spot).getIsRed(); col++) {
        count++;
      }

      if (count >= 3) {
        return i;
      }
    }

    for (int i = 0; i < myGame.getColumnCount(); i++) {
      Connect4Column test = myGame.getColumn(i);
      int emptySpot = getLowestEmptyIndex(test);
      if (emptySpot == -1) {
        continue;
      }
      int count = 0;
      int col = i - 1;
      int row;
      for (row = emptySpot - 1; col >= 0 && row >= 0 && myGame.getColumn(col).getSlot(row).getIsFilled() && !myGame.getColumn(col).getSlot(row).getIsRed(); row--) {
        count++;
        col--;
      }

      row = emptySpot + 1;
      for (col = i + 1; col < myGame.getColumnCount() && row < test.getRowCount() && myGame.getColumn(col).getSlot(row).getIsFilled() && !myGame.getColumn(col).getSlot(row).getIsRed(); row++) {
        count++;
        col++;
      }

      if (count >= 3) {
        return i;
      }
      count = 0;
      col = i - 1;
      for (row = emptySpot + 1; col >= 0 && row < test.getRowCount() && myGame.getColumn(col).getSlot(row).getIsFilled() && !myGame.getColumn(col).getSlot(row).getIsRed(); row++) {
        count++;
        col--;
      }

      row = emptySpot - 1;
      for (col = i + 1; col < myGame.getColumnCount() && row >= 0 && myGame.getColumn(col).getSlot(row).getIsFilled() && !myGame.getColumn(col).getSlot(row).getIsRed(); row--) {
        count++;
        col++;
      }

      if (count >= 3) {
        return i;
      }
    }

    return -1;
  }

  public int theyCanWinOffOfMyPlay(int i) {
    Connect4Column test = myGame.getColumn(i);
    int emptySpot = getLowestEmptyIndex(test);
    if (emptySpot == -1 || emptySpot == 0) {
      return -1;
    }
    emptySpot--;
    int count = 0;
    int col = i - 1;
    int row;
    for (row = emptySpot - 1; col >= 0 && row >= 0 && myGame.getColumn(col).getSlot(row).getIsFilled() && !myGame.getColumn(col).getSlot(row).getIsRed(); row--) {
      count++;
      col--;
    }

    row = emptySpot + 1;
    for (col = i + 1; col < myGame.getColumnCount() && row < test.getRowCount() && myGame.getColumn(col).getSlot(row).getIsFilled() && !myGame.getColumn(col).getSlot(row).getIsRed(); row++) {
      count++;
      col++;
    }

    if (count >= 3) {
      return i;
    }
    count = 0;
    col = i - 1;
    for (row = emptySpot + 1; col >= 0 && row < test.getRowCount() && myGame.getColumn(col).getSlot(row).getIsFilled() && !myGame.getColumn(col).getSlot(row).getIsRed(); row++) {
      count++;
      col--;
    }

    row = emptySpot - 1;
    for (col = i + 1; col < myGame.getColumnCount() && row >= 0 && myGame.getColumn(col).getSlot(row).getIsFilled() && !myGame.getColumn(col).getSlot(row).getIsRed(); row--) {
      count++;
      col++;
    }

    if (count >= 3) {
      return i;
    }
    row = emptySpot;
    count = 0;
    for (col = i - 1; col >= 0 && myGame.getColumn(col).getSlot(row).getIsFilled() && !myGame.getColumn(col).getSlot(row).getIsRed(); col--) {
      count++;
    }

    for (col = i + 1; col < myGame.getColumnCount() && myGame.getColumn(col).getSlot(row).getIsFilled() && !myGame.getColumn(col).getSlot(row).getIsRed(); col++) {
      count++;
    }

    if (count >= 3) {
      return i;
    } else {
      return -1;
    }
  }

  public int ICanWinOffOfMyPlay(int i) {
    Connect4Column test = myGame.getColumn(i);
    int emptySpot = getLowestEmptyIndex(test);
    if (emptySpot == -1 || emptySpot == 0) {
      return -1;
    }
    emptySpot--;
    int count = 0;
    int col = i - 1;
    int row;
    for (row = emptySpot - 1; col >= 0 && row >= 0 && myGame.getColumn(col).getSlot(row).getIsFilled() && myGame.getColumn(col).getSlot(row).getIsRed(); row--) {
      count++;
      col--;
    }

    row = emptySpot + 1;
    for (col = i + 1; col < myGame.getColumnCount() && row < test.getRowCount() && myGame.getColumn(col).getSlot(row).getIsFilled() && myGame.getColumn(col).getSlot(row).getIsRed(); row++) {
      count++;
      col++;
    }

    if (count >= 3) {
      return i;
    }
    count = 0;
    col = i - 1;
    for (row = emptySpot + 1; col >= 0 && row < test.getRowCount() && myGame.getColumn(col).getSlot(row).getIsFilled() && myGame.getColumn(col).getSlot(row).getIsRed(); row++) {
      count++;
      col--;
    }

    row = emptySpot - 1;
    for (col = i + 1; col < myGame.getColumnCount() && row >= 0 && myGame.getColumn(col).getSlot(row).getIsFilled() && myGame.getColumn(col).getSlot(row).getIsRed(); row--) {
      count++;
      col++;
    }

    if (count >= 3) {
      return i;
    }
    row = emptySpot;
    count = 0;
    for (col = i - 1; col >= 0 && myGame.getColumn(col).getSlot(row).getIsFilled() && myGame.getColumn(col).getSlot(row).getIsRed(); col--) {
      count++;
    }

    for (col = i + 1; col < myGame.getColumnCount() && myGame.getColumn(col).getSlot(row).getIsFilled() && myGame.getColumn(col).getSlot(row).getIsRed(); col++) {
      count++;
    }

    if (count >= 3) {
      return i;
    } else {
      return -1;
    }
  }
}