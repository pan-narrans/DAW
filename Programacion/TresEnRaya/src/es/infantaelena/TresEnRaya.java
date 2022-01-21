package es.infantaelena;

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

    final int TAM_TABLERO = 3;
    final int NUM_RECORDS = 3;

    static Scanner sc = new Scanner(System.in);

    // Variable para indicar los turnos 0 primer jugador, 1 segundo jugador
    int turno;

    // Variable para guardar el número de movimientos de la partida actual
    int movimientos;

    // Nº max de movimientos de una partida -> TAM_TABLERO * TAM_TABLERO
    int maxMovimientos = TAM_TABLERO * TAM_TABLERO;

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
     * Inicializa el estado del juego
     */
    public TresEnRaya() {
        records = creaRecords();
    }

    /**
     * TODO imprimir el tablero con más gracia
     * 
     * Prints the game board
     * 
     * @param tablero
     */
    public void imprimirTablero(char[][] tablero) {
        System.out.println("");

        for (int i = 0; i < tablero.length; i++) {
            System.out.println(Arrays.toString(tablero[i]));
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
        if (fila < 0 || fila > tableroJuego.length)
            return false;

        // Check valid column number
        if (col < 0 || col > tableroJuego[0].length)
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
     * TODO: pedir jugada empezando en 0 o en 1
     * 
     * Shows which player's turn it is and aks them some coordinates to place their
     * token in the board.
     * If the coordinates are not valid, it'll ask again until they are.
     */
    public void pedirJugadaHumano() {
        int fila, columna;
        boolean jugadaValida;

        System.out.println("Turno del Jugador " + (turno + 1));

        do {
            // Querries the row
            System.out.println("Introduce la fila:");
            fila = sc.nextInt() - 1;

            // Querries the column
            System.out.println("Introduce la columna:");
            columna = sc.nextInt() - 1;

            jugadaValida = esJugadaValida(fila, columna, tablero);
            if (!jugadaValida) {
                System.out.println("La jugada introducida no es válida.");
                System.out.println("Introduce otra jugada Jugador " + (turno + 1) + ":");
                System.out.println("---------------------");
                imprimirTablero(tablero);
            }
        } while (!jugadaValida);

        tablero[fila][columna] = (turno == 0) ? JUG_1 : JUG_2;
    }

    /**
     * TODO: ejecutar el menu en bucle
     * Función que imprime las opciones del menú del juego
     */
    public void menuJuego() {

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

                break;
            default:
                System.out.println("Esta opción no está recogida.");
                break;
        }

    }

    /**
     * TODO: darle más chicha y limoná (que quede + bonito)
     * 
     * Función que imprime el contenido de la matriz de records
     * 
     * @param records
     */
    public void imprimirRecords(String[][] records) {
        System.out.println("--- HIGH SCORES ---");
        for (String[] record : records) {
            System.out.println(Arrays.toString(record));
        }
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
     * @param records     The high scores matrix.
     * @param nombre      The name to put on the wall of fame.
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
     * TODO Función que implementa una partida entre jugadores
     * ya sean humano y humano, humano y pc o humano y humano
     * no termina hasta que un jugador gane o se terminen los movimientos
     * indicará en la consola que jugador ha ganado o si ha sido un empate
     * en caso de producirse un record si es humano, introducirá su nombre
     * si es un pc se introducirá automáticamente un record con nombre PC
     * 
     */
    public void jugar() {
        // Initialize variables
        int ganador = -1;
        movimientos = 0;
        turno = sortearTurno();
        tablero = creaTablero(TAM_TABLERO);

        imprimirTablero(tablero);

        do {
            pedirJugada();
            imprimirTablero(tablero);
            turno = (turno == 0) ? 1 : 0;

            ganador = comprobarVictoria(tablero);
            partidaTerminada = (ganador == -1) ? false : true;

        } while (!partidaTerminada);

        System.out.println("ha ganado el jugador " + ganador);

    }

    /**
     * TODO Función que indica si ha ganado un jugador, es un empate o todavía no ha
     * terminado
     * 
     * @param tablero
     * @return -1 Si todavía no ha terminado
     *         0 Si ha ganado el jugador 1
     *         1 Si ha ganado el jugador 2
     *         2 Si ha sido un empate
     */
    public int comprobarVictoria(char[][] tablero) {

        int oneCounterH, twoCounterH;
        int oneCounterV, twoCounterV;

        for (int i = 0; i < tablero.length; i++) {
            // Reiniciar variables
            oneCounterH = 0;
            twoCounterH = 0;
            oneCounterV = 0;
            twoCounterV = 0;

            for (int j = 0; j < tablero.length; j++) {

                // Check horizontals
                if (tablero[i][j] == JUG_1)
                    oneCounterH++;
                else if (tablero[i][j] == JUG_2)
                    twoCounterH++;

                // Check verticals
                if (tablero[j][i] == JUG_1)
                    oneCounterV++;
                else if (tablero[j][i] == JUG_2)
                    twoCounterV++;

                // Return winners if found to avoid further checking
                if (oneCounterV > 2 || oneCounterH > 2)
                    return 0;
                if (twoCounterV > 2 || twoCounterH > 2)
                    return 1;

                // esta funcion se ejecuta una vez por turno, si encontramos un ganador sera el
                // ultimo que ha puesto ficha
                // repensar la logica de la comprobacion en base a eso
                if (oneCounterV > 2 || oneCounterH > 2 || twoCounterV > 2 || twoCounterH > 2)
                    return turno;
            }
        }

        // Check diagonals

        // Partida no acabada
        if (++movimientos < maxMovimientos)
            return -1;

        return 2;

    }

}
