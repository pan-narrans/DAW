import Alex_Ressources.*;

public class Ejercicios_Tema03 {

  static ValidateInput validate = new ValidateInput();

  public static void main(String[] args) throws Exception {

    //
    E01_funciones bloque01 = new E01_funciones();

    // Declaración de variables para escojer ejercicio
    int ejercicio;
    final int N_EJERCICIOS = 7;
    boolean exitApp = false;

    // Le pide al usuario que ejercicio quiere ejecutar
    System.out.println("Hay " + N_EJERCICIOS + " ejercicios, escoje uno:");
    System.out.println(" Ejercicio 01: ");
    System.out.println("");
    ejercicio = validate.inputRange(1, 1, N_EJERCICIOS);


    // Escoger Bloque
    while (!exitApp) {
      switch (ejercicio) {
      case -1:
        exitApp = true;
        break;
      case 1:
        bloque01.mainE01();
        break;
      default:
        break;
      }
    }

    // Cerrar el validar
    validate.close();
  }
}
