
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class B03_switchs extends Bloque {
  public void main() {
    System.out.println("Bloque 03 de ejercicios.\n");

    final int N_EJERCICIOS = 7;

    // Inicialización de ejercicios
    Ejercicio[] ejercicios = new Ejercicio[N_EJERCICIOS];
    ejercicios[0] = new B03_E01("\t Ejercicio 01: califica la nota introducida.");
    ejercicios[1] = new B03_E02("\t Ejercicio 02: devuelve el nº de días de un mes.");
    ejercicios[2] = new B03_E03("\t Ejercicio 03: devuelve el día de la semana.");
    ejercicios[3] = new B03_E04("\t Ejercicio 04: dice si un día es laborable o no.");
    ejercicios[4] = new B03_E05("\t Ejercicio 05: devuelve el mes y la estación.");
    ejercicios[5] = new B03_E06("\t Ejercicio 06: califica tu IMC.");
    ejercicios[6] = new B03_E07("\t Ejercicio 07: calculadora.");

    // ESCOGER EJERCICIO
    chooseExercise(ejercicios);

  }// Fin main.

  /*
   * TESTING
   */
  @Test
  public void test_diasDelMes() {
    assertEquals(31, B03_E02.diasDelMes(1));
    assertEquals(31, B03_E02.diasDelMes(3));
    assertEquals(31, B03_E02.diasDelMes(5));
    assertEquals(31, B03_E02.diasDelMes(7));
    assertEquals(31, B03_E02.diasDelMes(8));
    assertEquals(31, B03_E02.diasDelMes(10));
    assertEquals(31, B03_E02.diasDelMes(12));
    assertEquals(30, B03_E02.diasDelMes(4));
    assertEquals(30, B03_E02.diasDelMes(6));
    assertEquals(30, B03_E02.diasDelMes(9));
    assertEquals(30, B03_E02.diasDelMes(11));
    assertEquals(28, B03_E02.diasDelMes(2));
    assertEquals(-1, B03_E02.diasDelMes(0));
    assertEquals(-1, B03_E02.diasDelMes(13));
    assertEquals(-1, B03_E02.diasDelMes(Integer.MAX_VALUE));
    assertEquals(-1, B03_E02.diasDelMes(Integer.MIN_VALUE));
  }

  @Test
  public void test_calculadora() {
    assertEquals(0, B03_E07.calculadora(Double.MAX_VALUE, '*', 0), 0);
    assertEquals(0, B03_E07.calculadora(Double.MIN_VALUE, '*', 0), 0);
    assertEquals(Double.MAX_VALUE, B03_E07.calculadora(Double.MAX_VALUE / 2, '+', Double.MAX_VALUE / 2), 0);
    assertEquals(25, B03_E07.calculadora(100, '/', 4), 0);
    assertEquals(0, B03_E07.calculadora(450, '%', 2), 0);
    assertEquals(47, B03_E07.calculadora(40, '+', 7), 0);
  }

  /**
   * Bloque 03 - Ejercicio 01
   */
  private class B03_E01 extends Ejercicio {

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

  } // Fin Ejercicio 01

  /**
   * Bloque 03 - Ejercicio 02
   */
  private class B03_E02 extends Ejercicio {

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

    static public int diasDelMes(int n) {
      int days;
      switch (n) {
      case 1, 3, 5, 7, 8, 10, 12:
        days = 31;
        break;
      case 4, 6, 9, 11:
        days = 30;
        break;
      case 2:
        days = 28;
        break;
      default:
        days = -1;
      }
      return days;
    }

  } // Fin Ejercicio 02

  /**
   * Bloque 03 - Ejercicio 03
   */
  private class B03_E03 extends Ejercicio {

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
      int day;

      System.out.println("Introduce nº del día de la semana:");
      day = validate.inputRange(1, 1, 7);

      System.out.println("El día introducido es el " + diaSemana(day));
    }

    enum DIAS {
      LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SÁBADO, DOMINGO, ERROR
    }

    public static DIAS diaSemana(int day) {
      switch (day) {
      case 1:
        return DIAS.LUNES;
      case 2:
        return DIAS.MARTES;
      case 3:
        return DIAS.MIERCOLES;
      case 4:
        return DIAS.JUEVES;
      case 5:
        return DIAS.VIERNES;
      case 6:
        return DIAS.SÁBADO;
      case 7:
        return DIAS.DOMINGO;
      default:
        return DIAS.ERROR;
      }
    }
  }

  /**
   * Bloque 03 - Ejercicio 04
   */
  private class B03_E04 extends Ejercicio {

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
      int day;

      System.out.println("Introduce nº del día de la semana:");
      day = validate.inputRange(1, 1, 7);

      System.out.println("El día introducido " + (esLaborable(day) ? "" : "no ") + "es laborable.");
    }

    boolean esLaborable(int day) {
      switch (day) {
      case 1, 2, 3, 4, 5:
        return true;
      case 6, 7:
      default:
        return false;
      }
    }
  }

  /**
   * Bloque 03 - Ejercicio 05
   */
  private class B03_E05 extends Ejercicio {

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
      int month;
      String textMonth;

      System.out.println("Introduce nº del mes:");
      month = validate.inputType(1);
      textMonth = mesDelAño(month);

      System.out.println((textMonth != "Inconcievable!") ? textMonth : "Mes no válido.");
    }

    public String mesDelAño(int month) {
      String value;
      switch (month) {
      case 1:
        value = "Enero: Invierno";
        break;
      case 2:
        value = "Febrero: Invierno";
        break;
      case 3:
        value = "Marzo: Primavera";
        break;
      case 4:
        value = "Abril: Primavera";
        break;
      case 5:
        value = "Mayo: Primavera";
        break;
      case 6:
        value = "Junio: Verano";
        break;
      case 7:
        value = "Julio: Verano";
        break;
      case 8:
        value = "Agosto: Verano";
        break;
      case 9:
        value = "Septiembre: Otoño";
        break;
      case 10:
        value = "Octubre: Otoño";
        break;
      case 11:
        value = "Noviembre: Otoño";
        break;
      case 12:
        value = "Diciembre: Invierno";
        break;
      default:
        value = "Inconcievable!";
        break;
      }
      return value;
    }
  }

  /**
   * Bloque 03 - Ejercicio 06
   */
  private class B03_E06 extends Ejercicio {

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
      float weight, height;

      System.out.println("Introduce peso (kg) y luego altura (m):");
      weight = validate.inputType(1f);
      height = validate.inputType(1f);

      System.out.println("Tu calificación es: " + showPeso(calcularIMC(weight, height)));
    }

    enum PESOS {
      BajoPeso, Normal, Sobrepeso, Obeso, ERROR
    }

    public PESOS showPeso(float IMC) {
      PESOS peso = PESOS.ERROR;
      if (IMC <= 0) {
        ;
      } else if (IMC <= 18.5) {
        peso = PESOS.BajoPeso;
      } else if (IMC <= 25) {
        peso = PESOS.Normal;
      } else if (IMC <= 30) {
        peso = PESOS.Sobrepeso;
      } else {
        peso = PESOS.Obeso;
      }
      return peso;
    }

    private float calcularIMC(float weight, float height) {
      float IMC;

      IMC = (height > 0 && weight > 0) ? weight / (float) Math.pow(height, 2) : 0;

      return IMC;
    }
  }

  /**
   * Bloque 03 - Ejercicio 07
   */
  private class B03_E07 extends Ejercicio {

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
      double num1, num2;
      char operation;

      System.out.println("Introduce la operación que quieres realizar:");
      System.out.println("ej: 4 * 2,5");

      System.out.println("Número 1:");
      num1 = validate.inputType(1f);

      System.out.println("Operación:");
      operation = validate.inputType('c');

      System.out.println("Número 2:");
      num2 = validate.inputType(1f);

      System.out.println("El resultado es:");
      System.out.println(calculadora(num1, operation, num2));
    }

    public static double calculadora(double num1, char operation, double num2) {

      switch (operation) {
      case '+':
        return num1 + num2;
      case '-':
        return num1 - num2;
      case '*':
        return num1 * num2;
      case '/':
        return num1 / num2;
      case '%':
        return num1 % num2;
      default:
        return 8008.7172;
      }
    }
  }

}// Fin Clase
