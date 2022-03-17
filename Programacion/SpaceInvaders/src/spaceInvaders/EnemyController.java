package spaceInvaders;

public class EnemyController implements GameObject {
  private int speedDelay        = 40;
  private int speedCounter      = 0;
  private boolean hasEnemyReady = false;

  // private byte[][] waves = {
  // { 1, 1, 1, 1, 1 },
  // { 0, 1, 1, 1, 0 },
  // { 0, 0, 1, 0, 0 },
  // { 1, 1, 0, 1, 1 },
  // { 1, 0, 1, 0, 1 }
  // };
  
  public void update() {
    speedCounter++;
    if (speedCounter == speedDelay) {
      speedCounter  = 0;
      hasEnemyReady = true;
    }
  }

  public boolean hasEnemyReady() {
    return hasEnemyReady;
  }

  public Enemy createEnemy() {
    hasEnemyReady = false;
    return new Enemy(new int[]{
      0, 0
    }, speedDelay);
  }
}
