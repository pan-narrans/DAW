package ejemplos_objetos;

public class Animal {
  protected int nLegs;
  protected boolean alive;

  // Constructor por defecto llama al otro constructor
  Animal() {
    this(0);
  }

  // Constructor con atributos
  Animal(int nLegs) {
    this.alive = true;
    this.nLegs = nLegs;
  }

  public void revive() {
    this.alive = true;
  }

  public void die() {
    this.alive = false;
  }

  public void isAlive(String name) {
    System.out.println(name + ((alive) ? " is alive." : " is dead."));
  }
}
