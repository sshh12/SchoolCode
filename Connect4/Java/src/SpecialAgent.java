
public class SpecialAgent extends Agent {

    private String name;

    public SpecialAgent(String n, Connect4Game game, boolean iAmRed) {
        super(game, iAmRed);
        name = n;
    }

    @Override
    public void move() {
    }

    public int getRandomCol() {
        return (int) (getCols() * Math.random());
    }

    public char[][] getBoard() {
        return super.myGame.getBoardMatrix();
    }

    public int getCols() { //Shorter Name
        return super.myGame.getColumnCount();
    }

    public int getRows() { //Shorter Name
        return super.myGame.getRowCount();
    }

    public char getChar() {
        return super.iAmRed ? 'R' : 'Y';
    }

    public char getOpChar() {
        return super.iAmRed ? 'Y' : 'R';
    }

    public int getLowestIndex(Connect4Column column) {
        int lowestSlot = -1;
        for (int i = 0; i < column.getRowCount(); i++) {
            if (!column.getSlot(i).getIsFilled()) {
                lowestSlot = i;
            }
        }

        return lowestSlot;
    }

    public void playCol(int col) {
        int index = getLowestIndex(myGame.getColumn(col));
        if (index > -1) {
            Connect4Slot slot = myGame.getColumn(col).getSlot(index);
            if (iAmRed) {
                slot.addRed();
            } else {
                slot.addYellow();
            }
        } else {
            playCol(this.getRandomCol());
        }
    }

    @Override
    public String getName() {
        return name;
    }
}
