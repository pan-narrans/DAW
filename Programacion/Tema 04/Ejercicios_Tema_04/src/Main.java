import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws Exception {
    final String SEPARADOR = "\n===============";

    Scanner sc = new Scanner(System.in);
    Ejercicios_Arrays ej1 = new Ejercicios_Arrays();
    boolean correrEjercicios = true;

    int[] numeros = new int[5];
    int[] pares = {
        23, 2, 23, 4, 2, 35, 34, 5, 23, 34, 2, 24, 5, 0, 3, 4, 1, 234,
        123, 1, 23, 2, 34, 123, 123, 5, 7, 5, 67, 8, 3, 45, 4, 7, 245
    };

    do {
      System.out.println(SEPARADOR);
      System.out.println("Ejercicios Arrays:");
      System.out.println("    03: Filtrar Pares");
      System.out.println("    04: Quiniela");
      System.out.println("    05: Apuesta Primitiva");
      System.out.println("    06: Primitiva");
      System.out.println("    07: Apariciones de número en array");
      System.out.println("    08: Apariciones de número en array (bis)");
      System.out.println("    09: Rellenar un array sin repeticiones");
      System.out.println("    10: Imprimir un array ignorando repeticiones");
      System.out.println("    -1: Salir \n");

      System.out.println(SEPARADOR);
      System.out.println("¿Qué ejercicio quieres probar?");
      int ejercicio = sc.nextInt();

      System.out.println(SEPARADOR);
      switch (ejercicio) {
        case 3:
          System.out.println("Ejercicio 03: Filtrar Pares");
          ej1.imprimirArray(pares);
          ej1.imprimirArray(ej1.filtrarPares(pares));
          break;

        case 4:
          System.out.println("Ejercicio 04: Quiniela");
          ej1.imprimirArray(ej1.quiniela());
          break;

        case 5:
          System.out.println("Ejercicio 05: Apuesta Primitiva");
          ej1.imprimirArray(ej1.apuestaPrimitiva());
          break;

        case 6:
          System.out.println("Ejercicio 06: Primitiva");
          ej1.imprimirPrimitiva(ej1.primitiva());
          break;

        case 7:
          System.out.println("Ejercicio 07: Apariciones de número en array");
          int numeroABuscar = 4;
          int apariciones = ej1.aparicionesNumero(pares, numeroABuscar);
          ej1.imprimirArray(pares);
          System.out
              .print("En el array hay \'" + apariciones + ((apariciones == 1) ? "\' aparición" : "\' apariciones"));
          System.out.println(" de el número " + numeroABuscar + ".");
          break;

        case 8:
          System.out.println("Ejercicio 08: Apariciones de número en array (bis)");
          ej1.busquedaNumeros(pares);
          break;

        case 9:
          System.out.println("Ejercicio 09: Rellenar un array sin repeticiones");
          ej1.rellenarArraySinRepetir(numeros);
          ej1.imprimirArray(numeros);
          break;

        case 10:
          System.out.println("Ejercicio 10: Imprimir un array ignorando repeticiones");
          ej1.imprimirArray(pares);
          ej1.imprimirArraySinRepetir(pares);
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
