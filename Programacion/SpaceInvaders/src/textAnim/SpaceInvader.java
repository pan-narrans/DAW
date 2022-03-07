package textAnim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.*;

public class SpaceInvader {

  private final String[][] ENEMY1 = {
      { "-----------------",
          "------▀▄ ▄▀------",
          "--- ▄█▀███▀█▄ ---",
          "---█▀███████▀█---",
          "---█-█▀▀▀▀▀█-█---",
          "------▀▀-▀▀ -----",
          "-----------------" },
      { "-----------------",
          "---▄-▀▄---▄▀-▄---",
          "---█▄███████▄█---",
          "---███▄███▄███---",
          "---▀█████████▀---",
          "----▄▀-----▀▄----",
          "-----------------" } };

  public void printEnemy(int i) {
    for (String s : ENEMY1[i]) {
      System.out.println(s);
    }
  }

  public static void main(String[] args) throws InterruptedException, IOException {
    String line = "hey jude";
    Scanner sc = new Scanner(System.in);
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    SpaceInvader spacey = new SpaceInvader();
    char c = 0;
    int i = 0;


    // System.out.print("hit a key: ");
    // System.out.print(System.in.read());

    do {
      System.out.print("\033[H\033[2J");
      System.out.flush();
      spacey.printEnemy(i);
      System.out.println(line);

      if (c == 'w') {
        line = "i dont want to lose this feeling";
        c = 0;
      }

      i = (i == 0) ? 1 : 0;

      try {
        Robot robot = new Robot();

        // Simulate a key press

        robot.keyPress(KeyEvent.VK_PERIOD);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        if (sc.hasNext()) {
          c = sc.next().charAt(0);
        }
      } catch (AWTException e) {
        System.out.println("gfuck");
        e.printStackTrace();
      }

      Thread.sleep(500);

    } while (true);

  }
}
/*
 * 
 * 
 * FLYIN SAUCER
 * -----------------
 * -----------------
 * -----▄▄▄▄▄▄▄-----
 * ---▄█████████▄---
 * -▄██▄██▄█▄██▄██▄-
 * ----▀█▀-▀-▀█▀----
 * -----------------
 * 
 * 
 * ENEMY 1
 * -----------------
 * ------▀▄ ▄▀------
 * --- ▄█▀███▀█▄ ---
 * ---█▀███████▀█---
 * ---█-█▀▀▀▀▀█-█---
 * ------▀▀-▀▀ -----
 * -----------------
 * 
 * -----------------
 * ---▄-▀▄---▄▀-▄---
 * ---█▄███████▄█---
 * ---███▄███▄███---
 * ---▀█████████▀---
 * ----▄▀-----▀▄----
 * -----------------
 * 
 * 
 * ENEMY 2
 * -----------------
 * ----▄▄████▄▄-----
 * ---██████████----
 * ---██▄▄██▄▄██----
 * ----▄▀▄▀▀▄▀▄-----
 * ---▀--------▀----
 * -----------------
 * 
 * -----------------
 * ------▄██▄-------
 * ----▄██████▄-----
 * ---███▄██▄███----
 * -----▄▀▄▄▀▄------
 * ----▀-▀--▀-▀-----
 * -----------------
 * 
 * PLAYER
 * -----------------
 * --------▄--------
 * -------███-------
 * --▄███████████▄--
 * --█████████████--
 * --█████████████--
 * -----------------
 * 
 * -----------------
 * --------▄--------
 * -------███-------
 * -------███-------
 * -------███-------
 * --------▀--------
 * -----------------
 * 
 * -----------------
 * --▀----------▀---
 * -----------------
 * ------▀---▀------
 * -----------------
 * --▀----------▀---
 * -----------------
 * 
 * 
 */