package spaceInvaders;

import java.util.Arrays;

public class Board {

  public char[][] playBoard = new char[BOARD_SIZE_Y][BOARD_SIZE_X];

  protected final static int BOARD_SIZE_X = 5;
  protected final static int BOARD_SIZE_Y = 10;

  private final char EMPTY = '.';
  // private final char PLAYER = '▄';
  // private final char ENEMY = 'Y';
  // private final char BULLET = 'o';

  protected Board() {
    resetBoard();
  }

  /**
   * Calls {@link #clearScreen()} and prints the new board.
   */
  protected void prinBoard() {
    clearScreen();
    for (char[] charray : playBoard) {
      System.out.println(Arrays.toString(charray));
    }
  }

  protected void updateBoard(BoardObject[] objects) {
    for (BoardObject o : objects) {
      updateObjet(o);
    }
  }

  private void updateObjet(BoardObject o) {
    playBoard[o.getPositionY()][o.getPositionX()] = o.SPRITE;
  }

  /**
   * Sets all cells to empty.
   */
  protected void resetBoard() {
    for (int i = 0; i < BOARD_SIZE_Y; i++) {
      for (int j = 0; j < BOARD_SIZE_X; j++) {
        playBoard[i][j] = EMPTY;
      }
    }
  }

  /**
   * "Clears" the screen, allowing for the new frame to be printed.
   */
  private void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }
}
