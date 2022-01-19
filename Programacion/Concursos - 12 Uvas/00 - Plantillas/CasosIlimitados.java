
public class CasosIlimitados {

  static java.util.Scanner in;

  public static boolean casoDePrueba() {
    int n;
    n = in.nextInt();

    if (!in.hasNext()) // Exit condition
      return false;

    return true;
  }

  public static void main(String args[]) {
    in = new java.util.Scanner(System.in);
    while (casoDePrueba())
      ;
  }

}
