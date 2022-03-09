package spaceInvaders;

public class Bullet extends BoardObject {

  public Bullet(int[] position) {
    super();
    this.position = position.clone();
    this.type = Type.BULLET;
  }

  @Override
  public void updatePos() {
    position[1] -= 1;

    if (position[1] < 0)
      outOfBounds = true;
  }

}
