package spaceInvaders;

// Basic functionalities
import java.util.ArrayList;
import java.util.Iterator;

public class GameController {

  private final int SLEEP_TIME = 10;

  private Menu menu = new Menu();
  private Board board = new Board();
  private Player playerShip = new Player();
  private EnemyController badGuyControl = new EnemyController();
  private ArrayList<BoardObject> boardObjects = new ArrayList<BoardObject>();

  private boolean gameOver = false;
  private int score = 0;

  /** Default constructor */
  public GameController() {
    boardObjects.add(playerShip);
  }

  // public void start() {
  // boolean inSpaceInvaders = true;
  // boolean inMenu = true;
  // do {
  // do {
  // manageMenuInput(listenKey());
  // menu.update();
  // sleep();
  // } while (inMenu);
  // play();
  // } while (inSpaceInvaders);
  // }

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
    // TODO: press key to continue
  }

  public void play(char key) {
    // Player Actions
    manageInput(key);

    // Other elements management
    updateObjects();
    generateEnemies();
    checkCollisions();
    objectCleanUp();

    // BOARD
    board.updateBoard(boardObjects.toArray(new BoardObject[0]));
  }

  /**
   * If there's an enemy to generate, it adds it to the array.
   */
  private void generateEnemies() {
    if (badGuyControl.hasEnemyReady()) {
      boardObjects.add(badGuyControl.createEnemy());
    }
  }

  /**
   * Calls the update method of each game object.
   */
  private void updateObjects() {
    badGuyControl.update();
    for (BoardObject o : boardObjects) {
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
          boardObjects.add(playerShip.shoot());
        break;
      default:
        break;
    }
  }

  /**
   * Removes from the {@link #boardObjects} array list all objects marked as
   * 'dead'.
   */
  private void objectCleanUp() {
    Iterator<BoardObject> it = boardObjects.iterator();
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
    Iterator<BoardObject> it1 = boardObjects.iterator();
    while (it1.hasNext()) {
      BoardObject obj1 = it1.next();
      if (obj1 instanceof Bullet) {
        // Used to break out of the inner loop, as bullets can only collide with one
        // object
        boolean collision = false;

        // 2nd loop
        Iterator<BoardObject> it2 = boardObjects.iterator();
        while (it2.hasNext() && !collision) {
          BoardObject obj2 = it2.next();
          // Collision check
          if (obj1.comparePosition(obj2) && !obj1.equals(obj2)) {
            collision = true;
            obj1.kill();
            obj2.kill();
          }
          if (collision)
            addScore(obj2.getPointValue());
        }
        // End 2nd loop

      } // End if bullet
    } // End 1st loop
  } // End checkCollisions()

  protected boolean checkGameOver() {
    Iterator<BoardObject> it = boardObjects.iterator();
    while (it.hasNext()) {
      BoardObject obj = it.next();
      if (obj instanceof Enemy && obj.position[1] > Board.BOARD_SIZE_Y - 2)
        return true;
    }
    return false;
  }

  private void addScore(int pointValue) {
    score += pointValue;
  }

}
