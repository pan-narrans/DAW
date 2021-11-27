public class B06_for extends Bloque {

  public void main() {
    System.out.println("Bloque 06 de ejercicios.\n");

    // final int N_EJERCICIOS = 4;

    // Inicialización de ejercicios
    // Ejercicio[] ejercicios = new Ejercicio[N_EJERCICIOS];

    // ejercicios[0] = new B06_E01("\t Ejercicio 01: .");
    // ejercicios[1] = new B06_E02("\t Ejercicio 02: .");
    // ejercicios[2] = new B06_E03("\t Ejercicio 03: .");
    // ejercicios[3] = new B06_E04("\t Ejercicio 04: .");

    // ESCOGER EJERCICIO
    // chooseExercise(ejercicios);

    bucleFor01();
    System.out.println("");

    tablasDeMultiplicar();
    System.out.println("");

    contarOvejas(5);
    System.out.println("");

    imprimirCuadrado(5);
    System.out.println("");

    imprimirTrianguloDescendente(5);
    System.out.println("");

    imprimirTrianguloAscentente(5);
    System.out.println("");

    imprimirTriangulo(5);
    System.out.println("");

    textoDelReves("Sphinx of black quartz judge my vow.");
    System.out.println("");

  }// Fin main.

  /**
   * Ejercicio 01
   */
  private void bucleFor01() {
    System.out.println("Ejercicio 01:");

    int sum;
    for (int i = 1; i < 5; i++) {
      for (int j = 3; j > -1; j--) {
        sum = i * 10 + j;
        System.out.print(sum + " ");
      }
    }

    System.out.println("");
  }

  /**
   * Implementa un procedimiento llamada void tablasDeMultiplicar(), que imprimirá
   * por pantalla las tablas de multiplicar del 1 al 10 utilizando un bucle for.
   */
  private void tablasDeMultiplicar() {
    System.out.println("Ejercicio 02:");

    for (int i = 1; i < 11; i++) {
      System.out.print("Tabla del " + i + ":\t");
      for (int j = 1; j < 11; j++) {
        System.out.print(i * j + ", ");
      }
      System.out.println("");
    }
  }

  /**
   * Programa una función llamada void contarOvejas(int numOvejas), que reciba un
   * número entero e imprima en pantalla el número de ovejas utilizando un bucle
   * for:
   * 
   * Por ejemplo para 3 debería devolver 1 oveja...2 ovejas...3 ovejas…
   * 
   * Nota que la primera oveja debería ir en singular. *
   * 
   * @param nSheeps number of sheeps
   * 
   *                <pre>
                    * example of sheep:
                        _.-..
                      ,'9 )\)`-.,.--.
                      `-.|           `.
                        \,      ,    \)
                        `.  )._\   (\
                          |//   `-,//
                          ]||    //"
                          ""    ""
   *                </pre>
   * 
   */
  private void contarOvejas(int nSheeps) {
    System.out.println("Ejercicio 03:");

    for (int i = 1; i < nSheeps + 1; i++) {
      System.out.print(i + " oveja" + ((i > 1) ? "s" : "") + "... ");
    }

    System.out.println("");
  }

  /**
   * Implemente la función imprimirCuadrado (int n) que recibe un número entero n
   * y después de comprobar que es que igual o mayor que cero imprimirá un
   * cuadrado de n elementos con asteriscos utilizando dos for anidados.
   * 
   * @param n size of the side of the square
   */
  private void imprimirCuadrado(int n) {
    System.out.println("Ejercicio 04:");

    if (n > -1) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          System.out.print("* ");
        }
        System.out.println("");
      }
    }
  }

  /**
   * Implemente la función imprimirTrianguloDescentente (int n) que recibe un
   * número entero n y después de comprobar que es que igual o mayor que cero
   * imprimirá mediante dos for anidados un triángulo descendente con asteriscos.
   */
  private void imprimirTrianguloDescendente(int n) {
    System.out.println("Ejercicio 05:");

    if (n > -1) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n - i; j++) {
          System.out.print("* ");
        }
        System.out.println("");
      }
    }
  }

  /**
   * Implemente la función imprimirTrianguloAscentente (int n) que recibe un
   * número entero n y después de comprobar que es que igual o mayor que cero
   * imprimirá mediante dos for anidados un triángulo ascendente con asteriscos.
   */
  private void imprimirTrianguloAscentente(int n) {
    System.out.println("Ejercicio 06:");

    if (n > -1) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < i + 1; j++) {
          System.out.print("* ");
        }
        System.out.println("");
      }
    }
  }

  /**
   * Implemente la función imprimirTriangulo (int n) que recibe un número entero n
   * y después de comprobar que es igual o mayor que cero que imprimirá mediante
   * dos for anidados un triangulo con n asteriscos de base.
   */
  private void imprimirTriangulo(int n) {
    System.out.println("Ejercicio 07:");

    if (n > -1) {
      for (int i = 0; i < n; i += 2) {
        // Imprime los espacios
        for (int j = 0; j < (n - i) / 2; j++) {
          System.out.print("  ");
        }
        // Imprime los asteriscos
        for (int k = 0; k < i + 1; k++) {
          System.out.print("* ");
        }
        // Salta a la línea
        System.out.println("");
      }
    }
  }

  /**
   * Escriba la función String textoDelReves (String texto) que recibe una cadena
   * de texto y devuelve la cadena de texto del revés utilizando un for y los
   * métodos de String charAt(pos) y length..
   */
  private void textoDelReves(String text) {
    System.out.println("Ejercicio 08:");

    for (int i = text.length() - 1; i > -1; i--) {
      System.out.print(text.charAt(i));
    }
  }

}