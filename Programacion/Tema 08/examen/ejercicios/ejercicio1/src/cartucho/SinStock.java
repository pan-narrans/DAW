package cartucho;

public class SinStock extends Exception {
  private static final long serialVersionUID = -986433501373320604L;

  public SinStock(String mensaje) {
    super(mensaje);
  }
}
