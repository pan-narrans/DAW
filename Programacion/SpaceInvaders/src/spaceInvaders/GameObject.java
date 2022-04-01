package spaceInvaders;

import java.util.Arrays;

public abstract class GameObject implements Constants {

  /** vector2 [ x , y ] */
  protected int[] position;

  /** Dead instances will be deleted. */
  protected boolean isDead;
  protected int pointValue = 0;;

  // SPEED
  /** range [ 1 , 100 ] */
  protected int speedDelay;
  protected int speedCounter;

  protected char sprite;

  GameObject() {
  }

  GameObject(char sprite) {
    isDead = false;
    this.sprite = sprite;
  }

  public int getPositionX() {
    return position[0];
  }

  public int getPositionY() {
    return position[1];
  }

  public int getPointValue() {
    return pointValue;
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

  /** Updates the object's position. */
  protected abstract void move();

  /**
   * @param o Object to compare our position to.
   * @return true if the position is the same, false if no
   */
  public boolean samePositionAs(GameObject o) {
    boolean areEqual = true;
    if (this.position[0] != o.position[0])
      areEqual = false;
    if (this.position[1] != o.position[1])
      areEqual = false;
    return areEqual;
  }

  /**
   * Checks if an object's position fits inside the board or not.
   * 
   * @return true if within the confines of the board, false if not
   */
  public boolean isOutOfBounds() {
    // Check X
    if (this.position[0] < 0 || this.position[0] >= BOARD_SIZE_X)
      return true;

    // Check Y
    if (this.position[1] < 0 || this.position[1] >= BOARD_SIZE_Y)
      return true;

    return false;
  };

  public void kill() {
    isDead = true;
  }

  @Override
  public String toString() {
    return "BoardObject [sprite=" + sprite + ", isDead=" + isDead + ", position=" +
        Arrays.toString(position) + "]";
  }
}
