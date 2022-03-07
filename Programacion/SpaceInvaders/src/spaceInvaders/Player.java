package spaceInvaders;

public class Player {

  protected static int[] oldPosition;
  protected static int[] position;

  public Player() {
    Player.position = new int[] { (int) (Board.BOARD_SIZE_X / 2), Board.BOARD_SIZE_Y };
    Player.oldPosition = Player.position.clone();
  }

  public void moveLeft() {
    oldPosition = position.clone();
    position[0] = (position[0] == Board.BOARD_SIZE_X - 1) ? position[0] : position[0] + 1;
  }

  public void moveRight() {
    oldPosition[0] = position[0];
    position[0] = (position[0] == 0) ? position[0] : position[0] - 1;
  }
}
