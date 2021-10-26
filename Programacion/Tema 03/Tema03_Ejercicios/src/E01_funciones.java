public class E01_funciones extends Bloque {

  public void main() {
    System.out.println("bloque 1 de ejercicios");

    // Declaración de variables para escojer ejercicio
    int n_ejercicio;
    final int N_EJERCICIOS = 2;
    boolean exitApp = false;
    /*
     * Ejercicio[] e_funciones = new Ejercicio[N_EJERCICIOS]; e_funciones[0] =
     * new Ejercicio(); 
     * e_funciones[0].setSelfInfo("Ejercicio 01 : tema del main");
     * e_funciones[1] = new Ejercicio();
     * e_funciones[1].setSelfInfo("Ejercicio 01 : otro tema del main, yo que se tio"
     * );
     */

    // ESCOGER BLOQUE
    while (!exitApp) {
      // showInfo(bloques, N_EJERCICIOS);
      // Le pide al usuario que bloque quiere ejecutar
      // n_ejercicio = validate.inputRange(1, 1, N_EJERCICIOS) - 1;

      // Ejecuta el main del bloque escogido
      // bloques[n_ejercicio].main();

      // Le pide al usuario que ejercicio quiere ejecutar
      System.out.println("Hay " + N_EJERCICIOS + " ejercicios, escoje uno:");
      // showInfo(e_funciones, N_EJERCICIOS);
      n_ejercicio = validate.inputRange(1, 1, N_EJERCICIOS);

      // Escoger el ejercicio
      switch (n_ejercicio) {
      case 1:
        ejercicio_01();
        break;
      default:
        break;
      }

      // Continuar ejecución o no
      System.out.println("¿Quieres volver a la selección de bloque?");
      exitApp = validate.inputType(true);
    }

  }// fin main

  private void ejercicio_01() {

  }

}
