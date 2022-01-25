package es.infantaelena;

import java.io.IOException;
//import java.lang.reflect.Array;
// why use this with array of anything other than primitive types?
import java.util.Arrays;
// import java.util.Random;
import java.util.Scanner;

public class TresEnRaya {

  // enumeración para saber si el jugador es un PC o un Humano
  enum TipoJugador {
    PC, HUMANO
  };

  static final char JUG_1 = 'X';
  static final char JUG_2 = 'O';
  static final char VACIA = '-';
  static final char[] JUGADAS = { JUG_1, JUG_2 };

  final int TAM_TABLERO;
  final int NUM_RECORDS = 3;
  final int NUM_RAYAS;

  static Scanner sc = new Scanner(System.in);

  // Variable para indicar los turnos 0 primer jugador, 1 segundo jugador
  int turno;

  // Variable para guardar el número de movimientos de la partida actual
  int movimientos;

  // Nº max de movimientos de una partida -> TAM_TABLERO * TAM_TABLERO
  int maxMovimientos;

  // Matriz para la partida de tres en raya
  public char tablero[][];

  // Matriz ordenada para almacenar los records,
  // la primera columna para el nombre
  // y la segunda para el número de movimientos
  String[][] records;

  // Array para saber que jugadores estan haciendo la partida.
  TipoJugador jugadores[] = new TipoJugador[2];

  boolean partidaTerminada = false;

  /**
   * Constructor.
   */
  public TresEnRaya() {
    TAM_TABLERO = 3;
    NUM_RAYAS = ((TAM_TABLERO + 1) / 2) + 1;
    maxMovimientos = TAM_TABLERO * TAM_TABLERO;
    records = creaRecords();
  }

  /**
   * Constructor.
   * 
   * @param tam Size of the board
   */
  public TresEnRaya(int tam) {
    TAM_TABLERO = tam;
    NUM_RAYAS = (TAM_TABLERO / 2) + 1;
    maxMovimientos = TAM_TABLERO * TAM_TABLERO;
    records = creaRecords();
  }

  /**
   * Prints the game board
   * 
   * @param tablero
   */
  public void imprimirTablero(char[][] tablero) {
    System.out.println("");

    System.out.println("   0  1  2");
    for (int i = 0; i < tablero.length; i++) {
      System.out.println(i + " " + Arrays.toString(tablero[i]));
    }

    System.out.println("");
  }

  /**
   * Función que devuelve un tablero de records vacio
   * con la mínima puntuación TAM_TABLERO X TAM_TABLERO y usuario PC
   * 
   * @return tablero de records inicial
   */
  //
  public String[][] creaRecords() {
    String[][] array = new String[NUM_RECORDS][2];
    String puntos = Integer.toString(maxMovimientos);

    // Fill the array with placeholder values
    for (int i = 0; i < NUM_RECORDS; i++) {
      array[i][0] = "PC";
      array[i][1] = puntos;
    }

    return array;
  }

  /**
   * Initializes the board for a new game
   * 
   * @param tam size of the board
   * @return empty board matrix
   */
  public char[][] creaTablero(int tam) {
    char[][] array = new char[tam][tam];

    // Fill the array with placeholder values
    for (int i = 0; i < array.length; i++) {
      Arrays.fill(array[i], VACIA);
    }

    return array;
  }

  /**
   * Checks if a move made by a player is valid or not.
   * 
   * @param tableroJuego board to check
   * @param fila         row of the board
   * @param col          column of the board
   * @return Returns true if the move is valid, false if not.
   */
  public boolean esJugadaValida(int fila, int col, char[][] tableroJuego) {
    // Check valid row number
    if (fila < 0 || fila > tableroJuego.length - 1)
      return false;

    // Check valid column number
    if (col < 0 || col > tableroJuego[0].length - 1)
      return false;

    // Check for empty cell
    return esPosicionVacia(tableroJuego, fila, col);
  }

  /**
   * Checks if a board cell is occupied or not.
   * 
   * @param tableroJuego board to check
   * @param fila         row of the board
   * @param col          column of the board
   * @return Returns true if occupied, false if not.
   */
  public boolean esPosicionVacia(char[][] tableroJuego, int fila, int col) {
    return (tableroJuego[fila][col] == VACIA) ? true : false;
  }

  /**
   * Función para llamar a pedirJugadaHumano o pedirJugadaPC
   * según el tipo de jugador del jugador al que le toca
   */
  public void pedirJugada() {
    if (jugadores[turno] == TipoJugador.HUMANO)
      pedirJugadaHumano();
    else
      pedirJugadaPC();
  }

  /**
   * Función que realiza la jugada para un jugador PC
   * (de forma aleatoria o con algún tipo de estrategia)
   * Genera como salida el jugador que juega y que fila y columna elige
   */
  public void pedirJugadaPC() {
    int fila, columna;
    boolean jugadaValida;

    do {
      // Chooses row and column
      fila = (int) (Math.random() * TAM_TABLERO);
      columna = (int) (Math.random() * TAM_TABLERO);

      // Checks if play is valid
      jugadaValida = esJugadaValida(fila, columna, tablero);
    } while (!jugadaValida);

    tablero[fila][columna] = (turno == 0) ? JUG_1 : JUG_2;

  }

  /**
   * Shows which player's turn it is and aks them some coordinates to place their
   * token in the board.
   * If the coordinates are not valid, it'll ask again until they are.
   */
  public void pedirJugadaHumano() {
    int fila, columna;
    boolean jugadaValida;

    System.out.println("Turno del Jugador " + (turno + 1));

    do {
      imprimirTablero(tablero);

      // Querries the row
      System.out.println("Introduce la fila:");
      fila = sc.nextInt();

      // Querries the column
      System.out.println("Introduce la columna:");
      columna = sc.nextInt();

      jugadaValida = esJugadaValida(fila, columna, tablero);
      if (!jugadaValida) {
        System.out.println("La jugada introducida no es válida.");
        System.out.println("Introduce otra jugada Jugador " + (turno + 1) + ":");
        System.out.println("---------------------");
      }
    } while (!jugadaValida);

    tablero[fila][columna] = (turno == 0) ? JUG_1 : JUG_2;
  }

  /**
   * Función que imprime las opciones del menú del juego
   */
  public void menuJuego() {

    // TODO: dar opcion a escoger tamaño tablero
    // TODO: X en raya en función del tamaño del tablero

    boolean continuePlaying = true;

    do {
      System.out.println("\n--- GENERAL INFO ---");
      System.out.println("Tamaño del tablero: " + TAM_TABLERO);
      System.out.println("Fichas consecutivas para ganar: " + NUM_RAYAS);

      System.out.println("\n--- MAIN MENU ---");
      System.out.println("1) Jugar humano vs humano");
      System.out.println("2) Jugar humano vs PC");
      System.out.println("3) Jugar PC vs PC");
      System.out.println("4) Mostrar Records");
      System.out.println("5) Salir");

      switch (sc.nextInt()) {
        case 1:
          jugadores[0] = TipoJugador.HUMANO;
          jugadores[1] = TipoJugador.HUMANO;
          jugar();
          break;
        case 2:
          jugadores[0] = TipoJugador.HUMANO;
          jugadores[1] = TipoJugador.PC;
          jugar();
          break;
        case 3:
          jugadores[0] = TipoJugador.PC;
          jugadores[1] = TipoJugador.PC;
          jugar();
          break;
        case 4:
          imprimirRecords(records);
          break;
        case 5:
          continuePlaying = false;
          break;
        default:
          System.out.println("Esta opción no está recogida.");
          break;
      }

    } while (continuePlaying);

  }

  /**
   * Función que imprime el contenido de la matriz de records
   * 
   * @param records
   */
  public void imprimirRecords(String[][] records) {
    System.out.println("\n--- HIGH SCORES ---");
    for (String[] record : records) {
      System.out.println(Arrays.toString(record));
    }
    pressEnterToContinue();
  }

  /**
   * Devuelve si se ha producido un nuevo record
   * 
   * @param records
   * @param movimientos
   * @return Returns true if its a new high score, false if not
   */
  public boolean esNuevoRecord(String[][] records, int movimientos) {
    for (int i = 0; i < records.length; i++) {
      if (movimientos <= Integer.valueOf(records[i][1]))
        return true;
    }
    return false;
  }

  /**
   * Añade un nuevo record ordenado al array y borra el último record.
   * 
   * @param records     High scores matrix.
   * @param nombre      Name to put on the wall of fame.
   * @param movimientos Number of moves taken to beat the game.
   * @return Array with the new high score included
   */
  public String[][] nuevoRecord(String[][] records, String nombre, int movimientos) {
    int position = 0;

    // Finds the position the new score would hold in the ranking
    while (Integer.valueOf(records[position][1]) < movimientos) {
      position++;
    }

    // Shift all items one position from the bottom up,
    // ending in the selected position
    for (int i = records.length - 1; i > position; i--) {
      records[i][0] = records[i - 1][0];
      records[i][1] = records[i - 1][1];
    }

    // Adds the new high score
    records[position][0] = nombre;
    records[position][1] = Integer.toString(movimientos);

    return records;
  }

  /**
   * Genera un turno pseudo-aleatorio entre 0 y 1
   * 
   * @return Número pseudo-aleatorio entre 0 y 1
   */
  private int sortearTurno() {
    return (int) (Math.random() * 2);
  }

  /**
   * Función que implementa una partida entre jugadores
   * ya sean humano y humano, humano y pc o humano y humano
   * no termina hasta que un jugador gane o se terminen los movimientos
   * indicará en la consola que jugador ha ganado o si ha sido un empate
   * en caso de producirse un record si es humano, introducirá su nombre
   * si es un pc se introducirá automáticamente un record con nombre PC
   * 
   */
  public void jugar() {
    // Initialize variables
    String nombre;
    int ganador = -1;
    movimientos = 0;

    turno = sortearTurno();
    tablero = creaTablero(TAM_TABLERO);

    System.out.println("\n--- GAME ON ---");
    System.out.println("JUGADOR 01: " + JUG_1);
    System.out.println("JUGADOR 02: " + JUG_2);

    do {
      // First things first, +1 moves
      movimientos++;

      // Call methods
      pedirJugada();
      ganador = comprobarVictoria(tablero);

      // Update variables
      turno = (turno == 0) ? 1 : 0;
      partidaTerminada = (ganador == -1) ? false : true;
    } while (!partidaTerminada);

    // Show final state of the board
    imprimirTablero(tablero);

    // Anounces winner
    if (ganador == 2)
      System.out.println("¡Empate!");
    else {
      System.out.println("ha ganado el jugador " + (ganador + 1));
      pressEnterToContinue();

      // If there's a new record, record it
      if (esNuevoRecord(records, movimientos)) {
        // Ask name
        if (jugadores[ganador] == TipoJugador.HUMANO) {
          System.out.println("Introduce tu nombre Jugador " + ganador + 1);
          nombre = sc.next();
        } else {
          nombre = "PC";
        }
        nuevoRecord(records, nombre, movimientos);
      } // End "manage records"

    } // End "anounce winner"

  }// End jugar()

  /**
   * Función que indica si ha ganado un jugador, es un empate o todavía no ha
   * terminado.
   * 
   * 
   * @param tablero
   * @return -1 Si todavía no ha terminado
   *         0 Si ha ganado el jugador 1
   *         1 Si ha ganado el jugador 2
   *         2 Si ha sido un empate
   */
  public int comprobarVictoria(char[][] tablero) {
    /*
     * As the function is called in at every turn, we only have to check the pieces
     * for the current player. If a match of 3 is found, the winner is the current
     * player.
     */

    int CounterH = 0, CounterV = 0;
    int ajuste = NUM_RAYAS - 1;

    // Check horizontals and verticals
    for (int i = 0; i < tablero.length; i++) {
      // Reiniciar variables
      CounterH = 0;
      CounterV = 0;

      for (int j = 0; j < tablero.length; j++) {
        // Check horizontals
        if (tablero[i][j] == JUGADAS[turno])
          CounterH++;

        // Check verticals
        if (tablero[j][i] == JUGADAS[turno])
          CounterV++;

        // Return winner if found, and avoid diagonal calculation
        if (CounterH > 2 || CounterV > 2)
          return turno;
      }
    }

    // Check diagonals
    if (tablero.length == 3) {
      // Check diagonals in 3x3 board

      // Reiniciar variables
      CounterH = 0;
      CounterV = 0;

      for (int i = 0; i < 3; i++) {
        if (tablero[i][i] == JUGADAS[turno])
          CounterH++;
        if (tablero[i][2 - i] == JUGADAS[turno])
          CounterV++;

        // Return winner if found
        if (CounterH > 2 || CounterV > 2)
          return turno;
      }
    } else {
      // Check bigger diagonals or how I learned to stop worrying and trust the magic
      // TODO: no comprobar las diagonales pequeñas

      // Check 1st half of the board
      for (int i = ajuste; i < tablero.length; i++) {
        // Reiniciar variables
        CounterH = 0;
        CounterV = 0;

        for (int j = 0; j <= i; j++) {
          // - 0
          // 0 -
          if (tablero[i - j][j] == JUGADAS[turno])
            CounterH++;

          // 0 -
          // - 0
          if (tablero[i - j][tablero.length - 1 - j] == JUGADAS[turno])
            CounterV++;

          // Return winner if found
          if (CounterH > 2 || CounterV > 2)
            return turno;
        }
      }

      // Check 2nd half of the board
      for (int i = tablero.length - 2; i > ajuste - 1; i--) {
        // Reiniciar variables
        CounterH = 0;
        CounterV = 0;

        for (int j = 0; j <= i; j++) {
          // - 0
          // 0 -

          //TODO: arreglar problema aqui con tableros grandes
          if (tablero[i + j][tablero.length - 1 - j] == JUGADAS[turno])
            CounterH++;

          // 0 -
          // - 0
          if (tablero[tablero.length - 1 - j][i - j] == JUGADAS[turno])
            CounterV++;

          // Return winner if found
          if (CounterH > 2 || CounterV > 2)
            return turno;
        }
      }
    }

    // Game still in progress
    if (movimientos < maxMovimientos)
      return -1;

    return 2;

  }

  /**
   * Stops the execution of the program until enter is pressed.
   */
  private void pressEnterToContinue() {

    System.out.println("\n--- press enter to continue");

    try {
      System.in.read();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}// End class
