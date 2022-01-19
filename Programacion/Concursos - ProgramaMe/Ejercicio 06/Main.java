import java.util.Arrays;
import java.util.Locale;

public class Main {

  static java.util.Scanner in;

  public static boolean casoDePrueba() {

    if (!in.hasNext()) // Exit condition
      return false;

    float[] notas = new float[7];

    for (int i = 0; i < 7; i++) {
      float nota = in.nextFloat();
      notas[i] = nota;
    }

    Arrays.sort(notas);

    float suma = (notas[2] + notas[3] + notas[4]) * 2;

    System.out.println((int) suma);

    return true;
  }

  public static void main(String args[]) {
    in = new java.util.Scanner(System.in).useLocale(Locale.US);;

    while (casoDePrueba())
      ;

  }

}
