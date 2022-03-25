package spaceInvaders;

import java.util.Arrays;

public abstract class BoardObject implements Sprites {

  /** vector2 [ x , y ] */
  protected int[] position;

  /** Dead instances will be deleted. */
  protected boolean isDead;

  protected final char SPRITE;

  protected int pointValue = 0;;

  // SPEED
  /** range [ 1 , 100 ] */
  protected int speedDelay;
  protected int speedCounter;

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

  public boolean comparePosition(BoardObject o) {
    boolean areEqual = true;
    if (this.position[0] != o.position[0])
      areEqual = false;
    if (this.position[1] != o.position[1])
      areEqual = false;
    return areEqual;
  }

  public void kill() {
    isDead = true;
  }

  public void update() {
    updatePos();
  }

  public void updatePos() {
    speedCounter++;
    if (speedCounter == speedDelay) {
      speedCounter = 0;
      move();
    }
  }

  protected abstract void move();

  @Override
  public String toString() {
    return "BoardObject [SPRITE=" + SPRITE + ", isDead=" + isDead + ", position=" +
        Arrays.toString(position) + "]";
  }

  public int getPointValue() {
    return pointValue;
  }

}
