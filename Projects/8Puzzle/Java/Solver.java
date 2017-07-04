
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;
import static java.lang.System.out;
import java.util.*;

public class Solver {

    private Board init;
    private int minMoves = -1;
    private boolean solvable = false;
    private LinkedList<Board> solution;

    public Solver(Board initial) { // find a solution to the initial board (using the A* algorithm)
        init = initial;
		
		solve();
    }

    private void solve() {

        MinPQ<Board> p = new MinPQ(), twinp = new MinPQ();

        Board twin = init.twin();

        p.insert(init);
        twinp.insert(twin);
        
        while (!p.isEmpty() && !twinp.isEmpty()) { //Essentially Always True
            Board current = p.delMin();
            Board twincurrent = twinp.delMin();

            if (current.isGoal()) { //Break if goal board is found
                minMoves = current.getMoves();
                
                solution = new LinkedList<>();
                while(current != null){ //Loop through parents to get the sequence of moves to get to the goal board
                    solution.addFirst(current);
                    current = current.getParent();
                }
                
                solvable = true;
                break;
                
            } else if (twincurrent.isGoal()) { //If the twin was solved then the init board was unsolvable
                solvable = false;
                solution = null;
                break;

            } else { //Add children/neighboring boards

                for (Board child : current.neighbors()) {
                    if (!child.equals(current.getParent())) { //The Critical Optimization checks for neighbors that equal the parent to avoid redundancy
                        p.insert(child);
                    }
                }
                for (Board child : twincurrent.neighbors()) {
                    if (!child.equals(twincurrent.getParent())) {
                        twinp.insert(child);
                    }
                }

            }

        }
    }

    public Iterable<Board> solution() { // sequence of boards in a shortest solution; null if unsolvable
        return solution;
    }
	
	public boolean isSolvable() { // is the initial board solvable?
        return solvable;
    }

    public int moves() { // min number of moves to solve initial board; -1 if unsolvable
        return minMoves;
    }
	
}
