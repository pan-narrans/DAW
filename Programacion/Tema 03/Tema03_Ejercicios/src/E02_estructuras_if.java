public class E02_estructuras_if extends Bloque {

  public void main() {
    System.out.println("bloque 1 de ejercicios");

    // Declaración de variables para escojer ejercicio
    int n_ejercicio;
    final int N_EJERCICIOS = 9;
    boolean exitApp = false;

    Ejercicio[] ejercicios = new Ejercicio[N_EJERCICIOS];
    ejercicios[0] = new B02_E01();
    ejercicios[0].setSelfInfo("\t Ejercicio 01: comprobar si dos nº son iguales.");
    ejercicios[1] = new B02_E02();
    ejercicios[1].setSelfInfo("\t Ejercicio 02: comprobar si un nº es positivo.");
    ejercicios[2] = new B02_E03();
    ejercicios[2].setSelfInfo("\t Ejercicio 03: comprobar si un nº par o impar.");
    ejercicios[3] = new B02_E04();
    ejercicios[3].setSelfInfo("\t Ejercicio 04: comprobar si dos nº múltiplos o no.");
    ejercicios[4] = new B02_E05();
    ejercicios[4].setSelfInfo("\t Ejercicio 05: devolver el más grande de dos nº.");
    ejercicios[5] = new B02_E06();
    ejercicios[5].setSelfInfo("\t Ejercicio 06: ordenar nº del mayor a menor.");
    ejercicios[6] = new B02_E07();
    ejercicios[6].setSelfInfo("\t Ejercicio 07: devuelve el nº de cifras de un short.");
    ejercicios[7] = new B02_E08();
    ejercicios[7].setSelfInfo("\t Ejercicio 08: devuelve el nº con las cifras en orden ivnerso.");
    ejercicios[8] = new B02_E09();
    ejercicios[8].setSelfInfo("\t Ejercicio 09: ");

    // ESCOGER EJERCICIO
    while (!exitApp) {
      // Le pide al usuario que ejercicio quiere ejecutar
      System.out.println("Hay " + N_EJERCICIOS + " ejercicios, escoje uno:");
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

/**
 * Crear una función llamada sonMultiplos que reciba dos números por parámetro y
 * devuelva true si uno es multiplo del otro o false en caso contrario.
 */
class B02_E04 extends Ejercicio {
  public void main() {
    float num1, num2;

    System.out.println("Introduce dos números:");
    num1 = validate.inputType(1f);
    num2 = validate.inputType(1f);

    System.out.println(
        "Los dos números " + (funtion.areMultiple(num1, num2) ? "SI " : "NO ") + "son múltiplos el uno del otro.");
  }
}

/**
 * Crear una función llamada mayorNumero que reciba dos números reales por
 * parámetro y devuelva el número mayor.
 */
class B02_E05 extends Ejercicio {
  public void main() {
    float num1, num2;

    System.out.println("Introduce dos números:");
    num1 = validate.inputType(1f);
    num2 = validate.inputType(1f);

    System.out.println("El número más grande es: " + funtion.biggerOfTwo(num1, num2) + ".");
  }
}

/**
 * Crear un procedimiento llamado ordenarNumeros que reciba tres números por
 * parámetro ydevuelva un String con los números ordenados de mayor a menor Ej
 * ordenarNumeros(5,23,7) devolvería “23 7 5”.
 */
class B02_E06 extends Ejercicio {
  public void main() {
    int n_numbers = 3;
    float[] nums = new float[n_numbers];

    System.out.println("Introduce los " + n_numbers + " números.");
    for (int i = 0; i < n_numbers; i++) {
      nums[i] = validate.inputType(1f);
    }

    System.out.println("La lista ordenada de nº es: " + funtion.orderNumbersBigToSmall(nums));
  }
}

/**
 * Crear una función llamada contarCifras que reciba un número short y devuelva
 * el número de cifras tiene, en caso de recibir un número menor a 0 o mayor a
 * 9999 devolverá -1.
 */
class B02_E07 extends Ejercicio {
  public void main() {
    short num, nCifras;

    System.out.println("Introduce un número:");
    num = validate.inputType((short) 1);
    nCifras = (short) funtion.nDigits(num);

    System.out
        .println((nCifras != -1) ? "El número tiene " + nCifras + " cifras." : "El número introducido no era válido.");

  }
}

/**
 * Crear una función llamada invertirCifras que reciba un número short entre 0 y
 * 9999 y devuelva el número al revés, en caso de recibir un número menor a 0 o
 * mayor a 9999 devolverá -1.
 */
class B02_E08 extends Ejercicio {
  public void main() {
    short num, reversed;

    System.out.println("Introduce un número:");
    num = validate.inputType((short) 1);
    reversed = (short) funtion.reverseDigits(num);

    System.out.println(
        (reversed != -1) ? "El número invertido es " + reversed + " cifras." : "El número introducido no era válido.");
  }
}

/**
 * Crear una función llamada esCapicua que reciba un número short entre 0 y 9999
 * y devuelva true si es capicua y false en caso contrario, en caso de recibir
 * un número menor a 0 o mayor a 9999 devolverá también false.
 */
class B02_E09 extends Ejercicio {
  public void main() {
    short num;

    System.out.println("Introduce un número:");
    num = validate.inputType((short) 1);

    System.out.println("El número " + (funtion.isPalindromic(num) ? "" : "no ") + "es capicúa.");

  }
}