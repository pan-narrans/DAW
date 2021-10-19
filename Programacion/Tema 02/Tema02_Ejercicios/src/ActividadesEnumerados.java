public class ActividadesEnumerados {
  // Clase propia para validar las entradas por teclado
  static ValidateInput validate = new ValidateInput(3);

  public static void main(String[] args) {
    // Declaración de variables para escojer ejercicio
    int ejercicio;
    final int N_EJERCICIOS = 2;

    // Le pide al usuario que ejercicio quiere ejecutar
    System.out.println("Hay " + N_EJERCICIOS + " ejercicios, escoje uno:");
    System.out.println(" Ejercicio 01: Días de la semana como enumerados.");
    System.out.println(" Ejercicio 02: Más enumerados");
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
      default:
        break;
    }

    // Cerrar el validar
    validate.close();
  }

  /**
   * Días de la semana en un enumerado.
   */
  static void ejercicio01() {
    // Intro
    System.out.println("\n EJERCICIO 01:");
    System.out.println(" Días de la semana como enumerados. \n");

    // Variables
    enum Days {
      LUNES, MARTES, MIÉRCOLES, JUEVES, VIERNES, SÁBADO, DOMINGO;
    }

    // Salidas
    Days day = Days.MARTES;
    System.out.println("Hoy es " + day + ".");
    System.out.println("El domingo es el día nº " + Days.DOMINGO.ordinal() + " de la semana.");

  }

  /**
   * Declaración de más enumerados.
   */
  static void ejercicio02() {
    // Intro
    System.out.println("\n EJERCICIO 02:");
    System.out.println(" Más enumerados. \n");

    // Enumerado de los días laborables
    enum WorkDays {
      LUNES, MARTES, MIÉRCOLES, JUEVES, VIERNES;
    }

    // Enumerado de los tres primeros meses del año
    enum FirstThreeMonths {
      ENERO, FEBRERO, MARZO;
    }

    // Enumerado de las notas de un alumno
    enum Scores {
      exámen_1(5), exámen_2(7), exámen_3(3), exámen_4(9), exámen_5(2);

      private final int score;

      // Método para asignarle el valor numérico a la nota
      private Scores(int score) {
        this.score = score;
      }

      // Método para recuperar el valor numérico de la nota en sí
      public int getScore() {
        return score;
      }
    }

    // Enumerado de los colores primários
    enum PrimaryColors {
      CYAN, MAGENTA, AMARILLO;
    }

    // Enumerado de las notas musicales
    enum Notes {
      DO, RE, MI, FA, SOL, LA, SI;
    }

    // Enumerado de los colores del arcoiris
    enum RainbowColors {
      ROJO, NARANJA, AMARILLO, VERDE, AÑIL, AZUL, VIOLETA;
    }

    // Enumerado de los colores de la televisión
    enum TVColors {
      REG, GREEN, BLUE;
    }

    // Salida de datos
    // Hacemos un foreach para cada enum e imprimimos por pantalla sus datos
    System.out.println("Dias laborables");
    for (WorkDays day : WorkDays.values()) {
      System.out.println(day);
    }
    System.out.println("\nTres primeros meses del año");
    for (FirstThreeMonths month : FirstThreeMonths.values()) {
      System.out.println(month);
    }
    System.out.println("\nNotas de los alumnos");
    for (Scores exam : Scores.values()) {
      System.out.println("nota del " + exam + ": " + exam.getScore() + "/10");
    }
    System.out.println("\nColores primarios");
    for (PrimaryColors color : PrimaryColors.values()) {
      System.out.println(color);
    }
    System.out.println("\nNotas musicales");
    for (Notes note : Notes.values()) {
      System.out.println(note);
    }
    System.out.println("\nColores del arcoiris");
    for (RainbowColors color : RainbowColors.values()) {
      System.out.println(color);
    }
    System.out.println("\nColores de la tele");
    for (TVColors color : TVColors.values()) {
      System.out.println(color);
    }

  }

}
