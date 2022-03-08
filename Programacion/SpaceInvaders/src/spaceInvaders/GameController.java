package spaceInvaders;

// Robot Imports
import java.awt.Robot;
import java.awt.AWTException;
import java.awt.event.KeyEvent;

// Basic funcionalities
import java.util.ArrayList;
import java.util.Scanner;

public class GameController {

  private final int SLEEP_TIME = 100;

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
  }

  private void Update() {
    char keyPressed = listenKey();
    switch (keyPressed) {
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

    for (BoardObject o : boardObjets) {
      o.updatePos();
      board.updateObjet(o);
    }

    board.prinBoard();

    try {
      Thread.sleep(SLEEP_TIME);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void play() {
    do {
      Update();
    } while (true);
  }

  private char listenKey() {
    char pressed = '.';

    robot.keyPress(KeyEvent.VK_PERIOD);
    robot.keyPress(KeyEvent.VK_ENTER);
    robot.keyRelease(KeyEvent.VK_ENTER);

    if (sc.hasNext()) {
      pressed = sc.next().charAt(0);
    }

    return pressed;
  }

}
