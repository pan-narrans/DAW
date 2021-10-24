import Alex_Ressources.*;

public class Ejercicios_Tema03 extends Ejercicios {

  public String info;

  public void setSelfInfo(String info) {
    this.info = info;
  }

  public void showSelfInfo() {
    System.out.println(info);
  }

  public void main() {

  }

}

class Ejercicios {
  public static ValidateInput validate = new ValidateInput();

  public static void main(String[] args) {
    // Declaración de variables para escojer ejercicio
    final int N_BLOQUES = 1;
    int bloque;
    boolean exitApp = false;

    Ejercicios_Tema03[] bloques = new Ejercicios_Tema03[N_BLOQUES];

    // Preparando las variable
    bloques[0] = new E01_funciones();
    bloques[0].setSelfInfo(" Bloque 01: Ejercicios de funciones");

    // Escoger Bloque
    while (!exitApp) {
      showInfo(bloques, N_BLOQUES);
      // Le pide al usuario que bloque quiere ejecutar
      bloque = validate.inputRange(1, 1, N_BLOQUES);

      switch (bloque) {
      case 1:
        bloques[0].main();
        break;
      default:
        break;
      }

      System.out.println("¿Quieres salir de la aplicación?");
      exitApp = validate.inputType(true);
    }

    // Cerrar el validar
    validate.close();
  }

  static public void showInfo(Ejercicios_Tema03[] objetos, int nObjetos) {
    System.out.println("Hay " + nObjetos + " bloques de ejercicios, escoje uno:");

    for (Ejercicios_Tema03 objeto : objetos) {
      objeto.showSelfInfo();
    }

    System.out.println("");
  }
}