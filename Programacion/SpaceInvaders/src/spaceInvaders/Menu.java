package spaceInvaders;

import java.util.HashMap;

public class Menu {
  private SpaceInvader spaceInvader;
  private final HashMap<Integer, String> KEYS = new HashMap<>();

  // Strings
  private final String HEAD = "=== SPACE INVADERS ===";
  private final String BLANK = "=                    =";
  private final String INFO = "press 'd' to select";
  private final String END = "======================";
  private final String[][] ITEMS = {
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

  Menu(SpaceInvader spaceInvader) {
    KEYS.put(0, "play");
    KEYS.put(1, "exit");
    this.spaceInvader = spaceInvader;
  }

  /**
   * Prints the actual state of the menu.
   */
  public void printMenu() {
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
  public void update(char key) {
    manageInput(key);
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

  private void manageInput(char key) {
    switch (Character.toLowerCase(key)) {
      case 'w':
        previousItem();
        break;
      case 's':
        nextItem();
        break;
      case 'd':
        takeAction();
        break;
      default:
        break;
    }
  }

  private void takeAction() {
    switch (itemSelected) {
      case 0:
        spaceInvader.startGame();
        break;
      case 1:
        spaceInvader.exitApp();
        break;
      default:
        break;
    }
  }

}
