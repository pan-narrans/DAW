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

  private Menu menu = new Menu();
  private GameController gameController = new GameController();

  private static boolean inSpaceInvaders;
  private static boolean inGame;

  public SpaceInvader() {
    try {
      this.robot = new Robot();
    } catch (AWTException e) {
      System.out.println("El robot no se ha podido instanciar.");
      e.printStackTrace();
    }
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

  protected static void startGame() {
    inGame = true;
  }

  protected static void endGame() {
    inGame = false;
  }

  protected static void exitApp() {
    inSpaceInvaders = false;
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
  protected static void clearScreen() {
    try {
      new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    } catch (Exception e) {
      System.out.println("Couldn't clear the screen...");
      e.printStackTrace();
    }
  }
}
