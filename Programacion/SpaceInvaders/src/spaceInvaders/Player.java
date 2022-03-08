package spaceInvaders;

public class Player extends BoardObject {

  public Player() {
    this.position = new int[] { (int) (Board.BOARD_SIZE_X / 2), Board.BOARD_SIZE_Y - 1 };
    this.oldPosition = this.position.clone();
    this.type = Type.PLAYER;
  }

  public void moveLeft() {
    oldPosition = position.clone();
    position[0] = (position[0] == Board.BOARD_SIZE_X - 1) ? position[0] : position[0] + 1;
  }

  public void moveRight() {
    oldPosition[0] = position[0];
    position[0] = (position[0] == 0) ? position[0] : position[0] - 1;
  }

  public Bullet shoot() {
    return new Bullet(position);
  }
}
