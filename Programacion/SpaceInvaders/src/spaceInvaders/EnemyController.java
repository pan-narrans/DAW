package spaceInvaders;

import java.util.ArrayList;
import java.util.Iterator;

public class EnemyController implements Constants {
  private ArrayList<Enemy> enemies = new ArrayList<>();
  // * tener en cuenta el tamaño del tablero a la hora de generar los enemigos
  private byte[][][] swampTemplates = new byte[][][] {
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
  private byte direction = 1;

  public void update() {
    if (enemies.isEmpty()) {
      createSwarm(getRandomTemplate());
    }

    if (canMove())
      moveSwarm();

    objectCleanUp();
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

  // TODO: solve bug
  // ! BUG when shooting the swarm goes down one position
  private boolean swarmIsOutOfBounds() {
    for (Enemy enemy : enemies) {
      if (enemy.isOutOfBounds() && enemy.hasEnteredBoard)
        return true;
    }
    return false;
  }

  // TODO: clean up
  public void createSwarm(byte[][] template) {
    int startX = 0, startY = template.length - 1;

    for (int i = template.length - 1; i > -1; i--) {
      for (int j = template[0].length - 1; j > -1; j--) {
        if (template[i][j] == 1)
          enemies.add(new Enemy(new int[] { startX, startY }, speedDelay, PT_ENEMY));
        startX--;
      }
      startX = 0;
      startY--;
    }

    // Add enemies to the gameObject array.
    for (GameObject enemy : enemies) {
      GameController.addObject(enemy);
    }
  }

  private byte[][] getRandomTemplate() {
    return swampTemplates[(int) (Math.random() * swampTemplates.length)];
  }

}
