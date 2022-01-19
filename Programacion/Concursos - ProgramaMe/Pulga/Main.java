public class Main {
  static java.util.Scanner in;

  public static void casoDePrueba() {
    int size, power, time;
    size = in.nextInt();
    power = in.nextInt();
    time = in.nextInt();

    System.out.println((time <= size) ? time * power : power * (time % (size + 1)));
  }

  public static void main(String[] args) {
    in = new java.util.Scanner(System.in);
    int nCasos = in.nextInt();
    for (int i = 0; i < nCasos; i++) {
      casoDePrueba();
    }
  }
}