package ejemplos_objetos;

public class Caballo extends Animal {
  protected String breed;

  public Caballo(String breed) {
    super(4);
    this.breed = breed;
  }

  public String getBreed() {
    return breed;
  }

  public void setBreed(String breed) {
    this.breed = breed;
  }

  public void weirdShit() {
    System.out.println("\nahora sin nada\n");
    isAlive("Caballito");
    die();
    isAlive("Caballito");
    revive();
    isAlive("Caballito");

    System.out.println("\nahora con super\n");
    super.isAlive("Caballito");
    super.die();
    super.isAlive("Caballito");
    super.revive();
    super.isAlive("Caballito");

    System.out.println("\nahora con this\n");

    this.isAlive("Caballito");
    this.die();
    this.isAlive("Caballito");
    this.revive();
    this.isAlive("Caballito");
  }

  //@Override
  public void revive() {
    System.out.println("Has revivido al caballo :)");
    this.alive = true;
  }

  //@Override
  public void die() {
    System.out.println("Has matado al caballo :(");
    this.alive = false;
  }
}
