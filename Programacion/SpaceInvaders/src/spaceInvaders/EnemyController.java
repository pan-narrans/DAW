package spaceInvaders;

public class EnemyController implements Constants {
  private int speedDelay = SPD_ENEMY;
  private int speedCounter = 0;
  private boolean hasEnemyReady = false;
  private byte[][] enemyBlockTemplate = new byte[][] {
      { 1, 1, 1, 1, 1 },
      { 1, 1, 1, 1, 1 },
      { 0, 1, 1, 1, 0 },
  };

  public void update() {

  }

  

}
