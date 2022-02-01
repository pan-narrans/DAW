package es.infantaelena;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class TresEnRaya {

  // Enum differencing the type of the player
  enum TipoJugador {
    PC, HUMANO
  };

  // Board Tokens:
  static final char JUG_1 = 'X';
  static final char JUG_2 = 'O';
  static final char VACIA = '-';

  final static int TAM_TABLERO = 3; // Default board size
  final int NUM_RECORDS = 3;
  final int NUM_RAYAS; // Number of consecutive tokens needed to win

  // Board size,
  // introduced in order not to change the final variable already in the code.
  private int tamTablero;

  static Scanner sc = new Scanner(System.in);

  // Marks the player's turn, 0 - player 1, 1 - player 2
  int turno;

  // Stores the number of moves made during the game
  int movimientos;

  // max nº of possible moves -> TAM_TABLERO * TAM_TABLERO
  int maxMovimientos;

  // Board matrix to store the tokens in
  public char tablero[][];

  // Records matrix:
  // name, nº of moves
  String[][] records;

  // Array for storing the type of player playing the current game
  TipoJugador jugadores[] = new TipoJugador[2];

  boolean partidaTerminada = false;

  /**
   * Constructor.
   */
  public TresEnRaya() {
    this(TAM_TABLERO);
  }

  /**
   * Constructor.
   * 
   * @param tamTablero Size of the board
   */
  public TresEnRaya(int size) {
    tamTablero = size;
    NUM_RAYAS = ((tamTablero + 1) / 2) + 1;
    maxMovimientos = tamTablero * tamTablero;
    records = creaRecords();
  }

  /**
   * Prints the game board
   * 
   * @param tablero
   */
  public void imprimirTablero(char[][] tablero) {
    System.out.print("\n ");

    // Print col numbers
    for (int i = 0; i < tablero.length; i++) {
      System.out.print("  " + i);
    }

    System.out.println("");

    // Print row numbers and array contents
    for (int i = 0; i < tablero.length; i++) {
      System.out.println(i + " " + Arrays.toString(tablero[i]));
    }

    System.out.println("");
  }

  /**
   * Creates an empty scoreboard with placeholder values.
   * All the records will be hold by "PC" with the worst possible score (board
   * size * board size).
   * 
   * @return scoreboard
   */
  //
  public String[][] creaRecords() {
    String[][] array = new String[NUM_RECORDS][2];
    String puntos = Integer.toString(maxMovimientos);

    // Fill the array with the placeholder values
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

    // Fill the array with empty tokens
    for (int i = 0; i < array.length; i++) {
      Arrays.fill(array[i], VACIA);
    }

    return array;
  }

  /**
   * Checks if a move made by a player is valid or not.
   * 
   * @param fila         row of the board
   * @param col          column of the board
   * @param tableroJuego board to check
   * @return Returns true if the move is valid, false if not.
   */
  public boolean esJugadaValida(int fila, int col, char[][] tableroJuego) {
    // Check valid row number
    if (fila < 0 || fila > tamTablero - 1)
      return false;

    // Check valid column number
    if (col < 0 || col > tamTablero - 1)
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
   * Asks current player for a move.
   */
  public void pedirJugada() {
    if (jugadores[turno] == TipoJugador.HUMANO)
      pedirJugadaHumano();
    else
      pedirJugadaPC();
  }

  /**
   * Makes a random valid move for the PC player.
   */
  public void pedirJugadaPC() {
    // TODO: ia easy/medium/ipossible
    int fila, columna;
    boolean jugadaValida;

    do {
      // Chooses row and column
      fila = (int) (Math.random() * tamTablero);
      columna = (int) (Math.random() * tamTablero);

      // Checks if play is valid
      jugadaValida = esJugadaValida(fila, columna, tablero);
    } while (!jugadaValida);

    // PLaces the token
    tablero[fila][columna] = (turno == 0) ? JUG_1 : JUG_2;
  }

  /**
   * Asks a human player for a valid move.
   * <p>
   * It'll keep asking until the move introduces is either valid or the app is
   * closed in frustration.
   */
  public void pedirJugadaHumano() {
    String jugadaString = "";
    String[] jugadaArray;
    int fila = 0, columna = 0;
    boolean jugadaValida;

    // Informs the human of the current holder of the turn
    System.out.println("\nTurno del Jugador " + (turno + 1));

    // Ask for a move until the move is valid
    do {
      imprimirTablero(tablero);

      // Ask
      System.out.println("Introduce la jugada fila-columna (ej: 2-0):");
      jugadaString = sc.next();
      jugadaArray = jugadaString.split("-");

      // Check nº on inputs recieved
      if (jugadaArray.length == 2) {
        // All is good if we have two
        fila = Integer.valueOf(jugadaArray[0]);
        columna = Integer.valueOf(jugadaArray[1]);
        jugadaValida = esJugadaValida(fila, columna, tablero);
      } else {
        // If we have any other number of inputs, we ask again
        jugadaValida = false;
      }

      if (!jugadaValida) {
        System.out.println("La jugada introducida no es válida.");
        System.out.println("Introduce otra jugada Jugador " + (turno + 1) + ":");
        System.out.println("---------------------");
      }
    } while (!jugadaValida);

    // Place token
    tablero[fila][columna] = (turno == 0) ? JUG_1 : JUG_2;
  }

  /**
   * Prints the game menu.
   */
  public void menuJuego() {

    boolean continuePlaying = true;

    do {
      System.out.println("\n--- GENERAL INFO ---");
      System.out.println("Tamaño del tablero: " + tamTablero);
      System.out.println("Fichas consecutivas para ganar: " + NUM_RAYAS);

      System.out.println("\n--- MAIN MENU ---");
      System.out.println("1) Jugar humano vs humano");
      System.out.println("2) Jugar humano vs PC");
      System.out.println("3) Jugar PC vs PC");
      System.out.println("4) Mostrar Records");
      System.out.println("5) Salir\n");

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
          pressEnterToContinue();
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

  public static char getJug1() {
    return JUG_1;
  }

  /**
   * Prints the contents of the records matrix.
   * 
   * @param records records matrix to print
   */
  public void imprimirRecords(String[][] records) {
    System.out.println("\n--- HIGH SCORES ---");
    for (String[] record : records) {
      System.out.println(Arrays.toString(record));
    }
  }

  /**
   * Checks if a new record had been achieved.
   * 
   * @param records     records matrix to check against
   * @param movimientos nº of moves
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
   * Adds a new record to the array, deleting the last record.
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
   * Randomly assigns a turn.
   * 
   * @return random 0 or 1
   */
  private int sortearTurno() {
    return (int) (Math.random() * 2);
  }

  /**
   * Starts a new game between two players.
   * <p>
   * A game lasts until there is a winner or there are no moves left.
   * If the winner breaks a record, the event is handled.
   */
  public void jugar() {
    String nombre = "";
    int ganador = -1;
    movimientos = 0;

    // Draws the first turn and initializes the board
    turno = sortearTurno();
    tablero = creaTablero(tamTablero);

    System.out.println("\n--- GAME ON ---");
    System.out.println("JUGADOR 01: " + JUG_1);
    System.out.println("JUGADOR 02: " + JUG_2);

    // Play game per se
    do {
      // Updates the nº of moves
      movimientos++;

      // Ask for a move and check for victory
      pedirJugada();
      ganador = comprobarVictoria(tablero);

      // Change the turn and check if the game has ended
      turno = (turno == 0) ? 1 : 0;
      partidaTerminada = (ganador == -1) ? false : true;
    } while (!partidaTerminada);

    // Show final state of the board
    imprimirTablero(tablero);

    // Anounces winner and handles high scores
    if (ganador == 2)
      System.out.println("¡Empate!");
    else {
      System.out.println("¡Ha ganado el jugador " + (ganador + 1) + "!");
      pressEnterToContinue();

      // If there's a new record, record it
      if (esNuevoRecord(records, movimientos)) {
        // Ask for name if human
        if (jugadores[ganador] == TipoJugador.HUMANO) {
          System.out.println("\nIntroduce tu nombre Jugador " + ganador + 1);
          nombre = sc.next();
        } else {
          nombre = "PC";
        }
        nuevoRecord(records, nombre, movimientos);
      } // End "manage records"
    } // End "anounce winner"

  }// End jugar()

  /**
   * Checks a board for victory and returns the current state of the game.
   * 
   * @param tablero board to check
   * @return -1 : Si todavía no ha terminado
   *         <li>0 : Si ha ganado el jugador 1
   *         <li>1 : Si ha ganado el jugador 2
   *         <li>2 : Si ha sido un empate
   */
  public int comprobarVictoria(char[][] tablero) {
    // Two counters per player
    int CounterJ1H = 0, CounterJ1V = 0;
    int CounterJ2H = 0, CounterJ2V = 0;

    // Used in checking diagonals
    int ajuste = NUM_RAYAS - 1;

    // Used in checking for ties
    boolean emptyCells = false;

    // Check horizontals and verticals
    for (int i = 0; i < tablero.length; i++) {
      CounterJ1H = 0;
      CounterJ1V = 0;
      CounterJ2H = 0;
      CounterJ2V = 0;

      for (int j = 0; j < tablero.length; j++) {
        // Check horizontals
        CounterJ1H = (tablero[i][j] == JUG_1) ? CounterJ1H + 1 : 0;
        CounterJ2H = (tablero[i][j] == JUG_2) ? CounterJ2H + 1 : 0;

        // Check verticals
        CounterJ1V = (tablero[j][i] == JUG_1) ? CounterJ1V + 1 : 0;
        CounterJ2V = (tablero[j][i] == JUG_2) ? CounterJ2V + 1 : 0;

        // Return winner if found, and avoid diagonal calculation
        if (CounterJ1H > NUM_RAYAS - 1 || CounterJ1V > NUM_RAYAS - 1)
          return 0;
        if (CounterJ2H > NUM_RAYAS - 1 || CounterJ2V > NUM_RAYAS - 1)
          return 1;
      }
    }

    // Check diagonals
    if (tablero.length == 3) {
      // Check diagonals in 3x3 board
      CounterJ1H = 0;
      CounterJ1V = 0;
      CounterJ2H = 0;
      CounterJ2V = 0;

      for (int i = 0; i < 3; i++) {
        // Left to right
        CounterJ1H = (tablero[i][i] == JUG_1) ? CounterJ1H + 1 : 0; // - 0
        CounterJ2H = (tablero[i][i] == JUG_2) ? CounterJ2H + 1 : 0; // 0 -

        // Right to left
        CounterJ1V = (tablero[i][2 - i] == JUG_1) ? CounterJ1V + 1 : 0; // 0 -
        CounterJ2V = (tablero[i][2 - i] == JUG_2) ? CounterJ2V + 1 : 0; // - 0

        // Return winner if found
        if (CounterJ1H > 2 || CounterJ1V > 2)
          return 0;
        if (CounterJ2H > 2 || CounterJ2V > 2)
          return 1;
      }

    } else {
      // Check bigger diagonals or:
      // How I learned to stop worrying and trust the numbers

      // Checks 1st half of the board
      for (int i = ajuste; i < tablero.length; i++) {
        // Reiniciar variables
        CounterJ1H = 0;
        CounterJ1V = 0;
        CounterJ2H = 0;
        CounterJ2V = 0;

        for (int j = 0; j <= i; j++) {
          // Left to right
          CounterJ1H = (tablero[i - j][j] == JUG_1) ? CounterJ1H + 1 : 0; // - 0
          CounterJ2H = (tablero[i - j][j] == JUG_2) ? CounterJ2H + 1 : 0; // 0 -

          // Right to left
          CounterJ1V = (tablero[i - j][tablero.length - 1 - j] == JUG_1) ? CounterJ1V + 1 : 0; // 0 -
          CounterJ2V = (tablero[i - j][tablero.length - 1 - j] == JUG_2) ? CounterJ2V + 1 : 0; // - 0

          // Return winner if found
          if (CounterJ1H > NUM_RAYAS - 1 || CounterJ1V > NUM_RAYAS - 1)
            return 0;
          if (CounterJ2H > NUM_RAYAS - 1 || CounterJ2V > NUM_RAYAS - 1)
            return 1;
        }
      }

      // Checks 2nd half of the board
      for (int i = tablero.length - 2; i > ajuste - 1; i--) {
        // Reiniciar variables
        CounterJ1H = 0;
        CounterJ1V = 0;
        CounterJ2H = 0;
        CounterJ2V = 0;

        for (int j = 0; j <= i; j++) {
          // Left to right
          CounterJ1H = (tablero[tablero.length - 1 - j][tablero.length - 1 - i + j] == JUG_1) ? CounterJ1H + 1 : 0;
          CounterJ2H = (tablero[tablero.length - 1 - j][tablero.length - 1 - i + j] == JUG_2) ? CounterJ2H + 1 : 0;

          // Right to left
          CounterJ1V = (tablero[tablero.length - 1 - j][i - j] == JUG_1) ? CounterJ1V + 1 : 0;
          CounterJ2V = (tablero[tablero.length - 1 - j][i - j] == JUG_2) ? CounterJ2V + 1 : 0;

          // Return winner if found
          if (CounterJ1H > NUM_RAYAS - 1 || CounterJ1V > NUM_RAYAS - 1)
            return 0;
          if (CounterJ2H > NUM_RAYAS - 1 || CounterJ2V > NUM_RAYAS - 1)
            return 1;
        }
      }
    }

    // Check for empty cells
    for (int i = 0; i < tablero.length; i++) {
      for (int j = 0; j < tablero.length; j++) {
        if (tablero[i][j] == VACIA) {
          emptyCells = true;
          break;
        }
      }

      if (emptyCells)
        break;
    }

    // Game still in progress or tie
    if (emptyCells)
      return -1;
    else
      return 2;

  }

  /**
   * Stops the execution of the program until enter is pressed.
   * <p>
   * <i>Functionality plucked gently from StackOverflow.</i>
   */
  private void pressEnterToContinue() {

    System.out.print("\n--- press enter to continue");

    try {
      System.in.read();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * <h1>FOR REFERENCE ONLY</h1>
   * Función que indica si ha ganado un jugador, es un empate o todavía no ha
   * terminado.
   * <p>
   * Únicamente comprueba la victoria del último jugador en jugar. Depende de la
   * variables turno y movimientos para poder funcionar correctamente.
   * 
   * @param tablero
   * @return -1 Si todavía no ha terminado
   *         0 Si ha ganado el jugador 1
   *         1 Si ha ganado el jugador 2
   *         2 Si ha sido un empate
   */
  public int oldComprobarVictoria(char[][] tablero) {
    /*
     * As the function is called in at every turn, we only have to check the pieces
     * for the current player. If a match of 3 is found, the winner is the current
     * player.
     */

    char jugadaAct = (turno == 0) ? JUG_1 : JUG_2;

    int CounterH = 0, CounterV = 0;
    int ajuste = NUM_RAYAS - 1;

    // Check horizontals and verticals
    for (int i = 0; i < tablero.length; i++) {
      CounterH = 0;
      CounterV = 0;

      for (int j = 0; j < tablero.length; j++) {
        // Check horizontals
        CounterH = (tablero[i][j] == jugadaAct) ? CounterH + 1 : 0;

        // Check verticals
        CounterV = (tablero[j][i] == jugadaAct) ? CounterV + 1 : 0;

        // Return winner if found, and avoid diagonal calculation
        if (CounterH > NUM_RAYAS - 1 || CounterV > NUM_RAYAS - 1)
          return 0;
      }
    }

    // Check diagonals
    if (tablero.length == 3) {
      // Check diagonals in 3x3 board
      CounterH = 0;
      CounterV = 0;

      for (int i = 0; i < 3; i++) {
        // Left to right
        CounterH = (tablero[i][i] == jugadaAct) ? CounterH + 1 : 0;

        // Right to left
        CounterV = (tablero[i][2 - i] == jugadaAct) ? CounterV + 1 : 0;

        // Return winner if found
        if (CounterH > 2 || CounterV > 2)
          return 0;
      }

    } else {
      // Check bigger diagonals or:
      // How I learned to stop worrying and trust the numbers

      // Checks 1st half of the board
      for (int i = ajuste; i < tablero.length; i++) {
        // Reiniciar variables
        CounterH = 0;
        CounterV = 0;

        for (int j = 0; j <= i; j++) {
          // Left to right
          CounterH = (tablero[i - j][j] == jugadaAct) ? CounterH + 1 : 0;

          // Right to left
          CounterV = (tablero[i - j][tablero.length - 1 - j] == jugadaAct) ? CounterV + 1 : 0;

          // Return winner if found
          if (CounterH > NUM_RAYAS - 1 || CounterV > NUM_RAYAS - 1)
            return 0;
        }
      }

      // Checks 2nd half of the board
      for (int i = tablero.length - 2; i > ajuste - 1; i--) {
        // Reiniciar variables
        CounterH = 0;
        CounterV = 0;

        for (int j = 0; j <= i; j++) {
          // Left to right
          CounterH = (tablero[tablero.length - 1 - j][tablero.length - 1 - i + j] == jugadaAct) ? CounterH + 1 : 0;

          // Right to left
          CounterV = (tablero[tablero.length - 1 - j][i - j] == jugadaAct) ? CounterV + 1 : 0;

          // Return winner if found
          if (CounterH > NUM_RAYAS - 1 || CounterV > NUM_RAYAS - 1)
            return 0;
        }
      }
    }

    // Game still in progress
    if (movimientos < maxMovimientos)
      return -1;

    return 2;

  }

}// End class
