import java.util.Scanner;
import java.util.Arrays;

public class Ejercicios_Arrays {
  static Scanner sc = new Scanner(System.in);

  /* ========================================================================== */
  /* ============================== EJERCICIO 10 ============================== */
  /* ========================================================================== */
  /**
   * <h5>EJERCICIO 10</h5>
   * Escriba la función void imprimirArraySinRepetir(int [] numeros) que imprima
   * en la consola los números del array, los números que estuvieran repetidos
   * solo se deben mostrar una vez.
   * 
   * @param numeros
   */
  void imprimirArraySinRepetir(int[] numeros) {
    int[] numerosImpresos = new int[numeros.length];
    boolean imprimirNumero;
    int contador = 0;

    for (int numero : numeros) {
      imprimirNumero = true;
      for (int i = 0; i < numerosImpresos.length; i++) {
        if (numero == numerosImpresos[i]) {
          imprimirNumero = false;
        }
      }
      // Añadirle el nº al array que se imprime
      if (imprimirNumero)
        numerosImpresos[contador++] = numero;
    }
    numerosImpresos = recortarArray(numerosImpresos, contador);
    System.out.println("Array = " + Arrays.toString(numerosImpresos));
  }

  /* ========================================================================== */
  /* ============================== EJERCICIO 09 ============================== */
  /* ========================================================================== */
  /**
   * <h5>EJERCICIO 09</h5>
   * Escriba la función void rellenarArraySinRepetir(int [] numeros) que rellene
   * el array con números sin repetir. Si el usuario introduce algún número
   * repetido se le debe notificar, y no ha de ser contabilizado.
   * 
   * @param numeros
   */
  void rellenarArraySinRepetir(int[] numeros) {
    boolean datoRepetido, ceroIntroducido = false;
    int numero;

    // Reseteamos el array rellenandolo con 0s
    for (int i = 0; i < numeros.length; i++) {
      numeros[i] = 0;
    }

    for (int i = 0; i < numeros.length; i++) {
      do {
        datoRepetido = false;
        System.out.print("Introduce un valor para la posición nº" + i + " del array: ");
        numero = sc.nextInt();
        // Recorremos el array para buscar dentro el nº introducido
        for (int j : numeros) {
          // Gestiona el poder introducir un 1er 0
          if (numero == 0 && !ceroIntroducido) {
            ceroIntroducido = true;
            break;
          }
          // Si el nº ya está dentro se repite el while
          if (j == numero) {
            datoRepetido = true;
            System.out.println("¡El dato ya está dentro del array!");
            System.out.println("Prueba otra vez.");
            break;
          }
        }
      } while (datoRepetido);
      // Asignar el valor al array
      numeros[i] = numero;
    }

    System.out.println("¡El array está completo!");

  }

  /* ========================================================================== */
  /* ============================== EJERCICIO 08 ============================== */
  /* ========================================================================== */
  /**
   * <h5>EJERCICIO 08</h5>
   * Escribe la función void busquedaNumeros(int [] numeros) que pedirá al usuario
   * buscar un número introducido por teclado y le dirá si ha sido encontrado o
   * no.
   * <p>
   * En el caso en el que haya sido encontrado, le indicará cuántas veces se
   * ha introducido.
   * <p>
   * El programa preguntará si quiere seguir buscando más números
   * o no: “¿Desea seguir buscando?(s/n)”.
   * 
   * @param numeros
   */
  void busquedaNumeros(int[] numeros) {
    boolean seguirBuscando = false;

    do {
      imprimirArray(numeros);
      System.out.println("===========================");
      System.out.println("¿Qué número quieres buscar?");
      int numero = sc.nextInt();
      int apariciones = aparicionesNumero(numeros, numero);

      if (apariciones > 0) {
        System.out.println("Apariciones del número: " + apariciones);
      } else {
        System.out.println("¡El número no aparece ni una sola vez!");
      }

      System.out.println("¿Quieres seguir buscando? s/n");
      char respuesta = sc.next().charAt(0);
      seguirBuscando = (java.lang.Character.toLowerCase(respuesta) == 's') ? true : false;
    } while (seguirBuscando);
  }

  /* ========================================================================== */
  /* ============================== EJERCICIO 07 ============================== */
  /* ========================================================================== */
  /**
   * <h5>EJERCICIO 07</h5>
   * Escriba la función int aparicionesNumero(int [] numeros, int numero) que
   * devuelve el número de veces que aparece numero en el array.
   * 
   * @param numeros Array de integers a comprobar.
   * @param numero  Integer a buscar en el array.
   * @return Número de veces que aparece número en el array.
   */
  int aparicionesNumero(int[] numeros, int numero) {
    int apariciones = 0;

    for (int i : numeros) {
      if (i == numero)
        apariciones++;
    }

    return apariciones;
  }

  /* ========================================================================== */
  /* ============================== EJERCICIO 06 ============================== */
  /* ========================================================================== */
  /**
   * <h5>EJERCICIO 06</h5>
   * Realizar la función String [][] primitiva () Devuelve una matriz con la
   * apuesta aleatoria (seis números enteros aleatorios escogidos entre 1 y 49).
   * <p>
   * La matriz deberá contener una matriz de 10 x 40, con los valores que le
   * corresponde, sustituyendo los que forman parte de la apuesta por una “X” y
   * usando el formato de los boletos oficiales impresos.
   */

  String[][] primitiva() {
    String[][] primitiva = new String[10][40];

    // Rellenar la primitiva con cada una de las apuestas individuales
    for (int i = 0; i < 40 / 5; i++) {
      String[][] apuesta = setPartePrimitiva();
      apuesta[0][0] = Integer.toString(i + 1);
      apuesta(apuesta);
      for (int j = i * 5; j < i * 5 + 5; j++) {
        for (int j2 = 0; j2 < 10; j2++) {
          primitiva[j2][j] = apuesta[j2][j - i * 5];
        }
      }
    }

    return primitiva;
  }

  void imprimirPrimitiva(String[][] primitiva) {
    int caja = 0;

    // Imprimir parte de arriba
    for (int i = 0; i < 7; i++) {
      System.out.print("+---------------");
    }
    System.out.println("+---------------+");

    // Imprimir valores
    for (String[] strings : primitiva) {
      System.out.print("| ");
      for (String string : strings) {
        System.out.print(string + ' ' + ((++caja % 5 == 0) ? "| " : ""));
      }
      System.out.println("");
    }

    // Imprimir parte de abajo
    for (int i = 0; i < 7; i++) {
      System.out.print("+---------------");
    }
    System.out.println("+---------------+");
  }

  void apuesta(String[][] primitiva) {
    int row = 0;
    int column = 0;

    // Evita que una apuesta caiga en el [0][0]
    while (row == column && row == 0) {
      row = (int) (Math.random() * primitiva.length);
      column = (int) (Math.random() * primitiva[0].length);
    }

    primitiva[row][column] = (column > 0) ? "X " : "X";
  }

  String[][] setPartePrimitiva() {
    String[][] primitiva = new String[10][5];
    int number = 0;

    for (int i = 0; i < primitiva[0].length; i++) {
      for (int j = 0; j < primitiva.length; j++) {
        primitiva[j][i] = Integer.toString(number++);
      }
    }

    return primitiva;
  }

  /* ========================================================================== */
  /* ============================== EJERCICIO 05 ============================== */
  /* ========================================================================== */
  /**
   * <h5>EJERCICIO 05</h5>
   * Realizar la función int [] primitiva() que genere una primitiva de 6 números
   * enteros entre el 1 y el 49.
   * 
   * @return
   */
  int[] apuestaPrimitiva() {
    int[] primitiva = new int[6];

    for (int i = 0; i < primitiva.length; i++) {
      primitiva[i] = (int) (Math.random() * 48) + 1;
    }

    return primitiva;
  }

  /* ========================================================================== */
  /* ============================== EJERCICIO 04 ============================== */
  /* ========================================================================== */
  /**
   * <h5>EJERCICIO 04</h5>
   * Realizar la función {char [] quiniela()} que genere una quiniela de 15
   * resultados con valores aleatorios 1, X o 2.
   * 
   * @return
   */
  char[] quiniela() {
    char[] quiniela = new char[15];

    for (int i = 0; i < quiniela.length; i++) {
      int aux = (int) (Math.random() * 3);
      quiniela[i] = (aux == 0 ? '1' : (aux == 1) ? 'X' : '2');
    }

    return quiniela;
  }

  /* ========================================================================== */
  /* ============================== EJERCICIO 03 ============================== */
  /* ========================================================================== */
  /**
   * <h5>EJERCICIO 03</h5>
   * Escriba la función int [] filtrarPares(int [] numeros) que reciba un array
   * con números y devuelva un nuevo array solo con los que sean pares.
   * 
   * @param numeros Array a filtrar
   * @return Array con solo los números pares
   */
  int[] filtrarPares(int[] numeros) {
    int[] pares = new int[numeros.length];
    int nPares = 0;

    // Grabamos los nº pares en un array temporal del tamaño máximo
    for (int num : numeros) {
      if (num % 2 == 0)
        pares[nPares++] = num;
    }

    // Recortamos el array de pares a su tamaño justo
    pares = recortarArray(pares, nPares);

    return pares;
  }

  /* ========================================================================== */
  /* ============================== EJERCICIO 02 ============================== */
  /* ========================================================================== */
  /**
   * <h5>EJERCICIO 02</h5>
   * Escriba la función void imprimirArray(int [] numeros) que imprima en la
   * consola los números del array.
   * 
   * @param numeros Array a imprimir
   */
  void imprimirArray(int[] numeros) {
    System.out.println("Array = " + Arrays.toString(numeros));
  }

  void imprimirArray(char[] chars) {
    System.out.println("Array = " + Arrays.toString(chars));
  }

  void imprimirArray(String[][] stringMatrix) {
    System.out.println("Primitiva = ");
    for (String[] strings : stringMatrix) {
      for (String string : strings) {
        System.out.print(string + ' ');
      }
      System.out.println();
    }
  }

  /* ========================================================================== */
  /* ============================== EJERCICIO 01 ============================== */
  /* ========================================================================== */
  /**
   * <h5>EJERCICIO 01</h5>
   * Escribe la función void rellenarArray(int [] numeros) que pedirá al usuario
   * que introduzca números hasta que el array esté completo.
   * 
   * @param numeros Array a rellenar
   */
  void rellenarArray(int[] numeros) {
    for (int i = 0; i < numeros.length; i++) {
      System.out.print("Introduce un nº: ");
      numeros[i] = sc.nextInt();
    }
    System.out.println("¡El array está completo!");
  }

  /* ========================================================================== */
  /* ============================== OTRAS COSAS ============================== */
  /* ========================================================================== */
  /**
   * Takes the first {@code #number} items of {@code #array} and returns them in
   * the form of a new shorter array.
   * 
   * @param array  array to shorten
   * @param number number of items in shortened array
   * @return Shorteneted array.
   */
  int[] recortarArray(int[] array, int number) {
    // Para evitar un indexOutOfBounds
    if (number > array.length)
      return array;

    // Copia y pega los valores de un array a otro
    int[] shortenedArray = new int[number];
    for (int i = 0; i < shortenedArray.length; i++) {
      shortenedArray[i] = array[i];
    }

    return shortenedArray;
  }

  void ordenarArray(int[] numbers) {
    int salto = numbers.length / 2;

    for (int j = 0; j < numbers.length / 2; j++) {
      for (int i = 0; i < numbers.length - salto; i++) {
        // Intercambio de números
        if (numbers[i] > numbers[i + salto]) {
          int temp = numbers[i];
          numbers[i] = numbers[i + salto];
          numbers[i + salto] = temp;
        }
      }
      salto--;
    }

  }

}
