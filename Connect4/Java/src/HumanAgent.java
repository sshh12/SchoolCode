/**
 * A super simple agent class for people to play.
 * Prompts for console input and plays on that location.
 */

import java.util.Scanner;


public class HumanAgent extends SpecialAgent {
    
    Scanner term;

    public HumanAgent(Connect4Game game, boolean isRed) {
        super("Human", game, isRed);
        term = new Scanner(System.in);
    }

    @Override
    public void move() {
        System.out.print("Enter Column to Play > ");
        
        int loc = term.nextInt();
        term.nextLine();
        
        System.out.println();
        
        super.playCol(loc - 1);
    }
}
