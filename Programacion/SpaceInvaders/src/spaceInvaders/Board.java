package spaceInvaders;

import java.util.Arrays;

public class Board {

  public char[][] playBoard = new char[BOARD_SIZE_Y][BOARD_SIZE_X];

  protected final static int BOARD_SIZE_X = 5;
  protected final static int BOARD_SIZE_Y = 10;


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

  public void updateObjets() {
    // old pos
    playBoard[BOARD_SIZE_Y - 1][Player.oldPosition[0]] = '-';

    // new pos
    playBoard[BOARD_SIZE_Y - 1][Player.position[0]] = 'X';
  }

  private void resetBoard() {
    for (int i = 0; i < BOARD_SIZE_Y; i++) {
      for (int j = 0; j < BOARD_SIZE_X; j++) {
        playBoard[i][j] = '-';
      }
    }
  }

}
