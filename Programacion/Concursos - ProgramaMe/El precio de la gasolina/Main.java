
public class Main {

  static java.util.Scanner in;

  public static boolean casoDePrueba() {
    int n;
    n = in.nextInt();

    if (n == 0) // Exit condition
      return false;

    int oldPrice;
    int newPrice = in.nextInt();
    int days = 1;

    for (int i = 1; i < n; i++) {
      oldPrice = newPrice;
      newPrice = in.nextInt();
      if (newPrice > oldPrice)
        days++;
    }

    System.out.println(days);

    return true;
  }

  public static void main(String args[]) {
    in = new java.util.Scanner(System.in);
    while (casoDePrueba())
      ;
  }

}
