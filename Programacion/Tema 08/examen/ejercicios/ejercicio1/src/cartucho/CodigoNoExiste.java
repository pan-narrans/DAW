package cartucho;

public class CodigoNoExiste extends Exception {
  private static final long serialVersionUID = -6834182206343927855L;

  public CodigoNoExiste(String mensaje) {
    super(mensaje);
  }
}
