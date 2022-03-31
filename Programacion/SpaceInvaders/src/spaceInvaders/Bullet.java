package spaceInvaders;

public class Bullet extends GameObject {

  /**
   * Instantiates a new bullet.
   *
   * @param position  initial position of the bullet
   * @param direction -1 for up,
   *                  1 for down,
   *                  0 for self destruct (why?)
   */
  public Bullet(int[] position, int direction) {
    super(SPR_BULLET);
    this.position = position.clone();

    // Manual clamp the direction value between -1 and 1
    this.position[1] += Math.max(-1, Math.min(1, direction));

    speedDelay = SPD_BULLET;
  }

  @Override
  public void move() {
    position[1] -= 1;

    if (position[1] < 0)
      isDead = true;
  }

}
