package spaceInvaders;

public class BoardObject {

  /** [ x , y ] */
  protected int[] position;
  /** [ x , y ] */
  protected int[] oldPosition;

  protected static enum Type {
    PLAYER, ENEMY, BULLET
  }

  protected Type type;

  public int getPositionX() {
    return position[0];
  }

  public int getPositionY() {
    return position[1];
  }

  public int getOldPositionX() {
    return oldPosition[0];
  }

  public int getOldPositionY() {
    return oldPosition[1];
  }

  public Type getType() {
    return type;
  }

  public void updatePos() {
    ;
  }
  

}
