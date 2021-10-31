public class E02_estructuras_if extends Bloque {

  public void main() {
    System.out.println("bloque 1 de ejercicios");

    // Declaración de variables para escojer ejercicio
    int n_ejercicio;
    final int N_EJERCICIOS = 16;
    boolean exitApp = false;

    Ejercicio[] ejercicios = new Ejercicio[N_EJERCICIOS];
    ejercicios[0] = new B02_E01("\t Ejercicio 01: comprobar si dos nº son iguales.");
    ejercicios[1] = new B02_E02("\t Ejercicio 02: comprobar si un nº es positivo.");
    ejercicios[2] = new B02_E03("\t Ejercicio 03: comprobar si un nº par o impar.");
    ejercicios[3] = new B02_E04("\t Ejercicio 04: comprobar si dos nº múltiplos o no.");
    ejercicios[4] = new B02_E05("\t Ejercicio 05: devolver el más grande de dos nº.");
    ejercicios[5] = new B02_E06("\t Ejercicio 06: ordenar nº del mayor a menor.");
    ejercicios[6] = new B02_E07("\t Ejercicio 07: devuelve el nº de cifras de un short.");
    ejercicios[7] = new B02_E08("\t Ejercicio 08: devuelve el nº con las cifras en orden ivnerso.");
    ejercicios[8] = new B02_E09("\t Ejercicio 09: dice si un nº es capicúa o no.");
    ejercicios[9] = new B02_E10("\t Ejercicio 10: ");
    ejercicios[10] = new B02_E11("\t Ejercicio 11: validar si una fecha es plausible o no.");
    ejercicios[11] = new B02_E12("\t Ejercicio 12: igual que el 11.");
    ejercicios[12] = new B02_E13("\t Ejercicio 13: devuelve el día siguiente al introducido.");
    ejercicios[13] = new B02_E14("\t Ejercicio 14: igual que el 13.");
    ejercicios[14] = new B02_E15("\t Ejercicio 15: comprobar si alguien es mayor de edad.");
    ejercicios[15] = new B02_E16("\t Ejercicio 16: ");

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

  /**
   * Crear una función llamada sonIguales que reciba dos números por parámetro y
   * devuelva true si son iguales o false en caso contrario.
   * 
   * @param info pequeña descripción del ejercicio
   */
  public B02_E01(String info) {
    setSelfInfo(info);
  }

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

  public B02_E02(String info) {
    setSelfInfo(info);
  }

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

  public B02_E03(String info) {
    setSelfInfo(info);
  }

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

  public B02_E04(String info) {
    setSelfInfo(info);
  }

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

  public B02_E05(String info) {
    setSelfInfo(info);
  }

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

  public B02_E06(String info) {
    setSelfInfo(info);
  }

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

  public B02_E07(String info) {
    setSelfInfo(info);
  }

  public void main() {
    short num, nCifras;

    System.out.println("Introduce un número:");
    num = validate.inputType((short) 1);
    nCifras = (short) funtion.nDigits(num);

    System.out.println(
        (nCifras > 4 | num < 0) ? "El número tiene " + nCifras + " cifras." : "El número introducido no era válido.");

  }
}

/**
 * Crear una función llamada invertirCifras que reciba un número short entre 0 y
 * 9999 y devuelva el número al revés, en caso de recibir un número menor a 0 o
 * mayor a 9999 devolverá -1.
 */
class B02_E08 extends Ejercicio {

  public B02_E08(String info) {
    setSelfInfo(info);
  }

  public void main() {
    short num, reversed, nCifras;

    System.out.println("Introduce un número:");
    num = validate.inputType((short) 1);
    reversed = (short) funtion.reverseDigits(num);
    nCifras = (short) funtion.nDigits(num);

    System.out.println((nCifras > 4 | num < 0) ? "El número invertido es " + reversed + " cifras."
        : "El número introducido no era válido.");
  }
}

/**
 * Crear una función llamada esCapicua que reciba un número short entre 0 y 9999
 * y devuelva true si es capicua y false en caso contrario, en caso de recibir
 * un número menor a 0 o mayor a 9999 devolverá también false.
 */
class B02_E09 extends Ejercicio {

  public B02_E09(String info) {
    setSelfInfo(info);
  }

  public void main() {
    short num;

    System.out.println("Introduce un número:");
    num = validate.inputType((short) 1);

    System.out.println("El número " + (funtion.isPalindromic(num) ? "" : "no ") + "es capicúa.");

  }
}

/**
 * Crear una función llamada obtenerNota que reciba nota del 0 al 10 y devuelva
 * un enum Notas con los valores Insuficiente, Suficiente, Bien, Notable
 * Sobresaliente. En caso de que la nota sea menor que 0 o mayor que 10
 * devolverá error.
 */
class B02_E10 extends Ejercicio {

  public B02_E10(String info) {
    setSelfInfo(info);
  }

  public void main() {
    // TODO:
  }
}

/**
 * Bloque 02 - Ejercicio 11
 */
class B02_E11 extends Ejercicio {

  /**
   * Crear una función llamada esFechaCorrecta que reciba por parámetro el día, el
   * mes y el año de una fecha y devuelva true si es correcto o false en caso
   * contrario. Suponer que todos los meses son de 30 días.
   * <p>
   * Refactorizar la función anterior, pero teniendo en cuenta meses de 28, 30 y
   * 31 días y años bisiestos.
   * 
   * @param info pequeña descripción del ejercicio
   */
  public B02_E11(String info) {
    setSelfInfo(info);
  }

  public void main() {
    int day, month, year;

    System.out.println("Introduce D/M/Y:");
    day = validate.inputType(1);
    month = validate.inputType(1);
    year = validate.inputType(1);

    System.out.println("La fecha introducida " + (funtion.validateDate(day, month, year) ? "" : "no ") + "es válida.");
  }
}

/**
 * Refactorizar la función anterior, pero teniendo en cuenta meses de 28, 30 y
 * 31 días y años bisiestos.
 */
class B02_E12 extends Ejercicio {

  public B02_E12(String info) {
    setSelfInfo(info);
  }

  public void main() {
    int day, month, year;

    System.out.println("Introduce D/M/Y:");
    day = validate.inputType(1);
    month = validate.inputType(1);
    year = validate.inputType(1);

    System.out.println("La fecha introducida " + (funtion.validateDate(day, month, year) ? "" : "no ") + "es válida.");
  }
}

/**
 * Bloque 02 - Ejercicio 13
 */
class B02_E13 extends Ejercicio {

  /**
   * Crear una función llamada obtenerSiguienteDía que reciba por parámetro el
   * día, el mes y el año de una fecha y si es la fecha correcta, devuelva el
   * siguiente String con el formato dd-mm-yyyy. Suponer que todos los meses son
   * de 30 días.
   * 
   * @param info pequeña descripción del ejercicio
   */
  public B02_E13(String info) {
    setSelfInfo(info);
  }

  public void main() {
    int day, month, year;

    System.out.println("Introduce D/M/Y:");
    day = validate.inputType(1);
    month = validate.inputType(1);
    year = validate.inputType(1);

    System.out.println(funtion.nextDay(day, month, year));
  }
}

/**
 * Bloque 02 - Ejercicio 14
 */
class B02_E14 extends Ejercicio {

  /**
   * Mismo programa que el anterior.
   * 
   * @param info pequeña descripción del ejercicio
   */
  public B02_E14(String info) {
    setSelfInfo(info);
  }

  public void main() {
    int day, month, year;

    System.out.println("Introduce D/M/Y:");
    day = validate.inputType(1);
    month = validate.inputType(1);
    year = validate.inputType(1);

    System.out.println(funtion.nextDay(day, month, year));
  }
}

/**
 * Bloque 02 - Ejercicio 15
 */
class B02_E15 extends Ejercicio {

  /**
   * Crear una función llamada esMayorEdad que reciba por parámetro el día, el mes
   * y el año de nacimiento e indicar si es mayor de edad en la fecha de hoy.
   * 
   * @param info
   */
  public B02_E15(String info) {
    setSelfInfo(info);
  }

  public void main() {
    // TODO:
  }
}

/**
 */
class B02_E16 extends Ejercicio {

  /**
   * Escriba una función llamada cambioEnMonedas, que reciba por parámetro un
   * valor real que indica la cantidad de dinero en euros. El método imprime por
   * pantalla la cantidad de monedas de cada tipo, en que se debe devolver la
   * cantidad de dinero indicada.
   * 
   * @param info
   */
  public B02_E16(String info) {
    setSelfInfo(info);
  }

  public void main() {
    // TODO:
  }
}