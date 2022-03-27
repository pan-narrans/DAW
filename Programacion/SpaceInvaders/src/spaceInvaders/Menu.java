package spaceInvaders;

import java.util.HashMap;

public class Menu extends Screen {

  protected final HashMap<Integer, String> KEYS = new HashMap<>();

  protected final String HEAD = "=== SPACE INVADERS ===";
  protected final String BLANK = "=                    =";
  protected final String INFO = "press 'd' to select";
  protected final String END = "======================";
  protected final String[][] ITEMS = {
      {
          "=      > PLAY        =",
          "=        PLAY        ="
      },
      {
          "=      > EXIT        =",
          "=        EXIT        ="
      }
  };

  private int itemSelected = 0;

  Menu() {
    KEYS.put(0, "play");
    KEYS.put(1, "exit");
  }

  /**
   * Prints the actual state of the menu.
   */
  public void printMenu() {
    clearScreen();
    System.out.println(HEAD);
    System.out.println(BLANK);

    for (int i = 0; i < ITEMS.length; i++) {
      int aux = 1;
      if (i == itemSelected)
        aux = 0;
      System.out.println(ITEMS[i][aux]);
    }

    System.out.println(BLANK);
    System.out.println(END);
    System.out.println(INFO);
  }

  /**
   * Updates the menu on the screen.
   */
  public void update() {
    printMenu();
  }

  /**
   * Selects the next item in the menu, if going out of bounds, it loops back to
   * the first item.
   */
  protected void nextItem() {
    itemSelected++;
    itemSelected = (itemSelected > ITEMS.length - 1) ? 0 : itemSelected;
  }

  /**
   * Selects the previous item in the menu, if going out of bounds, it loops back
   * to the last item.
   */
  protected void previousItem() {
    itemSelected--;
    itemSelected = (itemSelected < 0) ? ITEMS.length : itemSelected;
  }

  public String selectItem() {
    return KEYS.get(itemSelected);
  }

}
