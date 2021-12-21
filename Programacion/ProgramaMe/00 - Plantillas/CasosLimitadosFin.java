package Programame.Plantillas;

public class CasosLimitadosFin {

  static java.util.Scanner in;

  public static boolean casoDePrueba() {
    int n;
    n = in.nextInt();

    if (n == 0) // Exit condition
      return false;

    return true;
  }

  public static void main(String args[]) {
    in = new java.util.Scanner(System.in);
    while (casoDePrueba())
      ;
  }

}
