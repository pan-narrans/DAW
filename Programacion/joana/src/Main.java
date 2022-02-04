import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws Exception {

    boolean nRepetido = false;
    int numero, tamaño;
    Scanner sc = new Scanner(System.in);

    // pedir tamaño array
    tamaño = sc.nextInt();
    int[] numeros = new int[tamaño];

    // for para rellenar el array
    for (int i = 0; i < numeros.length; i++) {

      do {
        // pedir nº
        numero = sc.nextInt();

        // comprobar si esta repetido
        nRepetido = comprobarRepetido(numeros, numero);

        // guardar si no esta repetido
        if (!nRepetido) {
          numeros[i] = numero;
        }

      } while (nRepetido);

    }

  }

  /**
   * comprueba si esta repetido
   * 
   * @return false si no esta repetido, true si si lo esta
   */
  static public boolean comprobarRepetido(int[] array, int numero ) {
    boolean repetido = false;
    //boleano = false
    for (int i = 0; i < array.length; i++) {
      if(array[i]==numero){
        // boleano = true
        repetido = true;
      }
    }
    return repetido;
  }
}
