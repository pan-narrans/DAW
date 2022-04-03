package spaceInvaders;

public class Player extends GameObject {

  private static int shootDelay = PLR_SHOOT_DELAY;
  private int shootCounter = 0;

  private boolean canShoot;

  public Player() {
    super(SPR_PLAYER);
    this.position = new int[] {
        (int) (Board.BOARD_SIZE_X / 2),
        Board.BOARD_SIZE_Y - 1
    };
    speedDelay = SPD_PLAYER;
  }

  public void moveLeft() {
    position[0] = (position[0] == Board.BOARD_SIZE_X - 1) ? position[0] : position[0] + 1;
  }

  public void moveRight() {
    position[0] = (position[0] == 0) ? position[0] : position[0] - 1;
  }

  @Override
  public void update() {
    super.update();

    // Shoot Delay
    shootCounter++;
    if (shootCounter == shootDelay) {
      shootCounter = 0;
      canShoot = true;
    }
  }

  public boolean canShoot() {
    return canShoot;
  }

  protected Bullet shoot() {
    canShoot = false;
    // return new Bullet(new int[] { position[0], position[1] - 1 });
    return new Bullet(position, -1);
  }

  @Override
  protected void move() {
    ;
  }

}
