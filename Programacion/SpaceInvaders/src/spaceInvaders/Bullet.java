package spaceInvaders;

public class Bullet extends BoardObject {

  public Bullet(int[] position) {
    super('o');
    this.position = position.clone();
    // this.position[1] -= 2;
    speedDelay = 5;
  }

  @Override
  public void move() {
    position[1] -= 1;

    if (position[1] < 0)
      isDead = true;
  }

}