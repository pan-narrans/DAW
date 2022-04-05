package spaceInvaders;

public class Enemy extends GameObject {
  public Enemy(int[] position) {
    this(position, PT_ENEMY);
  }

  public Enemy(int[] position, int pointValue) {
    super(SPR_ENEMY);
    this.position = position.clone();
    this.pointValue = pointValue;
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
