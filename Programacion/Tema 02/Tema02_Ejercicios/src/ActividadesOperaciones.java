import java.text.DecimalFormat;

public class ActividadesOperaciones {

  // Clase propia para validar las entradas por teclado
  static ValidateInput validate = new ValidateInput(3);
  // Usamos df para darle un formato más amable a los resultados que le mostramos
  // al ususario
  static DecimalFormat df = new DecimalFormat();

  public static void main(String[] args) {
    // Declaración de variables para escojer ejercicio
    int ejercicio;
    final int N_EJERCICIOS = 3;

    // Set del formato decimal
    df.setMaximumFractionDigits(2);
    df.setMinimumFractionDigits(2);

    // Le pide al usuario que ejercicio quiere ejecutar
    System.out.println("Hay " + N_EJERCICIOS + " ejercicios, escoje uno:");
    System.out.println(" Ejercicio 01: rebajas");
    System.out.println(" Ejercicio 02: banco");
    System.out.println(" Ejercicio 03: rectangulo");
    System.out.println("");
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
      default:
        break;
    }

    // Cerrar el validar
    validate.close();
  }

  /**
   * Programa que calcula el precio de unas deportivas en función de si el usuario
   * sabe o no de la existencia de la rebaja.
   */
  private static void ejercicio01() {
    // Intro
    System.out.println("\n EJERCICIO 01:");
    System.out.println(
        " Calcular el precio de unas deportivas en función de si se sabe o no de la \n existencia de la rebaja. \n");

    // Variables
    boolean loSabe;
    float precio = 85;

    // Comprobar si hay rebaja
    System.out.println("¿Sabes si hay rebaja? \n true/false");
    loSabe = validate.inputType(true);

    // Aplica la rebaja del 15% a las zapatillas si sabe de ella
    if (loSabe) {
      precio -= precio * 0.15f;
    }

    // Salida
    System.out.println("Las zapatillas cuestan " + df.format(precio) + "€.");
  }

  /**
   * Programa para calcular cuanto nos paga el banco por nuestro depósito en base
   * a una serie de variábles.
   */
  private static void ejercicio02() {
    // Intro
    System.out.println("\n EJERCICIO 02:");
    System.out.println(" Calcular cuanto nos paga el banco por nuestro depósito. \n");

    // Variables
    int moneyInAccount = 2000, months = 6;
    float interest = 2.75f, hacienda = 18f;
    float money, moneyHacienda;

    // Mostrar por pantalla los datos
    System.out.println("\t Dinero en cuenta: " + df.format(moneyInAccount) + "€");
    System.out.println("\t Meses que lleva el depósito: " + months + " meses");
    System.out.println("\t Interés anual del " + df.format(interest) + "%");
    System.out.println("\t Porcentaje para Hacienda del dinero retirado: " + df.format(hacienda) + "%");

    // Dinero generado por el interés
    money = (float) moneyInAccount * (interest / 100) * ((float) months / 12);
    System.out.println("\n\t El depósito ha generdado: " + df.format(money) + "€");

    // Cálculo de la parte para haciendo y parte que nos queda a nosotros
    moneyHacienda = money * hacienda / 100;
    money -= moneyHacienda;
    System.out.println("\t Hacienda se lleva: " + df.format(moneyHacienda) + "€");
    System.out.println("\t Nos quedan: " + df.format(money) + "€ \n");
  }

  /**
   * Programa que muestra las características básicas de un rectángulo
   */
  private static void ejercicio03() {
    // Intro
    System.out.println("\n EJERCICIO 03:");
    System.out.println(" Mostrar cierta información relevante sobre un rectángulo. \n");

    // Variables
    int height = 15, width = 25;
    float perimeter, area;

    // Calcular perímetro y área
    perimeter = height * 2 + width * 2;
    area = height * width;

    // Salida
    System.out.println("El rectángulo tiene: \n \t - " + height + "cm de alto" + "\n \t - " + width + "cm de ancho \n");
    System.out.println("Su perímetro es de " + df.format(perimeter) + "cm.");
    System.out.println("Su área es de " + df.format(area) + "cm.");

  }

}
