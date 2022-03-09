package spaceInvaders;

// Robot Imports
import java.awt.Robot;
import java.awt.AWTException;
import java.awt.event.KeyEvent;

// Basic funcionalities
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class GameController {

  private final int SLEEP_TIME = 10;
  private final int FRAME_DELAY = 20;
  private int delayCounter = 0;

  private Robot robot;
  private Scanner sc = new Scanner(System.in);

  private Board board = new Board();
  private Player playerShip = new Player();
  private ArrayList<BoardObject> boardObjets = new ArrayList<BoardObject>();

  public GameController() {
    try {
      this.robot = new Robot();
    } catch (AWTException e) {
      System.out.println("El robot no se ha podido instanciar.");
      e.printStackTrace();
    }

    boardObjets.add(playerShip);
    Enemy enemyTest = new Enemy(new int[] { 0, 0 });
    boardObjets.add(enemyTest);
  }

  public void play() {
    do {
      Update();
    } while (true);
  }

  private void Update() {

    // Player Actions
    managePlayerInput(listenKey());

    delayCounter++;

    if (delayCounter == FRAME_DELAY) {
      delayCounter = 0;
      // Other elements management
      for (BoardObject o : boardObjets) {
        o.updatePos();
      }
      deleteOutOfBounds();
    }

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
    switch (key) {
      case 'a':
      case 'A':
        playerShip.moveRight();
        break;
      case 'd':
      case 'D':
        playerShip.moveLeft();
        break;
      case 's':
      case 'S':
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
   * Removes from the {@link #boardObjets} array all out of bounds objects.
   */
  private void deleteOutOfBounds() {
    Iterator<BoardObject> it = boardObjets.iterator();
    while (it.hasNext()) {
      BoardObject temp = it.next();
      if (temp.outOfBounds)
        it.remove();
    }
  }

}
