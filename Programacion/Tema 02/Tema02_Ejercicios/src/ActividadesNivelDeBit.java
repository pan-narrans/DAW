import java.text.DecimalFormat;

public class ActividadesNivelDeBit {

  // Clase propia para validar las entradas por teclado
  static ValidateInput validate = new ValidateInput(3);
  // Usamos df para darle un formato más amable a los resultados que le mostramos
  // al ususario
  static DecimalFormat df = new DecimalFormat();

  public static void main(String[] args) {
    // Declaración de variables para escojer ejercicio
    int ejercicio;
    final int N_EJERCICIOS = 7;

    // Set del formato decimal
    df.setMaximumFractionDigits(2);
    df.setMinimumFractionDigits(2);

    // Le pide al usuario que ejercicio quiere ejecutar
    System.out.println("Hay " + N_EJERCICIOS + " ejercicios, escoje uno:");
    System.out.println(" Ejercicio 01: ");
    System.out.println(" Ejercicio 02: ");
    System.out.println(" Ejercicio 03: ");
    System.out.println(" Ejercicio 04: ");
    System.out.println(" Ejercicio 05: ");
    System.out.println(" Ejercicio 06: ");
    System.out.println(" Ejercicio 07: ");
    System.out.println("");
    ejercicio = validate.inputRange(1, 1, N_EJERCICIOS);

    // Escoger el ejercicio
    switch (ejercicio) {
      case 1:
        ejercicio01();
        break;
      case 2:
        ejercicio02();
        break;
      case 3:
        ejercicio03();
        break;
      case 4:
        ejercicio04();
        break;
      case 5:
        ejercicio05();
        break;
      case 6:
        ejercicio06();
        break;
      case 7:
        ejercicio07();
        break;
      default:
        break;
    }

    // Cerrar el validar
    validate.close();
  }

  /**
   * Programa para verificar que el bit menos significativo (LSB) de un número
   * byte esté inicializado o no. (utilizar la operación AND lógica y un 1)
   * <p>
   * Ejemplo:
   * <li>- 0b00001001 Devolvería true
   * <li>- 0b00000100 Devolvería false
   * 
   */
  private static void ejercicio01() {
    // Intro
    System.out.println("\n EJERCICIO 01:");
    System.out.println(
        " Programa para verificar que el bit menos significativo (LSB) de un número byte esté inicializado o no. \n ");

    // Variables
    byte number, lastBit, comparator = 0b1;

    // Entrada de datos
    System.out.println("Introduce un número:");
    number = validate.inputType((byte) 1);
    lastBit = (byte) (number & comparator);

    // Salida:
    // He introducido dentro del mensaje un if shorthand por acotar el código y no
    // tener que escribir el mensaje dos veces.
    // 
    System.out.println(
        "El número introducido corresponde a \"" + ((number < 0) ? Integer.toBinaryString(number).substring(32 - 8) : Integer.toBinaryString(number)) + "\" en binario");
    System.out.println("El último bit del número es un \"" + lastBit + "\" por lo que " + ((lastBit == 1) ? "" : "no ")
        + "está inicializado.");
  }

  /**
   * Programa para verificar que el bit más significativo (MSB) de un número short
   * esté inicializado o no . (desplazar a la izquierda 8 bits el 1 y aplicar la
   * operación AND lógica)
   * <p>
   * Ejemplo:
   * <li>- 0b00001001 Devolvería false
   * <li>- 0b11011001 Devolvería true
   */
  private static void ejercicio02() {
    // Intro
    System.out.println("\n EJERCICIO 02:");
    System.out.println(
        " Programa para verificar que el bit más significativo (MSB) de un número short esté inicializado o no . \n ");

    // Variables
    short number, firstBit, comparator = 1;

    // TODO:
    // ESCRIBIR EL Nº CON TODOS SUS BITS

    // Entrada de datos
    System.out.println("Introduce un número:");
    number = validate.inputType((short) 1);
    firstBit = (short) (number >> 16 & comparator);

    System.out.println("El número introducido corresponde a \"" + intToString(number, 16, 4) + "\" en binario");
    System.out.println("El primer bit del número es un \"" + firstBit + "\" por lo que "
        + ((firstBit == 1) ? "" : "no ") + "está inicializado.");
  }

  /**
   * Escriba un programa para obtener el enésimo bit de un número short. (guardar
   * el desplazamiento a la derecha n bits del número y hacer un AND lógico con 1)
   * obtener el bit 7 de 0b010000100 Devolvería 1
   */
  private static void ejercicio03() {
  }

  /**
   */
  private static void ejercicio04() {
  }

  /**
   */
  private static void ejercicio05() {
  }

  /**
  */
  private static void ejercicio06() {
  }

  /**
  */
  private static void ejercicio07() {
  }

  /**
   * <b>¡MÉTODO SACADO DE INTERNET DIRECTAMENTE POR GANAR TIEMPO!</b> Converts an
   * integer to a 32-bit binary string
   * 
   * @param number    The number to convert
   * @param nBits     The number of bits expected
   * @param groupSize The number of bits in a group
   * @return The 32-bit long bit string
   */
  public static String intToString(int number, int nBits, int groupSize) {
    StringBuilder result = new StringBuilder();

    for (int i = nBits - 1; i >= 0; i--) {
      int mask = 1 << i;
      result.append((number & mask) != 0 ? "1" : "0");

      if (i % groupSize == 0)
        result.append(" ");
    }
    result.replace(result.length() - 1, result.length(), "");

    return result.toString();
  }

}
