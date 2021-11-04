
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class B03_switchs extends Bloque {
  public void main() {
    System.out.println("Bloque 03 de ejercicios.\n");

    final int N_EJERCICIOS = 7;

    // Inicialización de ejercicios
    Ejercicio[] ejercicios = new Ejercicio[N_EJERCICIOS];
    ejercicios[0] = new B03_E01("\t Ejercicio 01: .");
    ejercicios[1] = new B03_E02("\t Ejercicio 02: .");
    ejercicios[2] = new B03_E03("\t Ejercicio 03: .");
    ejercicios[3] = new B03_E04("\t Ejercicio 04: .");
    ejercicios[4] = new B03_E05("\t Ejercicio 05: .");
    ejercicios[5] = new B03_E06("\t Ejercicio 06: .");
    ejercicios[6] = new B03_E07("\t Ejercicio 07: .");

    // ESCOGER EJERCICIO
    chooseExercise(ejercicios);

  }// Fin main.

}// Fin Clase

/**
 * Bloque 03 - Ejercicio 01
 */
class B03_E01 extends Ejercicio {

  /**
   * Sobreescribir la función enum Notas obtenerNota (float nota) que recibe una
   * por parámetro del 0.0f al 10.0f para que devuelva un enum Notas con los
   * valores INSUFICIENTE, SUFICIENTE, BIEN, NOTABLE, SOBRESALIENTE y ERROR
   * utilizando un switch. En caso de que la nota sea menor que 0f. o mayor que
   * 10f devolverá el valor ERROR de la enumeración.
   * 
   * @param info pequeña descripción del ejercicio
   */
  public B03_E01(String info) {
    setSelfInfo(info);
  }

  public void main() {
    float score;

    System.out.println("Introduce la nota recibida:");
    score = validate.inputType(1f);

    System.out.println("La nota es " + functionsB02.getScore((int) score) + ".");
  }

}

/**
 * Bloque 03 - Ejercicio 02
 */
class B03_E02 extends Ejercicio {

  /**
   * Escribir una función llamada int diasDelMes (int mes) que reciba por
   * parámetro el número del mes, compruebe que está entre 1 y 12 y devuelva el
   * número de días que tiene (no se tienen en cuenta años bisiestos).
   * 
   * @param info pequeña descripción del ejercicio
   */
  public B03_E02(String info) {
    setSelfInfo(info);
  }

  public void main() {
    int month;

    System.out.println("Introduce el día del mes:");
    month = validate.inputType(1);

    System.out.println("El mes tiene " + diasDelMes(month) + " días.");
  }

  private int diasDelMes(int n) {
    int days;
    switch (n) {
    case 1, 3, 5, 7, 8, 10, 12:
      days = 31;
      break;
    case 4, 6, 9, 11:
      days = 30;
    case 2:
      days = 28;
    default:
      days = -1;
    }
    return days;
  }

  @Test
  public void test_diasDelMes() {
    assertEquals(31, 1);
    assertEquals(31, 3);
    assertEquals(31, 5);
    assertEquals(31, 7);
    assertEquals(31, 8);
    assertEquals(31, 10);
    assertEquals(31, 12);
    assertEquals(30, 4);
    assertEquals(30, 6);
    assertEquals(30, 9);
    assertEquals(30, 11);
    assertEquals(28, 2);
    assertEquals(-1, 0);
    assertEquals(-1, 13);
    assertEquals(-1, Integer.MAX_VALUE);
    assertEquals(-1, Integer.MIN_VALUE);
  }
}

/**
 * Bloque 03 - Ejercicio 03
 */
class B03_E03 extends Ejercicio {

  /**
   * Escribir una función llamada enum Dias diaSemana (int dia) que reciba por
   * parámetro un día, compruebe que el día está entre el 1 y el 7 y devuelva a
   * que día corresponde en una enumeración llamada Dias que contendrá los valores
   * LUNES, MARTES…. En caso de recibir un número menor de uno o mayor que siete
   * devolverá el valor ERROR de la numeración.
   * 
   * @param info pequeña descripción del ejercicio
   */
  public B03_E03(String info) {
    setSelfInfo(info);
  }

  public void main() {
    // TODO: ejercicio
  }
}

/**
 * Bloque 03 - Ejercicio 04
 */
class B03_E04 extends Ejercicio {

  /**
   * Escribir una función llamada boolean esLaborable (int dia) que reciba por
   * parámetro un día compruebe que está entre el 1 al 7 y devuelva true si es de
   * lunes a viernes y false si es sábado o domingo. En caso de recibir un número
   * menor de uno o mayor que siete devolverá false.
   * 
   * @param info pequeña descripción del ejercicio
   */
  public B03_E04(String info) {
    setSelfInfo(info);
  }

  public void main() {
    // TODO: ejercicio
  }
}

/**
 * Bloque 03 - Ejercicio 05
 */
class B03_E05 extends Ejercicio {

  /**
   * Escribir un procedimiento llamado String mesDelaño (int mes) que reciba por
   * parámetro un mes del 1 al 12 e devuelva el mes al que corresponde y a que
   * estación pertenece. mesDelaño (1) Devolverá Enero: Invierno.
   * 
   * @param info pequeña descripción del ejercicio
   */
  public B03_E05(String info) {
    setSelfInfo(info);
  }

  public void main() {
    // TODO: ejercicio
  }
}

/**
 * Bloque 03 - Ejercicio 06
 */
class B03_E06 extends Ejercicio {

  /**
   * Escribe una función llamada float calcularIMC (float peso, float altura) que
   * reciba el peso y la altura, compruebe que son mayores que cero y devuelva el
   * índice de masa corporal que le corresponde imc= peso / altura2) utilizando
   * una enumeración.
   * 
   * si imc <= 18.5 devuelve "Bajo peso" si imc <= 25.0 devuelve "Normal" si imc
   * <= 30.0 devuelve "Sobrepeso" si imc > 30 retudevuelvern "Obeso"
   * 
   * En caso de que el peso y/o la altura sean igual o menor que cero, devolverá
   * ERROR.
   * 
   * @param info pequeña descripción del ejercicio
   */
  public B03_E06(String info) {
    setSelfInfo(info);
  }

  public void main() {
    // TODO: ejercicio
  }
}

/**
 * Bloque 03 - Ejercicio 07
 */
class B03_E07 extends Ejercicio {

  /**
   * Implemente una función llamada double calculadora(double primerOperador, char
   * operacion, double segundoOperador), en la que recibe el primer operando de
   * tipo double, un operador aritmético en un char (+, -, *, / o % )y el segundo
   * operando también de tipo double para devolver a continuación el resultado.
   * 
   * @param info pequeña descripción del ejercicio
   */
  public B03_E07(String info) {
    setSelfInfo(info);
  }

  public void main() {
    // TODO: ejercicio
  }
}
