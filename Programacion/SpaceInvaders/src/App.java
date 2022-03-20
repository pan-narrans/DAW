import spaceInvaders. *;

public class App {
  public static void main(String[] args)throws Exception {
    SpaceInvader sp = new SpaceInvader();
    GameController gc = new GameController();

    sp.menu();
    // gc.play();
  }
}
