import Alex_Ressources.*;

class Bloque extends Tema_03 {

  public String info = "placeholder info";

  public void setSelfInfo(String info) {
    this.info = info;
  }

  public void showSelfInfo() {
    System.out.println(info);
  }

  public void main() {

  }

  /**
   * Given an array of {@code Ejercicios} it lets the user choose from one of
   * them.
   * 
   * @param ejercicios
   */
  public void chooseExercise(Ejercicio[] ejercicios) {
    int n_ejercicio;
    boolean continueExecution = true;
    while (continueExecution) {
      // Le pide al usuario que ejercicio quiere ejecutar
      System.out.println("Hay " + ejercicios.length + " ejercicios, escoje uno:");
      showInfo(ejercicios);
      n_ejercicio = validate.inputRange(1, 1, ejercicios.length) - 1;

      ejercicios[n_ejercicio].main();

      // Continuar ejecución o no
      System.out.println("¿Quieres ejecutar otro ejercicio?");
      continueExecution = validate.inputType(true);
    }
  }

}

class Ejercicio extends Bloque {

  Functions_General func = new Functions_General();
  Functions_B02 functionsB02 = new Functions_B02();

  public void main() {

  }

}

public class Tema_03 {
  public static ValidateInput validate = new ValidateInput();

  public static String[] mainArgs;

  public static void main(String[] args) {
    // VARIABLES
    // Número total de bloques
    final int N_BLOQUES = 3;
    // Número de bloque escogido
    int n_bloque;
    // Array de bloques
    Bloque[] bloques = new Bloque[N_BLOQUES];
    // Condición del while
    boolean exitApp = false;
    // ARGS
    setArgs(args);

    // INICIALIZACIÓN
    bloques[0] = new B01_funciones();
    bloques[0].setSelfInfo(" Bloque 01: Ejercicios de funciones");
    bloques[1] = new B02_estructuras_if();
    bloques[1].setSelfInfo(" Bloque 02: Ejercicios de if's");
    bloques[2] = new B02_estructuras_if();
    bloques[2].setSelfInfo(" Bloque 03: Ejercicios de switch's");

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