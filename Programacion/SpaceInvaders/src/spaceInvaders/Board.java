package spaceInvaders;

import java.util.Arrays;

public class Board implements Constants {

  public char[][] playBoard = new char[BOARD_SIZE_Y][BOARD_SIZE_X];

  protected Board() {
    resetBoard();
  }

  /**
   * Calls {@link #clearScreen()} then prints all the interface goodies, including
   * (but not restricted to) the board, the score, the TITLE.
   *
   * @param score
   */
  protected void print(int score) {
    printHead();
    printScore(score);
    printBoard();
    // printPlayerInfo();
  }

  /**
   * Prints the board...
   */
  private void printBoard() {
    int i = 0;
    System.out.println("");
    for (char[] charArray : playBoard) {
      if (i > BOARD_SIZE_Y - 2)
        printPlayerLine();
      System.out.println(i++ + " " + Arrays.toString(charArray));
    }
    System.out.println("");

  }

  private void printPlayerLine() {
    System.out.print("  ");
    for (int i = 0; i < BOARD_SIZE_X; i++) {
      System.out.print("---");
    }
    System.out.println("");
  }

  protected void updateBoard(GameObject[] objects) {
    resetBoard();
    for (GameObject o : objects) {
      updateObjet(o);
    }
  }

  private void updateObjet(GameObject o) {
    if (!o.isOutOfBounds())
      playBoard[o.getPositionY()][o.getPositionX()] = o.sprite;
  }

  /**
   * Sets all cells to empty.
   */
  private void resetBoard() {
    for (int i = 0; i < BOARD_SIZE_Y; i++) {
      for (int j = 0; j < BOARD_SIZE_X; j++) {
        playBoard[i][j] = SPR_EMPTY;
      }
    }
  }

  protected void printHead() {
    System.out.println("");
    System.out.println("");
    System.out.println("=== SPACE INVADERS ===");
  }

  protected void printScore(int score) {
    System.out.println("Score = " + score);
  }

  private void printPlayerInfo() {
    System.out.println("Player = ");
  }

  protected void printGameOver() {
    System.out.println("=== GAME OVER ===");
    System.out.println("press 'd' to continue ");
  }

}
