
Connect4Game game = new Connect4Game(7, 6);

Player red = new Human(game);
Player yellow = new MiniMaxAgent(game);

boolean redturn = true;
int framesElapsed = 0;

void setup() {
  size(800, 600);

  game.setRed(red);
  game.setYellow(yellow);

  game.render();
}

void draw() {
  game.render();

  Player w = game.getWinner();
  if (game.isFull() || w != null) {

    //Game Over
    game.highlightWinner((int)(sin(framesElapsed/3)*255));
    if (framesElapsed <= 0 && w != null) {
      w.wins++;
      println("Winner: " + w);
      println("Red: " + red.wins + " Yellow: " + yellow.wins);
      framesElapsed = 1;
    } else if (framesElapsed < 200) {
      framesElapsed++;
    } else {
      game.reset();
      framesElapsed = 0;
    }
  } else {

    //Game In Progress
    if (game.play(redturn ? red : yellow)) {
      redturn = !redturn;
    }
  }
}