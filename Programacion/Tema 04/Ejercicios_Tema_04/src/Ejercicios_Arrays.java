import java.util.Scanner;
import java.util.Arrays;

public class Ejercicios_Arrays {
  static Scanner sc = new Scanner(System.in);
  /*
   * 
   * 
   * Realizar la función int [] primitiva() que genere una primitiva de 6 números
   * enteros entre el 1 y el 49.
   * 
   */

  /* ========================================================================== */
  /* ============================== EJERCICIO 04 ============================== */
  /* ========================================================================== */
  /**
   * <h5>EJERCICIO 04</h5>
   * Realizar la función  {char [] quiniela()} que genere una quiniela de 15
   * resultados con valores aleatorios 1, X o 2.
   * 
   * @return
   */
  char[] quiniela() {
    char[] quiniela = new char[14];

    return quiniela;
  }

  /* ========================================================================== */
  /* ============================== EJERCICIO 03 ============================== */
  /* ========================================================================== */
  /**
   * <h5>EJERCICIO 03</h5>
   * Escriba la función int [] filtrarPares(int [] numeros) que reciba un array
   * con números y devuelva un nuevo array solo con los que sean pares.
   * 
   * @param numeros Array a filtrar
   * @return Array con solo los números pares
   */
  int[] filtrarPares(int[] numeros) {
    int[] temp = new int[numeros.length];
    int i = 0;

    // Grabamos los nº pares en un array temporal del tamaño máximo
    for (int num : numeros) {
      if (num % 2 == 0)
        temp[i++] = num;
    }

    // Creamos un array del tamaño justo con solo los nº pares
    int[] soloPares = new int[i];
    for (int j = 0; j < i; j++) {
      soloPares[j] = temp[j];
    }

    return soloPares;
  }

  /* ========================================================================== */
  /* ============================== EJERCICIO 02 ============================== */
  /* ========================================================================== */
  /**
   * <h5>EJERCICIO 02</h5>
   * Escriba la función void imprimirArray(int [] numeros) que imprima en la
   * consola los números del array.
   * 
   * @param numeros Array a imprimir
   */
  void imprimirArray(int[] numeros) {
    System.out.println("Array = " + Arrays.toString(numeros));
  }

  /* ========================================================================== */
  /* ============================== EJERCICIO 01 ============================== */
  /* ========================================================================== */
  /**
   * <h5>EJERCICIO 01</h5>
   * Escribe la función void rellenarArray(int [] numeros) que pedirá al usuario
   * que introduzca números hasta que el array esté completo.
   * 
   * @param numeros Array a rellenar
   */
  void rellenarArray(int[] numeros) {
    for (int i = 0; i < numeros.length; i++) {
      System.out.print("Introduce un nº: ");
      numeros[i] = sc.nextInt();
    }
    System.out.println("¡El array está completo!");
  }

}
