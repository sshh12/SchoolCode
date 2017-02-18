
import static java.lang.System.out;
import java.util.*;

public class Board implements Comparable<Board> {

    int[][] blocks;
    private int moves;
    private int score = -1;
    private Board parent;

    // construct a board from an n-by-n array of blocks
    // (where blocks[i][j] = block in row i, column j)
    public Board(int[][] blocks) {
        this(blocks, 0, null);
    }

    public Board(int[][] blks, int movs, Board prnt) {
        if (blks == null) {
            throw new java.lang.NullPointerException();
        }

        blocks = blks;
        moves = movs;
        parent = prnt;
    }

    public int dimension() { // board size
        return blocks.length;
    }

    public int hamming() { //Count Blocks out of position
        int count = 0, dim = dimension();

        for (int r = 0, i = 1; r < blocks.length; r++) {
            for (int c = 0; c < blocks[r].length; c++, i++) {
                if (blocks[r][c] != i && blocks[r][c] != 0) {
                    count++;
                }
                i %= dim * dim;
            }
        }

        return count + moves;
    }

    public int manhattan() { //Sum of vertical + horizontal distances of out of place squares
        int sum = 0, dim = dimension();

        for (int r = 0, i = 1; r < dim; r++) {
            for (int c = 0; c < dim; c++, i++) {

                if (blocks[r][c] != i && blocks[r][c] != 0) {

                    int rC = (blocks[r][c] - 1) / dim;
                    int cC = (blocks[r][c] - 1) % dim;
                    sum += Math.abs(rC - r) + Math.abs(cC - c);

                }

            }
        }

        return sum + moves;
    }

    public boolean isGoal() { // is this board the goal board?
        int dim = dimension();
        for (int r = 0, i = 1; r < dim; r++) {
            for (int c = 0; c < dim; c++, i++) {
                if (blocks[r][c] != i && blocks[r][c] != 0) {
                    return false;
                }
                i %= dim * dim;
            }
        }
        return true;
    }
    
    private void swap(int[][] mat, int r1, int c1, int r2, int c2){
        int temp = mat[r1][c1];
        mat[r1][c1] = mat[r2][c2];
        mat[r2][c2] = temp;
    }

    public Board twin() { // a board that is obtained by exchanging any pair of blocks
        int r1, c1, r2, c2, dim = dimension();
        r1 = c1 = r2 = c2 = 0;

        while (r1 == r2 && c1 == c2 || Math.min(blocks[r1][c1], blocks[r2][c2]) == 0) {
            r1 = (int) (Math.random() * dim);
            c1 = (int) (Math.random() * dim);
            r2 = (int) (Math.random() * dim);
            c2 = (int) (Math.random() * dim);
        }

        int[][] newBlocks = new int[dim][dim];
        for (int r = 0; r < dim; r++) {
            newBlocks[r] = blocks[r].clone();
        }

        swap(newBlocks, r1, c1, r2, c2);

        return new Board(newBlocks);
    }

    public boolean equals(Object y) {   // does this board equal y?
        if (y == null || y instanceof Board == false) {
            return false;
        }
        
        Board other = (Board)y;

        for (int r = 0; r < blocks.length; r++) {
            for (int c = 0; c < blocks[r].length; c++) {
                if (blocks[r][c] != other.blocks[r][c]) {
                    return false;
                }
            }
        }

        return true;
    }

    public Iterable<Board> neighbors() {    // all neighboring boards
        ArrayList<Board> list = new ArrayList<>();

        int rZero = -1, cZero = -1;
        for (int r = 0; r < blocks.length && rZero < 0; r++) { //Find the empty square location
            for (int c = 0; c < blocks[r].length && rZero < 0; c++) {
                if (blocks[r][c] == 0) {
                    rZero = r;
                    cZero = c;
                }
            }
        }

        list.add(makeShift(rZero, cZero, 1, 0));
        list.add(makeShift(rZero, cZero, -1, 0));
        list.add(makeShift(rZero, cZero, 0, 1));
        list.add(makeShift(rZero, cZero, 0, -1));

        return list;
    }

    private Board makeShift(int rZ, int cZ, int rShift, int cShift) { //Created new board from given shift of magic square
        int swapIndex, dim = dimension();
        int[][] newBlocks = new int[dim][dim];

        for (int r = 0; r < dim; r++) {
            newBlocks[r] = blocks[r].clone();
        }

        if (rShift != 0) {
            swapIndex = (cZ + rShift + dim) % dim;
            swap(newBlocks, rZ, cZ, rZ, swapIndex);
        } else {
            swapIndex = (rZ + cShift + dim) % dim;
            swap(newBlocks, rZ, cZ, swapIndex, cZ);
        }

        return new Board(newBlocks, moves + 1, this);
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        int n = blocks.length;

        s.append(moves + "\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                s.append(String.format("%2d ", blocks[i][j]));
            }
            s.append("\n");
        }
        return s.toString();
    }
    
    public int getScore(){
        if(score == -1) //Check for cached score
            score = manhattan();
        return score;
    }
    
    public Board getParent(){
        return parent;
    }
    
    public int getMoves(){
        return moves;
    }

    @Override
    public int compareTo(Board t) { //Compare Scores for PQ
        if (this.equals(t)) {
            return 0;
        }
        return getScore() - t.getScore();
    }
}
