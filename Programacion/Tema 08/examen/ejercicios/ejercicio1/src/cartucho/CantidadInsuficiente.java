package cartucho;

public class CantidadInsuficiente extends Exception {
  private static final long serialVersionUID = 3953164442997740645L;

  public CantidadInsuficiente(String mensaje) {
    super(mensaje);
  }

}
