package spaceInvaders;

public class Enemy extends GameObject {

  public Enemy(int[] position, int speedDelay, int pointValue) {
    super(SPR_ENEMY);
    this.position = position.clone();
    this.pointValue = pointValue;
  }

  @Override
  protected void move() {
  }

}
