import java.util.*;

public class E01_funciones extends Bloque {

  public void main() {
    System.out.println("Bloque 01 de ejercicios.\n");

    // Declaración de variables para escojer ejercicio
    int n_ejercicio;
    final int N_EJERCICIOS = 6;
    boolean continueExecution = true;

    // Inicialización de ejercicios
    Ejercicio[] ejercicios = new Ejercicio[N_EJERCICIOS];
    ejercicios[0] = new B01_E01("\t Ejercicio 01: si la función main recibe un solo argumento, lo imprime.");
    ejercicios[1] = new B01_E02("\t Ejercicio 02: si la función main recibe 3 nº enteros, imprime el mayor.");
    ejercicios[2] = new B01_E03("\t Ejercicio 03: devuelve la media de las notas pasadas por la función main.");
    ejercicios[3] = new B01_E04("\t Ejercicio 04: muestra un mensaje por pantalla n veces.");
    ejercicios[4] = new B01_E05("\t Ejercicio 05: calcula el precio con iva de un artículo.");
    ejercicios[5] = new B01_E06("\t Ejercicio 06: devuelve solo los nº impares.");

    // ESCOGER EJERCICIO
    while (continueExecution) {
      // Le pide al usuario que ejercicio quiere ejecutar
      System.out.println("Hay " + N_EJERCICIOS + " ejercicios, escoje uno:");
      showInfo(ejercicios);
      n_ejercicio = validate.inputRange(1, 1, N_EJERCICIOS) - 1;

      ejercicios[n_ejercicio].main();

      // Continuar ejecución o no
      System.out.println("¿Quieres ejecutar otro ejercicio?");
      continueExecution = validate.inputType(true);
    } // Fin escoger ejercicio.

  }// Fin main.

}// Fin clase Bloque 01.

/**
 * Bloque 01 - Ejercicio 01
 */
class B01_E01 extends Ejercicio {

  /**
   * Realizar un programa que compruebe si ha recibido un argumento la función
   * main, y en caso afirmativo que lo imprima por pantalla.
   * 
   * @param info pequeña descripción del ejercicio
   */
  public B01_E01(String info) {
    setSelfInfo(info);
  }

  public void main() {
    String[] args = getArgs();

    if (args.length == 1) {
      System.out.println("La función main ha recibido un solo argumento: " + args[0]);
    } else {
      System.out.println("La función main no ha recibido un solo argumento.");
    }
  }
}

/**
 * Bloque 01 - Ejercicio 02
 */
class B01_E02 extends Ejercicio {

  /**
   * Realizar un programa que reciba tres argumentos de números positivos por la
   * función main, en caso de recibir más de 3 o menos de 3 o un número negativo
   * devolverá -1. El programa devolverá el mayor número de los tres recibidos.
   * 
   * @param info pequeña descripción del ejercicio
   */
  public B01_E02(String info) {
    setSelfInfo(info);
  }

  public void main() {
    String[] args = getArgs();
    float[] nums = new float[3];

    // Validación de los datos.
    if (args.length != 3) {
      System.out.println("-1");
    } else {
      for (int i = 0; i < 3; i++) {
        try {
          nums[i] = Float.parseFloat(args[i]);
        } catch (Exception e) {
          System.out.println("El argumento nº" + i + " no es un número.");
          return;
        }
        if (nums[i] < 0) {
          System.out.println("El argumento nº" + i + " no es un número positivo.");
          return;
        }
      } // Fin bucle for.
    }

    nums = function.orderNumbersBigToSmall(nums);

    System.out.println("El nº mayor de los recibidos es: " + nums[0]);

  }
}

/**
 * Bloque 01 - Ejercicio 03
 */
class B01_E03 extends Ejercicio {

  /**
   * Realizar un programa que devuelva la media de todas las notas de 0.0 a 10.0
   * introducidas mediante args en main.
   * 
   * @param info pequeña descripción del ejercicio
   */
  public B01_E03(String info) {
    setSelfInfo(info);
  }

  public void main() {
    String[] args = getArgs();
    float[] nums = new float[args.length];
    float average = 0;

    // Validación de los datos.
    for (int i = 0; i < args.length; i++) {
      try {
        nums[i] = Float.parseFloat(args[i]);
      } catch (Exception e) {
        System.out.println("El argumento nº" + i + " no es un número.");
        return;
      }
      if (nums[i] < 0 | nums[i] > 10) {
        System.out.println(
            "El argumento nº" + i + " no es un número válido. \nLas notas tienen que estar entre el 0 y el 10.");
        return;
      }
      average += nums[i];
    } // Fin bucle for.

    average /= args.length;

    System.out.println("La media de las notas es: " + average + "/10.");
  }
}

/**
 * Bloque 01 - Ejercicio 04
 */
class B01_E04 extends Ejercicio {

  /**
   * Realizar un procedimiento, a la que se le pase como parámetro un número N, y
   * muestre por pantalla N veces, el mensaje: “Módulo ejecutándose”
   * 
   * @param info pequeña descripción del ejercicio
   */
  public B01_E04(String info) {
    setSelfInfo(info);
  }

  public void main() {
    System.out.println("¿Cuantas veces quieres ejecutar el módulo?");
    int n = validate.inputType(1);
    imprimir(n);
  }

  private void imprimir(int n) {
    for (int i = 0; i < n; i++) {
      System.out.println(i + " Módulo ejecutándose.");
    }
  }
}

/**
 * Bloque 01 - Ejercicio 05
 */
class B01_E05 extends Ejercicio {

  /**
   * Realizar una función llamada calcularIVA que reciba un importe positivo en
   * euros y el iva correspondiente (entre 0.00 y 1.00) y devuelva el importe con
   * IVA. En caso de error devolverá -1.
   * 
   * @param info pequeña descripción del ejercicio
   */
  public B01_E05(String info) {
    setSelfInfo(info);
  }

  public void main() {
    float euros, IVA;

    System.out.println("Introduce el importe en euros:");
    euros = validate.inputType(1f);
    System.out.println("Introduce el IVA (entre 0.0 y 1.0):");
    IVA = validate.inputType(1f);

    euros = calcularIVA(euros, IVA);

    System.out.println(
        (euros != -1) ? "El precio con IVA es: " + euros + "€" : "Alguno de los valores introducidos no es válido.");

  }

  private float calcularIVA(float euros, float IVA) {
    if (IVA < 0 | IVA > 1 | euros < 0) {
      euros = -1;
    } else {
      euros += euros * IVA;
    }
    return euros;
  }
}

/**
 * Bloque 01 - Ejercicio 06
 */
class B01_E06 extends Ejercicio {

  /**
   * Realizar una función llamada contarImpares que reciba un número variable de
   * números enteros y devuelva cuántos de estos son impares.
   * 
   * @param info pequeña descripción del ejercicio
   */
  public B01_E06(String info) {
    setSelfInfo(info);
  }

  public void main() {
    boolean seguir = true;
    List<Integer> nums = new LinkedList<Integer>();

    // Toma de nº
    while (seguir) {
      System.out.println("Introduce un nº entero:");
      nums.add(validate.inputType(1));
      System.out.println("¿Quieres introducir otro nº?");
      seguir = validate.inputType(true);
    }

    // Quitar los pares
    nums = onlyOdds(nums);

    System.out.println("Hay " + nums.size() + " nº impares, y son: " + nums);
  }

  /**
   * @param nums list of integers to sift through.
   * @return a list with only the odd numbers in the original input.
   */
  private List<Integer> onlyOdds(List<Integer> nums) {
    for (int i = 0; i < nums.size(); i++) {
      int num = nums.get(i);
      if ((num & 1) == 0) {
        nums.remove(i);
        i--;
      }
    }
    return nums;
  }
}
