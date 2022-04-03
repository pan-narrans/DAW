package spaceInvaders;

public class Board implements Constants {

  /*
   * Coordinates:
   * Y ↓ / X →
   * 
   * BOARD EX
   * ========
   * 00 10 20
   * 01 11 21
   * 02 12 22
   * 03 13 23
   * 04 14 24
   */
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
    printBoard();
    printScore(score);
  }

  /**
   * Prints the board...
   */
  private void printBoard() {
    int i = 0;
    System.out.println("");
    for (char[] charArray : playBoard) {
      if (i > BOARD_SIZE_Y - 2)
        printDeathLine();
      System.out.print(i++ + " ");
      printLine(charArray);
    }
    System.out.println("");

  }

  /*
   * prints a single line char array with custom styling
   */
  private void printLine(char[] line) {
    System.out.print("|");

    for (int i = 0; i < line.length; i++) {
      if (line[i] == SPR_ENEMY)
        changeStyle("green");
      System.out.print(line[i]);
      changeStyle("default");

      if (i != line.length - 1)
        System.out.print(" ");
    }

    System.out.print("|\n");
  }

  private void printDeathLine() {
    changeStyle("red");
    System.out.print("  ");
    for (int i = 0; i < BOARD_SIZE_X; i++) {
      System.out.print("--");
    }
    System.out.print("--\n");
    changeStyle("default");
  }

  protected void updateBoard(GameObject[] objects) {
    resetBoard();
    for (GameObject o : objects) {
      if (!o.isOutOfBounds())
        playBoard[o.getPositionY()][o.getPositionX()] = o.sprite;
    }
  }

  private void changeStyle(String color) {
    String ANSI = "\033[0m";
    switch (color) {
      case "red":
        ANSI = "\033[1;31m";
        break;
      case "green":
        ANSI = "\033[1;32m";
        break;
      case "default":
      default:
        break;
    }
    System.out.print(ANSI);
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
    int num = BOARD_SIZE_X * 2 + 1 - 16;
    num /= 2;
    System.out.print("  ");

    for (int i = 0; i < num; i++) {
      System.out.print("=");
    }

    System.out.print(" SPACE INVADERS ");

    for (int i = 0; i < num; i++) {
      System.out.print("=");
    }
  }

  protected void printScore(int score) {
    System.out.println("Score = " + score);
  }

  protected void printGameOver() {
    System.out.println("=== GAME OVER ===");
    System.out.println("press 'd' to continue ");
  }

}
