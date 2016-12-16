
class Human extends Player {

  public Human(Connect4Game g) {
    super(g);
  }

  int getMove() {
    if (mousePressed) {
      delay(200);
      return mouseX / (width/7);
    }
    return -1;
  }
}