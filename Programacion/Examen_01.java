
import java.util.Scanner;

/**
 * @author Alejandro Pérez Álvarez
 * @version 1
 */

class Examen_01 {

  static Scanner sc = new Scanner(System.in);

  enum Mano {
    PIEDRA, PAPEL, TIJERA
  };

  enum Ganador {
    EMPATE, JUGADOR1, JUGADOR2
  };

  /* ========================================================================== */
  /* ============================= EJERCICIO 06.A ============================= */
  /* ========================================================================== */
  /**
   * Ejercicio 6.a preguntará a un jugador humano que quiere jugar, piedra, papel
   * o tijera por teclado, después mediante operadores condicionales devolverá la
   * elección de tipo Mano
   * 
   * @return enum Mano con la elección del jugador
   */
  static Mano jugadaHumano() {
    Mano mano = Mano.PAPEL;
    int manoInt;
    boolean manoLeida = false;

    do {
      manoLeida = true;

      System.out.println("Elige Piedra(1), Papel(2), o Tijera (3).");
      manoInt = sc.nextInt();

      switch (manoInt) {
        case 1:
          mano = Mano.PIEDRA;
          break;
        case 2:
          mano = Mano.PAPEL;
          break;
        case 3:
          mano = Mano.TIJERA;
          break;
        default:
          manoLeida = false;
          System.out.println("Valor introducido no válido. \n");
          break;
      }
    } while (!manoLeida);

    return mano;
  } // Fin jugadaHumano()

  /* ========================================================================== */
  /* ============================= EJERCICIO 06.B ============================= */
  /* ========================================================================== */
  /**
   * Ejerciciio 6.b Esta función se utilizará para jugar contra la IA. En este
   * caso calculará un número aleatorio entre 0 y 2 con Math.random() * 3 y
   * devolverá la elección de tipo Mano.
   * 
   * @return enum Mano con la elección aleatoria del ordenador
   */
  static Mano jugadaAleatoria() {
    Mano mano = Mano.PAPEL;
    int manoInt;

    manoInt = (int) (Math.random() * 3);

    switch (manoInt) {
      case 0:
        mano = Mano.PIEDRA;
        break;
      case 1:
        mano = Mano.PAPEL;
        break;
      case 2:
      default:
        mano = Mano.TIJERA;
        break;
    }

    return mano;
  } // Fin jugadaAleatoria()

  /* ========================================================================== */
  /* ============================= EJERCICIO 06.C ============================= */
  /* ========================================================================== */
  /**
   * Ejercicio 6.c Esta función recibirá dos manos de dos jugadores, y devolverá
   * un tipo Ganador indicando si es un empate, si ha ganado el primer jugador o
   * el segundo.
   * 
   * @param jugada1 jugada del jugador 1
   * @param jugada2 jugada del jugador 2
   * @return Devuelve quien es el ganador o si ha sido un empate
   */
  static Ganador ganador(Mano jugada1, Mano jugada2) {
    Ganador ganador = Ganador.EMPATE;

    if (jugada1 == jugada2) {
      ;
    } else {
      if (jugada1 == Mano.PIEDRA & jugada2 == Mano.TIJERA | jugada1 == Mano.PAPEL & jugada2 == Mano.PIEDRA
          | jugada1 == Mano.TIJERA & jugada2 == Mano.PAPEL) {
        ganador = Ganador.JUGADOR1;
      } else {
        ganador = Ganador.JUGADOR2;
      }
    }

    return ganador;
  } // Fin ganador()

  /* ========================================================================== */
  /* ============================= EJERCICIO 06.D ============================= */
  /* ========================================================================== */
  /**
   * Ejercicio 6.d Esta función permite jugar una partida contra la IA. Debe
   * implementar un bucle para repetir partidas hasta que el jugador ya no desee
   * jugar.
   */
  public static void juegoPiedraPapelTijera() {
    boolean seguirJugando = true;
    Mano jugada1, jugada2;
    Ganador ganador;

    do {
      System.out.println("\n¡Empieza el juego!");

      jugada1 = jugadaHumano();
      jugada2 = jugadaAleatoria();
      ganador = ganador(jugada1, jugada2);

      System.out.println("\n¡Piedra ... papel ... o tijera");
      System.out.println("Tu:¡" + jugada1 + "!");
      System.out.println("\tPC:¡" + jugada2 + "!");

      System.out.println(ganador == Ganador.EMPATE ? "¡EMPATE!" : "El ganador es: " + ganador);

      System.out.println("\n¿Quieres jugar otra vez? s(1)/n(0)");
      seguirJugando = sc.nextInt() == 1 ? true : false;
    } while (seguirJugando);

    System.out.println("¡Adios!");

  } // Fin juegoPiedraPapelTijera()

  /* ========================================================================== */
  /* ============================== EJERCICIO 05 ============================== */
  /* ========================================================================== */
  /**
   * Ejercicio 05 Implementar en la función main el siguiente menú y ejecute las
   * acciones correspondientes: Calcula la cuota de socio de un club de padel
   * Comprueba si la hora es válida Calcula el factorial de un número Calcula la
   * suma de dígitos Salir
   */
  public static void menu() {
    int ejercicio;
    boolean mostrarMenu = true;

    do {
      System.err.println("\nBienvenid@ al exámen de Alejandro Pérez de 1ro de DAW.");
      System.err.println("Este es el menú de los 4 primeros ejercicios:");
      System.err.println("\t 1. Calcula la cuota de socio de un club de padel");
      System.out.println("\t 2. Comprueba si la hora es válida");
      System.out.println("\t 3. Calcula el factorial de un número");
      System.out.println("\t 4. Calcula la suma de dígitos");
      System.out.println("\t 5. Salir");
      ejercicio = sc.nextInt();
      System.out.println("");

      switch (ejercicio) {
        case 1:
          cuotaSocio();
          break;
        case 2:
          int hora, minutos, segundos;

          System.out.println("Función para comprobar si una hora dada es válida o no:");
          System.out.println("Introduce la hora, minutos y segundos por separado y en ese orden:");
          hora = sc.nextInt();
          minutos = sc.nextInt();
          segundos = sc.nextInt();

          System.out
              .println("La hora introducida " + (horaValida(hora, minutos, segundos) ? " " : "no ") + "es válida.");
          break;
        case 3:
          int n;
          long factorial;

          System.out.println("Función para calcular el factorial de un número:");
          System.out.println("Introduce el número:");
          n = sc.nextInt();

          factorial = factorial(n);
          System.out.println(factorial == -1 ? "El número introducido no es válido."
              : "El factorial de " + n + " es: " + factorial + ".");
          break;
        case 4:
          int numero;

          System.out.println("Función para calcular la suma de los dígitos de un número:");
          System.out.println("Introduce el número:");
          numero = sc.nextInt();

          System.out.println("La suma de los dígitos de " + numero + " es: " + calculaSumaDigitos(numero) + ".");
          break;
        case 5:
          System.out.println("¡Nos vemos luego!");
          mostrarMenu = false;
          break;
        default:
          System.out.println("Valor introducido no válido.");
          break;
      }

    } while (mostrarMenu);

  } // Fin menu()

  /* ========================================================================== */
  /* ============================== EJERCICIO 04 ============================== */
  /* ========================================================================== */
  /**
   * Ejercicio 04 Suma los dígitos de un número.
   * 
   * @param numero
   * @return Devuelve la suma los de dígitos del número
   */
  static int calculaSumaDigitos(int numero) {
    int result = 0;

    // Usando el absoluto pordemos calcular la suma también para nº negativos
    numero = Math.abs(numero);

    while (numero > 0) {
      result += numero % 10;
      numero /= 10;
    }

    return result;
  } // Fin calculaSumaDigitos()

  /* ========================================================================== */
  /* ============================== EJERCICIO 03 ============================== */
  /* ========================================================================== */
  /**
   * Ejercicio 03 Completar la función static long factorial (int n) que recibe un
   * número y devuelve el factorial. Deberá comprobar que el número que recibe sea
   * menor o igual que 20, en caso contrario devolverá -1.
   * 
   * @param n entre 0 y 20
   * @return Devuelve el factorial del número n o -1 en caso de que n esté fuera
   *         de rango
   */
  static long factorial(int n) {
    long result = 1;

    if (n < 0 | n > 20) { // !(-1 < n && n < 21)
      result = -1;
    } else {
      // Empezamos en 2 porque 0! y 1! son iguales a 1, por lo que no hace falta
      // calcularlos.
      for (int i = 2; i <= n; i++) {
        result *= i;
      }
    }

    return result;
  } // Fin factorial()

  /* ========================================================================== */
  /* ============================== EJERCICIO 02 ============================== */
  /* ========================================================================== */
  /**
   * Ejercicio 02 Comprueba que todos los parámetros de la hora son válidos.
   * Supondremos que se lee la hora en modo 24 Horas
   * 
   * @param hora     Entre 0 a 24 (23!!!)
   * @param minutos  Entre 0 y 59
   * @param segundos Entre 0 y 59
   * @return Devuelve si la hora es válida
   */
  static boolean horaValida(int hora, int minutos, int segundos) {
    boolean valida = true;

    // HORA > 23 !!!
    if (hora > 24 || hora < 0) {
      valida = false;
    } else if (minutos > 59 || minutos < 0) {
      valida = false;
    } else if (segundos > 59 || segundos < 0) {
      valida = false;
    } else {
      ;
    }

    // Otra opción
    return (hora > -1 && hora < 24 &&
        minutos > -1 && minutos < 60 &&
        segundos > -1 && segundos < 60);

    // return valida;
  } // Fin horaValida()

  /* ========================================================================== */
  /* ============================== EJERCICIO 01 ============================== */
  /* ========================================================================== */
  /**
   * Ejercicio 01 calcula la cuota anual que se debe abonar en un club de padel.
   * La cuota general es de 800 euros. Pedirá por teclado la edad del usuario y en
   * caso de ser menor si sus padres son socios. Después imprimirá la cuota que
   * debe pagar. Tendrán un 40% de descuento las personas con 65 años cumplidos o
   * más; un 25% de descuento los menores de 21 años, si los padres no son socios,
   * y un 45% de descuento los menores de 21 si los padres son socios.
   *
   */
  static void cuotaSocio() {
    // Variables
    boolean hijoDeSocio;
    int edad;
    float cuota = 800;
 
    // BUENA PRACTICA
    float descuentoMayores = 0.4, descuentoJovenHijoSocio = 0.45, desjuentoJoven = 0.25;

    // Entrada de usuario
    System.out.println("Bienvenid@ al calculador de cuota del club de padel.");
    System.out.println("Para empezar introduce tu edad:");
    edad = sc.nextInt();

    // Calcular la cuota correspondiente
    if (edad < 21) {
      System.out.println("¿Es alguno de tus padres socio del club? \n 0. no \n 1. si");
      // Para leer s/n -> sc.Next().toLowerCase().chartAt(0);
      hijoDeSocio = sc.nextInt() == 1 ? true : false;
      cuota = hijoDeSocio ? cuota * 0.55f : cuota * 0.75f;
    } else if (edad > 64) {
      // cuota = cuota * (1 - descuentoMayores);
      cuota *= 0.6f;
    } else {
      ;
    }

    // Salida por consola
    System.out.println("Tu cuota es de: " + (int) cuota + " euros.");
    System.out.println("Gracias por confiar en nosotros.");

  } // Fin cuentaSocio()

  /* ========================================================================== */
  /* ================================== MAIN ================================== */
  /* ========================================================================== */
  public static void main(String[] args) {

    menu();

    juegoPiedraPapelTijera();

    sc.close();

  } // Fin main()

} // Fin Clase Main
