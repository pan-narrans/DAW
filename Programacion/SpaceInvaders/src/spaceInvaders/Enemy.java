package spaceInvaders;

public class Enemy extends BoardObject {

  private int moveDir = 1;

  public Enemy(int[] position) {
    super('Y');
    this.position = position.clone();
    speedDelay = 40;
  }

  @Override
  protected void move() {
    position[0] += moveDir;
    
    if (position[0] >= Board.BOARD_SIZE_X || position[0] < 0) {
      position = new int[] { position[0] - moveDir, position[1] + 1 };
      moveDir *= -1;
    }

    if (position[1] >= Board.BOARD_SIZE_Y)
      isDead = true;
  }

}
