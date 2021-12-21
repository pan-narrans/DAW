import java.util.Arrays;

public class Main {

  static java.util.Scanner in;

  public static boolean casoDePrueba() {
    /*
     * int n;
     * n = in.nextInt();
     */

    /*
     * if (!in.hasNext()) // Exit condition
     * return false;
     */

    float[] notas = new float[7];

    for (int i = 0; i < 7; i++) {
      float nota = in.nextFloat();
      notas[i] = nota;
      System.out.println(notas[i]);

    }

    Arrays.sort(notas);

    float suma = (notas[2] + notas[3] + notas[4]) * 2;

    System.out.println((int) (suma));

    return true;
  }

  public static void main(String args[]) {
    in = new java.util.Scanner(System.in);
    /*
     * while (casoDePrueba())
     * ;
     */
    // casoDePrueba();
    test();
  }

  public static void test() {
    float number;
    number = in.nextFloat();
    System.out.println("el numero es " + number);
  }

}
