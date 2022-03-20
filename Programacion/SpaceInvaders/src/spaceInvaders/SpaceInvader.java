package spaceInvaders;

public class SpaceInvader {
  private GameController gc     = new GameController();
  private Board board           = new Board();

  protected final String HEAD   = "=== SPACE INVADERS ===";
  protected final String BLANK  = "=                    =";
  protected final String END    = "======================";
  protected final String[] PLAY = {
    "=      > PLAY        =",
    "=        PLAY        ="
  };
  protected final String[] EXIT = {
    "=      > EXIT        =",
    "=        EXIT        ="
  };

  public void menu() {
    // board.printHead();
    System.out.println("=== SPACE INVADERS ===");
    System.out.println("=                    =");
    System.out.println("=      > PLAY        =");
    // System.out.println("=        SCORES      =");
    System.out.println("=        EXIT        =");
    System.out.println("=                    =");
    System.out.println("======================");
  }

}
