import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class MiniMax {

    SpecialAgent agent;
    private final int depth;

    public MiniMax(SpecialAgent a) {
        agent = a;
        depth = 5;
    }

    public int getDepth() {
        return depth;
    }

    public int getBestLocation() {

        char[][] board = agent.getBoard();

        TheoreticalBoard current = new TheoreticalBoard(board, agent);

        if (current.isEmpty()) { // The game is just starting -> pick random place
            return agent.getRandomCol() % 3 + 1;
        }

        Tree minimax = new Tree(current);

        minimax.setBranches(depth); //Creates the magical tree

        ArrayList<Tree> trees = new ArrayList<>(minimax.getSubTrees());

        int biggest = TheoreticalBoard.MIN;
        Tree best = null;
        for (Tree t : trees) { //Evaluates the current options
            int e = t.evaluate();
            if (e >= biggest) {
                biggest = e;
                best = t;
            }
        }

        if (biggest == TheoreticalBoard.MIN) { //RIP, There is no way to win

            int mov = 0;
            for (int i = 0; i < trees.size(); i++) {

                ArrayList<Tree> subtrees = new ArrayList<>(trees.get(i).getSubTrees());
                for (int k = 0; k < subtrees.size(); k++) {
                    int e = subtrees.get(k).getHead().evaluate();
                    if (e <= biggest) {
                        biggest = e;
                        mov = subtrees.get(k).getHead().move;
                    }
                }
            }
            return mov;
        }

        return best.getHead().move;
    }
}

class TheoreticalBoard {

    private char[][] board;
    private boolean isOurTurn;
    private SpecialAgent agent;
    public int move, eval = 0;
    public static final int MAX = 100000, MIN = -MAX; //Pro Strats, these are the worst and best board cases

    public TheoreticalBoard(char[][] b, boolean rt, SpecialAgent a, int mov) {
        board = b;
        isOurTurn = rt;
        agent = a;
        move = mov;
    }

    public TheoreticalBoard(char[][] b, SpecialAgent a) {
        this(b, true, a, -1); // -1 means unknown/no move & true b\c it has to be our turn
    }

    public ArrayList<TheoreticalBoard> getBranches() {
        ArrayList<TheoreticalBoard> branches = new ArrayList<>();

        if (this.evaluate() <= MIN) { //No point of continuing branch
            return branches;
        }

        for (int i = 0; i < board[0].length; i++) {

            char c = ourTurn() ? agent.getChar() : agent.getOpChar();

            char[][] placed = place(c, i);

            if (placed != null) {
                branches.add(new TheoreticalBoard(placed, !isOurTurn, agent, i));
            }

        }

        return branches;
    }

    public boolean ourTurn() { //Ez Logic
        return isOurTurn;
    }

    public int evaluate() { //Evaluates the Board
        char me = agent.getChar();
        char them = agent.getOpChar();

        if (eval != 0) { //Removes redundant calculations in the future
            return eval;
        }

        int[] me_values = {mostInHorizontal(me), mostInVertical(me), mostInIncDiag(me), mostInDecDiag(me)};

        int[] them_values = {mostInHorizontal(them), mostInVertical(them), mostInIncDiag(them), mostInDecDiag(them)};

        int Three4Me = 0, Three4Them = 0;

        for (int v : me_values) { //These loops check for a winning or losing board
            if (v >= 4) {
                return MAX;
            } else if (v == 3) {
                Three4Me += 10; // 3 is close to losing/winning so add 10 bonus points
            }
        }

        for (int v : them_values) {
            if (v >= 4) {
                return MIN;
            } else if (v == 3) {
                Three4Them += 10;
            }
        }

        int me_points = ((me_values[0] + me_values[1] + me_values[2] + me_values[3] + Three4Me) * 100) / 16;
        int them_points = ((them_values[0] + them_values[1] + them_values[2] + them_values[3] + Three4Them) * 100) / 16;

        return me_points - them_points; // Bad < 0, Draw == 0, Good > 0
    }

    private boolean columnFull(int c) { //Checks if column is full of pieces
        return board[0][c] != 'B';
    }

    public char[][] place(char c, int col) { //Places char C in column COL and returns new board as char[][]
        if (!columnFull(col)) {

            char[][] n = new char[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                n[i] = board[i].clone();
            }

            int row = 0;

            for (int i = board.length - 1; i >= 0; i--) {
                if (board[i][col] == 'B') {
                    row = i;
                    break;
                }
            }

            n[row][col] = c;

            return n;
        }
        return null;
    }

    private int mostInVertical(char p) { //Counts the most of char P in vertical alignment
        int most = 0;

        for (int c = 0; c < board[0].length; c++) {
            for (int r = 0; r < board.length; r++) {
                if (board[r][c] == p) {
                    int count = 1;
                    while (r + count < board.length && board[r + count][c] == p) {
                        count++;
                    }
                    most = most > count ? most : count;
                }
            }
        }
        return most;
    }

    private int mostInHorizontal(char p) { //Counts the most of char P in horizontal alignment
        int most = 0;

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == p) {
                    int count = 1;
                    while (c + count < board[0].length && board[r][c + count] == p) {
                        count++;
                    }
                    most = most > count ? most : count;
                }
            }
        }
        return most;
    }

    private int mostInIncDiag(char p) { //Counts the most of char P in increasing diagnol alignment
        int most = 0;

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                int rr = r, cc = c, count = 0;

                while (rr > 0 && cc < board[rr].length && board[rr][cc] == p) {
                    rr--;
                    cc++;
                    count++;
                }

                most = most > count ? most : count;
            }
        }

        return most;
    }

    private int mostInDecDiag(char p) { //Counts the most of char P in decreasing diagnol alignment
        int most = 0;

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                int rr = r, cc = c, count = 0;

                while (rr < board.length && cc < board[rr].length && board[rr][cc] == p) {
                    rr++;
                    cc++;
                    count++;
                }

                most = most > count ? most : count;
            }
        }

        return most;
    }

    public boolean isEmpty() { //Checks if there are no pieces on the board
        for (int c = 0; c < board[0].length; c++) {
            if (board[board.length - 1][c] != 'B') {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() { // String of evaluate function
        return "" + evaluate();
    }

    public String Stringify() { //Prints entire board and meta data
        String out = "";

        for (char[] r : board) {
            for (char c : r) {
                out += c + " ";
            }
            out += "\n";
        }
        out += String.format("Sc %d,  Mv %d", evaluate(), move);
        return out;
    }
}

class Tree { // Trees for the enviroments

    private TheoreticalBoard head;

    private ArrayList<Tree> leafs = new ArrayList<>();

    private Tree parent = null;

    private HashMap<TheoreticalBoard, Tree> locate = new HashMap<>();

    private int eval = 0;

    public Tree(TheoreticalBoard head) {
        this.head = head;
        locate.put(head, this);
    }

    public void addLeaf(TheoreticalBoard root, TheoreticalBoard leaf) {
        if (locate.containsKey(root)) {
            locate.get(root).addLeaf(leaf);
        } else {
            addLeaf(root).addLeaf(leaf);
        }
    }

    public Tree addLeaf(TheoreticalBoard leaf) {
        Tree t = new Tree(leaf);
        leafs.add(t);
        t.parent = this;
        t.locate = this.locate;
        locate.put(leaf, t);
        return t;
    }

    public TheoreticalBoard getHead() { // Trees have heads?
        return head;
    }

    public Tree getTree(TheoreticalBoard element) {
        return locate.get(element);
    }

    public Tree getParent() {
        return parent;
    }

    public void setBranches(int b) { // Makes tree grow
        if (b == 0) {
            return;
        } else if (leafs.isEmpty()) {
            for (TheoreticalBoard leaflet : this.getHead().getBranches()) {
                addLeaf(leaflet);
            }
        }

        for (Tree t : leafs) {
            if (t.getHead().evaluate() > TheoreticalBoard.MIN) {
                t.setBranches(b - 1);
            }
        }
    }

    public int evaluate() { // Magic Recursion Evaluation Functuation
        if (eval != 0) {
            return eval;
        }

        TheoreticalBoard h = this.getHead();
        if (leafs.isEmpty()) {
            return h.evaluate();
        } else if (!h.ourTurn()) {
            int smallest = TheoreticalBoard.MAX;
            for (Tree leaf : leafs) {
                int e = leaf.evaluate();
                if (e < smallest) {
                    smallest = e;
                }
            }
            eval = smallest;
        } else {
            int biggest = TheoreticalBoard.MIN;
            for (Tree leaf : leafs) {
                int e = leaf.evaluate();
                if (e > biggest) {
                    biggest = e;
                }
            }
            eval = biggest;
        }
        return eval;
    }

    public ArrayList<TheoreticalBoard> getSuccessors(TheoreticalBoard root) { // The children
        ArrayList<TheoreticalBoard> successors = new ArrayList<>();
        Tree tree = getTree(root);
        if (null != tree) {
            for (Tree leaf : tree.leafs) {
                successors.add(leaf.head);
            }
        }
        return successors;
    }

    public Collection<Tree> getSubTrees() {
        return leafs;
    }

    @Override
    public String toString() {
        return printTree(0);
    }

    private String printTree(int increment) { // Beautiful Ascii Trees
        String s = "";
        String inc = "";
        for (int i = 0; i < increment; ++i) {
            inc = inc + " ";
        }
        s = inc + this.evaluate();
        for (Tree child : leafs) {
            s += "\n" + child.printTree(increment + 3);
        }
        return s;
    }
}
