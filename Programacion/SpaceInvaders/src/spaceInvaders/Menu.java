package spaceInvaders;

public class Menu extends Screen{

  protected final String HEAD = "=== SPACE INVADERS ===";
  protected final String BLANK = "=                    =";
  protected final String END = "======================";
  protected final String[] PLAY = {
      "=      > PLAY        =",
      "=       >PLAY        =",
      "=        PLAY        ="
  };
  protected final String[] EXIT = {
      "=      > EXIT        =",
      "=       >EXIT        =",
      "=        EXIT        ="
  };

  public void printMenu() {
    System.out.println(HEAD);
    // System.out.println(BLANK);
    System.out.println(PLAY[0]);
    System.out.println(EXIT[2]);
    // System.out.println(BLANK);
    System.out.println(END);
  }

  public void update() {
    printMenu();
  }

}
