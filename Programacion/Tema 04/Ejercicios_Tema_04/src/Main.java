import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws Exception {

    Scanner sc = new Scanner(System.in);
    Ejercicios_Arrays ej1 = new Ejercicios_Arrays();
    boolean correrEjercicios = true;

    int[] pares = { 23, 2, 23, 4, 2, 35, 34, 5, 23, 34, 2, 24, 5, 3, 4, 1, 2, 5, 1, 2, 34 };

    do {
      System.out.println("\n==================");
      System.out.println("Ejercicios Arrays:");
      System.out.println("    03: Filtrar Pares");
      System.out.println("    04: Quiniela");
      System.out.println("    05: Apuesta Primitiva");
      System.out.println("    06: Primitiva");
      System.out.println("    07: Apariciones de número en array");
      System.out.println("    08: Apariciones de número en array (bis)");
      System.out.println("    -1: Salir \n");

      System.out.println("¿Qué ejercicio quieres probar?");
      int ejercicio = sc.nextInt();

      switch (ejercicio) {
        case 3:
          System.out.println("\nEjercicio 03: Filtrar Pares");
          ej1.imprimirArray(pares);
          ej1.imprimirArray(ej1.filtrarPares(pares));
          break;

        case 4:
          System.out.println("\nEjercicio 04: Quiniela");
          ej1.imprimirArray(ej1.quiniela());
          break;

        case 5:
          System.out.println("\nEjercicio 05: Apuesta Primitiva");
          ej1.imprimirArray(ej1.apuestaPrimitiva());
          break;

        case 6:
          System.out.println("\nEjercicio 06: Primitiva");
          ej1.imprimirPrimitiva(ej1.primitiva());
          break;

        case 7:
          System.out.println("\nEjercicio 07: Apariciones de número en array");
          int numeroABuscar = 4;
          int apariciones = ej1.aparicionesNumero(pares, numeroABuscar);
          ej1.imprimirArray(pares);
          System.out
              .print("En el array hay \'" + apariciones + ((apariciones == 1) ? "\' aparición" : "\' apariciones"));
          System.out.println(" de el número " + numeroABuscar + ".");
          break;

        case 8:
          System.out.println("\nEjercicio 08: Apariciones de número en array (bis)");
          ej1.busquedaNumeros(pares);
          break;

        case 9:
          break;

        case -1:
        default:
          System.out.println("¡Adiós!");
          correrEjercicios = false;
          break;
      }
      if (correrEjercicios) {
        System.out.println("Pulsa enter para continuar.");
        System.in.read();
      }

    } while (correrEjercicios);

    sc.close();
  }
}
