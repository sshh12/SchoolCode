import java.util.Random;

public class EnemyAgent extends Agent {

    public EnemyAgent(Connect4Game game, boolean iAmRed) {
        super(game, iAmRed);
        r = new Random();
    }

    public void move() {
        int count;
        int rand;
        if (!iAmRed) {
            count = 0;
            rand = (int) (Math.random() * 2D);
            if (theyCanWin() > -1) {
                moveOnColumn(theyCanWin());
            } else if (iCanWin() > -1) {
                moveOnColumn(iCanWin());
            } else if (myGame.getColumn(3).getSlot(myGame.getRowCount() - 1).getIsFilled() && myGame.getColumn(3).getSlot(myGame.getRowCount() - 1).getIsRed() && !myGame.getColumn(2).getSlot(myGame.getRowCount() - 1).getIsFilled()) {
                moveOnColumn(2);
            } else if (myGame.getColumn(3).getSlot(myGame.getRowCount() - 2).getIsFilled() && myGame.getColumn(3).getSlot(myGame.getRowCount() - 2).getIsRed() && myGame.getColumn(4).getSlot(myGame.getRowCount() - 2).getIsFilled() && myGame.getColumn(4).getSlot(myGame.getRowCount() - 2).getIsRed() && getLowestEmptyIndex(myGame.getColumn(2)) == myGame.getRowCount() - 2 && theyCanWinOffOfMyPlay(2) == -1 && ICanWinOffOfMyPlay(2) == -1) {
                moveOnColumn(2);
            } else if (myGame.getColumn(3).getSlot(myGame.getRowCount() - 2).getIsFilled() && myGame.getColumn(3).getSlot(myGame.getRowCount() - 2).getIsRed() && myGame.getColumn(2).getSlot(myGame.getRowCount() - 2).getIsFilled() && myGame.getColumn(2).getSlot(myGame.getRowCount() - 2).getIsRed() && getLowestEmptyIndex(myGame.getColumn(4)) == myGame.getRowCount() - 2 && theyCanWinOffOfMyPlay(4) == -1 && ICanWinOffOfMyPlay(4) == -1) {
                moveOnColumn(4);
            } else if (getLowestEmptyIndex(myGame.getColumn(3)) > 0 && theyCanWinOffOfMyPlay(3) == -1 && ICanWinOffOfMyPlay(3) == -1) {
                moveOnColumn(3);
            } else if (rand % 2 == 0 && getLowestEmptyIndex(myGame.getColumn(2)) > 0 && theyCanWinOffOfMyPlay(2) == -1 && ICanWinOffOfMyPlay(2) == -1 && setsUp3fromCol2(2) == 2) {
                moveOnColumn(2);
            } else if (rand % 2 == 1 && getLowestEmptyIndex(myGame.getColumn(4)) > 0 && theyCanWinOffOfMyPlay(4) == -1 && ICanWinOffOfMyPlay(4) == -1 && setsUp3fromCol4(4) == 4) {
                moveOnColumn(4);
            } else if (rand % 2 == 0 && getLowestEmptyIndex(myGame.getColumn(1)) > 0 && theyCanWinOffOfMyPlay(1) == -1 && ICanWinOffOfMyPlay(1) == -1) {
                moveOnColumn(1);
            } else if (rand % 2 == 1 && getLowestEmptyIndex(myGame.getColumn(5)) > 0 && theyCanWinOffOfMyPlay(5) == -1 && ICanWinOffOfMyPlay(5) == -1) {
                moveOnColumn(5);
            } else {
                count = 0;
                do {
                    if (count >= 200) {
                        break;
                    }
                    int i = randomMove();
                    if (i != theyCanWinOffOfMyPlay(i) && ICanWinOffOfMyPlay(i) != i) {
                        moveOnColumn(i);
                        break;
                    }
                    count++;
                } while (true);
            }
            if (count == 200) {
                for (int x = 0; x < myGame.getColumnCount(); x++) {
                    if (getLowestEmptyIndex(myGame.getColumn(x)) != -1) {
                        moveOnColumn(x);
                        return;
                    }
                }

                moveOnColumn(randomMove());
            }
            return;
        }
        count = 0;
        rand = (int) (Math.random() * 2D);
        if (iCanWin() > -1) {
            moveOnColumn(iCanWin());
        } else if (theyCanWin() > -1) {
            moveOnColumn(theyCanWin());
        } else if (myGame.getColumn(3).getSlot(myGame.getRowCount() - 1).getIsFilled() && !myGame.getColumn(3).getSlot(myGame.getRowCount() - 1).getIsRed() && !myGame.getColumn(2).getSlot(myGame.getRowCount() - 1).getIsFilled()) {
            moveOnColumn(2);
        } else if (myGame.getColumn(3).getSlot(myGame.getRowCount() - 2).getIsFilled() && !myGame.getColumn(3).getSlot(myGame.getRowCount() - 2).getIsRed() && myGame.getColumn(4).getSlot(myGame.getRowCount() - 2).getIsFilled() && !myGame.getColumn(4).getSlot(myGame.getRowCount() - 2).getIsRed() && getLowestEmptyIndex(myGame.getColumn(2)) == myGame.getRowCount() - 2 && theyCanWinOffOfMyPlay(2) == -1 && ICanWinOffOfMyPlay(2) == -1) {
            moveOnColumn(2);
        } else if (myGame.getColumn(3).getSlot(myGame.getRowCount() - 2).getIsFilled() && !myGame.getColumn(3).getSlot(myGame.getRowCount() - 2).getIsRed() && myGame.getColumn(2).getSlot(myGame.getRowCount() - 2).getIsFilled() && !myGame.getColumn(2).getSlot(myGame.getRowCount() - 2).getIsRed() && getLowestEmptyIndex(myGame.getColumn(4)) == myGame.getRowCount() - 2 && theyCanWinOffOfMyPlay(4) == -1 && ICanWinOffOfMyPlay(4) == -1) {
            moveOnColumn(4);
        } else if (getLowestEmptyIndex(myGame.getColumn(3)) > 0 && theyCanWinOffOfMyPlay(3) == -1 && ICanWinOffOfMyPlay(3) == -1) {
            moveOnColumn(3);
        } else if (rand % 2 == 0 && getLowestEmptyIndex(myGame.getColumn(2)) > 0 && theyCanWinOffOfMyPlay(2) == -1 && ICanWinOffOfMyPlay(2) == -1 && setsUp3fromCol2(2) == 2) {
            moveOnColumn(2);
        } else if (rand % 2 == 1 && getLowestEmptyIndex(myGame.getColumn(4)) > 0 && theyCanWinOffOfMyPlay(4) == -1 && ICanWinOffOfMyPlay(4) == -1 && setsUp3fromCol4(4) == 4) {
            moveOnColumn(4);
        } else if (rand % 2 == 0 && getLowestEmptyIndex(myGame.getColumn(1)) > 0 && theyCanWinOffOfMyPlay(1) == -1 && ICanWinOffOfMyPlay(1) == -1) {
            moveOnColumn(1);
        } else if (rand % 2 == 1 && getLowestEmptyIndex(myGame.getColumn(5)) > 0 && theyCanWinOffOfMyPlay(5) == -1 && ICanWinOffOfMyPlay(5) == -1) {
            moveOnColumn(5);
        } else {
            count = 0;
            do {
                if (count >= 200) {
                    break;
                }
                int i = randomMove();
                if (i != theyCanWinOffOfMyPlay(i) && ICanWinOffOfMyPlay(i) != i) {
                    moveOnColumn(i);
                    break;
                }
                count++;
            } while (true);
        }
        if (count == 200) {
            for (int x = 0; x < myGame.getColumnCount(); x++) {
                if (getLowestEmptyIndex(myGame.getColumn(x)) != -1) {
                    moveOnColumn(x);
                    return;
                }
            }

            moveOnColumn(randomMove());
        }
    }

    public int setsUp3fromCol2(int spot) {
        int lowest = getLowestEmptyIndex(myGame.getColumn(spot));
        return lowest - 1 <= 3 || !myGame.getColumn(spot + 1).getSlot(lowest - 1).getIsFilled() || myGame.getColumn(spot + 1).getSlot(lowest - 1).getIsRed() || !myGame.getColumn(spot + 2).getSlot(lowest - 1).getIsFilled() || myGame.getColumn(spot + 2).getSlot(lowest - 1).getIsRed() ? 2 : -1;
    }

    public int setsUp3fromCol4(int spot) {
        int lowest = getLowestEmptyIndex(myGame.getColumn(spot));
        return lowest - 1 <= 3 || !myGame.getColumn(spot - 1).getSlot(lowest - 1).getIsFilled() || myGame.getColumn(spot - 1).getSlot(lowest - 1).getIsRed() || !myGame.getColumn(spot - 2).getSlot(lowest - 1).getIsFilled() || myGame.getColumn(spot - 2).getSlot(lowest - 1).getIsRed() ? 4 : -1;
    }

    public void moveOnColumn(int columnNumber) {
        int lowestEmptySlotIndex = getLowestEmptyIndex(myGame.getColumn(columnNumber));
        if (lowestEmptySlotIndex > -1) {
            Connect4Slot lowestEmptySlot = myGame.getColumn(columnNumber).getSlot(lowestEmptySlotIndex);
            if (iAmRed) {
                lowestEmptySlot.addRed();
            } else {
                lowestEmptySlot.addYellow();
            }
        }
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

    public String getName() {
        return "My Agent";
    }

    Random r;
}
