public class E01_funciones extends Ejercicios_Tema03 {


  public void main() {
    System.out.println("bloque 1 de ejercicios");

    //
    E01_funciones bloque01 = new E01_funciones();

    // Declaración de variables para escojer ejercicio
    int ejercicio;
    final int N_EJERCICIOS = 7;
    boolean exitApp = false;

    // Le pide al usuario que ejercicio quiere ejecutar
    System.out.println("Hay " + N_EJERCICIOS + " ejercicios, escoje uno:");
    System.out.println(" Ejercicio 01: ");
    System.out.println("");
    ejercicio = validate.inputRange(1, 1, N_EJERCICIOS);

  }

}
