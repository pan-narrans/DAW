public class PruebaDebugger {

  /*
   * Crea un proyecto nuevo en Eclipse que contega estas dos clases. Compila y
   * ejecuta. Si todo funciona bien añade puntos de control en la segunda clase
   * que muestre el valor de la variable suma cuando se le añade el valor 33 de la
   * lista. Adjunta pantallazos
   */

  public static void main(String[] args) {
    ClaseParaDepurar clase = new ClaseParaDepurar();
    double valor = clase.echaCuentas();
    System.out.println("Sale " + valor);
  }

}