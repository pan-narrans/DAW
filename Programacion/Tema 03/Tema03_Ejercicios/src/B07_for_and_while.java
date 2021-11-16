public class B07_for_and_while extends Bloque {

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

    listadoPrimos(100);
    System.out.println("");

    System.out.println(showSequence(15));

  }// Fin main.

  /**
   * Ejercicio 01
   */
  private void bucleFor01() {
    System.out.println("Ejercicio 01:");

    int j = 0;
    for (int i = 1; i < 4; i++) {
      j = i + 1;
      while (j < 4) {
        System.out.print(j - i + " ");
        j++;
      }
      System.out.println("");
    }

    System.out.println("");
  }

  /**
   * Realizar un programa que nos pida un número y nos imprima los números son
   * primos que hay hasta este.
   */
  private void listadoPrimos(int num) {
    System.out.println("Listado de primos hasta " + num + ":");

    boolean printNumber;
    if (num > 1) {
      for (int i = 2; i < num + 1; i++) {
        printNumber = true;
        for (int j = 2; j < i; j++) {
          if (i % j == 0)
            printNumber = false;
        }
        if (printNumber)
          System.out.print(i + " ");
      }
    }
  }

  public static String showSequence(int value) {
    int sum = 0;
    String sumText = "";

    if (value < 0) {
      sumText = value + "<0";
    } else {
      for (int i = 0; i <= value; i++) {
        sumText = sumText + i + ((i == value) ? "=" : "+");
        sum += i;
      }
      sumText += sum;
    }

    return sumText;
  }
}
