package spaceInvaders;

// Robot Imports
import java.awt.Robot;
import java.awt.AWTException;
import java.awt.event.KeyEvent;

// Basic functionalities
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class SpaceInvader {

  private final int SLEEP_TIME = 10;

  private Robot robot;
  private Scanner sc = new Scanner(System.in);

  private Menu menu = new Menu();
  private Board board = new Board();
  private Player playerShip = new Player();
  private EnemyController badGuyControl = new EnemyController();
  private ArrayList<BoardObject> boardObjects = new ArrayList<BoardObject>();

  private boolean inGame = false;
  private int score = 0;

  /** Default constructor */
  public SpaceInvader() {
    try {
      this.robot = new Robot();
    } catch (AWTException e) {
      System.out.println("El robot no se ha podido instanciar.");
      e.printStackTrace();
    }
    boardObjects.add(playerShip);
  }

  public void start() {
    boolean inSpaceInvaders = true;
    boolean inMenu = true;
    do {
      do {
        manageMenuInput(listenKey());
        menu.update();
        sleep();
      } while (inMenu);
      play();
    } while (inSpaceInvaders);
  }

  public void play() {
    inGame = true;
    do {
      Update();
      inGame = checkGameOver();
      sleep();
    } while (inGame);
    board.printGameOver();

    // TODO: press key to continue
  }

  private void Update() {
    // Player Actions
    manageGameInput(listenKey());

    // Other elements management
    updateObjects();
    generateEnemies();
    checkCollisions();
    objectCleanUp();

    // BOARD
    board.updateBoard(boardObjects.toArray(new BoardObject[0]));
    board.print(score);
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

  private void manageMenuInput(char key) {
    switch (Character.toLowerCase(key)) {
      case 'w':
        menu.previousItem();
        break;
      case 's':
        menu.nextItem();
        break;
      case 'd':
        gameAction(menu.selectItem());
        break;
      default:
        break;
    }
  }

  private void gameAction(String action) {
    switch (action) {
      case "play":

        break;
      case "exit":
      default:
        break;
    }
  }

  /**
   * Calls the appropriate {@link #playerShip} method based of the key.
   *
   * @param key Key press of the current frame.
   */
  private void manageGameInput(char key) {
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

  private boolean checkGameOver() {
    Iterator<BoardObject> it = boardObjects.iterator();
    while (it.hasNext()) {
      BoardObject obj = it.next();
      if (obj instanceof Enemy && obj.position[1] > Board.BOARD_SIZE_Y - 2)
        return false;
    }
    return true;
  }

  private void addScore(int pointValue) {
    score += pointValue;
  }

  private void sleep() {
    try {
      Thread.sleep(SLEEP_TIME);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
