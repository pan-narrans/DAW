public class E02_estructuras_if extends Bloque {

  public void main() {
    System.out.println("bloque 1 de ejercicios");

    // Declaración de variables para escojer ejercicio
    int n_ejercicio;
    final int N_EJERCICIOS = 3;
    boolean exitApp = false;

    Ejercicio[] ejercicios = new Ejercicio[N_EJERCICIOS];
    ejercicios[0] = new B02_E01();
    ejercicios[0].setSelfInfo("\t Ejercicio 01: comprobar si dos nº son iguales.");
    ejercicios[1] = new B02_E02();
    ejercicios[2] = new B02_E03();

    // ESCOGER EJERCICIO
    while (!exitApp) {
      // Le pide al usuario que ejercicio quiere ejecutar
      System.out.println("Hay " + N_EJERCICIOS + " ejercicios, escoje uno:");
      System.out.println("\t Ejercicio 01: comprobar si dos nº son iguales.");
      System.out.println("\t Ejercicio 02: comprobar si un nº es positivo.");
      System.out.println("\t Ejercicio 03: comprobar si un nº par o impar.");
      showInfo(ejercicios, N_EJERCICIOS);
      n_ejercicio = validate.inputRange(1, 1, N_EJERCICIOS) - 1;

      ejercicios[n_ejercicio].main();

      // Continuar ejecución o no
      System.out.println("¿Quieres volver a la selección de bloque?");
      exitApp = validate.inputType(true);
    }

  }// fin main
}

/**
 * Crear una función llamada sonIguales que reciba dos números por parámetro y
 * devuelva true si son iguales o false en caso contrario.
 */
class B02_E01 extends Ejercicio {
  public void main() {
    float num1, num2;

    System.out.println("Introduce dos números:");
    num1 = validate.inputType(1f);
    num2 = validate.inputType(1f);

    System.out.println("Los números son " + (funtion.testEqual(num1, num2) ? "iguales." : "difentes."));
  }
}

/**
 * Crear una función llamada esPositivo que reciba un número por parámetro y
 * devuelva true si es positivo o false en caso contrario.
 */
class B02_E02 extends Ejercicio {
  public void main() {
    float num;

    System.out.println("Introduce un número:");
    num = validate.inputType(1f);

    System.out.println("El número " + (funtion.isPositive(num) ? "" : "no ") + "es positivo.");
  }
}

/**
 * Crear una función llamada parOimpar que reciba un número por
 */
class B02_E03 extends Ejercicio {
  public void main() {
    int num;

    System.out.println("Introduce un número:");
    num = validate.inputType(1);

    System.out.println("El número es " + (funtion.isEven(num) ? "par." : "impar."));
  }
}