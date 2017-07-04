
/**
 * The main driver of the program. This file will create the game, create the two agents,
 * and create the window for the game. After that, Connect4Frame runs everything.
 */
public class Main {

    public static void main(String[] args) {

        Connect4Game game = new Connect4Game(7, 6);

        Agent redPlayer = new AIAgent(game, true);
        //Agent yellowPlayer = new EnemyAgent(game, false);
        Agent yellowPlayer = new HumanAgent(game, false);

        Connect4Frame mainframe = new Connect4Frame(game, redPlayer, yellowPlayer); // create the game window

        mainframe.newGameButtonPressed();

        boolean test = true;

        if (test) {

            int me = 0, them = 0, draw = 0;
            int times = 1000;
            for (int i = 0; i < times; i++) {
                
                System.out.printf("%.1f%%\n", i / (double) times * 100);

                
                mainframe.playToEndButtonPressed();
                switch (game.gameWon()) {
                    case 'R':
                        me++;
                        break;
                    case 'Y':
                        them++;
                        break;
                    default:
                        draw++;
                        break;
                }
                mainframe.newGameButtonPressed();

            }

            System.out.println("\n\nDepth: " + 5);
            System.out.println("Wins: " + me);
            System.out.println("Losses: " + them);
            System.out.println("Draws: " + draw);
            System.out.println("Outcome: " + me / (double) times * 100 + "%\n\n");
        }

    }
}
