package spaceInvaders;

import java.util.Arrays;

public class Board {

  public char[][] playBoard = new char[BOARD_SIZE_Y][BOARD_SIZE_X];

  protected final static int BOARD_SIZE_X = 5;
  protected final static int BOARD_SIZE_Y = 10;

  private final char EMPTY = '-';
  private final char PLAYER = '▄';
  private final char ENEMY = 'Y';
  private final char BULLET = 'o';

  public Board() {
    resetBoard();
  }

  public void prinBoard() {
    clearScreen();
    for (char[] charray : playBoard) {
      System.out.println(Arrays.toString(charray));
    }
  }

  private void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  public void updateBoard(BoardObject[] objects) {
    for (BoardObject o : objects) {
      updateObjet(o);
    }
  }

  private void updateObjet(BoardObject o) {
    char c;

    // Choose Sprite
    switch (o.getType()) {
      case PLAYER:
        c = PLAYER;
        break;
      case ENEMY:
        c = ENEMY;
        break;
      case BULLET:
        c = BULLET;
        break;
      default:
        c = EMPTY;
        break;
    }

    // new pos
    playBoard[o.getPositionY()][o.getPositionX()] = c;
  }

  /**
   * Sets all cells to empty.
   */
  protected void resetBoard() {
    for (int i = 0; i < BOARD_SIZE_Y; i++) {
      for (int j = 0; j < BOARD_SIZE_X; j++) {
        playBoard[i][j] = '-';
      }
    }
  }

}
