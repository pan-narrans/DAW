public class B04_condicionales extends Ejercicio {
  public void main() {
    System.out.println("Bloque 04 de ejercicios.\n");

    final int N_EJERCICIOS = 7;

    // Inicialización de ejercicios
    Ejercicio[] ejercicios = new Ejercicio[N_EJERCICIOS];
    ejercicios[0] = new B04_E01("\t Ejercicio 01: .");
    ejercicios[1] = new B04_E02("\t Ejercicio 02: .");
    ejercicios[2] = new B04_E03("\t Ejercicio 03: .");
    ejercicios[3] = new B04_E04("\t Ejercicio 04: .");
    ejercicios[4] = new B04_E05("\t Ejercicio 05: .");
    ejercicios[5] = new B04_E06("\t Ejercicio 06: .");
    ejercicios[6] = new B04_E07("\t Ejercicio 07: .");
    ejercicios[6] = new B04_E08("\t Ejercicio 08: .");

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
     * @param info pequeña descripción del ejercicio
     */
    public B04_E03(String info) {
      setSelfInfo(info);
    }

    public void main() {
      // TODO
    }

  } // Fin Ejercicio 03

  /**
   * Bloque 03 - Ejercicio 04
   */
  private class B04_E04 extends Ejercicio {

    /**
     * @param info pequeña descripción del ejercicio
     */
    public B04_E04(String info) {
      setSelfInfo(info);
    }

    public void main() {
      // TODO
    }

  } // Fin Ejercicio 04

  /**
   * Bloque 03 - Ejercicio 05
   */
  private class B04_E05 extends Ejercicio {

    /**
     * @param info pequeña descripción del ejercicio
     */
    public B04_E05(String info) {
      setSelfInfo(info);
    }

    public void main() {
      // TODO
    }

  } // Fin Ejercicio 05

  /**
   * Bloque 03 - Ejercicio 06
   */
  private class B04_E06 extends Ejercicio {

    /**
     * @param info pequeña descripción del ejercicio
     */
    public B04_E06(String info) {
      setSelfInfo(info);
    }

    public void main() {
      // TODO
    }

  } // Fin Ejercicio 06

  /**
   * Bloque 03 - Ejercicio 07
   */
  private class B04_E07 extends Ejercicio {

    /**
     * @param info pequeña descripción del ejercicio
     */
    public B04_E07(String info) {
      setSelfInfo(info);
    }

    public void main() {
      // TODO
    }

  } // Fin Ejercicio 07

  /**
   * Bloque 03 - Ejercicio 08
   */
  private class B04_E08 extends Ejercicio {

    /**
     * @param info pequeña descripción del ejercicio
     */
    public B04_E08(String info) {
      setSelfInfo(info);
    }

    public void main() {
      // TODO
    }

  } // Fin Ejercicio 08
}
