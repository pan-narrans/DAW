package es.infantaelena;

import java.lang.reflect.Array;
import java.util.Arrays;
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

    // Variable para indicar los turnos 0, primer jugador, 1 segundo jugador
    int turno;

    // Variable para guardar el número de movimientos de la partida actual
    int movimientos;

    // Matriz para la partida de tres en raya
    char tablero[][];

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
     * TODO imprime tablero
     * 
     * @param tablero
     */
    public void imprimirTablero(char[][] tablero) {

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
        String puntos = Integer.toString(TAM_TABLERO * TAM_TABLERO);

        // Rellenar el array
        for (int i = 0; i < NUM_RECORDS; i++) {
            array[i][0] = "PC";
            array[i][1] = puntos;
        }

        return array;
    }

    /**
     * TODO Función devuelve un tablero de juego vacio
     * 
     * @param tam tamaÃ±o del tablero
     * @return tablero para la partida
     */
    public char[][] creaTablero(int tam) {
        return new char[][] { { ' ' }, { ' ' } };
    }

    /**
     * TODO Función que devuelve sin una jugada es válida y no
     * está ocupada
     * 
     */
    public boolean esJugadaValida(int fila, int col, char[][] tableroJuego) {
        return false;

    }

    /**
     * TODO Devuelve si está ocupada una posición del tablero
     * 
     * @param tableroJuego
     * @param fila
     * @param col
     * @return Devuelve true si es válida, false en caso contrario
     */
    public boolean esPosicionVacia(char[][] tableroJuego, int fila, int col) {
        return false;
    }

    /**
     * TODO Función para llamar a pedirJugadaHumano o pedirJugadaPC
     * según el tipo de jugador del jugador al que le toca
     */
    public void pedirJugada() {

    }

    /**
     * TODO Función que para un jugador PC para que
     * de forma aleatoria o con algún tipo de estrategia
     * realiza una jugada en el tablero
     * Genera como salida el jugador que juega y que fila y columna elige
     */
    public void pedirJugadaPC() {

    }

    /**
     * TODO Función que muestra de que jugador humano es el turno
     * pide al jugador humano una fila o columna
     * si la fila y/o columna no es válida volverá a pedirla
     */
    public void pedirJugadaHumano() {

    }

    /**
     * Función que imprime las opciones del menú del juego
     * 
     */
    public void menuJuego() {

        System.out.println("1) Jugar humano vs humano");
        System.out.println("2) Jugar humano vs PC");
        System.out.println("3) Jugar PC vs PC");
        System.out.println("4) Mostrar Records");
        System.out.println("5) Salir");

        switch (sc.nextInt()) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                imprimirRecords(records);
                break;
            case 5:

            default:
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
     * TODO función que devuelve si se ha producido un nuevo record
     * 
     * @param records
     * @param movimientos
     * @return Devuelve true si es un nuevo record, false en caso contrario
     */
    public boolean esNuevoRecord(String[][] records, int movimientos) {
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

        // Shift all items one position starting in the selected position
        for (int i = records.length - 1; i > position; i--) {
            records[i][0] = records[i - 1][0];
            records[i][1] = records[i - 1][1];
        }

        // Adds the new high score
        records[position][0] = nombre;
        records[position][1] = Integer.toString(movimientos);

        return new String[][] { { "" }, { "" } };
    }

    /**
     * TODO Función que genera un turno aleatorio entre 0 y 1
     * 
     * @return Número aletorio entre 0 y 1
     */
    private int sortearTurno() {
        return 0;
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

        return 0;

    }

}
