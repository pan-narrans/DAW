package spaceInvaders;

public class Enemy extends GameObject {

  public Enemy(int[] position, int speedDelay, int pointValue) {
    super(SPR_ENEMY);
    this.position = position.clone();
    this.pointValue = pointValue;
  }

  @Override
  public void update() {
  }

  @Override
  protected void move() {
  }

  protected void move(byte direction) {
    position[0] += direction;
  }

  protected void moveDown() {
    position[1]++;
  }

}
