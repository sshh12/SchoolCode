import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import static java.lang.System.out;

public class PuzzleChecker {

    public static void main(String[] args) {
		
		//Input Files
        //args = new String[]{"puzzle01.txt", "puzzle02.txt", "puzzle03.txt", "puzzle04.txt", "puzzle05.txt"};

        for (String filename : args) {

            // read in the board specified in the filename
            In in = new In(filename);
            int n = in.readInt();
            int[][] tiles = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    tiles[i][j] = in.readInt();
                }
            }

            // solve the slider puzzle
            Board initial = new Board(tiles);
			
            out.println(initial);
			
            Solver solver = new Solver(initial);
            StdOut.println(solver.solution());
            StdOut.println(filename + ": " + solver.moves());
        }
		
    }
}
