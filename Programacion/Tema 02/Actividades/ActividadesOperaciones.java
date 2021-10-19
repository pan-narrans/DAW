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

  private static void ejercicio01() {
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

  private static void ejercicio02() {
    System.out.println("no entiendo de bancos");
  }

  private static void ejercicio03() {
    // Variables
    int alto = 15, ancho = 25;

    System.out.println("El rectángulo tiene \n \t -" + alto + "cm de alto" + "\n \t -" + ancho + "cm de ancho");

  }

}
