package auxiliar;

public class Cadena {

  // MÉTODOS
  // primeraMayúscula

  public static String primeraMayuscula(String palabra)
      throws IllegalArgumentException {

    // Pone la primera letra de palabra en mayúscula
    if (palabra == "")
      // ProtecciónIn
      throw new IllegalArgumentException("Exception: Cadena vacía");

    // Toma el primer carácter y lo pone en mayúscula
    String primeraLetra = String.valueOf(palabra.charAt(0)).toUpperCase();

    // Devuelve la primera letra junto con el resto de la cadena
    return primeraLetra + palabra.substring(1);
  }

  class test {
    int i = 2;
    float asd = 3;
  }
}