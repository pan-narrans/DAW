import java.text.DecimalFormat;

public class ActividadesEntradaUsuario {

  // Clase propia para validar las entradas por teclado
  static ValidateInput validate = new ValidateInput(3);
  // Usamos df para darle un formato más amable a los resultados que le mostramos
  // al ususario
  static DecimalFormat df = new DecimalFormat();

  public static void main(String[] args) {
    // Declaración de variables para escojer ejercicio
    int ejercicio;
    final int N_EJERCICIOS = 7;

    // Set del formato decimal
    df.setMaximumFractionDigits(2);
    df.setMinimumFractionDigits(2);

    // Le pide al usuario que ejercicio quiere ejecutar
    System.out.println("Hay " + N_EJERCICIOS + " ejercicios, escoje uno:");
    ejercicio = validate.inputRange(1, 1, N_EJERCICIOS);

    // Escoger el ejercicio
    switch (ejercicio) {
      case 1:
        ejercicio01();
        break;
      case 2:
        ejercicio02();
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
      case 7:
        ejercicio07();
        break;
      default:
        break;
    }

    // Cerrar el validar
    validate.close();
  }

  // Te pide tu nombre
  private static void ejercicio01() {
    String name;

    System.out.println("¡Buenos días!");
    System.out.println("¿Cómo te llamas?");
    name = validate.inputType("");
    System.out.println("¡Hola " + name + "!");
  }

  // Te pide un cacrácter
  private static void ejercicio02() {
    char character;

    System.out.println("Introduce un carácter:");
    character = validate.inputType('a');
    System.out.println("El carácter introducido es \"" + character + "\".");
  }

  // Suma dos nº
  private static void ejercicio03() {
    float num1, num2, suma;

    System.out.println("Introduce un número:");
    num1 = validate.inputType(1f);
    System.out.println("Introduce un segundo número:");
    num2 = validate.inputType(1f);

    suma = num1 + num2;

    System.out.println("El resultado de la suma de los dos números es: " + suma);
  }

  // Cálcula la media de tres nº
  private static void ejercicio04() {
    float num1, num2, num3, media;

    System.out.println("Introduce un número:");
    num1 = validate.inputType(1f);
    System.out.println("Introduce un segundo número:");
    num2 = validate.inputType(1f);
    System.out.println("Introduce un tercer número:");
    num3 = validate.inputType(1f);

    media = (num1 + num2 + num3) / 3;

    System.out.println("La media de los tres números es: " + media);
  }

  // Pasa de grados Cº a : Fº, Kº y Rº
  private static void ejercicio05() {
    // Declaración de variables
    float celcius, fahrenheit, kelvin, reamur;

    // Pedir imput
    System.out.println("Introduce unos grados en celsius:");
    celcius = validate.inputType(1f);

    // Conversiones de celsius a cada una de las otras unidades de medida
    fahrenheit = celcius * 1.8f + 32f;
    kelvin = celcius - 273f;
    reamur = celcius * 0.8f;

    // Salidas
    System.out.println(df.format(celcius) + " ºC equivalen a:");
    System.out.println("  = " + df.format(fahrenheit) + " ºF");
    System.out.println("  = " + df.format(kelvin) + " ºK");
    System.out.println("  = " + df.format(reamur) + " ºR");
  }

  // Calcula la distancia entre dos puntos
  private static void ejercicio06() {
    // Declaración de variables
    float[][] points = new float[2][2];
    float distance;

    // Introducción de los datos
    for (int m = 1; m < 3; m++) {
      for (int n = 1; n < 3; n++) {
        System.out.println("Introduce la coordenada " + n + " del punto " + m + ":");
        points[m - 1][n - 1] = validate.inputType(1f);
      }
    }

    // Aplicación del teorema de Pitágoras y conversión a float
    distance = (float) Math
        .sqrt(Math.pow((points[0][0] - points[1][0]), 2) + Math.pow((points[0][1] - points[1][1]), 2));

    // Salida
    System.out.println("La distancia entre los dos puntos es de: " + df.format(distance) + " unidades.");
  }

  // Programa para calcular el consumo cada 100km de un coche y su coste por km
  // en base a la distancia recorrida entre dos repostajes, el precio del litro y
  // la cantidad total repostada
  private static void ejercicio07() {
    // Declaración de variables
    int kilometers = 0;
    float priceLiter, totalPaid, totalLiters = 0;
    float avgPriceLiter, costPerKm, consumptionPerHundred = 0;

    System.out.println("\n EJERCICIO 07:");
    System.out.println(" Programa para calcular el consumo cada 100km de un coche y su coste por km \n en base a la distancia recorrida entre dos repostajes, el precio del litro y \n la cantidad total repostada. \n ");

    // ENTRADA 1
    System.out.println("Primer reposte:");
    System.out.println(" - Precio del litro:");
    priceLiter = validate.inputType(1f);
    System.out.println(" - Total pagado:");
    totalPaid = validate.inputType(1f);
    System.out.println(" - Cuentakilometros:");
    kilometers = validate.inputType(1);
    System.out.println("");

    // Sacamos el nº de litros repostados dividiento el total pagado por el precio
    // por litro
    totalLiters = totalPaid / priceLiter;
    // Guardamos el valor del precio por litro para más tarde
    avgPriceLiter = priceLiter;

    // ENTRADA 2
    System.out.println("Segundo reposte:");
    System.out.println(" - Precio del litro:");
    priceLiter = validate.inputType(1f);
    System.out.println(" - Total pagado:");
    totalPaid = validate.inputType(1f);
    System.out.println("");

    // Mismo proceso que arriba y se lo sumamos al valor ya obtenido para sacar el
    // total de litros repostados
    totalLiters = totalLiters + (totalPaid / priceLiter);
    // Hacemos media de los precios por litro en los dos repostajes
    avgPriceLiter = (avgPriceLiter + priceLiter) / 2;

    // ENTRADA 3
    System.out.println("Tercer reposte:");
    System.out.println(" - Cuentakilometros:");
    kilometers = validate.inputType(1);
    System.out.println("");

    // Regla de tres para sacar el consumo cada 100km
    consumptionPerHundred = totalLiters * 100 / kilometers;
    // Precio medio del litro por el consumo cada 100km, dividido por 100 para sacar
    // el precio por km
    costPerKm = avgPriceLiter * consumptionPerHundred / 100;

    // Salidas
    System.out.println("Consumo cada 100km: " + df.format(consumptionPerHundred) + " litros");
    System.out.println("Precio del km: " + df.format(costPerKm) + "€");
  }

}
