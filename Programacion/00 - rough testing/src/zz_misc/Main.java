package zz_misc;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws Exception {

    int[][] tablero = new int[3][3];
    int[] numeros = { 4, 23, 564, 2 };

    for (int i = 0; i < tablero.length; i++) {
      for (int j = 0; j < tablero.length; j++) {
        tablero[i][j] = 2;
      }
    }

    for (int i = 0; i < tablero.length; i++) {
      for (int j = 0; j < tablero.length; j++) {
        System.out.print(tablero[i][j] + " ");
      }
      System.out.println("");
    }

    System.out.println(Arrays.toString(numeros));

    for (int i = 0; i < numeros.length; i++) {
      System.out.println(Arrays.toString(tablero[i]));
    }

  }
}
