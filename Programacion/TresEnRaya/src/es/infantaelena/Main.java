package es.infantaelena;

public class Main {

  // TODO: guardar records entre partidas

  public static void main(String[] args) {
    TresEnRaya t = new TresEnRaya();
    t.menuJuego();

    // probarRecords(t);
    // probarTablero(t);
    // probarDiagonales(t);

    {
      int test = 55;
      System.out.println(test);
    }
    {
      int test = 45;
      System.out.println(test);
    }

    // "Destructor"
    t = null;
  }

  static void probarDiagonales(TresEnRaya t) {

    int size = 5;
    int rayas = ((size + 1) / 2) + 1;
    int ajuste = rayas - 1;

    // Check diagonals
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        System.out.print("[" + i + "," + j + "]");
      }
      System.out.println("");
    }

    System.out.println("");
    System.out.println("size: " + size);
    System.out.println("Rayas:  " + rayas);
    System.out.println("Ajuste: " + ajuste);
    System.out.println("");

    // --0
    // -0-
    // 0--

    // Check diagonals
    for (int i = ajuste; i < size; i++) {
      for (int j = 0; j <= i; j++) {
        System.out.print("[" + (i - j) + "," + j + "]");
      }
      System.out.println("");
    }
    // Check diagonals
    for (int i = size - 2; i > ajuste - 1; i--) {
      for (int j = 0; j <= i; j++) {
        System.out.print("[" + (size - 1 - j) + "," + (size - 1 - i + j) + "]");
      }
      System.out.println("");
    }

    // 0--
    // -0-
    // --0

    // Check diagonals
    for (int i = ajuste; i < size; i++) {
      for (int j = 0; j <= i; j++) {
        System.out.print("[" + (i - j) + "," + (size - 1 - j) + "]");
      }
      System.out.println("");
    }
    // Check diagonals
    for (int i = size - 2; i > ajuste - 1; i--) {
      for (int j = 0; j <= i; j++) {
        System.out.print("[" + (size - 1 - j) + "," + (i - j) + "]");
      }
      System.out.println("");
    }

    System.out.println("");
  }

  static void probarRecords(TresEnRaya t) {
    System.out.println("\nPROBAR MÉTODOS RECORDS");

    String[][] records = t.creaRecords();

    t.nuevoRecord(records, "alex 01", 9);
    t.nuevoRecord(records, "alex 02", 6);
    t.nuevoRecord(records, "alex 03", 3);
    t.nuevoRecord(records, "alex 04", 5);
    t.nuevoRecord(records, "alex 05", 5);

    t.imprimirRecords(records);

    System.out.println("4 " + ((t.esNuevoRecord(t.records, 4)) ? "" : "no ") + "es nuevo record.");
    System.out.println("6 " + ((t.esNuevoRecord(t.records, 6)) ? "" : "no ") + "es nuevo record.");
    System.out.println("7 " + ((t.esNuevoRecord(t.records, 7)) ? "" : "no ") + "es nuevo record.");
  }

  static void probarTablero(TresEnRaya t) {
    System.out.println("\nPROBAR MÉTODOS TABLERO");

    t.tablero[1][0] = 'X';

    t.imprimirTablero(t.tablero);

    System.out.println("[1,0] " + ((t.esPosicionVacia(t.tablero, 1, 0)) ? "" : "no ") + "está vacía.");
    System.out.println("[2,1] " + ((t.esPosicionVacia(t.tablero, 2, 1)) ? "" : "no ") + "está vacía.");
  }

  static void probarJugada(TresEnRaya t) {
    System.out.println("\nPROBAR MÉTODOS TABLERO");

    t.tablero[1][0] = 'X';

    t.imprimirTablero(t.tablero);

    System.out.println("[1,0] " + ((t.esPosicionVacia(t.tablero, 1, 0)) ? "" : "no ") + "está vacía.");
    System.out.println("[2,1] " + ((t.esPosicionVacia(t.tablero, 2, 1)) ? "" : "no ") + "está vacía.");
  }

}
