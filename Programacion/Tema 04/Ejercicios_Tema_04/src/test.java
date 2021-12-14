
import java.util.Arrays;

public class test {

  static java.util.Scanner in;

  public static int iteraciones = 0;

  public static boolean casoDePrueba() {
    int nTests = in.nextInt();
    int[] tests = new int[nTests];

    for (int i = 0; i < tests.length; i++) {
      tests[i] = in.nextInt();
    }

    calcIteraciones(tests);

    System.out.println(iteraciones);
    iteraciones = 0;

    return (nTests != 0) ? true : false;

  }

  public static void calcIteraciones(int[] arr) {
    iteraciones++;
    int sumaArr = 0;
    for (int i = 0; i < arr.length; i++) {
      sumaArr += arr[i];
    }

    if (sumaArr != 0) {
      int a, b = 0;
      a = arr.length;
      if (a % 2 == 0) {
        a = a / 2;
      } else {
        a = a / 2 + 1;
      }

      int[] arr1 = new int[a];
      for (int i = 0; i < a; i++) {
        arr1[i] = arr[i];
      }
      int[] arr2 = new int[arr.length - a];

      for (int i = a; i < arr.length; i++) {
        arr2[i - a] = arr[i];
      }

      System.out.println(Arrays.toString(arr1));
      System.out.println(Arrays.toString(arr2));
      // int[] arr1 =
      // int[] arr2 =
      // calcIteraciones(arr1);
      // calcIteraciones(arr2);
    }
  }

  public static void main(String args[]) {
    in = new java.util.Scanner(System.in);
    while (casoDePrueba())
      ;
  }

}