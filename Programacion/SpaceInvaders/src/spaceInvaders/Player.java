package spaceInvaders;

public class Player extends BoardObject {

  public Player() {
    super('▄');
    this.position = new int[] { (int) (Board.BOARD_SIZE_X / 2), Board.BOARD_SIZE_Y - 1 };
    this.type = Type.PLAYER;
    speedDelay = 1;
  }

  public void moveLeft() {
    position[0] = (position[0] == Board.BOARD_SIZE_X - 1) ? position[0] : position[0] + 1;
  }

  public void moveRight() {
    position[0] = (position[0] == 0) ? position[0] : position[0] - 1;
  }

  public Bullet shoot() {
    return new Bullet(position);
  }
}
