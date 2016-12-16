
abstract class Player {
  boolean isRed;
  Connect4Game game;
  int wins;

  public Player(Connect4Game g) {
    this.game = g;
  }

  abstract int getMove();

  void setRed(boolean isR) {
    isRed = isR;
  }

  String toString() {
    return isRed ? "Red":"Yellow";
  }
}