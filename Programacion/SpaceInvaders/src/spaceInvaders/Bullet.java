package spaceInvaders;

public class Bullet extends BoardObject {

  public Bullet(int[] position) {
    this.position = position.clone();
    this.oldPosition = this.position.clone();
    this.type = Type.BULLET;
  }

  @Override
  public void updatePos() {
    oldPosition = position.clone();
    position[1] -= 1;

    if (position[1] < 0) {
      position[1] = 0;
      // TODO:
    }
  }

}
