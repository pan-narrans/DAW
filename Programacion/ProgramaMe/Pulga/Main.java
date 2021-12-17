public class Main {
  static java.util.Scanner in;

  public static void casoDePrueba() {
    int size = in.nextInt();
    int power = in.nextInt();
    int time = in.nextInt();

    if (time <= size) {
      System.out.println(time * power);
    } else {
      System.out.println(power * (time % (size + 1)));
    }
  }

  public static void main(String[] args) {
    in = new java.util.Scanner(System.in);
    int nCasos = in.nextInt();
    for (int i = 0; i < nCasos; i++) {
      casoDePrueba();
    }
  }
}
