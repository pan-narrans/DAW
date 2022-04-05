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
  private char[][] playBoard = new char[BOARD_SIZE_Y][BOARD_SIZE_X];
  private GameController gc;

  private enum COLOR {
    RED, GREEN, DEFAULT
  }

  Board(GameController gc) {
    this.gc = gc;
    resetBoard();
  }

  /**
   * Prints all the interface goodies, including (but not restricted to) the
   * board, the score, the TITLE.
   *
   * @param score Player score.
   */
  protected void print(int score) {
    printHead();
    printBoard();
    printScore();
    printDifficulty();
  }

  /**
   * Prints the "SPACE INVADERS" header, adjusted to the board width.
   */
  protected void printHead() {
    int num = BOARD_SIZE_X * 2 + 1 - 16;
    num /= 2;

    // Print ' '
    for (int i = 0; i < (int) (Math.log10(BOARD_SIZE_Y) + 1); i++) {
      System.out.print("  ");
    }

    // Print '='
    for (int i = 0; i < num; i++) {
      System.out.print("=");
    }

    System.out.print(" SPACE INVADERS ");

    // Print '='
    for (int i = 0; i < num; i++) {
      System.out.print("=");
    }
  }

  /**
   * Prints the board.
   */
  private void printBoard() {
    int i = 0;
    System.out.println("");
    for (char[] charArray : playBoard) {
      if (i > BOARD_SIZE_Y - 2)
        printDeathLine();
      if (i < 10)
        System.out.print(" " + i++ + " ");
      else
        System.out.print(i++ + " ");
      printBoardLine(charArray);
    }
    System.out.println("");

  }

  /**
   * Prints a single line char array with custom styling
   */
  private void printBoardLine(char[] line) {
    System.out.print("|");

    for (int i = 0; i < line.length; i++) {
      if (line[i] == SPR_ENEMY)
        changeStyle(COLOR.GREEN);
      System.out.print(line[i]);
      changeStyle(COLOR.DEFAULT);

      if (i != line.length - 1)
        System.out.print(" ");
    }

    System.out.print("|\n");
  }

  /**
   * Prints a red dotted line marking the player's space boundary.
   */
  private void printDeathLine() {
    changeStyle(COLOR.RED);

    System.out.print("  ");
    for (int i = 0; i < BOARD_SIZE_X; i++) {
      System.out.print("--");
    }
    System.out.print("--\n");

    changeStyle(COLOR.DEFAULT);
  }

  protected void updateBoard(GameObject[] objects) {
    resetBoard();
    for (GameObject o : objects) {
      if (!o.isOutOfBounds())
        playBoard[o.getPositionY()][o.getPositionX()] = o.sprite;
    }
  }

  /**
   * Changes the console color to the one specified. It need to be reset to the
   * default value once we're done with the color.
   * 
   * @param color color to change to.
   */
  private void changeStyle(COLOR color) {
    String ANSI = "\033[0m";
    switch (color) {
      case RED:
        ANSI = "\033[1;31m";
        break;
      case GREEN:
        ANSI = "\033[1;32m";
        break;
      case DEFAULT:
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

  protected void printScore() {
    System.out.println("Score = " + gc.getScore());
  }

  private void printDifficulty() {
    if (gc.getDifficulty() == MAX_DIFFICULTY)
      System.out.println("Difficulty = MAX");
    else
      System.out.println("Difficulty = " + gc.getDifficulty());
  }

  protected void printGameOver() {
    System.out.println("=== GAME OVER ===");
    System.out.println("press 'd' to continue ");
  }

}
