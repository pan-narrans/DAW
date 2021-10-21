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
    System.out.println(" Ejercicio 01: comprobar si el último bit está inicializado o no.");
    System.out.println(" Ejercicio 02: comprobar si el primer bit está inicializado o no.");
    System.out.println(" Ejercicio 03: comprobar si el enésimo bit está inicializado o no.");
    System.out.println(" Ejercicio 04: establecer el enésimo bit de un short.");
    System.out.println(" Ejercicio 05: cambiar los unos por ceros y todos los ceros por unos de un short.");
    System.out.println(" Ejercicio 06: intercambiar el valor de a y b utilizando solo dos variables.");
    System.out.println(" Ejercicio 07: verificar si un número es par o impar.");
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
    /*
     * He introducido dentro de los mensajes un par de if shorthand por acotar el
     * código y no tener que escribir el mensaje dos veces.
     * 
     * Usaba Integer.toBinaryString() para traducir un int a binario. Si el nº era
     * negativo daba todo muchos problemas.
     * 
     * Para mostrar los nº en binario estoy usando un método encontrado en internet
     * (leer documentación) que permite mostrarlos.
     */
    System.out.println("El número introducido corresponde a \"" + intToString(number, 8, 4) + "\" en binario");
    System.out.println("El último bit del número es un \"" + lastBit + "\" por lo que " + ((lastBit == 1) ? "" : "no ")
        + "está inicializado.");

  }

  /**
   * Programa para verificar que el bit más significativo (MSB) de un número short
   * esté inicializado o no. (desplazar a la izquierda 8 bits el 1 y aplicar la
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
        " Programa para verificar que el bit más significativo (MSB) de un número short esté inicializado o no. \n ");

    // Variables
    short number, firstBit, comparator = 1;

    // Entrada de datos
    System.out.println("Introduce un número:");
    number = validate.inputType((short) 1);
    firstBit = (short) (number >> 15 & comparator);

    // Salidas
    System.out.println("El número introducido corresponde a \"" + intToString(number, 16, 4) + "\" en binario");
    System.out.println("El primer bit del número es un \"" + firstBit + "\" por lo que "
        + ((firstBit == 1) ? "" : "no ") + "está inicializado.");
  }

  /**
   * Programa para obtener el enésimo bit de un número short. (guardar el
   * desplazamiento a la derecha n bits del número y hacer un AND lógico con 1)
   * <p>
   * Ejemplo:
   * <li>- obtener el bit 7 de 0b010000100 Devolvería 1
   */
  private static void ejercicio03() {
    // Intro
    System.out.println("\n EJERCICIO 03:");
    System.out.println(" Programa para obtener el enésimo bit de un número short. \n ");

    // Variables
    byte bitToSearch, bitFound;
    short number;

    // Entrada de datos
    System.out.println("Introduce un número:");
    number = validate.inputType((short) 1);
    System.out.println("Introduce un número de bit que quieres recuperar:");
    bitToSearch = validate.inputType((byte) 1);

    bitFound = (byte) ((number >> bitToSearch - 1) & 1);

    System.out.println("El bit nº " + bitToSearch + "del nº " + intToString(number, 16, 4) + " es: " + bitFound + ".");
  }

  /**
   * Programa para establecer el n-ésimo bit de un número short.
   * <p>
   * <i>(guardar el desplazamiento a la izquierda n bits del número y aplicar la
   * operación OR lógico con el número)</i>
   * <p>
   * Ejemplo:
   * <li>- establecer a 1 el bit 4 de 0b00 1001 0100 Devolvería 0b1 1001 0100
   */
  private static void ejercicio04() {
    // Intro
    System.out.println("\n EJERCICIO 04:");
    System.out.println(" Programa para establecer el n-ésimo bit de un número short. \n ");

    // Variables
    byte bitToChange;
    short number, changedNumber;

    // Entrada de datos
    System.out.println("Introduce un número:");
    number = validate.inputType((short) 1);
    System.out.println("Introduce el bit a cambiar de ese número:");
    bitToChange = (byte) validate.inputRange(1, 1, 16);

    /*
     * Desplazamos el nº 1 hasta la posición del bit a cambiar.
     * 
     * Realizamos el XOR del nº introducido con el nº resultante anterior, lo cual
     * cambia el valor del bit.
     * 
     * La operación devuelve un int por lo que hacemos la conversión a short.
     * 
     */
    changedNumber = (short) (number ^ (1 << (bitToChange - 1)));

    // Salidas
    System.out.println("El número introducido corresponde a \"" + intToString(number, 16, 4) + "\" en binario y a \""
        + number + "\" en decimal.");
    System.out.println("El número cambiado corresponde a \"" + intToString(changedNumber, 16, 4)
        + "\" en binario y a \"" + changedNumber + "\" en decimal.");
  }

  /**
   * Programa para cambiar todos los 1 por ceros y todos los ceros por unos de un
   * número short dado.
   * <p>
   * Ejemplo:
   * <li>- 0b1001001 se convertiría en 0b01101100
   * 
   */
  private static void ejercicio05() {
    // Intro
    System.out.println("\n EJERCICIO 05:");
    System.out.println(
        " Programa para cambiar todos los 1 por ceros y todos los ceros por unos de un número short dado. \n ");

    // Variables
    short number, changed;

    // Entrada de datos
    System.out.println("Introduce un número:");
    number = validate.inputType((short) 1);

    // Aplicamos el 'bitwise compliment' que invierte el valor de los bit
    changed = (short) ~number;

    // Salidas
    System.out.println("El número introducido corresponde a \"" + intToString(number, 16, 4) + "\" en binario y a \""
        + number + "\" en decimal.");
    System.out.println("El número cambiado corresponde a \"" + intToString(changed, 16, 4) + "\" en binario y a \""
        + changed + "\" en decimal.");
  }

  /**
   * Investigar cómo podríamos escribir un programa para intercambiar el valor de
   * a y b utilizando <b>solo dos variables</b> y el operador bit a bit XOR .
   */
  private static void ejercicio06() {
    // Intro
    System.out.println("\n EJERCICIO 06:");
    System.out.println(" Intercambiar el valor de a y b utilizando solo dos variables. \n ");

    int num1, num2;

    // Entrada de datos
    System.out.println("Introduce dos número:");
    num1 = validate.inputType(1);
    num2 = validate.inputType(1);

    System.out.println("\nLos números escogidos son:");
    System.out.println("num 1 = " + num1);
    System.out.println("num 2 = " + num2);

    // num1 = A
    // num2 = B
    System.out.println("\nAplicamos la magia de los bit...");

    // num2 = A^B
    num2 = num1 ^ num2;

    // num1 = A^(A^B) = B
    num1 = num1 ^ num2;

    // num2 = B^(A^B) = A
    num2 = num1 ^ num2;

    // Salida de datos
    System.out.println("num 1 = " + num1);
    System.out.println("num 2 = " + num2);
  }

  /**
   * Programa para verificar si un número es par o impar utilizando una operación
   * a nivel de bits.
   */
  private static void ejercicio07() {
    // Intro
    System.out.println("\n EJERCICIO 07:");
    System.out
        .println(" Programa para verificar si un número es par o impar utilizando una operación a nivel de bit. \n ");

    // Variables
    int number;
    byte lastBit;

    // Entrada de datos
    System.out.println("Introduce un número:");
    number = validate.inputType(1);
    // Comparar el último bit a 1
    lastBit = (byte) (number & 0b1);

    // Salidas
    System.out.println("El número introducido corresponde a \"" + intToString(number, 32, 4) + "\" en binario");
    System.out.println("El último bit del número es un \"" + lastBit + "\" por lo que "
        + ((lastBit == 1) ? "es impar" : "es par") + ".");
  }

  /**
   * <b>¡MÉTODO SACADO DE INTERNET DIRECTAMENTE POR GANAR TIEMPO!</b>
   * <p>
   * <i>(Ha sido ligeramente editado.)</i>
   * <p>
   * Converts an integer to a 32-bit binary string
   * 
   * @param number    The number to convert
   * @param nBits     The number of bits expected
   * @param groupSize The number of bits in a group
   * @return The n-bit long bit string
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

} // Fin clase
