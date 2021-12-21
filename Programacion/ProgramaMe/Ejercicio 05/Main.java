public class Main {

  static java.util.Scanner in;

  public static void casoDePrueba() {
    int day, month;
    day = in.nextInt();
    month = in.nextInt();
    System.out.println((day == 25 && month == 12) ? "SI" : "NO");
  }

  public static void main(String args[]) {
    in = new java.util.Scanner(System.in);
    int numCasos = in.nextInt();
    for (int i = 0; i < numCasos; i++)
      casoDePrueba();
  }

}
