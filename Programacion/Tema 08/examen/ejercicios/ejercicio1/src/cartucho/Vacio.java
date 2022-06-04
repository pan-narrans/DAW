package cartucho;

public class Vacio extends Exception {
  private static final long serialVersionUID = 2135617025744155329L;

  public Vacio(String mensaje) {
    super(mensaje);
  }
}
