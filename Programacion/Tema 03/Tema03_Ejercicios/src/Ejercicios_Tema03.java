import Alex_Ressources.*;

class Bloque extends Ejercicios_Tema03 {

  public String info = "placeholder info";

  public void setSelfInfo(String info) {
    this.info = info;
  }

  public void showSelfInfo() {
    System.out.println(info);
  }

  public void main() {

  }

}

class Ejercicio extends Bloque {

  General_Functions function = new General_Functions();

  public void main() {

  }

}

public class Ejercicios_Tema03 {
  public static ValidateInput validate = new ValidateInput();

  public static String[] mainArgs;

  public static void main(String[] args) {
    // VARIABLES
    // Número total de bloques
    final int N_BLOQUES = 2;
    // Número de bloque escogido
    int n_bloque;
    // Array de bloques
    Bloque[] bloques = new Bloque[N_BLOQUES];
    // Condición del while
    boolean exitApp = false;
    // ARGS
    setArgs(args);

    // INICIALIZACIÓN
    bloques[0] = new E01_funciones();
    bloques[0].setSelfInfo(" Bloque 01: Ejercicios de funciones");
    bloques[1] = new E02_estructuras_if();
    bloques[1].setSelfInfo(" Bloque 02: Ejercicios de if's");

    // ESCOGER BLOQUE
    while (!exitApp) {
      // Display info general
      System.out.println("Hay " + N_BLOQUES + " bloques, escoje uno:");
      showInfo(bloques);

      // Le pide al usuario que bloque quiere ejecutar
      n_bloque = validate.inputRange(1, 1, N_BLOQUES) - 1;

      // Ejecuta el main del bloque escogido
      bloques[n_bloque].main();

      // Continuar ejecución o no
      System.out.println("¿Quieres salir de la aplicación?");
      exitApp = validate.inputType(true);
    }

    // Cerrar el validar
    validate.close();
  }

  /**
   * Prints on the console the info of each of the items in the {@code objects}
   * parameter.
   * 
   * @param objects array of items to go through.
   */
  public static void showInfo(Bloque[] objects) {
    System.out.println("Hay " + objects.length + " opciones, escoje una:");

    for (Bloque objeto : objects) {
      objeto.showSelfInfo();
    }

    System.out.println("");
  }

  /**
   * Gives access the arguments of the main function of the app.
   * 
   * @param args
   */
  public static void setArgs(String[] args) {
    mainArgs = args;
  }

  public String[] getArgs() {
    return mainArgs;
  }
}