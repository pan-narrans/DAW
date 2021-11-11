import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class B04_condicionales extends Ejercicio {
  public void main() {
    System.out.println("Bloque 04 de ejercicios.\n");

    final int N_EJERCICIOS = 8;

    // Inicialización de ejercicios
    Ejercicio[] ejercicios = new Ejercicio[N_EJERCICIOS];
    ejercicios[0] = new B04_E01("\t Ejercicio 01: calcula cual es el mayor de dos nº.");
    ejercicios[1] = new B04_E02("\t Ejercicio 02: calcula cual es el mayor de tres nº.");
    ejercicios[2] = new B04_E03("\t Ejercicio 03: comprueba si un nº es par o impar.");
    ejercicios[3] = new B04_E04("\t Ejercicio 04: comprueba si dos nº son divisores.");
    ejercicios[4] = new B04_E05("\t Ejercicio 05: calcula si un año es bisiesto o no.");
    ejercicios[5] = new B04_E06("\t Ejercicio 06: dice si una nota es un suspenso o un aprobado.");
    ejercicios[6] = new B04_E07("\t Ejercicio 07: comprueba si un carácter pertenece al alfabeto o no.");
    ejercicios[7] = new B04_E08("\t Ejercicio 08: mismo que el 07.");

    // ESCOGER EJERCICIO
    chooseExercise(ejercicios);

  }// Fin main.

  /**
   * Bloque 03 - Ejercicio 01
   */
  private class B04_E01 extends Ejercicio {

    /**
     * Escribir una función llamada int esMayor (int a, int b) que recibe dos
     * números A y B e y devuelva utilizando el operador condicional el mayor de los
     * dos.
     * 
     * @param info pequeña descripción del ejercicio
     */
    public B04_E01(String info) {
      setSelfInfo(info);
    }

    public void main() {
      int num1, num2;
      System.out.println("Introduce un número:");
      num1 = validate.inputType(1);
      System.out.println("Introduce otro número:");
      num2 = validate.inputType(1);
      System.out.println("El mayor de los dos es el: " + esMayor(num1, num2));
    }

    private int esMayor(int num1, int num2) {
      return (num1 > num2) ? num1 : num2;
    }

  } // Fin Ejercicio 01

  /**
   * Bloque 03 - Ejercicio 02
   */
  private class B04_E02 extends Ejercicio {

    /**
     * Escribir una función llamada int esMayor(int a, int b, int c) que recibe tres
     * números A, B y C e y devuelva utilizando el operador condicional el mayor de
     * los tres.
     * 
     * @param info pequeña descripción del ejercicio
     */
    public B04_E02(String info) {
      setSelfInfo(info);
    }

    public void main() {
      int num1, num2, num3;
      System.out.println("Introduce un número:");
      num1 = validate.inputType(1);
      System.out.println("Introduce otro número:");
      num2 = validate.inputType(1);
      System.out.println("Introduce otro número:");
      num3 = validate.inputType(1);
      System.out.println("El mayor de los tres es el: " + esMayor(num1, num2, num3));
    }

    private int esMayor(int num1, int num2, int num3) {
      return (num1 > num2 & num1 > num3) ? num1 : (num2 > num3) ? num2 : num3;
    }

  } // Fin Ejercicio 02

  /**
   * Bloque 03 - Ejercicio 03
   */
  private class B04_E03 extends Ejercicio {

    /**
     * Crear una función llamada String parImpar (int numero) que recibe un número
     * por parámetro y devuelva utilizando el operador condicional “Par” si es par e
     * “Impar” en caso contrario.
     * 
     * @param info pequeña descripción del ejercicio
     */
    public B04_E03(String info) {
      setSelfInfo(info);
    }

    public void main() {
      int num;
      System.out.println("Introduce un número:");
      num = validate.inputType(1);
      System.out.println("El nº introducido es \"" + parImpar(num) + "\"");
    }

    private String parImpar(int num) {
      return (num % 2 == 0) ? "Par" : "Impar";
    }

  } // Fin Ejercicio 03

  /**
   * Bloque 03 - Ejercicio 04
   */
  private class B04_E04 extends Ejercicio {

    /**
     * Crear una función llamada boolean sonDivisores (int a, int b) que reciba dos
     * números por parámetro y compruebe si a es mayor que b y en ese caso que
     * devuelva utilizando el operador condicional true si uno es divisor del otro o
     * false en caso contrario.
     * 
     * @param info pequeña descripción del ejercicio
     */
    public B04_E04(String info) {
      setSelfInfo(info);
    }

    public void main() {
      int num1, num2;
      System.out.println("Introduce un nº:");
      num1 = validate.inputType(1);
      System.out.println("Introduce otro nº:");
      num2 = validate.inputType(1);
      System.out.println(
          "Los números introducidos " + (areMultiple(num1, num2) ? "" : "no ") + "son multiplos el uno del otro.");
      System.out.println((areMultiple(num1, num2) ? "Por lo tanto el más pequeño es divisor del mayor." : ""));
    }

    private boolean areMultiple(float num1, float num2) {
      return (num1 % num2 == 0) ? true : (num2 % num1 == 0) ? true : false;
    }

  } // Fin Ejercicio 04

  /**
   * Bloque 03 - Ejercicio 05
   */
  private class B04_E05 extends Ejercicio {

    /**
     * Crear una función llamada boolean esBisiesto (int dia, int mes, int año) que
     * reciba por parámetro un día, un mes y un año y que devuelva true si es año
     * bisiesto y false en caso contrario utilizando el operador condicional.
     * 
     * @param info pequeña descripción del ejercicio
     */
    public B04_E05(String info) {
      setSelfInfo(info);
    }

    public void main() {
      int year;
      System.out.println("Introduce el año que quieras comprobar:");
      year = validate.inputType(1);
      System.out.println("El año " + year + (esBisiesto(year) ? " " : " no ") + "es bisiesto.");
    }

    private boolean esBisiesto(int year) {
      return (year % 4 == 0 & year % 100 != 0 | year % 400 == 0) ? true : false;
    }

  } // Fin Ejercicio 05

  /**
   * Bloque 03 - Ejercicio 06
   */
  private class B04_E06 extends Ejercicio {

    /**
     * Escribir la función estaAprobado que reciba por parámetro una nota de tipo
     * float y devuelva utilizando el operador condicional un String “aprobado” si
     * es igual o mayor de cinco o “suspenso” en caso contrario.
     * 
     * @param info pequeña descripción del ejercicio
     */
    public B04_E06(String info) {
      setSelfInfo(info);
    }

    public void main() {
      float score;
      System.out.println("Introduce la nota obtenida:");
      score = validate.inputType(1f);
      System.out.println("El alumno está \"" + (estaAprobado(score)) + "\".");
    }

    private String estaAprobado(float score) {
      return (score >= 5) ? "Aprobado" : "Suspenso";
    }

  } // Fin Ejercicio 06

  /**
   * Bloque 03 - Ejercicio 07
   */
  private class B04_E07 extends Ejercicio {

    /**
     * Escribir un programa que lea un carácter e indique si es del alfabeto o no.
     * 
     * @param info pequeña descripción del ejercicio
     */
    public B04_E07(String info) {
      setSelfInfo(info);
    }

    public void main() {
      char c;
      System.out.println("Introduce un carácter:");
      c = validate.inputType('c');
      System.out.println("El carácter introducido " + (esAlfabeto(c) ? "" : "no ") + "pertenece al alfabeto.");
    }

    static public boolean esAlfabeto(char c) {
      return (c > 64 & c < 91 | c > 96 & c < 123 | c == 209 | c == 241) ? true : false;
    }

  } // Fin Ejercicio 07

  /**
   * Bloque 03 - Ejercicio 08
   */
  private class B04_E08 extends Ejercicio {

    /**
     * Escribir la función esAlfabeto que reciba por parámetro un carácter de tipo
     * char y utilizando el operador condicional devuelva true si es del alfabeto
     * (es una letra de la a la z incluida la ñ) y false en caso contrario.
     * 
     * @param info pequeña descripción del ejercicio
     */
    public B04_E08(String info) {
      setSelfInfo(info);
    }

    public void main() {
      char c;
      System.out.println("Introduce un carácter:");
      c = validate.inputType('c');
      System.out.println("char " + c + " code: " + (int) c);
      System.out.println("El carácter introducido " + (esAlfabeto(c) ? "" : "no ") + "pertenece al alfabeto.");
    }

    static public boolean esAlfabeto(char c) {
      return (c > 64 & c < 91 | c > 96 & c < 123 | c == 209 | c == 241) ? true : false;
    }

  } // Fin Ejercicio 08

  @Test
  public void test_esAlfabeto() {
    // A = 65 -> Z = 90
    // a = 97 -> z = 122
    // ñ = 241 & Ñ = 209

    char[] chars = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q', 'R', 'S',
        'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ',
        'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

    for (char c : chars) {
      assertEquals(true, B04_E07.esAlfabeto(c));
    }

    for (int i = -250; i < 250; i++) {
      if (i > 64 && i < 91) {
        assertEquals(true, B04_E07.esAlfabeto((char) i));
      } else if (i > 96 && i < 123) {
        assertEquals(true, B04_E07.esAlfabeto((char) i));
      } else if (i == 209 | i == 241) {
        assertEquals(true, B04_E07.esAlfabeto((char) i));
      } else {
        assertEquals(false, B04_E07.esAlfabeto((char) i));
      }
    }

    assertEquals(false, B04_E07.esAlfabeto((char) Integer.MAX_VALUE));
    assertEquals(false, B04_E07.esAlfabeto((char) Integer.MIN_VALUE));

  }
}
