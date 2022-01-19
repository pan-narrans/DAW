import java.util.Arrays;

public class Main {

  static java.util.Scanner in;

  public static boolean casoDePrueba() {
    int size_turron_1 = in.nextInt();

    if (!in.hasNext()) // Exit condition
      return false;

    int size_turron_2 = in.nextInt();

    int[] turron_1 = new int[size_turron_1];
    for (int i = 0; i < size_turron_1; i++) {
      turron_1[i] = in.nextInt();
    }

    int[] turron_2 = new int[size_turron_2];
    for (int i = 0; i < size_turron_2; i++) {
      turron_2[i] = in.nextInt();
    }

    System.out.println(Arrays.toString(turron_1));
    System.out.println(Arrays.toString(turron_2));

    return true;
  }

  public static void main(String args[]) {
    in = new java.util.Scanner(System.in);
    while (casoDePrueba())
      ;
  }

}
