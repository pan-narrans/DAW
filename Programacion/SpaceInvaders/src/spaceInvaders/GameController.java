package spaceInvaders;

import java.awt.Robot;
import java.awt.AWTException;
import java.awt.event.KeyEvent;

import java.util.Scanner;

public class GameController {
  Board board = new Board();
  Robot robot;
  Scanner sc = new Scanner(System.in);
  private Player playerShip = new Player();

  public GameController() {
    try {
      this.robot = new Robot();
    } catch (AWTException e) {
      e.printStackTrace();
    }
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

      default:
        break;
    }

    board.updateObjets();
    board.prinBoard();

    try {
      Thread.sleep(100);
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
