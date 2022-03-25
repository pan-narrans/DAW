package spaceInvaders;

public abstract class Screen {

  /**
   * "Clears" the screen, allowing for the new frame to be printed.
   */
  protected void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }
}
