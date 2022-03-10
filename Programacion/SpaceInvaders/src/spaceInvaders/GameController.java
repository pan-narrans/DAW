package spaceInvaders;

// Robot Imports
import java.awt.Robot;
import java.awt.AWTException;
import java.awt.event.KeyEvent;

// Basic funcionalities
import java.util.ArrayList;
import java.util.Scanner;

import spaceInvaders.BoardObject.Type;

import java.util.Iterator;

public class GameController {

  private final int SLEEP_TIME = 10;

  private Robot robot;
  private Scanner sc = new Scanner(System.in);

  private Board board = new Board();
  private Player playerShip = new Player();
  private ArrayList<BoardObject> boardObjets = new ArrayList<BoardObject>();

  /** Default constructor */
  public GameController() {
    try {
      this.robot = new Robot();
    } catch (AWTException e) {
      System.out.println("El robot no se ha podido instanciar.");
      e.printStackTrace();
    }

    boardObjets.add(playerShip);
    Enemy enemyTest1 = new Enemy(new int[] { 0, 0 });
    Enemy enemyTest2 = new Enemy(new int[] { 2, 0 });
    Enemy enemyTest3 = new Enemy(new int[] { 4, 0 });
    boardObjets.add(enemyTest1);
    boardObjets.add(enemyTest2);
    boardObjets.add(enemyTest3);
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
    for (BoardObject o : boardObjets) {
      o.updatePos();
    }
    objectCleanUp();

    // BOARD
    board.resetBoard();
    board.updateBoard(boardObjets.toArray(new BoardObject[0]));
    board.prinBoard();

    // SLEEP
    try {
      Thread.sleep(SLEEP_TIME);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  /**
   * Calls the appropriate {@link #playerShip} method based of the key.
   * 
   * @param key Key press of the current frame.
   */
  private void managePlayerInput(char key) {
    switch (Character.toLowerCase(key)) {
      case 'a':
        playerShip.moveRight();
        break;
      case 'd':
        playerShip.moveLeft();
        break;
      case 's':
        boardObjets.add(playerShip.shoot());
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
   * Removes from the {@link #boardObjets} array list all objects marked as
   * 'dead'.
   */
  private void objectCleanUp() {
    Iterator<BoardObject> it = boardObjets.iterator();
    while (it.hasNext()) {
      BoardObject temp = it.next();
      if (temp.isDead)
        it.remove();
    }
  }

  private void checkCollisions() {
    Iterator<BoardObject> it1 = boardObjets.iterator();

    while (it1.hasNext()) {
      BoardObject temp1 = it1.next();

      if (temp1.type == Type.BULLET) {
        Iterator<BoardObject> it2 = boardObjets.iterator();

        while (it2.hasNext()) {
          BoardObject temp2 = it2.next();

        }
      }
    }
  }

}
