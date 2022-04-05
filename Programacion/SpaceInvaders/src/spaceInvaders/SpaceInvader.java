package spaceInvaders;

// Robot Imports
import java.awt.Robot;
import java.awt.AWTException;
import java.awt.event.KeyEvent;

// Basic functionalities
import java.util.Scanner;

public class SpaceInvader implements Constants {
  private Robot robot;
  private Scanner sc = new Scanner(System.in);

  private static Menu menu;
  private static GameController gameController;

  private static boolean inSpaceInvaders;
  private static boolean inGame;

  // TODO: change head for gameover on gameover @class Board()
  // TODO: adjust value of constants

  public SpaceInvader() {
    try {
      this.robot = new Robot();
    } catch (AWTException e) {
      System.out.println("El robot no se ha podido instanciar.");
      e.printStackTrace();
    }

    menu = new Menu(this);
  }

  public void start() {
    inSpaceInvaders = true;
    do {
      clearScreen();
      if (!inGame) {
        menu.update(listenKey());
      } else {
        gameController.update(listenKey());
      }
      sleep(SLEEP_TIME);
    } while (inSpaceInvaders);
  }

  void startGame() {
    inGame = true;
    gameController = new GameController(this);
  }

  void endGame() {
    inGame = false;
  }

  void exitApp() {
    inSpaceInvaders = false;
  }

  /**
   * Fakes a keyboard input at each time a frame is called.
   * <p>
   * Returns the first character (transformed to lowercase) of the keyboard input
   * for the current frame.
   *
   * @return key pressed
   *         <li>'.' if no key is pressed
   */
  private char listenKey() {
    robot.keyPress(KeyEvent.VK_PERIOD);
    robot.keyPress(KeyEvent.VK_ENTER);
    robot.keyRelease(KeyEvent.VK_ENTER);
    return Character.toLowerCase(sc.next().charAt(0));
  }

  /**
   * Pauses the program for the given amount of milliseconds.
   * 
   * @param milliseconds
   */
  private void sleep(int milliseconds) {
    try {
      Thread.sleep(milliseconds);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  /**
   * "Clears" the screen, allowing for the new frame to be printed.
   */
  private void clearScreen() {
    try {
      new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    } catch (Exception e) {
      System.out.println("Couldn't clear the screen...");
      e.printStackTrace();
    }
  }

}
