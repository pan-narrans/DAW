import java.util.Scanner;
import java.util.Arrays;
import java.lang.Character;

public class Ejercicios_Strings {

  /* ========================================================================== */
  /* ============================== EJERCICIO 05 ============================== */
  /* ========================================================================== */
  /**
   * <h5>EJERCICIO 05</h5>
   * Escriba la función String piedraPapelTijera(String jugada1, String jugada2)
   * que reciba dos cadenas con una jugada “piedra”,
   * “papel” o “tijera” y devuelva:
   * "¡Gano el jugador 1!"
   * "¡Gano el jugador 2!"
   * "¡Empate!"
   * 
   * Tener en cuenta que la jugada puede ir en mayúsculas o minúsculas y contener
   * espacios al principio y al final.
   * 
   * @param cadena String a comprobar
   */
  static String piedraPapelTijera(String jugada1, String jugada2) {
    /*
     * Si el resultado de comparar es 0, son iguales y es un empate:
     * - papel papel 0 empate
     * - tijera tijera 0 empate
     * - piedra piedra 0 empate
     * 
     * Si la comparación da negativo gana el 1:
     * - papel piedra - gana 1
     * - piedra papel + gana 2
     * - piedra tijera - gana 1
     * - tijera piedra + gana 2
     * 
     * Siempre y cuando no hayan sido jugadas piedra y tijera a la vez
     * - tijera papel + gana 1
     * - papel tijera - gana 2
     */

    int comparado = jugada1.compareToIgnoreCase(jugada2);

    if (comparado == 0)
      return "¡Empate!";

    if (jugada1.toLowerCase().trim().equals("tijera") && jugada2.toLowerCase().trim().equals("papel")
        || jugada1.toLowerCase().trim().equals("papel") && jugada2.toLowerCase().trim().equals("tijera"))
      comparado *= -1;

    if (comparado > 0)
      return "¡Ganó el jugador 2!";

    return "¡Ganó el jugador 1!";
  }

  /* ========================================================================== */
  /* ============================== EJERCICIO 03 ============================== */
  /* ========================================================================== */
  /**
   * <h5>EJERCICIO 03</h5>
   * Escriba la función String eliminarVocales(String cadena)
   * que eliminará todas las vocales de la cadena.
   * 
   * @param cadena String a comprobar
   */
  static String eliminarVocales(String cadena) {
    return cadena.replaceAll("[aeiouAEIOUáàâä]", "");
  }

  /* ========================================================================== */
  /* ============================== EJERCICIO 02 ============================== */
  /* ========================================================================== */
  /**
   * <h5>EJERCICIO 02</h5>
   * Escriba la función boolean todosNumericos(String cadena) que nos dirá si la
   * cadena contiene todos los caracteres numéricos o no.
   * 
   * @param cadena String a comprobar
   */
  static boolean todosNumericos(String cadena) {

    if (cadena.isEmpty()) {
      return false;
    }

    for (int i = 0; i < cadena.length(); i++) {
      if (!Character.isDigit(cadena.charAt(i)))
        return false;
    }

    return true;
  }

  /* ========================================================================== */
  /* ============================== EJERCICIO 01 ============================== */
  /* ========================================================================== */
  /**
   * <h5>EJERCICIO 01</h5>
   * Escriba la función int contarCaracteresNoNumericos(String cadena) que recibe
   * una cadena y devuelva cuántos caracteres no numéricos hay.
   * 
   * @param cadena String a comprobar
   */
  static int rellencontarCaracteresNoNumericosarArray(String cadena) {
    int counter = 0;

    for (int i = 0; i < cadena.length(); i++) {
      if (!Character.isDigit(cadena.charAt(i)))
        counter++;
    }

    return counter;
  }

  public static void main(String[] args) {
    String cadena = new String();
    System.out.println("\nContar no numéricos");
    System.out.println(rellencontarCaracteresNoNumericosarArray("Palabra 01"));
    System.out.println(rellencontarCaracteresNoNumericosarArray("Todo esto son letras."));
    System.out.println(rellencontarCaracteresNoNumericosarArray(cadena));

    System.out.println("\nSon todo numericos");
    System.out.println(todosNumericos("Palabra 01"));
    System.out.println(todosNumericos("0123456789"));
    System.out.println(todosNumericos(cadena));

    System.out.println("\nEliminar vocales");
    System.out.println(eliminarVocales("Palabra 01"));
    System.out.println(eliminarVocales("MURCIELAGO volador no tiene el cuenta el día."));
    System.out.println(eliminarVocales(cadena));

    System.out.println("\nPiedra, Papel y Tijera");
    System.out.println(piedraPapelTijera("piEdra", "piedra"));
    System.out.println(piedraPapelTijera("piedra", "tIJera"));
    System.out.println(piedraPapelTijera("piedra  ", "papel"));
    System.out.println("");
    System.out.println(piedraPapelTijera("tijera", "tijera"));
    System.out.println(piedraPapelTijera("tijera", "  papel"));
    System.out.println(piedraPapelTijera("tijera", "piedra"));
    System.out.println("");
    System.out.println(piedraPapelTijera("PAPel", "papel"));
    System.out.println(piedraPapelTijera("papel", "  Piedra"));
    System.out.println(piedraPapelTijera("papeL  ", "tijera"));
  }

}
