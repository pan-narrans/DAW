package zz_misc;

public class HumanoJedi extends Jugador implements Jedi {

  HumanoJedi() {
    this.health = 100;
  }

  @Override
  public void forceBlast() {
    System.out.println("SOY UN HUMANO FUAAAA");
  }

}
