package spaceInvaders;

import java.util.ArrayList;
import java.util.Iterator;

public class EnemyController implements Constants {
  private GameController gc;
  private ArrayList<Enemy> enemies = new ArrayList<>();
  private byte[][][] swampTemplates = new byte[][][] {
      {
          { 1, 1, 1 },
          { 1, 1, 1 },
          { 0, 1, 0 },
      },
      {
          { 1, 1, 1, 1, 1 },
          { 1, 1, 1, 1, 1 },
          { 0, 1, 1, 1, 0 },
      },
      {
          { 1, 1, 1, 1, 1 },
          { 1, 1, 1, 1, 1 },
          { 1, 1, 1, 1, 1 },
          { 0, 1, 1, 1, 0 },
      },
      {
          { 0, 1, 1, 1, 1, 0 },
          { 1, 1, 0, 0, 1, 1 },
          { 1, 1, 0, 0, 1, 1 },
          { 0, 1, 1, 1, 1, 0 },
      },
  };

  private int speedDelay = SPD_ENEMY;
  private int counter = speedDelay;
  private byte direction;

  EnemyController(GameController gc) {
    this.gc = gc;
  }

  public void update() {
    if (enemies.isEmpty()) {
      gc.increaseDifficulty();
      increaseSpeed();
      direction = 1;
      createSwarm(getRandomTemplate());
    }

    if (canMove())
      moveSwarm();

    objectCleanUp();
  }

  private void increaseSpeed() {
    speedDelay = (speedDelay == SPD_ENEMY_MIN) ? speedDelay : speedDelay - gc.getDifficulty();
  }

  private void objectCleanUp() {
    Iterator<Enemy> it = enemies.iterator();
    while (it.hasNext()) {
      if (it.next().isDead)
        it.remove();
    }
  }

  private boolean canMove() {
    counter--;
    if (counter == 0) {
      counter = speedDelay;
      return true;
    }
    return false;
  }

  /**
   * Moves the swarm in the correct direction.
   */
  private void moveSwarm() {
    for (Enemy enemy : enemies) {
      enemy.move(direction);
    }

    if (swarmIsOutOfBounds()) {
      for (Enemy enemy : enemies) {
        enemy.moveDown();
      }
      direction *= -1;
      for (Enemy enemy : enemies) {
        enemy.move(direction);
      }
    }
  }

  private boolean swarmIsOutOfBounds() {
    for (Enemy enemy : enemies) {
      if (enemy.isOutOfBounds() && enemy.hasEnteredBoard)
        return true;
    }
    return false;
  }

  /**
   * Instantiates a swarm of enemies based on a template.
   * 
   * @param template Swarm template.
   */
  public void createSwarm(byte[][] template) {
    // [x, y]
    int[] coordinates = new int[] { 0, template.length - 1 };

    for (int i = template.length - 1; i > -1; i--) {
      for (int j = template[0].length - 1; j > -1; j--) {
        if (template[i][j] == 1)
          enemies.add(new Enemy(coordinates, PT_ENEMY * gc.getDifficulty()));
        coordinates[0]--;
      }
      coordinates[0] = 0;
      coordinates[1]--;
    }

    addEnemiesToGameController();
  }

  /**
   * Adds all enemies to the GameController() gameObjects array.
   */
  private void addEnemiesToGameController() {
    for (GameObject enemy : enemies) {
      gc.addObject(enemy);
    }
  }

  /**
   * @return Random valid enemy swarm template.
   */
  private byte[][] getRandomTemplate() {
    byte[][] template;

    do {
      template = swampTemplates[(int) (Math.random() * swampTemplates.length)];
    } while (template[0].length > BOARD_SIZE_X);

    return template;
  }

}
