package fruta;

public abstract class Fruta implements Comparable<Fruta> {

  Color color;
  Integer peso;

  public Fruta(Color color, int peso) {
    this.color = color;
    this.peso = peso;
  }

  public Color getColor() {
    return color;
  }

  public Integer getPeso() {
    return peso;
  }

  public String toString() {
    return getClass() + " [color=" + color + ", peso=" + peso + "]";
  }

  public int compareTo(Fruta o){
    return this.color.compareTo(o.getColor());
  }

}
