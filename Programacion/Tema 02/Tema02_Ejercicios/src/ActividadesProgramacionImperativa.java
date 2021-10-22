import java.text.DecimalFormat;
import static java.lang.Math.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ActividadesProgramacionImperativa {

  // Clase propia para validar las entradas por teclado
  static ValidateInput validate = new ValidateInput(3);
  /*
   * Usamos df para darle un formato más amable a los resultados que le mostramos
   * al ususario
   */
  static DecimalFormat df = new DecimalFormat();
  static SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");

  public static void main(String[] args) {
    // Declaración de variables para escojer ejercicio
    int ejercicio;
    final int N_EJERCICIOS = 6;

    // Set del formato decimal
    df.setMaximumFractionDigits(2);
    df.setMinimumFractionDigits(2);

    // Le pide al usuario que ejercicio quiere ejecutar
    System.out.println("Hay " + N_EJERCICIOS + " ejercicios, escoje uno:");
    System.out.println(" Ejercicio 01: calcular la diferencia en días entre dos fechas.");
    System.out.println(" Ejercicio 02: calcular la edad de una persona en años a partir de su fecha de nacimiento.");
    System.out.println(" Ejercicio 03: calcular los coeficientes de una ecuación de segundo grado.");
    System.out.println(" Ejercicio 04: calcular el área de un círculo a partir de su radio");
    System.out.println(" Ejercicio 05: calcular el perímetro de un círculo a partir de su radio.");
    System.out.println(
        " Ejercicio 06: calcular el perímetro y el área de un triángulo equilátero en base a uno de sus lados.");
    System.out.println("");
    ejercicio = validate.inputRange(1, 1, N_EJERCICIOS);

    // Escoger el ejercicio
    switch (ejercicio) {
    case 1:
      try {
        ejercicio01();
      } catch (Exception e) {
        // TODO: handle exception
        // ...yeah sure
      }
      break;
    case 2:
      try {
        ejercicio02();
      } catch (Exception e) {
        // TODO: handle exception
        // didn't do it above, won't do it below
      }
      break;
    case 3:
      ejercicio03();
      break;
    case 4:
      ejercicio04();
      break;
    case 5:
      ejercicio05();
      break;
    case 6:
      ejercicio06();
      break;
    default:
      break;
    }

    // Cerrar el validar
    validate.close();
  }

  /*
   * Pedir dos fechas e indicar la diferencia de días entre ellas *
   */
  private static void ejercicio01() throws ParseException {
    // Intro
    System.out.println("\n EJERCICIO 01:");
    System.out.println(" Calcular la diferencia en días entre dos fechas. \n ");

    // Variables
    long millisecondDifference;
    int daysDifference;
    String fechaInicioTexto = "23/01/1997";
    String fechaFinTexto = "27/04/1998";

    // Transformar la string en fecha
    Date fechaInicio = myFormat.parse(fechaInicioTexto);
    Date fechaFin = myFormat.parse(fechaFinTexto);

    // Calcular la diferencia en milisegundos entre las dos fechas
    millisecondDifference = fechaFin.getTime() - fechaInicio.getTime();
    // Convertir de milisegundos a días
    // milisegundo / 1000 -> segundo
    // segundo / 60 -> minuto
    // minuto / 60 -> hora
    // hora / 24 -> día
    daysDifference = (int) (millisecondDifference / 1000 / 60 / 60 / 24);
    daysDifference = (int) validate.alwaysPositive((float) daysDifference);

    // Salida:
    System.out.println("La diferencia en dias es de : " + daysDifference);
  }

  /*
   * Programa para calcula la edad de una persona, en años, a partir de su fecha
   * de nacimiento y la fecha de hoy.
   */
  private static void ejercicio02() throws ParseException {
    // Intro
    System.out.println("\n EJERCICIO 02:");
    System.out.println(
        " Calcular la edad de una persona, en años, a partir de su fecha de nacimiento y la fecha de hoy. \n ");

    // Entrada de datos
    String birthdayText = "09/06/1996";
    Date birthday = myFormat.parse(birthdayText);
    Date now = new Date();

    int age;
    double millisecondDifference;

    millisecondDifference = now.getTime() - birthday.getTime();
    age = (int) (millisecondDifference / 1000 / 60 / 60 / 24 / 365);
    System.out.println("Tiene " + age + " años.");

    // Salida:
  }

  /*
   * Pedir los coeficientes de una ecuación de segundo grado (a, b y c) y mostrar
   * sus soluciones reales. Si no existen debe indicarlo.
   */
  private static void ejercicio03() {
    // Intro
    System.out.println("\n EJERCICIO 03:");
    System.out.println(" Programa para coeficientes de una ecuación de segundo grado. \n ");

    // Variables
    double a, b, c;
    double discriminante, raiz1, raiz2;

    // Entrada de datos
    System.out.println("Introduce los coeficientes A, B y C de la ecuación Ax^2 + Bx + C = 0: ");
    a = validate.inputType(1f);
    b = validate.inputType(1f);
    c = validate.inputType(1f);

    // Calcular y salidas
    discriminante = pow(b, 2) - 4 * a * c;

    if (discriminante == 0) {
      raiz1 = -b + sqrt(discriminante) / 2 * a;
      System.out.println("La ecuación tiene como solución: " + raiz1);
    } else if (discriminante > 0) {
      raiz1 = -b + sqrt(discriminante) / 2 * a;
      raiz2 = -b - sqrt(discriminante) / 2 * a;
      System.out.println("La ecuación tiene como solución: " + raiz1 + " y " + raiz2);
    } else {
      System.out.println("La ecuación no tiene solución.");
    }
  }

  /*
   * Programa para calcular el área de un círculo a partir de su radio.
   */
  private static void ejercicio04() {
    // Intro
    System.out.println("\n EJERCICIO 04:");
    System.out.println(" Programa para calcular el área de un círculo a partir de su radio. \n ");

    // Variables
    float radius, area;

    // Entrada de datos
    System.out.println("Introduce el radio del círculo");
    radius = validate.inputType(1f);

    // Cálculos
    area = (int) (2 * PI * pow(radius, 2));

    // Salida:
    System.out.println("El área del círculo es igual a: " + area + "  unidades.");
  }

  /*
   * Programa para calcular el perímetro de un círculo a partir de su radio.
   */
  private static void ejercicio05() {
    // Intro
    System.out.println("\n EJERCICIO 05:");
    System.out.println(" Calcular el perímetro de un círculo a partir de su radio. \n ");

    // Variables
    float radius, perimeter;

    // Entrada de datos
    System.out.println("Introduce el radio del círculo");
    radius = validate.inputType(1f);

    // Cálculos
    perimeter = (int) (2 * PI * radius);

    // Salida:
    System.out.println("El perímetro del círculo es igual a: " + perimeter + "  unidades.");
  }

  /*
   * Programa que solicita al usuario el lado de un triángulo equilátero y calcula
   * su perímetro y su área.
   */
  private static void ejercicio06() {
    // Intro
    System.out.println("\n EJERCICIO 06:");
    System.out.println(" Calcular el perímetro y el área de un triángulo equilátero en base a uno de sus lados. \n ");

    // Variables
    float side, area, perimeter;

    // Entrada de datos
    System.out.println("Introduce el lado del triángulo");
    side = validate.inputType(1f);

    // Cálculos
    perimeter = side * 3;
    area = (float) (pow(side, 2) * sqrt(3) / 4);

    // Salida:
    System.out.println("El perímetro del triángulo es de: " + perimeter + "  unidades.");
    System.out.println("El área del triángulo es de: " + df.format(area) + "  unidades.");
  }
}
