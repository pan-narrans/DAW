package spaceInvaders;

// Robot Imports
import java.awt.Robot;
import java.awt.AWTException;
import java.awt.event.KeyEvent;

// Basic functionalities
import java.util.ArrayList;
import java.util.Scanner;

import java.util.Iterator;

public class GameController {

  private final int SLEEP_TIME = 10;

  private Robot robot;
  private Scanner sc;

  private Board board;
  private Player playerShip;
  private EnemyController badGuyControl;
  private ArrayList<BoardObject> boardObjects;

  private int score;

  /** Default constructor */
  public GameController() {
    try {
      this.robot = new Robot();
    } catch (AWTException e) {
      System.out.println("El robot no se ha podido instanciar.");
      e.printStackTrace();
    }

    sc            = new Scanner(System. in);
    board         = new Board();
    playerShip    = new Player();
    badGuyControl = new EnemyController();
    boardObjects  = new ArrayList<BoardObject>();

    boardObjects.add(playerShip);
    // Enemy enemyTest1 = new Enemy(new int[] { 0, 0 }); Enemy enemyTest2 = new
    // Enemy(new int[] { 2, 0 }); Enemy enemyTest3 = new Enemy(new int[] { 4, 0 });
    // boardObjects.add(enemyTest1); boardObjects.add(enemyTest2);
    // boardObjects.add(enemyTest3);
  }

  public void play() {
    do {
      Update();
    } while (true);
  }

  private void Update() {
    // Player Actions
    managePlayerInput(listenKey());

    // Other elements management
    updateObjects();
    generateEnemies();
    checkCollisions();
    objectCleanUp();

    // BOARD
    board.resetBoard();
    board.updateBoard(boardObjects.toArray(new BoardObject[0]));
    // board.printScore(score);
    board.print(score);
    // board.prinBoard(); SLEEP
    try {
      Thread.sleep(SLEEP_TIME);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
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
  private void managePlayerInput(char key) {
    switch (Character.toLowerCase(key)) {
      case "a":
        playerShip.moveRight();
        break;
      case "d":
        playerShip.moveLeft();
        break;
      case "s":
        if (playerShip.canShoot()) 
          boardObjects.add(playerShip.shoot());
        break;
      default:
        break;
    }
  }

  /**
   * Fakes a keyboard input.
   * <p>
   * Returns the first character of the keyboard input for the current frame.
   *
   * @return key pressed
   *         <li>'.' if no key is pressed
   */
  private char listenKey() {
    robot.keyPress(KeyEvent.VK_PERIOD);
    robot.keyPress(KeyEvent.VK_ENTER);
    robot.keyRelease(KeyEvent.VK_ENTER);
    return sc.next().charAt(0);
  }

  /**
   * Removes from the {@link #boardObjects} array list all objects marked as
   * 'dead'.
   */
  private void objectCleanUp() {
    Iterator<BoardObject> it = boardObjects.iterator();
    while (it.hasNext()) {
      // BoardObject temp = it.next();
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
        boolean collision         = false;
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

  private void addScore(int pointValue) {
    score += pointValue;
  }

}
