package spaceInvaders;

public class BoardObject {

  /** [ x , y ] */
  protected int[] position;
  protected int speed;
  protected boolean outOfBounds;

  protected Type type;

  protected static enum Type {
    PLAYER, ENEMY, BULLET
  }

  BoardObject() {
    outOfBounds = false;
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
    ;
  }

}
