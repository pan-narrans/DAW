package spaceInvaders;

public abstract class BoardObject {

  /** vector2 [ x , y ] */
  protected int[] position;
  /** Dead instances will be deleted. */
  protected boolean isDead;
  protected final char SPRITE;

  // SPEED

  /** range [ 1 , 100 ] */
  protected int speedDelay;
  protected int speedCounter;

  // DEPRECATED ?
  protected Type type;

  protected static enum Type {
    PLAYER, ENEMY, BULLET
  }

  BoardObject(char sprite) {
    isDead = false;
    SPRITE = sprite;
  }

  public int getPositionX() {
    return position[0];
  }

  public int getPositionY() {
    return position[1];
  }

  public Type getType() {
    return type;
  }

  public void updatePos() {
    speedCounter++;
    if (speedCounter == speedDelay) {
      speedCounter = 0;
      move();
    }
  }

  protected void move() {
    ;
  }

}
