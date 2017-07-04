import java.util.Random;

public class BrilliantAgent extends Agent {

    public BrilliantAgent(Connect4Game connect4game, boolean flag) {
        super(connect4game, flag);
        r = new Random();
    }

    public void move() {
        int i = 0;
        int j = canWin(iAmRed);
        int k = canWin(!iAmRed);
        if (j >= 0) {
            i = j;
        } else if (k >= 0) {
            i = k;
        } else {
            i = randomMove();
        }
        moveOnColumn(i);
    }

    public int randomMove() {
        int i;
        for (i = r.nextInt(myGame.getColumnCount()); getTopEmptySlot(myGame.getColumn(i)) == null; i = r.nextInt(myGame.getColumnCount()));
        return i;
    }

    public void moveOnColumn(int i) {
        Connect4Slot connect4slot = getTopEmptySlot(myGame.getColumn(i));
        if (connect4slot != null) {
            if (iAmRed) {
                connect4slot.addRed();
            } else {
                connect4slot.addYellow();
            }
        }
    }

    public Connect4Slot getTopEmptySlot(Connect4Column connect4column) {
        int i = -1;
        for (int j = 0; j < connect4column.getRowCount(); j++) {
            if (!connect4column.getSlot(j).getIsFilled()) {
                i = j;
            }
        }

        if (i < 0) {
            return null;
        } else {
            return connect4column.getSlot(i);
        }
    }

    public int canWin(boolean flag) {
        for (int i = 0; i < myGame.getColumnCount(); i++) {
            int j = getTopEmptyIndex(myGame.getColumn(i));
            if (j <= -1) {
                continue;
            }
            if (j < myGame.getRowCount() - 3 && myGame.getColumn(i).getSlot(j + 1).getIsRed() == flag && myGame.getColumn(i).getSlot(j + 2).getIsRed() == flag && myGame.getColumn(i).getSlot(j + 3).getIsRed() == flag) {
                return i;
            }
            if (i < myGame.getColumnCount() - 3 && checkIfEqual(flag, myGame.getColumn(i + 1).getSlot(j), myGame.getColumn(i + 2).getSlot(j), myGame.getColumn(i + 3).getSlot(j))) {
                return i;
            }
            if (i < myGame.getColumnCount() - 2 && i > 0 && checkIfEqual(flag, myGame.getColumn(i - 1).getSlot(j), myGame.getColumn(i + 1).getSlot(j), myGame.getColumn(i + 2).getSlot(j))) {
                return i;
            }
            if (i < myGame.getColumnCount() - 1 && i > 1 && checkIfEqual(flag, myGame.getColumn(i - 1).getSlot(j), myGame.getColumn(i + 1).getSlot(j), myGame.getColumn(i - 2).getSlot(j))) {
                return i;
            }
            if (i > 2 && checkIfEqual(flag, myGame.getColumn(i - 1).getSlot(j), myGame.getColumn(i - 3).getSlot(j), myGame.getColumn(i - 2).getSlot(j))) {
                return i;
            }
            if (i < myGame.getColumnCount() - 3 && j < myGame.getRowCount() - 3 && checkIfEqual(flag, myGame.getColumn(i + 1).getSlot(j + 1), myGame.getColumn(i + 3).getSlot(j + 3), myGame.getColumn(i + 2).getSlot(j + 2))) {
                return i;
            }
            if (i < myGame.getColumnCount() - 2 && i > 0 && j < myGame.getRowCount() - 2 && j > 0 && checkIfEqual(flag, myGame.getColumn(i + 1).getSlot(j + 1), myGame.getColumn(i - 1).getSlot(j - 1), myGame.getColumn(i + 2).getSlot(j + 2))) {
                return i;
            }
            if (i < myGame.getColumnCount() - 1 && i > 1 && j < myGame.getRowCount() - 1 && j > 1 && checkIfEqual(flag, myGame.getColumn(i + 1).getSlot(j + 1), myGame.getColumn(i - 1).getSlot(j - 1), myGame.getColumn(i - 2).getSlot(j - 2))) {
                return i;
            }
            if (i < myGame.getColumnCount() && i > 2 && j < myGame.getRowCount() && j > 2 && checkIfEqual(flag, myGame.getColumn(i - 1).getSlot(j - 1), myGame.getColumn(i - 2).getSlot(j - 2), myGame.getColumn(i - 3).getSlot(j - 3))) {
                return i;
            }
            if (i > 2 && i < myGame.getColumnCount() && j < myGame.getRowCount() - 3 && j >= 0 && checkIfEqual(flag, myGame.getColumn(i - 1).getSlot(j + 1), myGame.getColumn(i - 2).getSlot(j + 2), myGame.getColumn(i - 3).getSlot(j + 3))) {
                return i;
            }
            if (i > 1 && i < myGame.getColumnCount() - 1 && j < myGame.getRowCount() - 2 && j > 0 && checkIfEqual(flag, myGame.getColumn(i - 1).getSlot(j + 1), myGame.getColumn(i - 2).getSlot(j + 2), myGame.getColumn(i + 1).getSlot(j - 1))) {
                return i;
            }
            if (i > 0 && i < myGame.getColumnCount() - 2 && j < myGame.getRowCount() - 1 && j > 1 && checkIfEqual(flag, myGame.getColumn(i - 1).getSlot(j + 1), myGame.getColumn(i + 2).getSlot(j - 2), myGame.getColumn(i + 1).getSlot(j - 1))) {
                return i;
            }
            if (i >= 0 && i < myGame.getColumnCount() - 3 && j < myGame.getRowCount() && j > 2 && checkIfEqual(flag, myGame.getColumn(i + 3).getSlot(j - 3), myGame.getColumn(i + 2).getSlot(j - 2), myGame.getColumn(i + 1).getSlot(j - 1))) {
                return i;
            }
        }

        return -1;
    }

    public boolean checkIfEqual(boolean flag, Connect4Slot connect4slot, Connect4Slot connect4slot1, Connect4Slot connect4slot2) {
        return connect4slot.getIsFilled() && connect4slot1.getIsFilled() && connect4slot2.getIsFilled() && connect4slot.getIsRed() == flag && connect4slot1.getIsRed() == flag && connect4slot2.getIsRed() == flag;
    }

    public int getTopEmptyIndex(Connect4Column connect4column) {
        int i = -1;
        for (int j = 0; j < connect4column.getRowCount(); j++) {
            if (!connect4column.getSlot(j).getIsFilled()) {
                i = j;
            }
        }

        return i;
    }

    public String getName() {
        return "Brilliant Agent";
    }

    Random r;
}
