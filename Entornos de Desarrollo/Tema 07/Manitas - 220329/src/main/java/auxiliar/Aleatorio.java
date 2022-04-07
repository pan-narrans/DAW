package main.java.auxiliar;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Métodos auxiliares para generar valores aleatorios
 * 
 * @author bfrancoc@gmail.com
 * @version 1.0
 * @since 23-03-2022
 */

public class Aleatorio {

  static Random random = new Random();

  /**
   * @author bfrancoc@gmail.com
   * @version 1.0
   * @since 23-03-2022
   * @param min        min inclusivo
   * @param max        max inclusivo
   * @param nDecimales
   * @param nValores
   * @return List<Double> Lista con nValores double aleatorios entre min y max y
   *         nDecimales de precisión
   * @throws IllegalArgumentException Exception si max < min o precision < 0 o
   *                                  nValores menor que 1 y mayor que una
   *                                  constante (100)
   */

  private static final int nValoresMax = 10000;

  public static List<Double> getDoubleList(
      double min, double max, int precision, int nValores)
      throws IllegalArgumentException {
    if (max <= min)
      throw new IllegalArgumentException("Exception: Max <= Min");
    if (precision < 0)
      throw new IllegalArgumentException("Exception: Precisión < 0");
    if (nValores < 1)
      throw new IllegalArgumentException("Exception: nValores < 1");
    if (nValores > nValoresMax)
      throw new IllegalArgumentException(
          "Exception: nValores > " + nValoresMax);

    double redondeo = Math.pow(10, precision);

    return Stream
        // Genero un vector de números aleatorios entre el min y max
        .generate(() -> random.nextDouble(min, max))
        // Stream limitado a nValores
        .limit(nValores).map(numero -> numero * redondeo)
        // Empuja fuera del cero. Truco para lograr min,max inclusivos
        .map(numero -> numero >= 0 ? Math.ceil(numero) : Math.floor(numero))
        .map(numero -> numero / redondeo).toList();
  }

  /**
   * @author bfrancoc@gmail.com
   * @version 1.0
   * @since 23-03-2022
   * @param min
   * @param max
   * @param nDecimales
   * @return List<Double> Valor aleatorio entre min y max y nDecimales de
   *         precisión
   * @throws IllegalArgumentException Exception si max < min o precision < 0
   */

  // Caso particular de la lista anterior
  public static double getDouble(double min, double max, int nDecimales) {
    return getDoubleList(min, max, nDecimales, 1).get(0).doubleValue();
  }

  /**
   * @author bfrancoc@gmail.com
   * @version 1.0
   * @since 23-03-2022
   * @param min
   * @param max
   * @return List<Integer> Lista con nValores int aleatorios entre min y max
   * @throws IllegalArgumentException Exception si max < min o nValores menor
   *                                  que 1 y mayor que una constante (100)
   */

  public static List<Integer> getIntList(int min, int max, int nValores)
      throws IllegalArgumentException {
    if (max <= min)
      throw new IllegalArgumentException("Exception: Max <= Min");

    return Stream.generate(() -> random.nextInt(min, max + 1))
        // Vector de números aleatorios. El max+1 es para hacer el max inclusivo
        .limit(nValores) // Limitado a nValores
        .collect(Collectors.toList());
  } // Lo convierte a lista

  /**
   * @author bfrancoc@gmail.com
   * @version 1.0
   * @since 23-03-2022
   * @param min
   * @param max
   * @return List<Integer> Lista con nValores int aleatorios entre min y max
   * @throws IllegalArgumentException Exception si max < min o nValores menor
   *                                  que 1 y mayor que una constante (100)
   */

  // Caso particular del anterior
  public static int getInt(int min, int max) {
    return getIntList(min, max, 1).get(0).intValue();
  }

  /**
   * @author bfrancoc@gmail.com
   * @version 1.0
   * @since 23-03-2022
   * @param nChar N
   * @param max
   * @return String String con nChar caracteres alfabéticos aleatorios
   *         (minúsculas)
   * @throws IllegalArgumentException Exception si max < min o nChar menor que 1
   *                                  y mayor que una constante (20)
   */

  private static final int nCharMax = 20;

  public static String getString(int nChar) {
    if (nChar < 0)
      throw new IllegalArgumentException("Exception: nChar < 1");
    if (nChar > nCharMax)
      throw new IllegalArgumentException("Exception: nChar > " + nCharMax);

    StringBuilder resultado = new StringBuilder(); // String iterable

    getIntList(97, 122, nChar)
        // Genera una lista de nChar enteros con los ascii de las minúsculas
        .stream() // iterable
        .map(entero -> Character.toString(entero))
        // convierte el int al carácter ascii correspondiente
        .forEach(caracter -> resultado.append(caracter));
    // junta todos los caracteres en una cadena de longitud nChar

    return resultado.toString();
  } // Devuelve un String

  /**
   * @author bfrancoc@gmail.com
   * @version 1.0
   * @since 24-03-2022
   * @return boolean true or false aleatorio
   */

  public static boolean getBoolean() { return random.nextBoolean(); }

  // MAIN

  public static void main(String[] args) {

    getDoubleList(-100, 100, 2, 50).stream().filter(n -> n > 0)
        .forEach(n -> System.out.println(n));

  }
}
