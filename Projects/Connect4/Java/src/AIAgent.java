
public class AIAgent extends SpecialAgent {

    private MiniMax brain;

    public AIAgent(Connect4Game game, boolean isRed) {
        super("MiniMax Agent", game, isRed);

        brain = new MiniMax(this);
    }

    @Override
    public void move() {
        int loc = brain.getBestLocation();

        super.playCol(loc);
    }
}
