package zz_misc;
public class WookieJedi extends Jugador implements Jedi {

  WookieJedi() {
    this.health = 120;
  }

  @Override
  public void forceBlast() {
    System.out.println("SOY UN WOOKIE FUAAAA");

  }

}
