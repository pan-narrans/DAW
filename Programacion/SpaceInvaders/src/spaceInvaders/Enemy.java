package spaceInvaders;

public class Enemy extends BoardObject {

  public Enemy(int[] position) {
    super();
    this.position = position.clone();
    this.type = Type.ENEMY;
  }

  public void updatePos() {
    position[0] += 1;
    if (position[0] >= Board.BOARD_SIZE_X)
      position = new int[] { 0, position[1] + 1 };

    if (position[1] >= Board.BOARD_SIZE_Y)
      outOfBounds = true;

  }

}
