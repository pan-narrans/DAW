package spaceInvaders;

// Basic functionalities
import java.util.ArrayList;
import java.util.Iterator;

public class GameController {

  private Board board = new Board();
  private Player playerShip = new Player();
  private EnemyController enemyController = new EnemyController();
  public static ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();

  private boolean gameOver = false;
  private int score = 0;

  /** Default constructor */
  public GameController() {
    gameObjects.add(playerShip);
  }

  public void update(char key) {
    gameOver = checkGameOver();

    if (!gameOver)
      play(key);

    board.print(score);

    if (gameOver) {
      board.printGameOver();
      if (key == 'd')
        SpaceInvader.endGame();
    }
  }

  public void play(char key) {
    // Player Actions
    manageInput(key);

    // Other elements management
    updateObjects();
    // generateEnemies();
    enemyController.update();
    checkCollisions();
    objectCleanUp();

    // BOARD
    board.updateBoard(gameObjects.toArray(new GameObject[0]));
  }

  public static void addObject(GameObject o) {
    gameObjects.add(o);
  }

  /**
   * If there's an enemy to generate, it adds it to the array.
   */
  // private void generateEnemies() {
  // if (enemyController.hasEnemyReady()) {
  // gameObjects.add(enemyController.createEnemy());
  // }
  // }

  /**
   * Calls the update method of each game object.
   */
  private void updateObjects() {
    enemyController.update();
    for (GameObject o : gameObjects) {
      o.update();
    }
  }

  /**
   * Calls the appropriate {@link #playerShip} method based of the key.
   *
   * @param key Key press of the current frame.
   */
  private void manageInput(char key) {
    switch (Character.toLowerCase(key)) {
      case 'a':
        playerShip.moveRight();
        break;
      case 'd':
        playerShip.moveLeft();
        break;
      case 's':
        if (playerShip.canShoot())
          gameObjects.add(playerShip.shoot());
        break;
      default:
        break;
    }
  }

  /**
   * Removes from the {@link #gameObjects} array list all objects marked as
   * 'dead'.
   */
  private void objectCleanUp() {
    Iterator<GameObject> it = gameObjects.iterator();
    while (it.hasNext()) {
      if (it.next().isDead)
        it.remove();
    }
  }

  /**
   * Checks bullet collisions with other objects.
   */
  private void checkCollisions() {
    // 1st loop
    Iterator<GameObject> it1 = gameObjects.iterator();
    while (it1.hasNext()) {
      GameObject obj1 = it1.next();
      if (obj1 instanceof Bullet) {
        boolean hasCollided = false;
        Iterator<GameObject> it2 = gameObjects.iterator();

        // 2nd loop
        while (it2.hasNext() && !hasCollided) {
          GameObject obj2 = it2.next();
          // Collision check
          if (obj1.samePositionAs(obj2) && !obj1.equals(obj2)) {
            hasCollided = true;
            obj1.kill();
            obj2.kill();
          }
          if (hasCollided)
            addScore(obj2.getPointValue());
        } // End 2nd loop
      } // End if bullet
    } // End 1st loop
  } // End checkCollisions()

  private boolean checkGameOver() {
    Iterator<GameObject> it = gameObjects.iterator();
    while (it.hasNext()) {
      GameObject obj = it.next();
      if (obj instanceof Enemy && obj.position[1] > Board.BOARD_SIZE_Y - 2)
        return true;
    }
    return false;
  }

  private void addScore(int pointValue) {
    score += pointValue;
  }

}
